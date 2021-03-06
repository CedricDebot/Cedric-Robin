package gui;

import domein.DomeinController;
import domein.IcoonType;
import domein.SchermType;
import domein.Toestand;
import javafx.animation.TranslateTransition;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class VerkeersTechniek extends HBox {

    private DomeinController controller;

    private Scene scene;
    private ImageView middenGridImageView;
    

    private boolean roodLichtActive = false;
    private boolean oranjeLichtActive = false;
    private boolean groenLichtActive = false;
    
    private Group verkeerstechniekGroup;

    public VerkeersTechniek(DomeinController controller) {
        this.controller = controller;

        setId("rijtechniekHBox");
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(false);

        ColumnConstraints col0 = new ColumnConstraints(100);
        col0.setHalignment(HPos.RIGHT);
        ColumnConstraints col1 = new ColumnConstraints(100);
        col1.setHalignment(HPos.LEFT);
        ColumnConstraints col2 = new ColumnConstraints(100);
        col2.setHalignment(HPos.CENTER);
        ColumnConstraints col3 = new ColumnConstraints(100);
        col3.setHalignment(HPos.RIGHT);
        ColumnConstraints col4 = new ColumnConstraints(100);
        col4.setHalignment(HPos.RIGHT);
        ColumnConstraints col5 = new ColumnConstraints(100);
        col5.setHalignment(HPos.LEFT);

        grid.getColumnConstraints().addAll(col0, col1, col2, col3, col4, col5);

        RowConstraints row0 = new RowConstraints(100);
        row0.setValignment(VPos.BOTTOM);
        RowConstraints row1 = new RowConstraints(100);
        row1.setValignment(VPos.TOP);
        RowConstraints row2 = new RowConstraints(100);
        row2.setValignment(VPos.CENTER);
        RowConstraints row3 = new RowConstraints(100);
        row3.setValignment(VPos.CENTER);
        RowConstraints row4 = new RowConstraints(100);
        row4.setValignment(VPos.BOTTOM);
        RowConstraints row5 = new RowConstraints(100);
        row5.setValignment(VPos.TOP);

        grid.getRowConstraints().addAll(row0, row1, row2, row3, row4, row5);

        //Buttons met images
        //Voorrang
        ButtonTechniek voorrang = new ButtonTechniek(controller.getButtonVerkeersTechniek(0), true, SchermType.VERKEERSTECHNIEK, controller);
        voorrang.setVerkeerstechniek(this);
        voorrang.setId("voorrangHBox");

        voorrang.getButton().setOnMouseDragged(e -> {
            if (voorrang.isGekleurd()) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(controller.getLeerling().getVoorrangOpmerkingen(), controller, new IcoonType(voorrang.getKleur(), "Voorrang"));
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }
        });
        grid.add(voorrang, 2, 0, 2, 1);

        //OrdersOpvolgen
        ButtonTechniek orders = new ButtonTechniek(controller.getButtonVerkeersTechniek(1), true, SchermType.VERKEERSTECHNIEK, controller);
        orders.setVerkeerstechniek(this);
        orders.setId("orderOpvolgenHBox");

        orders.getButton().setOnMouseDragged(e -> {
            if (orders.isGekleurd()) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(controller.getLeerling().getOrderOpmerkingen(), controller, new IcoonType(orders.getKleur(), "Bevelen"));
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }
        });
        grid.add(orders, 4, 1);

        //snelheid
        ButtonTechniek snelheid = new ButtonTechniek(controller.getButtonVerkeersTechniek(2), true, SchermType.VERKEERSTECHNIEK, controller);
        snelheid.setVerkeerstechniek(this);
        snelheid.setId("snelheidHBox");

        snelheid.getButton().setOnMouseDragged(e -> {
            if (snelheid.isGekleurd()) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(controller.getLeerling().getSnelheidOpmerkingen(), controller, new IcoonType(snelheid.getKleur(), "Snelheid"));
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }
        });
        grid.add(snelheid, 5, 2);

        //afstand
        ButtonTechniek afstand = new ButtonTechniek(controller.getButtonVerkeersTechniek(3), true, SchermType.VERKEERSTECHNIEK, controller);
        afstand.setVerkeerstechniek(this);
        afstand.setId("afstandHBox");

        afstand.getButton().setOnMouseDragged(e -> {
            if (afstand.isGekleurd()) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(controller.getLeerling().getAfstandOpmerkingen(), controller, new IcoonType(afstand.getKleur(), "Afstand"));
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }
        });
        grid.add(afstand, 5, 3);

        //inhalen
        ButtonTechniek inhalen = new ButtonTechniek(controller.getButtonVerkeersTechniek(4), true, SchermType.VERKEERSTECHNIEK, controller);
        inhalen.setVerkeerstechniek(this);
        afstand.setId("afstandHBox");

        inhalen.getButton().setOnMouseDragged(e -> {
            if (inhalen.isGekleurd()) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(controller.getLeerling().getInhalenOpmerkingen(), controller, new IcoonType(inhalen.getKleur(), "Inhalen"));
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }
        });
        grid.add(inhalen, 4, 4);

        //kruisen
        ButtonTechniek kruisen = new ButtonTechniek(controller.getButtonVerkeersTechniek(5), true, SchermType.VERKEERSTECHNIEK, controller);
        kruisen.setVerkeerstechniek(this);
        kruisen.setId("kruisenHBox");

        kruisen.getButton().setOnMouseDragged(e -> {
            if (kruisen.isGekleurd()) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(controller.getLeerling().getKruisenOpmerkingen(), controller, new IcoonType(kruisen.getKleur(), "Kruisen"));
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }
        });
        grid.add(kruisen, 2, 5, 2, 1);

        //linksaf
        ButtonTechniek linksaf = new ButtonTechniek(controller.getButtonVerkeersTechniek(6), true, SchermType.VERKEERSTECHNIEK, controller);
        linksaf.setVerkeerstechniek(this);
        linksaf.setId("linksAfslaanHBox");

        linksaf.getButton().setOnMouseDragged(e -> {
            if (linksaf.isGekleurd()) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(controller.getLeerling().getLinksAfslaanOpmerkingen(), controller, new IcoonType(linksaf.getKleur(), "Links afslaan"));
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }
        });
        grid.add(linksaf, 1, 4);

        //rechtsaf
        ButtonTechniek rechtsaf = new ButtonTechniek(controller.getButtonVerkeersTechniek(7), true, SchermType.VERKEERSTECHNIEK, controller);
        rechtsaf.setVerkeerstechniek(this);
        rechtsaf.setId("rechtsAfslaanHBox");

        rechtsaf.getButton().setOnMouseDragged(e -> {
            if (rechtsaf.isGekleurd()) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(controller.getLeerling().getRechtsAfslaanOpmerkingen(), controller, new IcoonType(rechtsaf.getKleur(), "Rechts afslaan"));
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }
        });
        grid.add(rechtsaf, 0, 3);

        //Richtingsaanwijzers / pinkers
        ButtonTechniek pinkers = new ButtonTechniek(controller.getButtonVerkeersTechniek(8), true, SchermType.VERKEERSTECHNIEK, controller);
        pinkers.setVerkeerstechniek(this);
        pinkers.setId("pinkersHBox");

        pinkers.getButton().setOnMouseDragged(e -> {
            if (pinkers.isGekleurd()) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(controller.getLeerling().getPinkersOpmerkingen(), controller, new IcoonType(pinkers.getKleur(), "Richtingsaanwijzers"));
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }
        });
        grid.add(pinkers, 0, 2);

        //OpenbareWeg
        ButtonTechniek openbareWeg = new ButtonTechniek(controller.getButtonVerkeersTechniek(9), true, SchermType.VERKEERSTECHNIEK, controller);
        openbareWeg.setVerkeerstechniek(this);
        openbareWeg.setId("OWHBox");

        openbareWeg.getButton().setOnMouseDragged(e -> {
            if (openbareWeg.isGekleurd()) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(controller.getLeerling().getOwOpmerkingen(), controller, new IcoonType(openbareWeg.getKleur(), "Openbare weg"));
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }
        });
        grid.add(openbareWeg, 1, 1);

        Image middenGrid = new Image("images/verkeerstechniekIcoon/verkeerstechniekWit.png");
        middenGridImageView = new ImageView(middenGrid);
        middenGridImageView.setFitWidth(150);
        middenGridImageView.setFitHeight(150);

        verkeerstechniekGroup = controller.getIcoonToestanden().getVerkeerstechniekGroup();
        verkeerstechniekGroup.getChildren().add(middenGridImageView);
        grid.add(verkeerstechniekGroup, 2, 2, 2, 2);
        controller.getIcoonToestanden().kleurRotonde();

        Image cirkel = new Image("images/cirkel.png");
        ImageView cirkelImageView = new ImageView(cirkel);
        cirkelImageView.setFitWidth(600);
        cirkelImageView.setFitHeight(600);

        grid.setBlendMode(BlendMode.ADD);

        Group evaluatieGroup = new Group();
        evaluatieGroup.setId("evaluatieGroup");
        evaluatieGroup.getChildren().add(cirkelImageView);
        evaluatieGroup.getChildren().add(grid);

        //RandInfo
        VBox left = new VBox();
        left.setId("randinfoLeft");

