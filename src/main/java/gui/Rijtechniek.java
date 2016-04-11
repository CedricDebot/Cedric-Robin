package gui;

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
    private Dashboard dashboard;

    private boolean roodLichtActive = false;
    private boolean oranjeLichtActive = false;
    private boolean groenLichtActive = false;

    public Rijtechniek(Dashboard dashboard) {

        this.dashboard = dashboard;

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
        Image stuurBegin = new Image("images/rijtechniek/stuur" + dashboard.getLeerling().getRijtechniekDom().getStuurTechniek() + ".png");
        ImageView stuurImageView = new ImageView(stuurBegin);
        stuurImageView.setFitWidth(50);
        stuurImageView.setFitHeight(50);
        Button stuurBtn = new Button("", stuurImageView);
        stuurBtn.setId("icoontjesBtns");

        stuurBtn.setOnMouseDragged(e -> {
            IcoonStuurOpm icoonStuur = new IcoonStuurOpm(dashboard);
            icoonStuur.setScene(scene);
            scene.setRoot(icoonStuur);
        });
        Image stuurWit = new Image("images/rijtechniek/stuurWit.png");
        Image stuurRood = new Image("images/rijtechniek/stuurRood.png");
        Image stuurOranje = new Image("images/rijtechniek/stuurOranje.png");
        Image stuurGroen = new Image("images/rijtechniek/stuurGroen.png");

        stuurBtn.setOnAction(e -> {
            if (dashboard.getLeerling().getRijtechniekDom().getStuurTechniek() == Toestand.WIT) {
                dashboard.getLeerling().getRijtechniekDom().setStuurTechniek(Toestand.ROOD);
                stuurImageView.setImage(stuurRood);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getStuurTechniek() == Toestand.ROOD) {
                dashboard.getLeerling().getRijtechniekDom().setStuurTechniek(Toestand.ORANJE);
                stuurImageView.setImage(stuurOranje);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getStuurTechniek() == Toestand.ORANJE) {
                dashboard.getLeerling().getRijtechniekDom().setStuurTechniek(Toestand.GROEN);
                stuurImageView.setImage(stuurGroen);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getStuurTechniek() == Toestand.GROEN) {
                dashboard.getLeerling().getRijtechniekDom().setStuurTechniek(Toestand.WIT);
                stuurImageView.setImage(stuurWit);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandBoven();
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
        Image schakelenBegin = new Image("images/rijtechniek/schakelen" + dashboard.getLeerling().getRijtechniekDom().getSchakelTechniek() + ".png");
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
            if (dashboard.getLeerling().getRijtechniekDom().getSchakelTechniek() == Toestand.WIT) {
                dashboard.getLeerling().getRijtechniekDom().setSchakelTechniek(Toestand.ROOD);
                schakelenImageView.setImage(schakelenRood);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getSchakelTechniek() == Toestand.ROOD) {
                dashboard.getLeerling().getRijtechniekDom().setSchakelTechniek(Toestand.ORANJE);
                schakelenImageView.setImage(schakelenOranje);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getSchakelTechniek() == Toestand.ORANJE) {
                dashboard.getLeerling().getRijtechniekDom().setSchakelTechniek(Toestand.GROEN);
                schakelenImageView.setImage(schakelenGroen);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getSchakelTechniek() == Toestand.GROEN) {
                dashboard.getLeerling().getRijtechniekDom().setSchakelTechniek(Toestand.WIT);
                schakelenImageView.setImage(schakelenWit);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandBoven();
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
        Image kijkenBegin = new Image("images/rijtechniek/kijken" + dashboard.getLeerling().getRijtechniekDom().getKijkTechniek() + ".png");
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
            if (dashboard.getLeerling().getRijtechniekDom().getKijkTechniek() == Toestand.WIT) {
                dashboard.getLeerling().getRijtechniekDom().setKijkTechniek(Toestand.ROOD);
                kijkenImageView.setImage(kijkenRood);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getKijkTechniek() == Toestand.ROOD) {
                dashboard.getLeerling().getRijtechniekDom().setKijkTechniek(Toestand.ORANJE);
                kijkenImageView.setImage(kijkenOranje);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getKijkTechniek() == Toestand.ORANJE) {
                dashboard.getLeerling().getRijtechniekDom().setKijkTechniek(Toestand.GROEN);
                kijkenImageView.setImage(kijkenGroen);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getKijkTechniek() == Toestand.GROEN) {
                dashboard.getLeerling().getRijtechniekDom().setKijkTechniek(Toestand.WIT);
                kijkenImageView.setImage(kijkenWit);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandBoven();
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
        Image parkerenBegin = new Image("images/rijtechniek/parkeren" + dashboard.getLeerling().getRijtechniekDom().getParkeren() + ".png");
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
            if (dashboard.getLeerling().getRijtechniekDom().getParkeren() == Toestand.WIT) {
                dashboard.getLeerling().getRijtechniekDom().setParkeren(Toestand.ROOD);
                parkerenImageView.setImage(parkerenRood);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandRechts();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getParkeren() == Toestand.ROOD) {
                dashboard.getLeerling().getRijtechniekDom().setParkeren(Toestand.ORANJE);
                parkerenImageView.setImage(parkerenOranje);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandRechts();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getParkeren() == Toestand.ORANJE) {
                dashboard.getLeerling().getRijtechniekDom().setParkeren(Toestand.GROEN);
                parkerenImageView.setImage(parkerenGroen);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandRechts();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getParkeren() == Toestand.GROEN) {
                dashboard.getLeerling().getRijtechniekDom().setParkeren(Toestand.WIT);
                parkerenImageView.setImage(parkerenWit);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandRechts();
                kleurStuur();
            }
        });

        HBox kerenHBox = new HBox();
        Image kerenBegin = new Image("images/rijtechniek/keren" + dashboard.getLeerling().getRijtechniekDom().getKeren() + ".png");
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
            if (dashboard.getLeerling().getRijtechniekDom().getKeren() == Toestand.WIT) {
                dashboard.getLeerling().getRijtechniekDom().setKeren(Toestand.ROOD);
                kerenImageView.setImage(kerenRood);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandRechts();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getKeren() == Toestand.ROOD) {
                dashboard.getLeerling().getRijtechniekDom().setKeren(Toestand.ORANJE);
                kerenImageView.setImage(kerenOranje);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandRechts();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getKeren() == Toestand.ORANJE) {
                dashboard.getLeerling().getRijtechniekDom().setKeren(Toestand.GROEN);
                kerenImageView.setImage(kerenGroen);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandRechts();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getKeren() == Toestand.GROEN) {
                dashboard.getLeerling().getRijtechniekDom().setKeren(Toestand.WIT);
                kerenImageView.setImage(kerenWit);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandRechts();
                kleurStuur();
            }
        });

        HBox garageHBox = new HBox();
        Image garageBegin = new Image("images/rijtechniek/garage" + dashboard.getLeerling().getRijtechniekDom().getGarage() + ".png");
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
            if (dashboard.getLeerling().getRijtechniekDom().getGarage() == Toestand.WIT) {
                dashboard.getLeerling().getRijtechniekDom().setGarage(Toestand.ROOD);
                garageImageView.setImage(garageRood);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getGarage() == Toestand.ROOD) {
                dashboard.getLeerling().getRijtechniekDom().setGarage(Toestand.ORANJE);
                garageImageView.setImage(garageOranje);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getGarage() == Toestand.ORANJE) {
                dashboard.getLeerling().getRijtechniekDom().setGarage(Toestand.GROEN);
                garageImageView.setImage(garageGroen);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getGarage() == Toestand.GROEN) {
                dashboard.getLeerling().getRijtechniekDom().setGarage(Toestand.WIT);
                garageImageView.setImage(garageWit);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            }
        });

        HBox achteruitHBox = new HBox();
        Image achteruitBegin = new Image("images/rijtechniek/achteruit" + dashboard.getLeerling().getRijtechniekDom().getAchteruit() + ".png");
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
            if (dashboard.getLeerling().getRijtechniekDom().getAchteruit() == Toestand.WIT) {
                dashboard.getLeerling().getRijtechniekDom().setAchteruit(Toestand.ROOD);
                achteruitImageView.setImage(achteruitRood);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getAchteruit() == Toestand.ROOD) {
                dashboard.getLeerling().getRijtechniekDom().setAchteruit(Toestand.ORANJE);
                achteruitImageView.setImage(achteruitOranje);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getAchteruit() == Toestand.ORANJE) {
                dashboard.getLeerling().getRijtechniekDom().setAchteruit(Toestand.GROEN);
                achteruitImageView.setImage(achteruitGroen);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getAchteruit() == Toestand.GROEN) {
                dashboard.getLeerling().getRijtechniekDom().setAchteruit(Toestand.WIT);
                achteruitImageView.setImage(achteruitWit);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            }
        });

        HBox achtHBox = new HBox();
        Image achtBegin = new Image("images/rijtechniek/acht" + dashboard.getLeerling().getRijtechniekDom().getAcht() + ".png");
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
            if (dashboard.getLeerling().getRijtechniekDom().getAcht() == Toestand.WIT) {
                dashboard.getLeerling().getRijtechniekDom().setAcht(Toestand.ROOD);
                achtImageView.setImage(achtRood);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getAcht() == Toestand.ROOD) {
                dashboard.getLeerling().getRijtechniekDom().setAcht(Toestand.ORANJE);
                achtImageView.setImage(achtOranje);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getAcht() == Toestand.ORANJE) {
                dashboard.getLeerling().getRijtechniekDom().setAcht(Toestand.GROEN);
                achtImageView.setImage(achtGroen);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getAcht() == Toestand.GROEN) {
                dashboard.getLeerling().getRijtechniekDom().setAcht(Toestand.WIT);
                achtImageView.setImage(achtWit);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            }
        });

        HBox hellingHBox = new HBox();
        hellingHBox.setId("hellingHBox");
        Image hellingBegin = new Image("images/rijtechniek/helling" + dashboard.getLeerling().getRijtechniekDom().getHelling() + ".png");
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
            if (dashboard.getLeerling().getRijtechniekDom().getHelling() == Toestand.WIT) {
                dashboard.getLeerling().getRijtechniekDom().setHelling(Toestand.ROOD);
                hellingImageView.setImage(hellingRood);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getHelling() == Toestand.ROOD) {
                dashboard.getLeerling().getRijtechniekDom().setHelling(Toestand.ORANJE);
                hellingImageView.setImage(hellingOranje);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getHelling() == Toestand.ORANJE) {
                dashboard.getLeerling().getRijtechniekDom().setHelling(Toestand.GROEN);
                hellingImageView.setImage(hellingGroen);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandLinks();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getHelling() == Toestand.GROEN) {
                dashboard.getLeerling().getRijtechniekDom().setHelling(Toestand.WIT);
                hellingImageView.setImage(hellingWit);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandLinks();
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
        Image zithoudingBegin = new Image("images/rijtechniek/zithouding" + dashboard.getLeerling().getRijtechniekDom().getZithouding() + ".png");
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
            if (dashboard.getLeerling().getRijtechniekDom().getZithouding() == Toestand.WIT) {
                dashboard.getLeerling().getRijtechniekDom().setZithouding(Toestand.ROOD);
                zithoudingImageView.setImage(zithoudingRood);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getZithouding() == Toestand.ROOD) {
                dashboard.getLeerling().getRijtechniekDom().setZithouding(Toestand.ORANJE);
                zithoudingImageView.setImage(zithoudingOranje);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getZithouding() == Toestand.ORANJE) {
                dashboard.getLeerling().getRijtechniekDom().setZithouding(Toestand.GROEN);
                zithoudingImageView.setImage(zithoudingGroen);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getZithouding() == Toestand.GROEN) {
                dashboard.getLeerling().getRijtechniekDom().setZithouding(Toestand.WIT);
                zithoudingImageView.setImage(zithoudingWit);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandBoven();
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
        Image remtechniekBegin = new Image("images/rijtechniek/rem" + dashboard.getLeerling().getRijtechniekDom().getRemtechniek() + ".png");
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
            if (dashboard.getLeerling().getRijtechniekDom().getRemtechniek() == Toestand.WIT) {
                dashboard.getLeerling().getRijtechniekDom().setRemtechniek(Toestand.ROOD);
                remtechniekImageView.setImage(remtechniekRood);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getRemtechniek() == Toestand.ROOD) {
                dashboard.getLeerling().getRijtechniekDom().setRemtechniek(Toestand.ORANJE);
                remtechniekImageView.setImage(remtechniekOranje);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getRemtechniek() == Toestand.ORANJE) {
                dashboard.getLeerling().getRijtechniekDom().setRemtechniek(Toestand.GROEN);
                remtechniekImageView.setImage(remtechniekGroen);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getRemtechniek() == Toestand.GROEN) {
                dashboard.getLeerling().getRijtechniekDom().setRemtechniek(Toestand.WIT);
                remtechniekImageView.setImage(remtechniekWit);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandBoven();
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
        Image embrayageBegin = new Image("images/rijtechniek/embrayage" + dashboard.getLeerling().getRijtechniekDom().getKoppeling() + ".png");
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
            if (dashboard.getLeerling().getRijtechniekDom().getKoppeling() == Toestand.WIT) {
                dashboard.getLeerling().getRijtechniekDom().setKoppeling(Toestand.ROOD);
                embrayageImageView.setImage(embrayageRood);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getKoppeling() == Toestand.ROOD) {
                dashboard.getLeerling().getRijtechniekDom().setKoppeling(Toestand.ORANJE);
                embrayageImageView.setImage(embrayageOranje);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getKoppeling() == Toestand.ORANJE) {
                dashboard.getLeerling().getRijtechniekDom().setKoppeling(Toestand.GROEN);
                embrayageImageView.setImage(embrayageGroen);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandBoven();
                kleurStuur();
            } else if (dashboard.getLeerling().getRijtechniekDom().getKoppeling() == Toestand.GROEN) {
                dashboard.getLeerling().getRijtechniekDom().setKoppeling(Toestand.WIT);
                embrayageImageView.setImage(embrayageWit);
                dashboard.getLeerling().getRijtechniekDom().bepaalToestandBoven();
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
            dashboard.setScene(scene);
            scene.setRoot(dashboard);
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
            Toestand[] icoontjesToestand = {dashboard.getLeerling().getRijtechniekDom().getStuurTechniek(),
                dashboard.getLeerling().getRijtechniekDom().getSchakelTechniek(),
                dashboard.getLeerling().getRijtechniekDom().getKijkTechniek(),
                dashboard.getLeerling().getRijtechniekDom().getParkeren(),
                dashboard.getLeerling().getRijtechniekDom().getKeren(),
                dashboard.getLeerling().getRijtechniekDom().getGarage(),
                dashboard.getLeerling().getRijtechniekDom().getAchteruit(),
                dashboard.getLeerling().getRijtechniekDom().getAcht(),
                dashboard.getLeerling().getRijtechniekDom().getHelling(),
                dashboard.getLeerling().getRijtechniekDom().getZithouding(),
                dashboard.getLeerling().getRijtechniekDom().getRemtechniek(),
                dashboard.getLeerling().getRijtechniekDom().getKoppeling()};
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

            Toestand[] icoontjesToestand = {dashboard.getLeerling().getRijtechniekDom().getStuurTechniek(),
                dashboard.getLeerling().getRijtechniekDom().getSchakelTechniek(),
                dashboard.getLeerling().getRijtechniekDom().getKijkTechniek(),
                dashboard.getLeerling().getRijtechniekDom().getParkeren(),
                dashboard.getLeerling().getRijtechniekDom().getKeren(),
                dashboard.getLeerling().getRijtechniekDom().getGarage(),
                dashboard.getLeerling().getRijtechniekDom().getAchteruit(),
                dashboard.getLeerling().getRijtechniekDom().getAcht(),
                dashboard.getLeerling().getRijtechniekDom().getHelling(),
                dashboard.getLeerling().getRijtechniekDom().getZithouding(),
                dashboard.getLeerling().getRijtechniekDom().getRemtechniek(),
                dashboard.getLeerling().getRijtechniekDom().getKoppeling()};
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
            Toestand[] icoontjesToestand = {dashboard.getLeerling().getRijtechniekDom().getStuurTechniek(),
                dashboard.getLeerling().getRijtechniekDom().getSchakelTechniek(),
                dashboard.getLeerling().getRijtechniekDom().getKijkTechniek(),
                dashboard.getLeerling().getRijtechniekDom().getParkeren(),
                dashboard.getLeerling().getRijtechniekDom().getKeren(),
                dashboard.getLeerling().getRijtechniekDom().getGarage(),
                dashboard.getLeerling().getRijtechniekDom().getAchteruit(),
                dashboard.getLeerling().getRijtechniekDom().getAcht(),
                dashboard.getLeerling().getRijtechniekDom().getHelling(),
                dashboard.getLeerling().getRijtechniekDom().getZithouding(),
                dashboard.getLeerling().getRijtechniekDom().getRemtechniek(),
                dashboard.getLeerling().getRijtechniekDom().getKoppeling()};
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

        VBox menuStandaard = menu.buildMenuStandaard(dashboard.getLeerling());

        right.getChildren().add(menuStandaard);

        VBox menuBalk = menu.buildMenu(dashboard);

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
            if (dashboard.getLeerling().getRijtechniekDom().getStuurTechniek() == Toestand.ROOD) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getSturenOpmerkingen(), dashboard, "images/rijtechniek/stuurRood.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (dashboard.getLeerling().getRijtechniekDom().getStuurTechniek() == Toestand.ORANJE) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getSturenOpmerkingen(), dashboard, "images/rijtechniek/stuurOranje.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (dashboard.getLeerling().getRijtechniekDom().getStuurTechniek() == Toestand.GROEN) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getSturenOpmerkingen(), dashboard, "images/rijtechniek/stuurGroen.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });

        schakelenBtn.setOnMouseDragged(e -> {
            if (dashboard.getLeerling().getRijtechniekDom().getSchakelTechniek() == Toestand.ROOD) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getSchakelenOpmerking(), dashboard, "images/rijtechniek/schakelenRood.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (dashboard.getLeerling().getRijtechniekDom().getSchakelTechniek() == Toestand.ORANJE) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getSchakelenOpmerking(), dashboard, "images/rijtechniek/schakelenOranje.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (dashboard.getLeerling().getRijtechniekDom().getSchakelTechniek() == Toestand.GROEN) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getSchakelenOpmerking(), dashboard, "images/rijtechniek/schakelenGroen.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });

        kijkenBtn.setOnMouseDragged(e -> {
            if (dashboard.getLeerling().getRijtechniekDom().getKijkTechniek() == Toestand.ROOD) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getKijkenOpmerkingen(), dashboard, "images/rijtechniek/kijkenRood.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (dashboard.getLeerling().getRijtechniekDom().getKijkTechniek() == Toestand.ORANJE) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getKijkenOpmerkingen(), dashboard, "images/rijtechniek/kijkenOranje.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (dashboard.getLeerling().getRijtechniekDom().getKijkTechniek() == Toestand.GROEN) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getKijkenOpmerkingen(), dashboard, "images/rijtechniek/kijkenGroen.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });

        parkerenBtn.setOnMouseDragged(e -> {
            if (dashboard.getLeerling().getRijtechniekDom().getParkeren() == Toestand.ROOD) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getParkerenOpmerkingen(), dashboard, "images/rijtechniek/parkerenRood.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (dashboard.getLeerling().getRijtechniekDom().getParkeren() == Toestand.ORANJE) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getParkerenOpmerkingen(), dashboard, "images/rijtechniek/parkerenOranje.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (dashboard.getLeerling().getRijtechniekDom().getParkeren() == Toestand.GROEN) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getParkerenOpmerkingen(), dashboard, "images/rijtechniek/parkerenGroen.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });

        kerenBtn.setOnMouseDragged(e -> {

            if (dashboard.getLeerling().getRijtechniekDom().getKeren() == Toestand.ROOD) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getKerenOpmerkingen(), dashboard, "images/rijtechniek/kerenRood.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (dashboard.getLeerling().getRijtechniekDom().getKeren() == Toestand.ORANJE) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getKerenOpmerkingen(), dashboard, "images/rijtechniek/kerenOranje.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (dashboard.getLeerling().getRijtechniekDom().getKeren() == Toestand.GROEN) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getKerenOpmerkingen(), dashboard, "images/rijtechniek/kerenGroen.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });

        garageBtn.setOnMouseDragged(e -> {
            if (dashboard.getLeerling().getRijtechniekDom().getGarage() == Toestand.ROOD) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getGarageOpmerkingen(), dashboard, "images/rijtechniek/garageRood.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (dashboard.getLeerling().getRijtechniekDom().getGarage() == Toestand.ORANJE) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getGarageOpmerkingen(), dashboard, "images/rijtechniek/garageOranje.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (dashboard.getLeerling().getRijtechniekDom().getGarage() == Toestand.GROEN) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getGarageOpmerkingen(), dashboard, "images/rijtechniek/garageGroen.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });

        achteruitBtn.setOnMouseDragged(e -> {

            if (dashboard.getLeerling().getRijtechniekDom().getAchteruit() == Toestand.ROOD) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getAchteruitOpmerkingen(), dashboard, "images/rijtechniek/achteruitRood.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (dashboard.getLeerling().getRijtechniekDom().getAchteruit() == Toestand.ORANJE) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getAchteruitOpmerkingen(), dashboard, "images/rijtechniek/achteruitOranje.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (dashboard.getLeerling().getRijtechniekDom().getAchteruit() == Toestand.GROEN) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getAchteruitOpmerkingen(), dashboard, "images/rijtechniek/achteruitGroen.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });

        achtBtn.setOnMouseDragged(e -> {

            if (dashboard.getLeerling().getRijtechniekDom().getAcht() == Toestand.ROOD) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getAchtOpmerkingen(), dashboard, "images/rijtechniek/achtRood.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (dashboard.getLeerling().getRijtechniekDom().getAcht() == Toestand.ORANJE) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getAchtOpmerkingen(), dashboard, "images/rijtechniek/achtOranje.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (dashboard.getLeerling().getRijtechniekDom().getAcht() == Toestand.GROEN) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getAchtOpmerkingen(), dashboard, "images/rijtechniek/achtGroen.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });

        hellingBtn.setOnMouseDragged(e -> {
            if (dashboard.getLeerling().getRijtechniekDom().getHelling() == Toestand.ROOD) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getHellingOpmerkingen(), dashboard, "images/rijtechniek/hellingRood.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (dashboard.getLeerling().getRijtechniekDom().getHelling() == Toestand.ORANJE) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getHellingOpmerkingen(), dashboard, "images/rijtechniek/hellingOranje.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (dashboard.getLeerling().getRijtechniekDom().getHelling() == Toestand.GROEN) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getHellingOpmerkingen(), dashboard, "images/rijtechniek/hellingGroen.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });

        zithoudingBtn.setOnMouseDragged(e -> {
            if (dashboard.getLeerling().getRijtechniekDom().getZithouding() == Toestand.ROOD) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getZithoudingOpmerkingen(), dashboard, "images/rijtechniek/zithoudingRood.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (dashboard.getLeerling().getRijtechniekDom().getZithouding() == Toestand.ORANJE) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getZithoudingOpmerkingen(), dashboard, "images/rijtechniek/zithoudingOranje.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (dashboard.getLeerling().getRijtechniekDom().getZithouding() == Toestand.GROEN) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getZithoudingOpmerkingen(), dashboard, "images/rijtechniek/zithoudingGroen.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });

        remtechniekBtn.setOnMouseDragged(e -> {
            if (dashboard.getLeerling().getRijtechniekDom().getRemtechniek() == Toestand.ROOD) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getRemtechniekOpmerkingen(), dashboard, "images/rijtechniek/remRood.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (dashboard.getLeerling().getRijtechniekDom().getRemtechniek() == Toestand.ORANJE) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getRemtechniekOpmerkingen(), dashboard, "images/rijtechniek/remOranje.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (dashboard.getLeerling().getRijtechniekDom().getRemtechniek() == Toestand.GROEN) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getRemtechniekOpmerkingen(), dashboard, "images/rijtechniek/remGroen.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }
        });

        embrayageBtn.setOnMouseDragged(e -> {
            if (dashboard.getLeerling().getRijtechniekDom().getKoppeling() == Toestand.ROOD) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getEmbrayageOpmerkingen(), dashboard, "images/rijtechniek/embrayageRood.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (dashboard.getLeerling().getRijtechniekDom().getKoppeling() == Toestand.ORANJE) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getEmbrayageOpmerkingen(), dashboard, "images/rijtechniek/embrayageOranje.png");
                rijtechniek.setScene(scene);
                scene.setRoot(rijtechniek);
            }

            if (dashboard.getLeerling().getRijtechniekDom().getKoppeling() == Toestand.GROEN) {
                RijtechniekOpmerkingen rijtechniek = new RijtechniekOpmerkingen(dashboard.getLeerling().getEmbrayageOpmerkingen(), dashboard, "images/rijtechniek/embrayageGroen.png");
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

        if (dashboard.getLeerling().getRijtechniekDom().getRijtechniekIcoonBoven() == Toestand.GROEN) {
            Image stuurGroenBoven = new Image("images/rijtechniekIcoon/stuurGroenBoven.png");
            stuurBoven.setImage(stuurGroenBoven);
        } else if (dashboard.getLeerling().getRijtechniekDom().getRijtechniekIcoonBoven() == Toestand.ORANJE) {
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

        if (dashboard.getLeerling().getRijtechniekDom().getRijtechniekIcoonRechts() == Toestand.GROEN) {
            Image stuurGroenRechts = new Image("images/rijtechniekIcoon/stuurGroenRechts.png");
            stuurRechts.setImage(stuurGroenRechts);
        } else if (dashboard.getLeerling().getRijtechniekDom().getRijtechniekIcoonRechts() == Toestand.ORANJE) {
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

        if (dashboard.getLeerling().getRijtechniekDom().getRijtechniekIcoonLinks() == Toestand.GROEN) {
            Image stuurGroenLinks = new Image("images/rijtechniekIcoon/stuurGroenLinks.png");
            stuurLinks.setImage(stuurGroenLinks);
        } else if (dashboard.getLeerling().getRijtechniekDom().getRijtechniekIcoonLinks() == Toestand.ORANJE) {
            Image stuurOranjeLinks = new Image("images/rijtechniekIcoon/stuurOranjeLinks.png");
            stuurLinks.setImage(stuurOranjeLinks);
        }

        rijtechniekIcoonGroup.getChildren().add(stuurLinks);
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
