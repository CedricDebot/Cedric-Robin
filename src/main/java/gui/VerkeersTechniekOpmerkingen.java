package gui;

import domein.AttitudeOpmerking;
import domein.DomeinController;
import java.util.ArrayList;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.util.Duration;

public class VerkeersTechniekOpmerkingen extends GridPane {

    private DomeinController controller;
    private Scene scene;
    ImageView uitroepteken;

    public VerkeersTechniekOpmerkingen(ArrayList<AttitudeOpmerking> opmerkingenList, DomeinController controller, String icoonPad) {

        this.controller = controller;
        //HoofdGrid
        gridLinesVisibleProperty().set(false);
        ColumnConstraints col0 = new ColumnConstraints();
        col0.setPercentWidth(40);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(40);
        col1.setHalignment(HPos.LEFT);

        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(20);
        col2.setHalignment(HPos.CENTER);

        getColumnConstraints().addAll(col0, col1, col2);

        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(100);

        getRowConstraints().addAll(row1);

        //OpmerkingPane
        GridPane OpmerkingenPane = new GridPane();
        OpmerkingenPane.gridLinesVisibleProperty().set(false);
        ColumnConstraints col0OpmerkingPane = new ColumnConstraints();
        col0OpmerkingPane.setPercentWidth(100);
        col0OpmerkingPane.setHalignment(HPos.CENTER);

        RowConstraints row0Terug = new RowConstraints();
        row0Terug.setPercentHeight(22.5);

        RowConstraints row1Label = new RowConstraints();
        row1Label.setPercentHeight(10);
        row1Label.setValignment(VPos.BOTTOM);

        RowConstraints row2Text = new RowConstraints();
        row2Text.setPercentHeight(45);
        row2Text.setValignment(VPos.CENTER);

        RowConstraints row3Bewaar = new RowConstraints();
        row3Bewaar.setPercentHeight(22.5);
        row3Bewaar.setValignment(VPos.TOP);

        OpmerkingenPane.getColumnConstraints().add(col0OpmerkingPane);
        OpmerkingenPane.getRowConstraints().addAll(row0Terug, row1Label, row2Text, row3Bewaar);

        Image terugPijl = new Image("images/terug-pijl.png");
        ImageView terugPijlImageView = new ImageView(terugPijl);
        terugPijlImageView.setFitWidth(100);
        terugPijlImageView.setFitHeight(50);
        Button terugBtn = new Button("", terugPijlImageView);
        terugBtn.setId("menuButton");

        OpmerkingenPane.add(terugBtn, 0, 0);

        terugBtn.setOnAction(e -> {
                VerkeersTechniek verkeersTechniek = new VerkeersTechniek(controller);
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
        });
        
        //Listview
        ListView opmerkingenListView = new ListView();
        opmerkingenListView.setId("opmerkingenTechniek");
        ObservableList<AttitudeOpmerking> standaardOpmerkingen
                = FXCollections.observableArrayList();

        for (AttitudeOpmerking opm : opmerkingenList) {
            standaardOpmerkingen.add(opm);
        }

        opmerkingenListView.setItems(standaardOpmerkingen);

        opmerkingenListView.setCellFactory(new Callback<ListView<AttitudeOpmerking>, ListCell<AttitudeOpmerking>>() {

            @Override
            public ListCell<AttitudeOpmerking> call(ListView<AttitudeOpmerking> p) {

                ListCell<AttitudeOpmerking> cell = new ListCell<AttitudeOpmerking>() {

                    @Override
                    protected void updateItem(AttitudeOpmerking a, boolean bln) {
                        super.updateItem(a, bln);
                        if (a != null) {
                            setText(a.getNaam());
                        }
                    }
                };
                return cell;
            }
        });

        
        //voegtoe
        Button voegToe = new Button("Voeg Toe");
        TextField nieuw = new TextField();
        
        uitroepteken = new ImageView("images/uitroepTeken.png");
        Button uitroeptekenBtn = new Button("", uitroepteken);
        uitroeptekenBtn.setId("uitroeptekenKnop");
        
        HBox nieuwHB = new HBox();
        nieuwHB.setId("nieuwHB");
        nieuwHB.getChildren().addAll(nieuw, voegToe);

        voegToe.setId("attitudeVoegToe");
        VBox attitudeList = new VBox();
        attitudeList.setId("attitudeList");

        //Icon
        Image Icoon = new Image(icoonPad);
        ImageView IcoonView = new ImageView(Icoon);

        attitudeList.getChildren().addAll(IcoonView, opmerkingenListView, nieuwHB, uitroeptekenBtn);
        
        opmerkingenListView.setOnMouseClicked(event -> {

            AttitudeOpmerking geselecteerdeOpmerking = (AttitudeOpmerking) opmerkingenListView.getSelectionModel().getSelectedItem();
            if (geselecteerdeOpmerking.isUitroeptekenActive()) {
                Image uitroeptekenImage = new Image("images/uitroepTekenActive.png");
                uitroepteken.setImage(uitroeptekenImage);
            } else {
                Image uitroeptekenImage = new Image("images/uitroepTeken.png");
                uitroepteken.setImage(uitroeptekenImage);
            }

        });
        uitroeptekenBtn.setOnAction(e -> {
            AttitudeOpmerking geselecteerdeOpmerking = (AttitudeOpmerking) opmerkingenListView.getSelectionModel().getSelectedItem();
            if (geselecteerdeOpmerking.isUitroeptekenActive()) {
                geselecteerdeOpmerking.setUitroeptekenActive(false);
                controller.getLeerling().verwijderRecenteOpmerking(geselecteerdeOpmerking);
                Image uitroeptekenImage = new Image("images/uitroepTeken.png");
                uitroepteken.setImage(uitroeptekenImage);
            } else {
                geselecteerdeOpmerking.setUitroeptekenActive(true);
                controller.getLeerling().getRecenteOpmerkingen().add(geselecteerdeOpmerking);
                Image uitroeptekenImage = new Image("images/uitroepTekenActive.png");
                uitroepteken.setImage(uitroeptekenImage);
            }
        });
        
        voegToe.setOnAction(e -> {
            if (nieuw.getText().equalsIgnoreCase("")) {

            } else {
                AttitudeOpmerking nieuweOpmerking = new AttitudeOpmerking(nieuw.getText(), null);
                opmerkingenList.add(nieuweOpmerking);   //NODIG?
                standaardOpmerkingen.add(nieuweOpmerking);
                nieuw.clear();
            }
        });

        //Menu
        Menu menu = new Menu();
        //RIGHT
        VBox right = new VBox();
        //MenuStandaard
        VBox menuStandaard = menu.buildMenuStandaard(controller.getLeerling());
        right.getChildren().add(menuStandaard);

        //Menu
        VBox menuBalk = menu.buildMenu(controller, 1);

        menu.getMenuKnop().setOnAction(e -> {
            menu.setScene(scene);
            right.getChildren().remove(menuStandaard);

            TranslateTransition tt = new TranslateTransition(Duration.millis(500), menuBalk);

            tt.setFromX(100.0 + menuBalk.getLayoutX());
            tt.setByX(-90);
            tt.setCycleCount(1);

            tt.play();

            right.getChildren().addAll(menuBalk);
        });

        menu.getMenuTerug().setOnAction(e -> {
            TranslateTransition tt = new TranslateTransition(Duration.millis(500), menuBalk);
            tt.setOnFinished(ev -> {
                right.getChildren().removeAll(menuBalk);
                right.getChildren().add(menuStandaard);
            });

            tt.setFromX(menuBalk.getLayoutX());
            tt.setByX(120);
            tt.setCycleCount(1);

            tt.play();
            tt.onFinishedProperty();

        });

        add(OpmerkingenPane, 0, 0);
        add(attitudeList, 1, 0);
        add(right, 2, 0);

        
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