//        Image terugPijl = new Image("images/terug-pijl.png");
//        ImageView terugPijlImageView = new ImageView(terugPijl);
//        terugPijlImageView.setFitWidth(100);
//        terugPijlImageView.setFitHeight(50);
//        Button terugBtn = new Button("", terugPijlImageView);
//        terugBtn.setId("menuButton");
//
//        terugBtn.setOnAction(e -> {
//            controller.getDashboard().knopVerkeerstechniek();
//            controller.getDashboard().setScene(scene);
//            scene.setRoot(controller.getDashboard());
//        });
        Image rechthoek = new Image("images/verkeerslicht.png");
        ImageView rechthoekImageView = new ImageView(rechthoek);
        rechthoekImageView.setFitWidth(70);
        rechthoekImageView.setFitHeight(200);

        VBox lichten = new VBox();
        lichten.setId("lichten");
        Image groenLicht = new Image("images/verkeerslicht-groen.png");

        Image roodLicht = new Image("images/verkeerslicht-rood.png");
        ImageView roodLichtImageView = new ImageView(roodLicht);
        roodLichtImageView.setFitWidth(40);
        roodLichtImageView.setFitHeight(40);
        Button roodLichtButton = new Button("", roodLichtImageView);
        roodLichtButton.setId("icoontjesBtns");

        roodLichtButton.setOnAction(e -> {
            
            DropShadow ds = new DropShadow();
            ds.setOffsetY(3.0);
            ds.setOffsetX(3.0);
            ds.setColor(Color.LIGHTGREY);

            if (roodLichtButton.getEffect() == null) {
                roodLichtButton.setEffect(ds);

            } else {
                roodLichtButton.setEffect(null);
            }
            
            Toestand[] icoontjesToestand = {
                controller.getLeerling().getButtonVerkeersTechniek(0).getHuidigeToestand(),
                controller.getLeerling().getButtonVerkeersTechniek(1).getHuidigeToestand(),
                controller.getLeerling().getButtonVerkeersTechniek(2).getHuidigeToestand(),
                controller.getLeerling().getButtonVerkeersTechniek(3).getHuidigeToestand(),
                controller.getLeerling().getButtonVerkeersTechniek(4).getHuidigeToestand(),
                controller.getLeerling().getButtonVerkeersTechniek(5).getHuidigeToestand(),
                controller.getLeerling().getButtonVerkeersTechniek(6).getHuidigeToestand(),
                controller.getLeerling().getButtonVerkeersTechniek(7).getHuidigeToestand(),
                controller.getLeerling().getButtonVerkeersTechniek(8).getHuidigeToestand(),
                controller.getLeerling().getButtonVerkeersTechniek(9).getHuidigeToestand()};
            HBox[] icoontjesDisplay = {voorrang, orders, snelheid, afstand, inhalen, kruisen, linksaf, rechtsaf, pinkers, openbareWeg};

            if (oranjeLichtActive || groenLichtActive) {
                for (HBox icoontjes : icoontjesDisplay) {
                    icoontjes.setVisible(true);
                }

                oranjeLichtActive = false;
                groenLichtActive = false;
            }

            if (!roodLichtActive) {
                for (int i = 0; i < icoontjesToestand.length; i++) {
                    Toestand toestand = icoontjesToestand[i];
                    if (toestand != Toestand.ROOD) {
                        for (int j = 0; j < icoontjesDisplay.length; j++) {
                            HBox icoontje = icoontjesDisplay[j];
                            if (i == j) {
                                icoontje.setVisible(false);
                            }
                        }
                    }
                }
                roodLichtActive = true;
            } else {
                for (HBox icoontjes : icoontjesDisplay) {
                    icoontjes.setVisible(true);
                }
                roodLichtActive = false;
            }
        });

        Image oranjeLicht = new Image("images/verkeerslicht-oranje.png");
        ImageView oranjeLichtImageView = new ImageView(oranjeLicht);
        oranjeLichtImageView.setFitWidth(40);
        oranjeLichtImageView.setFitHeight(40);
        Button oranjeLichtButton = new Button("", oranjeLichtImageView);
        oranjeLichtButton.setId("icoontjesBtns");

        oranjeLichtButton.setOnAction(e -> {
            
            DropShadow ds = new DropShadow();
            ds.setOffsetY(3.0);
            ds.setOffsetX(3.0);
            ds.setColor(Color.LIGHTGREY);

            if (oranjeLichtButton.getEffect() == null) {
                oranjeLichtButton.setEffect(ds);

            } else {
                oranjeLichtButton.setEffect(null);
            }
            
            Toestand[] icoontjesToestand = {
                controller.getLeerling().getButtonVerkeersTechniek(0).getHuidigeToestand(),
                controller.getLeerling().getButtonVerkeersTechniek(1).getHuidigeToestand(),
                controller.getLeerling().getButtonVerkeersTechniek(2).getHuidigeToestand(),
                controller.getLeerling().getButtonVerkeersTechniek(3).getHuidigeToestand(),
                controller.getLeerling().getButtonVerkeersTechniek(4).getHuidigeToestand(),
                controller.getLeerling().getButtonVerkeersTechniek(5).getHuidigeToestand(),
                controller.getLeerling().getButtonVerkeersTechniek(6).getHuidigeToestand(),
                controller.getLeerling().getButtonVerkeersTechniek(7).getHuidigeToestand(),
                controller.getLeerling().getButtonVerkeersTechniek(8).getHuidigeToestand(),
                controller.getLeerling().getButtonVerkeersTechniek(9).getHuidigeToestand()};
            HBox[] icoontjesDisplay = {voorrang, orders, snelheid, afstand, inhalen, kruisen, linksaf, rechtsaf, pinkers, openbareWeg};

            if (roodLichtActive || groenLichtActive) {
                for (HBox icoontjes : icoontjesDisplay) {
                    icoontjes.setVisible(true);
                }

                roodLichtActive = false;
                groenLichtActive = false;
            }

            if (!oranjeLichtActive) {
                for (int i = 0; i < icoontjesToestand.length; i++) {
                    Toestand toestand = icoontjesToestand[i];
                    if (toestand != Toestand.ORANJE) {
                        for (int j = 0; j < icoontjesDisplay.length; j++) {
                            HBox icoontje = icoontjesDisplay[j];
                            if (i == j) {
                                icoontje.setVisible(false);
                            }
                        }
                    }
                }
                oranjeLichtActive = true;
            } else {
                for (HBox icoontjes : icoontjesDisplay) {
                    icoontjes.setVisible(true);
                }
                oranjeLichtActive = false;
            }
        });

        ImageView groenLichtImageView = new ImageView(groenLicht);
        groenLichtImageView.setFitWidth(40);
        groenLichtImageView.setFitHeight(40);
        Button groenLichtButton = new Button("", groenLichtImageView);
        groenLichtButton.setId("icoontjesBtns");

        groenLichtButton.setOnAction(e -> {
            
            DropShadow ds = new DropShadow();
            ds.setOffsetY(3.0);
            ds.setOffsetX(3.0);
            ds.setColor(Color.LIGHTGREY);

            if (groenLichtButton.getEffect() == null) {
                groenLichtButton.setEffect(ds);

            } else {
                groenLichtButton.setEffect(null);
            }
            
            Toestand[] icoontjesToestand = {
                controller.getLeerling().getButtonVerkeersTechniek(0).getHuidigeToestand(),
                controller.getLeerling().getButtonVerkeersTechniek(1).getHuidigeToestand(),
                controller.getLeerling().getButtonVerkeersTechniek(2).getHuidigeToestand(),
                controller.getLeerling().getButtonVerkeersTechniek(3).getHuidigeToestand(),
                controller.getLeerling().getButtonVerkeersTechniek(4).getHuidigeToestand(),
                controller.getLeerling().getButtonVerkeersTechniek(5).getHuidigeToestand(),
                controller.getLeerling().getButtonVerkeersTechniek(6).getHuidigeToestand(),
                controller.getLeerling().getButtonVerkeersTechniek(7).getHuidigeToestand(),
                controller.getLeerling().getButtonVerkeersTechniek(8).getHuidigeToestand(),
                controller.getLeerling().getButtonVerkeersTechniek(9).getHuidigeToestand()};
            HBox[] icoontjesDisplay = {voorrang, orders, snelheid, afstand, inhalen, kruisen, linksaf, rechtsaf, pinkers, openbareWeg};

            if (roodLichtActive || oranjeLichtActive) {
                for (HBox icoontjes : icoontjesDisplay) {
                    icoontjes.setVisible(true);
                }

                roodLichtActive = false;
                oranjeLichtActive = false;
            }

            if (!groenLichtActive) {
                for (int i = 0; i < icoontjesToestand.length; i++) {
                    Toestand toestand = icoontjesToestand[i];
                    if (toestand != Toestand.GROEN) {
                        for (int j = 0; j < icoontjesDisplay.length; j++) {
                            HBox icoontje = icoontjesDisplay[j];
                            if (i == j) {
                                icoontje.setVisible(false);
                            }
                        }
                    }
                }
                groenLichtActive = true;
            } else {
                for (HBox icoontjes : icoontjesDisplay) {
                    icoontjes.setVisible(true);
                }
                groenLichtActive = false;
            }
        });

        lichten.getChildren().addAll(roodLichtButton, oranjeLichtButton, groenLichtButton);
        lichten.setBlendMode(BlendMode.ADD);

        Group verkeerslicht = new Group();
        verkeerslicht.setId("groupVerkeerslicht");
        verkeerslicht.getChildren().add(rechthoekImageView);
        verkeerslicht.getChildren().add(lichten);

        left.getChildren().addAll( verkeerslicht);

        //Menu
        Menu menu = new Menu();
        VBox right = new VBox();
        VBox menuStandaard = menu.buildMenuStandaard(controller.getLeerling());

        right.getChildren().add(menuStandaard);

        VBox menuBalk = menu.buildMenu(controller, 4);

        menu.getMenuKnop().setOnAction(e -> {
            menu.setScene(scene);
            right.getChildren().remove(menuStandaard);

            TranslateTransition tt = new TranslateTransition(Duration.millis(500), menuBalk);

            tt.setFromX(150.0 + menuBalk.getLayoutX());
            tt.setByX(-140);
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

            tt.setFromX(menuBalk.getLayoutX() + 50);
            tt.setByX(100);
            tt.setCycleCount(1);

            tt.play();
            tt.onFinishedProperty();
        });
        
        menu.getVorigScherm().setOnAction(e->{
            controller.getDashboard().knopVerkeerstechniek();
            controller.getDashboard().setScene(scene);
            scene.setRoot(controller.getDashboard());
        });

        getChildren().addAll(left, evaluatieGroup, right);

        //Opmerkingen
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
