package gui;

import domein.AttitudeOpmerking;
import domein.DomeinController;
import domein.SchermType;
import domein.Toestand;
import javafx.animation.TranslateTransition;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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

        HBox stuurHBox = new HBox();
        stuurHBox.setId("stuurHBox");
        Image stuurBegin = new Image("images/rijtechniek/stuur" + controller.getLeerling().getRijtechniekDom().getStuurTechniek() + ".png");
        ImageView stuurImageView = new ImageView(stuurBegin);
        stuurImageView.setFitWidth(50);
        stuurImageView.setFitHeight(50);
        Button stuurBtn = new Button("", stuurImageView);
        stuurBtn.setId("icoontjesBtns");

        stuurBtn.setOnMouseDragged(e -> {
            IcoonStuurOpm icoonStuur = new IcoonStuurOpm(controller);
            icoonStuur.setScene(scene);
            scene.setRoot(icoonStuur);
        });
        Image stuurWit = new Image("images/rijtechniek/stuurWit.png");
        Image stuurRood = new Image("images/rijtechniek/stuurRood.png");
        Image stuurOranje = new Image("images/rijtechniek/stuurOranje.png");
        Image stuurGroen = new Image("images/rijtechniek/stuurGroen.png");

        stuurBtn.setOnAction(e -> {
            if (controller.getLeerling().getRijtechniekDom().getStuurTechniek() == Toestand.WIT) {
                controller.getLeerling().getRijtechniekDom().setStuurTechniek(Toestand.ROOD);
                stuurImageView.setImage(stuurRood);
                controller.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getStuurTechniek() == Toestand.ROOD) {
                controller.getLeerling().getRijtechniekDom().setStuurTechniek(Toestand.ORANJE);
                stuurImageView.setImage(stuurOranje);
                controller.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getStuurTechniek() == Toestand.ORANJE) {
                controller.getLeerling().getRijtechniekDom().setStuurTechniek(Toestand.GROEN);
                stuurImageView.setImage(stuurGroen);
                controller.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getStuurTechniek() == Toestand.GROEN) {
                controller.getLeerling().getRijtechniekDom().setStuurTechniek(Toestand.WIT);
                stuurImageView.setImage(stuurWit);
                controller.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            }
        });

        Rectangle stuurEva1 = new Rectangle(12, 12, Color.WHITE);
        Rectangle stuurEva2 = new Rectangle(12, 12, Color.WHITE);
        Rectangle stuurEva3 = new Rectangle(12, 12, Color.WHITE);

        VBox stuurEvamomenten = new VBox();
        stuurEvamomenten.setId("evamomenten");
        stuurEvamomenten.getChildren().addAll(stuurEva1, stuurEva2, stuurEva3);

        stuurHBox.getChildren().addAll(stuurBtn, stuurEvamomenten);

        grid.add(stuurHBox, 3, 0, 2, 1);

        HBox schakelenHBox = new HBox();
        schakelenHBox.setId("schakelenHBox");
        Image schakelenBegin = new Image("images/rijtechniek/schakelen" + controller.getLeerling().getRijtechniekDom().getSchakelTechniek() + ".png");
        ImageView schakelenImageView = new ImageView(schakelenBegin);
        schakelenImageView.setFitWidth(50);
        schakelenImageView.setFitHeight(50);
        Button schakelenBtn = new Button("", schakelenImageView);
        schakelenBtn.setId("icoontjesBtns");

        Image schakelenWit = new Image("images/rijtechniek/schakelenWit.png");
        Image schakelenRood = new Image("images/rijtechniek/schakelenRood.png");
        Image schakelenOranje = new Image("images/rijtechniek/schakelenOranje.png");
        Image schakelenGroen = new Image("images/rijtechniek/schakelenGroen.png");

        schakelenBtn.setOnAction(e -> {
            if (controller.getLeerling().getRijtechniekDom().getSchakelTechniek() == Toestand.WIT) {
                controller.getLeerling().getRijtechniekDom().setSchakelTechniek(Toestand.ROOD);
                schakelenImageView.setImage(schakelenRood);
                controller.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getSchakelTechniek() == Toestand.ROOD) {
                controller.getLeerling().getRijtechniekDom().setSchakelTechniek(Toestand.ORANJE);
                schakelenImageView.setImage(schakelenOranje);
                controller.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getSchakelTechniek() == Toestand.ORANJE) {
                controller.getLeerling().getRijtechniekDom().setSchakelTechniek(Toestand.GROEN);
                schakelenImageView.setImage(schakelenGroen);
                controller.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getSchakelTechniek() == Toestand.GROEN) {
                controller.getLeerling().getRijtechniekDom().setSchakelTechniek(Toestand.WIT);
                schakelenImageView.setImage(schakelenWit);
                controller.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            }
        });

        Rectangle schakelenEva1 = new Rectangle(12, 12, Color.WHITE);
        Rectangle schakelenEva2 = new Rectangle(12, 12, Color.WHITE);
        Rectangle schakelenEva3 = new Rectangle(12, 12, Color.WHITE);

        VBox schakelenEvamomenten = new VBox();
        schakelenEvamomenten.setId("evamomenten");
        schakelenEvamomenten.getChildren().addAll(schakelenEva1, schakelenEva2, schakelenEva3);

        schakelenHBox.getChildren().addAll(schakelenBtn, schakelenEvamomenten);

        grid.add(schakelenHBox, 4, 1);

        HBox kijkenHBox = new HBox();
        kijkenHBox.setId("kijkenHBox");
        Image kijkenBegin = new Image("images/rijtechniek/kijken" + controller.getLeerling().getRijtechniekDom().getKijkTechniek() + ".png");
        ImageView kijkenImageView = new ImageView(kijkenBegin);
        kijkenImageView.setFitWidth(50);
        kijkenImageView.setFitHeight(50);
        Button kijkenBtn = new Button("", kijkenImageView);
        kijkenBtn.setId("icoontjesBtns");
        //grid.add(kijkenBtn, 5, 2);

        Image kijkenWit = new Image("images/rijtechniek/kijkenWit.png");
        Image kijkenRood = new Image("images/rijtechniek/kijkenRood.png");
        Image kijkenOranje = new Image("images/rijtechniek/kijkenOranje.png");
        Image kijkenGroen = new Image("images/rijtechniek/kijkenGroen.png");

        kijkenBtn.setOnAction(e -> {
            if (controller.getLeerling().getRijtechniekDom().getKijkTechniek() == Toestand.WIT) {
                controller.getLeerling().getRijtechniekDom().setKijkTechniek(Toestand.ROOD);
                kijkenImageView.setImage(kijkenRood);
                controller.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getKijkTechniek() == Toestand.ROOD) {
                controller.getLeerling().getRijtechniekDom().setKijkTechniek(Toestand.ORANJE);
                kijkenImageView.setImage(kijkenOranje);
                controller.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getKijkTechniek() == Toestand.ORANJE) {
                controller.getLeerling().getRijtechniekDom().setKijkTechniek(Toestand.GROEN);
                kijkenImageView.setImage(kijkenGroen);
                controller.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getKijkTechniek() == Toestand.GROEN) {
                controller.getLeerling().getRijtechniekDom().setKijkTechniek(Toestand.WIT);
                kijkenImageView.setImage(kijkenWit);
                controller.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            }
        });

        Rectangle kijkenEva1 = new Rectangle(12, 12, Color.WHITE);
        Rectangle kijkenEva2 = new Rectangle(12, 12, Color.WHITE);
        Rectangle kijkenEva3 = new Rectangle(12, 12, Color.WHITE);

        VBox kijkenEvamomenten = new VBox();
        kijkenEvamomenten.setId("evamomenten");
        kijkenEvamomenten.getChildren().addAll(kijkenEva1, kijkenEva2, kijkenEva3);

        kijkenHBox.getChildren().addAll(kijkenBtn, kijkenEvamomenten);

        grid.add(kijkenHBox, 5, 2);

        HBox parkerenHBox = new HBox();
        Image parkerenBegin = new Image("images/rijtechniek/parkeren" + controller.getLeerling().getRijtechniekDom().getParkeren() + ".png");
        ImageView parkerenImageView = new ImageView(parkerenBegin);
        parkerenImageView.setId("parkerenIcoon");
        parkerenImageView.setFitWidth(50);
        parkerenImageView.setFitHeight(50);
        Button parkerenBtn = new Button("", parkerenImageView);
        parkerenBtn.setId("icoontjesBtns");
        parkerenHBox.getChildren().add(parkerenBtn);
        grid.add(parkerenHBox, 5, 3);

        Image parkerenWit = new Image("images/rijtechniek/parkerenWit.png");
        Image parkerenRood = new Image("images/rijtechniek/parkerenRood.png");
        Image parkerenOranje = new Image("images/rijtechniek/parkerenOranje.png");
        Image parkerenGroen = new Image("images/rijtechniek/parkerenGroen.png");

        
        parkerenBtn.setOnAction(e -> {
            if (controller.getLeerling().getRijtechniekDom().getParkeren() == Toestand.WIT) {
                controller.getLeerling().getRijtechniekDom().setParkeren(Toestand.ROOD);
                parkerenImageView.setImage(parkerenRood);
                controller.getLeerling().getRijtechniekDom().bepaalToestandRechts();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getParkeren() == Toestand.ROOD) {
                controller.getLeerling().getRijtechniekDom().setParkeren(Toestand.ORANJE);
                parkerenImageView.setImage(parkerenOranje);
                controller.getLeerling().getRijtechniekDom().bepaalToestandRechts();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getParkeren() == Toestand.ORANJE) {
                controller.getLeerling().getRijtechniekDom().setParkeren(Toestand.GROEN);
                parkerenImageView.setImage(parkerenGroen);
                controller.getLeerling().getRijtechniekDom().bepaalToestandRechts();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getParkeren() == Toestand.GROEN) {
                controller.getLeerling().getRijtechniekDom().setParkeren(Toestand.WIT);
                parkerenImageView.setImage(parkerenWit);
                controller.getLeerling().getRijtechniekDom().bepaalToestandRechts();
                kleurStuur();
            }
        });

        HBox kerenHBox = new HBox();
        Image kerenBegin = new Image("images/rijtechniek/keren" + controller.getLeerling().getRijtechniekDom().getKeren() + ".png");
        ImageView kerenImageView = new ImageView(kerenBegin);
        kerenImageView.setFitWidth(50);
        kerenImageView.setFitHeight(50);
        Button kerenBtn = new Button("", kerenImageView);
        kerenBtn.setId("icoontjesBtns");
        kerenHBox.getChildren().add(kerenBtn);
        grid.add(kerenHBox, 4, 4);

        Image kerenWit = new Image("images/rijtechniek/kerenWit.png");
        Image kerenRood = new Image("images/rijtechniek/kerenRood.png");
        Image kerenOranje = new Image("images/rijtechniek/kerenOranje.png");
        Image kerenGroen = new Image("images/rijtechniek/kerenGroen.png");

        kerenBtn.setOnAction(e -> {
            if (controller.getLeerling().getRijtechniekDom().getKeren() == Toestand.WIT) {
                controller.getLeerling().getRijtechniekDom().setKeren(Toestand.ROOD);
                kerenImageView.setImage(kerenRood);
                controller.getLeerling().getRijtechniekDom().bepaalToestandRechts();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getKeren() == Toestand.ROOD) {
                controller.getLeerling().getRijtechniekDom().setKeren(Toestand.ORANJE);
                kerenImageView.setImage(kerenOranje);
                controller.getLeerling().getRijtechniekDom().bepaalToestandRechts();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getKeren() == Toestand.ORANJE) {
                controller.getLeerling().getRijtechniekDom().setKeren(Toestand.GROEN);
                kerenImageView.setImage(kerenGroen);
                controller.getLeerling().getRijtechniekDom().bepaalToestandRechts();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getKeren() == Toestand.GROEN) {
                controller.getLeerling().getRijtechniekDom().setKeren(Toestand.WIT);
                kerenImageView.setImage(kerenWit);
                controller.getLeerling().getRijtechniekDom().bepaalToestandRechts();
                kleurStuur();
            }
        });

        HBox garageHBox = new HBox();
        Image garageBegin = new Image("images/rijtechniek/garage" + controller.getLeerling().getRijtechniekDom().getGarage() + ".png");
        ImageView garageImageView = new ImageView(garageBegin);
        garageImageView.setFitWidth(50);
        garageImageView.setFitHeight(50);
        Button garageBtn = new Button("", garageImageView);
        garageBtn.setId("icoontjesBtns");
        garageHBox.getChildren().add(garageBtn);
        grid.add(garageHBox, 3, 5);

        Image garageWit = new Image("images/rijtechniek/garageWit.png");
        Image garageRood = new Image("images/rijtechniek/garageRood.png");
        Image garageOranje = new Image("images/rijtechniek/garageOranje.png");
        Image garageGroen = new Image("images/rijtechniek/garageGroen.png");

        garageBtn.setOnAction(e -> {
            if (controller.getLeerling().getRijtechniekDom().getGarage() == Toestand.WIT) {
                controller.getLeerling().getRijtechniekDom().setGarage(Toestand.ROOD);
                garageImageView.setImage(garageRood);
                controller.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getGarage() == Toestand.ROOD) {
                controller.getLeerling().getRijtechniekDom().setGarage(Toestand.ORANJE);
                garageImageView.setImage(garageOranje);
                controller.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getGarage() == Toestand.ORANJE) {
                controller.getLeerling().getRijtechniekDom().setGarage(Toestand.GROEN);
                garageImageView.setImage(garageGroen);
                controller.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getGarage() == Toestand.GROEN) {
                controller.getLeerling().getRijtechniekDom().setGarage(Toestand.WIT);
                garageImageView.setImage(garageWit);
                controller.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            }
        });

        HBox achteruitHBox = new HBox();
        Image achteruitBegin = new Image("images/rijtechniek/achteruit" + controller.getLeerling().getRijtechniekDom().getAchteruit() + ".png");
        ImageView achteruitImageView = new ImageView(achteruitBegin);
        achteruitImageView.setFitWidth(50);
        achteruitImageView.setFitHeight(50);
        Button achteruitBtn = new Button("", achteruitImageView);
        achteruitBtn.setId("icoontjesBtns");
        achteruitHBox.getChildren().add(achteruitBtn);
        grid.add(achteruitHBox, 2, 5);

        Image achteruitWit = new Image("images/rijtechniek/achteruitWit.png");
        Image achteruitRood = new Image("images/rijtechniek/achteruitRood.png");
        Image achteruitOranje = new Image("images/rijtechniek/achteruitOranje.png");
        Image achteruitGroen = new Image("images/rijtechniek/achteruitGroen.png");

        achteruitBtn.setOnAction(e -> {
            if (controller.getLeerling().getRijtechniekDom().getAchteruit() == Toestand.WIT) {
                controller.getLeerling().getRijtechniekDom().setAchteruit(Toestand.ROOD);
                achteruitImageView.setImage(achteruitRood);
                controller.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getAchteruit() == Toestand.ROOD) {
                controller.getLeerling().getRijtechniekDom().setAchteruit(Toestand.ORANJE);
                achteruitImageView.setImage(achteruitOranje);
                controller.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getAchteruit() == Toestand.ORANJE) {
                controller.getLeerling().getRijtechniekDom().setAchteruit(Toestand.GROEN);
                achteruitImageView.setImage(achteruitGroen);
                controller.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getAchteruit() == Toestand.GROEN) {
                controller.getLeerling().getRijtechniekDom().setAchteruit(Toestand.WIT);
                achteruitImageView.setImage(achteruitWit);
                controller.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            }
        });

        HBox achtHBox = new HBox();
        Image achtBegin = new Image("images/rijtechniek/acht" + controller.getLeerling().getRijtechniekDom().getAcht() + ".png");
        ImageView achtImageView = new ImageView(achtBegin);
        achtImageView.setFitWidth(50);
        achtImageView.setFitHeight(50);
        Button achtBtn = new Button("", achtImageView);
        achtBtn.setId("icoontjesBtns");
        achtHBox.getChildren().add(achtBtn);
        grid.add(achtHBox, 1, 4);

        Image achtWit = new Image("images/rijtechniek/achtWit.png");
        Image achtRood = new Image("images/rijtechniek/achtRood.png");
        Image achtOranje = new Image("images/rijtechniek/achtOranje.png");
        Image achtGroen = new Image("images/rijtechniek/achtGroen.png");

        achtBtn.setOnAction(e -> {
            if (controller.getLeerling().getRijtechniekDom().getAcht() == Toestand.WIT) {
                controller.getLeerling().getRijtechniekDom().setAcht(Toestand.ROOD);
                achtImageView.setImage(achtRood);
                controller.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getAcht() == Toestand.ROOD) {
                controller.getLeerling().getRijtechniekDom().setAcht(Toestand.ORANJE);
                achtImageView.setImage(achtOranje);
                controller.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getAcht() == Toestand.ORANJE) {
                controller.getLeerling().getRijtechniekDom().setAcht(Toestand.GROEN);
                achtImageView.setImage(achtGroen);
                controller.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getAcht() == Toestand.GROEN) {
                controller.getLeerling().getRijtechniekDom().setAcht(Toestand.WIT);
                achtImageView.setImage(achtWit);
                controller.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            }
        });

        HBox hellingHBox = new HBox();
        hellingHBox.setId("hellingHBox");
        Image hellingBegin = new Image("images/rijtechniek/helling" + controller.getLeerling().getRijtechniekDom().getHelling() + ".png");
        ImageView hellingImageView = new ImageView(hellingBegin);
        hellingImageView.setFitWidth(50);
        hellingImageView.setFitHeight(50);
        Button hellingBtn = new Button("", hellingImageView);
        hellingBtn.setId("icoontjesBtns");

        Image hellingWit = new Image("images/rijtechniek/hellingWit.png");
        Image hellingRood = new Image("images/rijtechniek/hellingRood.png");
        Image hellingOranje = new Image("images/rijtechniek/hellingOranje.png");
        Image hellingGroen = new Image("images/rijtechniek/hellingGroen.png");

        hellingBtn.setOnAction(e -> {
            if (controller.getLeerling().getRijtechniekDom().getHelling() == Toestand.WIT) {
                controller.getLeerling().getRijtechniekDom().setHelling(Toestand.ROOD);
                hellingImageView.setImage(hellingRood);
                controller.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getHelling() == Toestand.ROOD) {
                controller.getLeerling().getRijtechniekDom().setHelling(Toestand.ORANJE);
                hellingImageView.setImage(hellingOranje);
                controller.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getHelling() == Toestand.ORANJE) {
                controller.getLeerling().getRijtechniekDom().setHelling(Toestand.GROEN);
                hellingImageView.setImage(hellingGroen);
                controller.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getHelling() == Toestand.GROEN) {
                controller.getLeerling().getRijtechniekDom().setHelling(Toestand.WIT);
                hellingImageView.setImage(hellingWit);
                controller.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            }
        });

        Rectangle bergopEva1 = new Rectangle(12, 12, Color.WHITE);
        Rectangle bergopEva2 = new Rectangle(12, 12, Color.WHITE);
        Rectangle bergopEva3 = new Rectangle(12, 12, Color.WHITE);

        VBox bergopEvamomenten = new VBox();
        bergopEvamomenten.setId("evamomenten");
        bergopEvamomenten.getChildren().addAll(bergopEva1, bergopEva2, bergopEva3);

        hellingHBox.getChildren().addAll(hellingBtn, bergopEvamomenten);

        grid.add(hellingHBox, 0, 3);

        HBox zithoudingHBox = new HBox();
        zithoudingHBox.setId("zithoudingHBox");
        Image zithoudingBegin = new Image("images/rijtechniek/zithouding" + controller.getLeerling().getRijtechniekDom().getZithouding() + ".png");
        ImageView zithoudingImageView = new ImageView(zithoudingBegin);
        zithoudingImageView.setFitWidth(50);
        zithoudingImageView.setFitHeight(50);
        Button zithoudingBtn = new Button("", zithoudingImageView);
        zithoudingBtn.setId("icoontjesBtns");

        Image zithoudingWit = new Image("images/rijtechniek/zithoudingWit.png");
        Image zithoudingRood = new Image("images/rijtechniek/zithoudingRood.png");
        Image zithoudingOranje = new Image("images/rijtechniek/zithoudingOranje.png");
        Image zithoudingGroen = new Image("images/rijtechniek/zithoudingGroen.png");

        zithoudingBtn.setOnAction(e -> {
            if (controller.getLeerling().getRijtechniekDom().getZithouding() == Toestand.WIT) {
                controller.getLeerling().getRijtechniekDom().setZithouding(Toestand.ROOD);
                zithoudingImageView.setImage(zithoudingRood);
                controller.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getZithouding() == Toestand.ROOD) {
                controller.getLeerling().getRijtechniekDom().setZithouding(Toestand.ORANJE);
                zithoudingImageView.setImage(zithoudingOranje);
                controller.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getZithouding() == Toestand.ORANJE) {
                controller.getLeerling().getRijtechniekDom().setZithouding(Toestand.GROEN);
                zithoudingImageView.setImage(zithoudingGroen);
                controller.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getZithouding() == Toestand.GROEN) {
                controller.getLeerling().getRijtechniekDom().setZithouding(Toestand.WIT);
                zithoudingImageView.setImage(zithoudingWit);
                controller.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            }
        });

        Rectangle zithoudingEva1 = new Rectangle(12, 12, Color.WHITE);
        Rectangle zithoudingEva2 = new Rectangle(12, 12, Color.WHITE);
        Rectangle zithoudingEva3 = new Rectangle(12, 12, Color.WHITE);

        VBox zithoudingEvamomenten = new VBox();
        zithoudingEvamomenten.setId("evamomenten");
        zithoudingEvamomenten.getChildren().addAll(zithoudingEva1, zithoudingEva2, zithoudingEva3);

        zithoudingHBox.getChildren().addAll(zithoudingBtn, zithoudingEvamomenten);

        grid.add(zithoudingHBox, 0, 2);

        HBox remtechniekHBox = new HBox();
        remtechniekHBox.setId("remtechniekHBox");
        Image remtechniekBegin = new Image("images/rijtechniek/rem" + controller.getLeerling().getRijtechniekDom().getRemtechniek() + ".png");
        ImageView remtechniekImageView = new ImageView(remtechniekBegin);
        remtechniekImageView.setFitWidth(50);
        remtechniekImageView.setFitHeight(50);
        Button remtechniekBtn = new Button("", remtechniekImageView);
        remtechniekBtn.setId("icoontjesBtns");

        Image remtechniekWit = new Image("images/rijtechniek/remWit.png");
        Image remtechniekRood = new Image("images/rijtechniek/remRood.png");
        Image remtechniekOranje = new Image("images/rijtechniek/remOranje.png");
        Image remtechniekGroen = new Image("images/rijtechniek/remGroen.png");

        remtechniekBtn.setOnAction(e -> {
            if (controller.getLeerling().getRijtechniekDom().getRemtechniek() == Toestand.WIT) {
                controller.getLeerling().getRijtechniekDom().setRemtechniek(Toestand.ROOD);
                remtechniekImageView.setImage(remtechniekRood);
                controller.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getRemtechniek() == Toestand.ROOD) {
                controller.getLeerling().getRijtechniekDom().setRemtechniek(Toestand.ORANJE);
                remtechniekImageView.setImage(remtechniekOranje);
                controller.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getRemtechniek() == Toestand.ORANJE) {
                controller.getLeerling().getRijtechniekDom().setRemtechniek(Toestand.GROEN);
                remtechniekImageView.setImage(remtechniekGroen);
                controller.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getRemtechniek() == Toestand.GROEN) {
                controller.getLeerling().getRijtechniekDom().setRemtechniek(Toestand.WIT);
                remtechniekImageView.setImage(remtechniekWit);
                controller.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            }
        });

        Rectangle remtechniekEva1 = new Rectangle(12, 12, Color.WHITE);
        Rectangle remtechniekEva2 = new Rectangle(12, 12, Color.WHITE);
        Rectangle remtechniekEva3 = new Rectangle(12, 12, Color.WHITE);

        VBox remtechniekEvamomenten = new VBox();
        remtechniekEvamomenten.setId("evamomenten");
        remtechniekEvamomenten.getChildren().addAll(remtechniekEva1, remtechniekEva2, remtechniekEva3);

        remtechniekHBox.getChildren().addAll(remtechniekBtn, remtechniekEvamomenten);

        grid.add(remtechniekHBox, 1, 1);

        HBox embrayageHBox = new HBox();
        embrayageHBox.setId("embrayageHBox");
        Image embrayageBegin = new Image("images/rijtechniek/embrayage" + controller.getLeerling().getRijtechniekDom().getKoppeling() + ".png");
        ImageView embrayageImageView = new ImageView(embrayageBegin);
        embrayageImageView.setFitWidth(50);
        embrayageImageView.setFitHeight(50);
        Button embrayageBtn = new Button("", embrayageImageView);
        embrayageBtn.setId("icoontjesBtns");

        Image embrayageWit = new Image("images/rijtechniek/embrayageWit.png");
        Image embrayageRood = new Image("images/rijtechniek/embrayageRood.png");
        Image embrayageOranje = new Image("images/rijtechniek/embrayageOranje.png");
        Image embrayageGroen = new Image("images/rijtechniek/embrayageGroen.png");

        embrayageBtn.setOnAction(e -> {
            if (controller.getLeerling().getRijtechniekDom().getKoppeling() == Toestand.WIT) {
                controller.getLeerling().getRijtechniekDom().setKoppeling(Toestand.ROOD);
                embrayageImageView.setImage(embrayageRood);
                controller.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getKoppeling() == Toestand.ROOD) {
                controller.getLeerling().getRijtechniekDom().setKoppeling(Toestand.ORANJE);
                embrayageImageView.setImage(embrayageOranje);
                controller.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getKoppeling() == Toestand.ORANJE) {
                controller.getLeerling().getRijtechniekDom().setKoppeling(Toestand.GROEN);
                embrayageImageView.setImage(embrayageGroen);
                controller.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (controller.getLeerling().getRijtechniekDom().getKoppeling() == Toestand.GROEN) {
                controller.getLeerling().getRijtechniekDom().setKoppeling(Toestand.WIT);
                embrayageImageView.setImage(embrayageWit);
                controller.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            }
        });

        Rectangle embrayageEva1 = new Rectangle(12, 12, Color.WHITE);
        Rectangle embrayageEva2 = new Rectangle(12, 12, Color.WHITE);
        Rectangle embrayageEva3 = new Rectangle(12, 12, Color.WHITE);

        VBox embrayageEvamomenten = new VBox();
        embrayageEvamomenten.setId("evamomenten");
        embrayageEvamomenten.getChildren().addAll(embrayageEva1, embrayageEva2, embrayageEva3);

        embrayageHBox.getChildren().addAll(embrayageBtn, embrayageEvamomenten);

        grid.add(embrayageHBox, 2, 0);

        Image middenGrid = new Image("images/rijtechniekIcoon/stuurWit.png");
        middenGridImageView = new ImageView(middenGrid);
        middenGridImageView.setFitWidth(150);
        middenGridImageView.setFitHeight(150);

        rijtechniekIcoonGroup = new Group();
        //rijtechniekIcoonGroup.setId("rijtechniekIcoonGroup");
        rijtechniekIcoonGroup.getChildren().add(middenGridImageView);
        grid.add(rijtechniekIcoonGroup, 2, 2, 2, 2);

        Image cirkel = new Image("images/verkeersTechniek/cirkel.png");
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

        Image terugPijl = new Image("images/terug-pijl.png");
        ImageView terugPijlImageView = new ImageView(terugPijl);
        terugPijlImageView.setFitWidth(100);
        terugPijlImageView.setFitHeight(50);
        Button terugBtn = new Button("", terugPijlImageView);
        terugBtn.setId("menuButton");

        terugBtn.setOnAction(e -> {
            controller.getDashboard().setScene(scene);
            scene.setRoot(controller.getDashboard());
        });

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
            Toestand[] icoontjesToestand = {controller.getLeerling().getRijtechniekDom().getStuurTechniek(),
                controller.getLeerling().getRijtechniekDom().getSchakelTechniek(),
                controller.getLeerling().getRijtechniekDom().getKijkTechniek(),
                controller.getLeerling().getRijtechniekDom().getParkeren(),
                controller.getLeerling().getRijtechniekDom().getKeren(),
                controller.getLeerling().getRijtechniekDom().getGarage(),
                controller.getLeerling().getRijtechniekDom().getAchteruit(),
                controller.getLeerling().getRijtechniekDom().getAcht(),
                controller.getLeerling().getRijtechniekDom().getHelling(),
                controller.getLeerling().getRijtechniekDom().getZithouding(),
                controller.getLeerling().getRijtechniekDom().getRemtechniek(),
                controller.getLeerling().getRijtechniekDom().getKoppeling()};
            HBox[] icoontjesDisplay = {stuurHBox, schakelenHBox, kijkenHBox, parkerenHBox, kerenHBox, garageHBox, achteruitHBox, achtHBox, hellingHBox, zithoudingHBox, remtechniekHBox, embrayageHBox};

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

            Toestand[] icoontjesToestand = {controller.getLeerling().getRijtechniekDom().getStuurTechniek(),
                controller.getLeerling().getRijtechniekDom().getSchakelTechniek(),
                controller.getLeerling().getRijtechniekDom().getKijkTechniek(),
                controller.getLeerling().getRijtechniekDom().getParkeren(),
                controller.getLeerling().getRijtechniekDom().getKeren(),
                controller.getLeerling().getRijtechniekDom().getGarage(),
                controller.getLeerling().getRijtechniekDom().getAchteruit(),
                controller.getLeerling().getRijtechniekDom().getAcht(),
                controller.getLeerling().getRijtechniekDom().getHelling(),
                controller.getLeerling().getRijtechniekDom().getZithouding(),
                controller.getLeerling().getRijtechniekDom().getRemtechniek(),
                controller.getLeerling().getRijtechniekDom().getKoppeling()};
            HBox[] icoontjesDisplay = {stuurHBox, schakelenHBox, kijkenHBox, parkerenHBox, kerenHBox, garageHBox, achteruitHBox, achtHBox, hellingHBox, zithoudingHBox, remtechniekHBox, embrayageHBox};

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
            Toestand[] icoontjesToestand = {controller.getLeerling().getRijtechniekDom().getStuurTechniek(),
                controller.getLeerling().getRijtechniekDom().getSchakelTechniek(),
                controller.getLeerling().getRijtechniekDom().getKijkTechniek(),
                controller.getLeerling().getRijtechniekDom().getParkeren(),
                controller.getLeerling().getRijtechniekDom().getKeren(),
                controller.getLeerling().getRijtechniekDom().getGarage(),
                controller.getLeerling().getRijtechniekDom().getAchteruit(),
                controller.getLeerling().getRijtechniekDom().getAcht(),
                controller.getLeerling().getRijtechniekDom().getHelling(),
                controller.getLeerling().getRijtechniekDom().getZithouding(),
                controller.getLeerling().getRijtechniekDom().getRemtechniek(),
                controller.getLeerling().getRijtechniekDom().getKoppeling()};
            HBox[] icoontjesDisplay = {stuurHBox, schakelenHBox, kijkenHBox, parkerenHBox, kerenHBox, garageHBox, achteruitHBox, achtHBox, hellingHBox, zithoudingHBox, remtechniekHBox, embrayageHBox};

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

        left.getChildren().addAll(terugBtn, verkeerslicht);
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

        getChildren().addAll(left, evaluatieGroup, right);

        //Opmerkingen
        stuurBtn.setOnMouseDragged(e -> {
            if (controller.getLeerling().getRijtechniekDom().getStuurTechniek() == Toestand.ROOD) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getSturenOpmerkingen(), controller,  "images/rijtechniek/stuurRood.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (controller.getLeerling().getRijtechniekDom().getStuurTechniek() == Toestand.ORANJE) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getSturenOpmerkingen(), controller,"images/rijtechniek/stuurOranje.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (controller.getLeerling().getRijtechniekDom().getStuurTechniek() == Toestand.GROEN) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getSturenOpmerkingen(), controller,"images/rijtechniek/stuurGroen.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });

        schakelenBtn.setOnMouseDragged(e -> {
            if (controller.getLeerling().getRijtechniekDom().getSchakelTechniek() == Toestand.ROOD) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getSchakelenOpmerking(), controller,"images/rijtechniek/schakelenRood.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (controller.getLeerling().getRijtechniekDom().getSchakelTechniek() == Toestand.ORANJE) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getSchakelenOpmerking(), controller,"images/rijtechniek/schakelenOranje.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (controller.getLeerling().getRijtechniekDom().getSchakelTechniek() == Toestand.GROEN) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getSchakelenOpmerking(), controller,"images/rijtechniek/schakelenGroen.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });

        kijkenBtn.setOnMouseDragged(e -> {
            if (controller.getLeerling().getRijtechniekDom().getKijkTechniek() == Toestand.ROOD) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getKijkenOpmerkingen(),controller, "images/rijtechniek/kijkenRood.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (controller.getLeerling().getRijtechniekDom().getKijkTechniek() == Toestand.ORANJE) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getKijkenOpmerkingen(), controller,"images/rijtechniek/kijkenOranje.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (controller.getLeerling().getRijtechniekDom().getKijkTechniek() == Toestand.GROEN) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getKijkenOpmerkingen(), controller,"images/rijtechniek/kijkenGroen.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });

        parkerenBtn.setOnMouseDragged(e -> {
            if (controller.getLeerling().getRijtechniekDom().getParkeren() == Toestand.ROOD) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getParkerenOpmerkingen(), controller,"images/rijtechniek/parkerenRood.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (controller.getLeerling().getRijtechniekDom().getParkeren() == Toestand.ORANJE) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getParkerenOpmerkingen(), controller,"images/rijtechniek/parkerenOranje.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (controller.getLeerling().getRijtechniekDom().getParkeren() == Toestand.GROEN) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getParkerenOpmerkingen(), controller,"images/rijtechniek/parkerenGroen.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });

        kerenBtn.setOnMouseDragged(e -> {

            if (controller.getLeerling().getRijtechniekDom().getKeren() == Toestand.ROOD) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getKerenOpmerkingen(), controller,"images/rijtechniek/kerenRood.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (controller.getLeerling().getRijtechniekDom().getKeren() == Toestand.ORANJE) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getKerenOpmerkingen(), controller,"images/rijtechniek/kerenOranje.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (controller.getLeerling().getRijtechniekDom().getKeren() == Toestand.GROEN) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getKerenOpmerkingen(), controller,"images/rijtechniek/kerenGroen.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });

        garageBtn.setOnMouseDragged(e -> {
            if (controller.getLeerling().getRijtechniekDom().getGarage() == Toestand.ROOD) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getGarageOpmerkingen(), controller,"images/rijtechniek/garageRood.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (controller.getLeerling().getRijtechniekDom().getGarage() == Toestand.ORANJE) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getGarageOpmerkingen(), controller,"images/rijtechniek/garageOranje.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (controller.getLeerling().getRijtechniekDom().getGarage() == Toestand.GROEN) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getGarageOpmerkingen(), controller,"images/rijtechniek/garageGroen.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });

        achteruitBtn.setOnMouseDragged(e -> {

            if (controller.getLeerling().getRijtechniekDom().getAchteruit() == Toestand.ROOD) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getAchteruitOpmerkingen(), controller,"images/rijtechniek/achteruitRood.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (controller.getLeerling().getRijtechniekDom().getAchteruit() == Toestand.ORANJE) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getAchteruitOpmerkingen(), controller,"images/rijtechniek/achteruitOranje.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (controller.getLeerling().getRijtechniekDom().getAchteruit() == Toestand.GROEN) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getAchteruitOpmerkingen(), controller,"images/rijtechniek/achteruitGroen.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });

        achtBtn.setOnMouseDragged(e -> {

            if (controller.getLeerling().getRijtechniekDom().getAcht() == Toestand.ROOD) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getAchtOpmerkingen(), controller,"images/rijtechniek/achtRood.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (controller.getLeerling().getRijtechniekDom().getAcht() == Toestand.ORANJE) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getAchtOpmerkingen(), controller,"images/rijtechniek/achtOranje.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (controller.getLeerling().getRijtechniekDom().getAcht() == Toestand.GROEN) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getAchtOpmerkingen(), controller,"images/rijtechniek/achtGroen.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });

        hellingBtn.setOnMouseDragged(e -> {
            if (controller.getLeerling().getRijtechniekDom().getHelling() == Toestand.ROOD) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getHellingOpmerkingen(), controller,"images/rijtechniek/hellingRood.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (controller.getLeerling().getRijtechniekDom().getHelling() == Toestand.ORANJE) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getHellingOpmerkingen(), controller,"images/rijtechniek/hellingOranje.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (controller.getLeerling().getRijtechniekDom().getHelling() == Toestand.GROEN) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getHellingOpmerkingen(), controller,"images/rijtechniek/hellingGroen.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });

        zithoudingBtn.setOnMouseDragged(e -> {
            if (controller.getLeerling().getRijtechniekDom().getZithouding() == Toestand.ROOD) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getZithoudingOpmerkingen(), controller,"images/rijtechniek/zithoudingRood.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (controller.getLeerling().getRijtechniekDom().getZithouding() == Toestand.ORANJE) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getZithoudingOpmerkingen(), controller,"images/rijtechniek/zithoudingOranje.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (controller.getLeerling().getRijtechniekDom().getZithouding() == Toestand.GROEN) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getZithoudingOpmerkingen(), controller,"images/rijtechniek/zithoudingGroen.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });

        remtechniekBtn.setOnMouseDragged(e -> {
            if (controller.getLeerling().getRijtechniekDom().getRemtechniek() == Toestand.ROOD) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getRemtechniekOpmerkingen(), controller,"images/rijtechniek/remRood.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (controller.getLeerling().getRijtechniekDom().getRemtechniek() == Toestand.ORANJE) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getRemtechniekOpmerkingen(), controller,"images/rijtechniek/remOranje.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (controller.getLeerling().getRijtechniekDom().getRemtechniek() == Toestand.GROEN) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getRemtechniekOpmerkingen(), controller,"images/rijtechniek/remGroen.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });

        embrayageBtn.setOnMouseDragged(e -> {
            if (controller.getLeerling().getRijtechniekDom().getKoppeling() == Toestand.ROOD) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getEmbrayageOpmerkingen(), controller,"images/rijtechniek/embrayageRood.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (controller.getLeerling().getRijtechniekDom().getKoppeling() == Toestand.ORANJE) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getEmbrayageOpmerkingen(), controller,"images/rijtechniek/embrayageOranje.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (controller.getLeerling().getRijtechniekDom().getKoppeling() == Toestand.GROEN) {
                TechniekOpmerkingen rijtechniek = new TechniekOpmerkingen(controller.getLeerling().getEmbrayageOpmerkingen(), controller,"images/rijtechniek/embrayageGroen.png", SchermType.RIJTECHNIEK);
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });

    }

    public void kleurStuur() {
        kleurStuurBoven();
        kleurStuurRechts();
        kleurStuurLinks();
    }

    public void kleurStuurBoven() {
        ImageView stuurBoven = new ImageView();
        stuurBoven.setFitWidth(150);
        stuurBoven.setFitHeight(150);
        if (rijtechniekIcoonGroup.getChildren().contains(stuurBoven)) {
            rijtechniekIcoonGroup.getChildren().remove(stuurBoven);
        }

        if (controller.getLeerling().getRijtechniekDom().getRijtechniekIcoonBoven() == Toestand.GROEN) {
            Image stuurGroenBoven = new Image("images/rijtechniekIcoon/stuurGroenBoven.png");
            stuurBoven.setImage(stuurGroenBoven);
        } else if (controller.getLeerling().getRijtechniekDom().getRijtechniekIcoonBoven() == Toestand.ORANJE) {
            Image stuurOranjeBoven = new Image("images/rijtechniekIcoon/stuurOranjeBoven.png");
            stuurBoven.setImage(stuurOranjeBoven);
        }
        rijtechniekIcoonGroup.getChildren().add(stuurBoven);
    }

    public void kleurStuurRechts() {
        ImageView stuurRechts = new ImageView();
        stuurRechts.setFitWidth(150);
        stuurRechts.setFitHeight(150);
        if (rijtechniekIcoonGroup.getChildren().contains(stuurRechts)) {
            rijtechniekIcoonGroup.getChildren().remove(stuurRechts);
        }

        if (controller.getLeerling().getRijtechniekDom().getRijtechniekIcoonRechts() == Toestand.GROEN) {
            Image stuurGroenRechts = new Image("images/rijtechniekIcoon/stuurGroenRechts.png");
            stuurRechts.setImage(stuurGroenRechts);
        } else if (controller.getLeerling().getRijtechniekDom().getRijtechniekIcoonRechts() == Toestand.ORANJE) {
            Image stuurOranjeRechts = new Image("images/rijtechniekIcoon/stuurOranjeRechts.png");
            stuurRechts.setImage(stuurOranjeRechts);
        }

        rijtechniekIcoonGroup.getChildren().add(stuurRechts);
    }

    public void kleurStuurLinks() {
        ImageView stuurLinks = new ImageView();
        stuurLinks.setFitWidth(150);
        stuurLinks.setFitHeight(150);
        if (rijtechniekIcoonGroup.getChildren().contains(stuurLinks)) {
            rijtechniekIcoonGroup.getChildren().remove(stuurLinks);
        }

        if (controller.getLeerling().getRijtechniekDom().getRijtechniekIcoonLinks() == Toestand.GROEN) {
            Image stuurGroenLinks = new Image("images/rijtechniekIcoon/stuurGroenLinks.png");
            stuurLinks.setImage(stuurGroenLinks);
        } else if (controller.getLeerling().getRijtechniekDom().getRijtechniekIcoonLinks() == Toestand.ORANJE) {
            Image stuurOranjeLinks = new Image("images/rijtechniekIcoon/stuurOranjeLinks.png");
            stuurLinks.setImage(stuurOranjeLinks);
        }

        rijtechniekIcoonGroup.getChildren().add(stuurLinks);
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
