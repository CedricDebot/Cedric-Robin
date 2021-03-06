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

public class Rijtechniek extends HBox {

    private Scene scene;
    private ImageView middenGridImageView;
    private Group rijtechniekIcoonGroup;

    private DomeinController controller;

    private boolean roodLichtActive = false;
    private boolean oranjeLichtActive = false;
    private boolean groenLichtActive = false;

    public Rijtechniek(DomeinController controller) {

        this.controller = controller;

        setId("rijtechniekHBox");
        GridPane grid = new GridPane();
        //grid.setGridLinesVisible(true);

        ColumnConstraints col1 = new ColumnConstraints(100);
        col1.setHalignment(HPos.RIGHT);
        ColumnConstraints col2 = new ColumnConstraints(100);
        col2.setHalignment(HPos.LEFT);
        ColumnConstraints col3 = new ColumnConstraints(100);
        col3.setHalignment(HPos.CENTER);
        ColumnConstraints col4 = new ColumnConstraints(100);
        col4.setHalignment(HPos.CENTER);
        ColumnConstraints col5 = new ColumnConstraints(100);
        col5.setHalignment(HPos.RIGHT);
        ColumnConstraints col6 = new ColumnConstraints(100);
        col6.setHalignment(HPos.LEFT);

        grid.getColumnConstraints().addAll(col1, col2, col3, col4, col5, col6);

        RowConstraints row1 = new RowConstraints(100);
        row1.setValignment(VPos.BOTTOM);
        RowConstraints row2 = new RowConstraints(100);
        row2.setValignment(VPos.TOP);
        RowConstraints row3 = new RowConstraints(100);
        row3.setValignment(VPos.CENTER);
        RowConstraints row4 = new RowConstraints(100);
        row4.setValignment(VPos.CENTER);
        RowConstraints row5 = new RowConstraints(100);
        row5.setValignment(VPos.BOTTOM);
        RowConstraints row6 = new RowConstraints(100);
        row6.setValignment(VPos.TOP);

        grid.getRowConstraints().addAll(row1, row2, row3, row4, row5, row6);

        //StuurTechniek
        ButtonTechniek stuur = new ButtonTechniek(controller.getButtonRijTechniek(1), true, SchermType.RIJTECHNIEK, controller);
        stuur.setRijtechniek(this);
        stuur.setId("stuurHBox");

        stuur.getButton().setOnMouseDragged(e -> {
            if (stuur.isGekleurd()) {
                RijTechniekOpmerkingen rijtechniek = new RijTechniekOpmerkingen(controller.getLeerling().getSturenOpmerkingen(), controller, new IcoonType(stuur.getKleur(), "Sturen"));
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });
        grid.add(stuur, 3, 0, 2, 1);

        //Schakelen
        ButtonTechniek schakelen = new ButtonTechniek(controller.getButtonRijTechniek(2), true, SchermType.RIJTECHNIEK, controller);
        schakelen.setRijtechniek(this);
        schakelen.setId("schakelenHBox");

        schakelen.getButton().setOnMouseDragged(e -> {
            if (stuur.isGekleurd()) {
                RijTechniekOpmerkingen rijtechniek = new RijTechniekOpmerkingen(controller.getLeerling().getSchakelenOpmerking(), controller, new IcoonType(schakelen.getKleur(), "Schakelen"));
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });
        grid.add(schakelen, 4, 1);

        //Kijken
        ButtonTechniek kijken = new ButtonTechniek(controller.getButtonRijTechniek(3), true, SchermType.RIJTECHNIEK, controller);
        kijken.setRijtechniek(this);
        kijken.setId("kijkenHBox");

        kijken.getButton().setOnMouseDragged(e -> {
            if (kijken.isGekleurd()) {
                RijTechniekOpmerkingen rijtechniek = new RijTechniekOpmerkingen(controller.getLeerling().getKijkenOpmerkingen(), controller, new IcoonType(kijken.getKleur(), "kijken"));
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });
        grid.add(kijken, 5, 2);

        //Parkeren
        ButtonTechniek parkeren = new ButtonTechniek(controller.getButtonRijTechniek(4), false, SchermType.RIJTECHNIEK, controller);
        parkeren.setRijtechniek(this);
        parkeren.setId("");

        parkeren.getButton().setOnMouseDragged(e -> {
            if (parkeren.isGekleurd()) {
                RijTechniekOpmerkingen rijtechniek = new RijTechniekOpmerkingen(controller.getLeerling().getParkerenOpmerkingen(), controller, new IcoonType(parkeren.getKleur(), "Parkeren"));
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });
        grid.add(parkeren, 5, 3);

        //Keren
        ButtonTechniek keren = new ButtonTechniek(controller.getButtonRijTechniek(5), false, SchermType.RIJTECHNIEK, controller);
        keren.setRijtechniek(this);
        keren.setId("");

        keren.getButton().setOnMouseDragged(e -> {
            if (keren.isGekleurd()) {
                RijTechniekOpmerkingen rijtechniek = new RijTechniekOpmerkingen(controller.getLeerling().getKerenOpmerkingen(), controller, new IcoonType(keren.getKleur(), "Keren"));
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });
        grid.add(keren, 4, 4);

        //Garage
        ButtonTechniek garage = new ButtonTechniek(controller.getButtonRijTechniek(6), false, SchermType.RIJTECHNIEK, controller);
        garage.setRijtechniek(this);
        garage.setId("");

        garage.getButton().setOnMouseDragged(e -> {
            if (garage.isGekleurd()) {
                RijTechniekOpmerkingen rijtechniek = new RijTechniekOpmerkingen(controller.getLeerling().getGarageOpmerkingen(), controller, new IcoonType(garage.getKleur(), "Garage"));
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });
        grid.add(garage, 3, 5);

        //Achteruit
        ButtonTechniek achteruit = new ButtonTechniek(controller.getButtonRijTechniek(7), false, SchermType.RIJTECHNIEK, controller);
        achteruit.setRijtechniek(this);
        achteruit.setId("");

        achteruit.getButton().setOnMouseDragged(e -> {
            if (achteruit.isGekleurd()) {
                RijTechniekOpmerkingen rijtechniek = new RijTechniekOpmerkingen(controller.getLeerling().getAchteruitOpmerkingen(), controller, new IcoonType(achteruit.getKleur(), "Achteruit"));
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });
        grid.add(achteruit, 2, 5);

        //Acht
        ButtonTechniek acht = new ButtonTechniek(controller.getButtonRijTechniek(8), false, SchermType.RIJTECHNIEK, controller);
        acht.setRijtechniek(this);
        acht.setId("");

        acht.getButton().setOnMouseDragged(e -> {
            if (acht.isGekleurd()) {
                RijTechniekOpmerkingen rijtechniek = new RijTechniekOpmerkingen(controller.getLeerling().getAchtOpmerkingen(), controller, new IcoonType(acht.getKleur(), "Acht"));
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });
        grid.add(acht, 1, 4);

        //Helling
        ButtonTechniek helling = new ButtonTechniek(controller.getButtonRijTechniek(9), true, SchermType.RIJTECHNIEK, controller);
        helling.setRijtechniek(this);
        helling.setId("hellingHBox");

        helling.getButton().setOnMouseDragged(e -> {
            if (helling.isGekleurd()) {
                RijTechniekOpmerkingen rijtechniek = new RijTechniekOpmerkingen(controller.getLeerling().getHellingOpmerkingen(), controller, new IcoonType(helling.getKleur(), "Helling"));
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });
        grid.add(helling, 0, 3);

        //Zithouding
        ButtonTechniek zithouding = new ButtonTechniek(controller.getButtonRijTechniek(10), true, SchermType.RIJTECHNIEK, controller);
        zithouding.setRijtechniek(this);
        zithouding.setId("zithoudingHBox");

        zithouding.getButton().setOnMouseDragged(e -> {
            if (zithouding.isGekleurd()) {
                RijTechniekOpmerkingen rijtechniek = new RijTechniekOpmerkingen(controller.getLeerling().getZithoudingOpmerkingen(), controller, new IcoonType(zithouding.getKleur(), "Zithouding"));
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });
        grid.add(zithouding, 0, 2);

        //remTechniek
        ButtonTechniek remTechniek = new ButtonTechniek(controller.getButtonRijTechniek(11), true, SchermType.RIJTECHNIEK, controller);
        remTechniek.setRijtechniek(this);
        remTechniek.setId("remtechniekHBox");

        remTechniek.getButton().setOnMouseDragged(e -> {
            if (zithouding.isGekleurd()) {
                RijTechniekOpmerkingen rijtechniek = new RijTechniekOpmerkingen(controller.getLeerling().getRemtechniekOpmerkingen(), controller, new IcoonType(remTechniek.getKleur(), "Rem techniek"));
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });
        grid.add(remTechniek, 1, 1);

        //Koppeling
        ButtonTechniek koppeling = new ButtonTechniek(controller.getButtonRijTechniek(0), true, SchermType.RIJTECHNIEK, controller);
        koppeling.setRijtechniek(this);
        koppeling.setId("embrayageHBox");

        koppeling.getButton().setOnMouseDragged(e -> {
            if (koppeling.isGekleurd()) {
                RijTechniekOpmerkingen rijtechniek = new RijTechniekOpmerkingen(controller.getLeerling().getEmbrayageOpmerkingen(), controller, new IcoonType(koppeling.getKleur(), "Koppeling"));
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });

        grid.add(koppeling, 2, 0);

        Image middenGrid = new Image("images/rijtechniekIcoon/stuurWit.png");
        middenGridImageView = new ImageView(middenGrid);
        middenGridImageView.setFitWidth(150);
        middenGridImageView.setFitHeight(150);

        rijtechniekIcoonGroup = controller.getIcoonToestanden().getRijtechniekIcoonGroup();
        //rijtechniekIcoonGroup.setId("rijtechniekIcoonGroup");
        rijtechniekIcoonGroup.getChildren().add(middenGridImageView);
        grid.add(rijtechniekIcoonGroup, 2, 2, 2, 2);
        controller.getIcoonToestanden().kleurStuur();

        Image cirkel = new Image("images/cirkel.png");
        ImageView cirkelImageView = new ImageView(cirkel);
        cirkelImageView.setFitWidth(600);
        cirkelImageView.setFitHeight(600);

        grid.setBlendMode(BlendMode.ADD);

        Group evaluatieGroup = new Group();
        evaluatieGroup.setId("evaluatieGroup");
        evaluatieGroup.getChildren().add(cirkelImageView);
        evaluatieGroup.getChildren().add(grid);

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
//            controller.getDashboard().knopRijtechniek();
//            controller.getDashboard().setScene(scene);
//            scene.setRoot(controller.getDashboard());
//        });

        Image rechthoek = new Image("images/verkeerslicht.png");
        ImageView rechthoekImageView = new ImageView(rechthoek);
        rechthoekImageView.setFitWidth(70);
        rechthoekImageView.setFitHeight(200);

        VBox lichten = new VBox();
        lichten.setId("lichten");

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
                controller.getLeerling().getButtonRijTechniek(1).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(2).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(3).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(4).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(5).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(6).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(7).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(8).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(9).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(10).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(11).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(0).getHuidigeToestand()};
            HBox[] icoontjesDisplay = {stuur, schakelen, kijken, parkeren, keren, garage, achteruit, acht, helling, zithouding, remTechniek, koppeling};

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
                controller.getLeerling().getButtonRijTechniek(1).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(2).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(3).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(4).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(5).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(6).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(7).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(8).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(9).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(10).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(11).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(0).getHuidigeToestand()};
            HBox[] icoontjesDisplay = {stuur, schakelen, kijken, parkeren, keren, garage, achteruit, acht, helling, zithouding, remTechniek, koppeling};

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

        Image groenLicht = new Image("images/verkeerslicht-groen.png");
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
                controller.getLeerling().getButtonRijTechniek(1).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(2).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(3).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(4).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(5).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(6).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(7).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(8).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(9).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(10).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(11).getHuidigeToestand(),
                controller.getLeerling().getButtonRijTechniek(0).getHuidigeToestand()};
            HBox[] icoontjesDisplay = {stuur, schakelen, kijken, parkeren, keren, garage, achteruit, acht, helling, zithouding, remTechniek, koppeling};

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
        Menu menu = new Menu();

        VBox right = new VBox();

        VBox menuStandaard = menu.buildMenuStandaard(controller.getLeerling());

        right.getChildren().add(menuStandaard);

        VBox menuBalk = menu.buildMenu(controller, 2);

        menu.getMenuKnop().setOnAction(e -> {
            menu.setScene(scene);
            right.getChildren().remove(menuStandaard);

            TranslateTransition tt = new TranslateTransition(Duration.millis(500), menuBalk);

            tt.setFromX(150.0 + menuBalk.getLayoutX());
            tt.setByX(-130);
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
            controller.getDashboard().knopRijtechniek();
            controller.getDashboard().setScene(scene);
            scene.setRoot(controller.getDashboard());
        });

        getChildren().addAll(left, evaluatieGroup, right);
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
