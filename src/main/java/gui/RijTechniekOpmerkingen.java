package gui;

import domein.AttitudeOpmerking;
import domein.DomeinController;
import domein.IcoonType;
import domein.OpmerkingListCell;
import java.util.ArrayList;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class RijTechniekOpmerkingen extends GridPane {

    private DomeinController controller;
    private Scene scene;

    public RijTechniekOpmerkingen(ArrayList<AttitudeOpmerking> opmerkingenList, DomeinController controller, IcoonType icoonType) {

        this.controller = controller;
        //HoofdGrid
        gridLinesVisibleProperty().set(false);
        ColumnConstraints col0 = new ColumnConstraints();
        col0.setPercentWidth(40);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(40);
        col1.setHalignment(HPos.CENTER);

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
            Rijtechniek rijTechniek = new Rijtechniek(controller);
            rijTechniek.setScene(scene);
            scene.setRoot(rijTechniek);
        });

        Label opmerking = new Label("Opmerking");
        opmerking.setId("OpmerkingLabel");
        OpmerkingenPane.add(opmerking, 0, 1);

        TextArea opmerkingVeld = new TextArea();
        opmerkingVeld.setId("OpmerkingenVeld");
        opmerkingVeld.setWrapText(true);
        OpmerkingenPane.add(opmerkingVeld, 0, 2);

        HBox bewaren = new HBox();
        bewaren.setSpacing(20);
        bewaren.setAlignment(Pos.CENTER);
        Button bewaarOpmerking = new Button("Bewaar");

        DropShadow shadow = new DropShadow();

        bewaarOpmerking.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            bewaarOpmerking.setEffect(shadow);
        });
        bewaarOpmerking.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            bewaarOpmerking.setEffect(null);
        });

        bewaren.getChildren().addAll(bewaarOpmerking);

        OpmerkingenPane.add(bewaren, 0, 3);

        //Listview
        ListView opmerkingenListView = new ListView();
        opmerkingenListView.setId("opmerkingenTechniek");
        ObservableList<AttitudeOpmerking> standaarOpmerkingen
                = FXCollections.observableArrayList();

        for (AttitudeOpmerking opm : opmerkingenList) {
            standaarOpmerkingen.add(opm);
        }

        opmerkingenListView.setItems(standaarOpmerkingen);

        opmerkingenListView.setCellFactory(c -> new OpmerkingListCell(controller));

        opmerkingenListView.setOnMouseClicked(event -> {
            try {
                AttitudeOpmerking geselecteerdeOpmerking = (AttitudeOpmerking) opmerkingenListView.getSelectionModel().getSelectedItem();
                opmerkingVeld.setText(geselecteerdeOpmerking.getOpmerking());
            }catch(NullPointerException npe){
                
            }

        });
        //voegtoe
        Button voegToe = new Button("Voeg Toe");

        voegToe.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            voegToe.setEffect(shadow);
        });
        voegToe.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            voegToe.setEffect(null);
        });

        TextField nieuw = new TextField();
        nieuw.setId("tekstNieuw");
        HBox nieuwHB = new HBox();
        nieuwHB.setId("nieuwHB");
        nieuwHB.getChildren().addAll(nieuw, voegToe);

        voegToe.setId("attitudeVoegToe");
        VBox attitudeList = new VBox();
        attitudeList.setId("attitudeList");

        //Icon
        Image Icoon = new Image(icoonType.getIcoonPad());
        ImageView IcoonView = new ImageView(Icoon);

        Label soortIcoon = new Label(icoonType.getNaam());
        soortIcoon.setId("listViewTitle");

        VBox ListViewMetLabel = new VBox();
        ListViewMetLabel.setId("listViewWithLabel");

        ListViewMetLabel.getChildren().addAll(soortIcoon, opmerkingenListView);

        attitudeList.getChildren().addAll(IcoonView, ListViewMetLabel, nieuwHB);

        bewaarOpmerking.setOnAction(e -> {

            AttitudeOpmerking geselecteerdeOpmerking = (AttitudeOpmerking) opmerkingenListView.getSelectionModel().getSelectedItem();
            geselecteerdeOpmerking.setOpmerking(opmerkingVeld.getText());

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
        
        menu.getVorigScherm().setOnAction(e->{
            Rijtechniek rijTechniek = new Rijtechniek(controller);
            rijTechniek.setScene(scene);
            scene.setRoot(rijTechniek);
        });

        add(OpmerkingenPane, 0, 0);
        add(attitudeList, 1, 0);
        add(right, 2, 0);

        voegToe.setOnAction(e -> {
            if (nieuw.getText().equalsIgnoreCase("")) {

            } else {
                AttitudeOpmerking nieuweStand = new AttitudeOpmerking(nieuw.getText(), "");
                opmerkingenList.add(nieuweStand);
                standaarOpmerkingen.add(nieuweStand);
                nieuw.clear();
                opmerkingVeld.clear();
            }
        });
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
