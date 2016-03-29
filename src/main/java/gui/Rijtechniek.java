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
//    private RijtechniekDom rijtechniekDom = new RijtechniekDom();

    public Rijtechniek(Dashboard dashboard) {
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
        Image stuurBegin = new Image("images/rijTechniek/stuur" + dashboard.getLeerling().getRijtechniekDom().getStuurTechniek() + ".png");
        ImageView stuurImageView = new ImageView(stuurBegin);
        stuurImageView.setFitWidth(50);
        stuurImageView.setFitHeight(50);
        Button stuurBtn = new Button("", stuurImageView);
        stuurBtn.setId("icoontjesBtns");
        //grid.add(stuurBtn, 3, 0);

        stuurBtn.setOnMouseDragged(e ->{
            IcoonStuurOpm icoonStuur = new IcoonStuurOpm(dashboard);
            icoonStuur.setScene(scene);
            scene.setRoot(icoonStuur);
        });
        Image stuurWit = new Image("images/rijTechniek/stuurWit.png");
        Image stuurRood = new Image("images/rijTechniek/stuurRood.png");
        Image stuurOranje = new Image("images/rijTechniek/stuurOranje.png");
        Image stuurGroen = new Image("images/rijTechniek/stuurGroen.png");

        stuurBtn.setOnAction(e -> {
            if (dashboard.getLeerling().getRijtechniekDom().getStuurTechniek() == Toestand.WIT) {
                dashboard.getLeerling().getRijtechniekDom().setStuurTechniek(Toestand.ROOD);
                stuurImageView.setImage(stuurRood);
            } else if (dashboard.getLeerling().getRijtechniekDom().getStuurTechniek() == Toestand.ROOD) {
                dashboard.getLeerling().getRijtechniekDom().setStuurTechniek(Toestand.ORANJE);
                stuurImageView.setImage(stuurOranje);
            } else if (dashboard.getLeerling().getRijtechniekDom().getStuurTechniek() == Toestand.ORANJE) {
                dashboard.getLeerling().getRijtechniekDom().setStuurTechniek(Toestand.GROEN);
                stuurImageView.setImage(stuurGroen);
            } else if (dashboard.getLeerling().getRijtechniekDom().getStuurTechniek() == Toestand.GROEN) {
                dashboard.getLeerling().getRijtechniekDom().setStuurTechniek(Toestand.WIT);
                stuurImageView.setImage(stuurWit);
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
        Image schakelenBegin = new Image("images/rijTechniek/schakelen" + dashboard.getLeerling().getRijtechniekDom().getSchakelTechniek() + ".png");
        ImageView schakelenImageView = new ImageView(schakelenBegin);
        schakelenImageView.setFitWidth(50);
        schakelenImageView.setFitHeight(50);
        Button schakelenBtn = new Button("", schakelenImageView);
        schakelenBtn.setId("icoontjesBtns");
        //grid.add(schakelenBtn, 4, 1);

        Image schakelenWit = new Image("images/rijTechniek/schakelenWit.png");
        Image schakelenRood = new Image("images/rijTechniek/schakelenRood.png");
        Image schakelenOranje = new Image("images/rijTechniek/schakelenOranje.png");
        Image schakelenGroen = new Image("images/rijTechniek/schakelenGroen.png");

        schakelenBtn.setOnAction(e -> {
            if (dashboard.getLeerling().getRijtechniekDom().getSchakelTechniek() == Toestand.WIT) {
                dashboard.getLeerling().getRijtechniekDom().setSchakelTechniek(Toestand.ROOD);
                schakelenImageView.setImage(schakelenRood);
            } else if (dashboard.getLeerling().getRijtechniekDom().getSchakelTechniek() == Toestand.ROOD) {
                dashboard.getLeerling().getRijtechniekDom().setSchakelTechniek(Toestand.ORANJE);
                schakelenImageView.setImage(schakelenOranje);
            } else if (dashboard.getLeerling().getRijtechniekDom().getSchakelTechniek() == Toestand.ORANJE) {
                dashboard.getLeerling().getRijtechniekDom().setSchakelTechniek(Toestand.GROEN);
                schakelenImageView.setImage(schakelenGroen);
            } else if (dashboard.getLeerling().getRijtechniekDom().getSchakelTechniek() == Toestand.GROEN) {
                dashboard.getLeerling().getRijtechniekDom().setSchakelTechniek(Toestand.WIT);
                schakelenImageView.setImage(schakelenWit);
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
        Image kijkenBegin = new Image("images/rijTechniek/kijken" + dashboard.getLeerling().getRijtechniekDom().getKijkTechniek()+ ".png");
        ImageView kijkenImageView = new ImageView(kijkenBegin);
        kijkenImageView.setFitWidth(50);
        kijkenImageView.setFitHeight(50);
        Button kijkenBtn = new Button("", kijkenImageView);
        kijkenBtn.setId("icoontjesBtns");
        //grid.add(kijkenBtn, 5, 2);

        Image kijkenWit = new Image("images/rijTechniek/kijkenWit.png");
        Image kijkenRood = new Image("images/rijTechniek/kijkenRood.png");
        Image kijkenOranje = new Image("images/rijTechniek/kijkenOranje.png");
        Image kijkenGroen = new Image("images/rijTechniek/kijkenGroen.png");

        kijkenBtn.setOnAction(e -> {
            if (dashboard.getLeerling().getRijtechniekDom().getKijkTechniek() == Toestand.WIT) {
                dashboard.getLeerling().getRijtechniekDom().setKijkTechniek(Toestand.ROOD);
                kijkenImageView.setImage(kijkenRood);
            } else if (dashboard.getLeerling().getRijtechniekDom().getKijkTechniek() == Toestand.ROOD) {
                dashboard.getLeerling().getRijtechniekDom().setKijkTechniek(Toestand.ORANJE);
                kijkenImageView.setImage(kijkenOranje);
            } else if (dashboard.getLeerling().getRijtechniekDom().getKijkTechniek() == Toestand.ORANJE) {
                dashboard.getLeerling().getRijtechniekDom().setKijkTechniek(Toestand.GROEN);
                kijkenImageView.setImage(kijkenGroen);
            } else if (dashboard.getLeerling().getRijtechniekDom().getKijkTechniek() == Toestand.GROEN) {
                dashboard.getLeerling().getRijtechniekDom().setKijkTechniek(Toestand.WIT);
                kijkenImageView.setImage(kijkenWit);
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

        Image parkerenBegin = new Image("images/rijTechniek/parkeren" + dashboard.getLeerling().getRijtechniekDom().getParkeren()+ ".png");
        ImageView parkerenImageView = new ImageView(parkerenBegin);
        parkerenImageView.setId("parkerenIcoon");
        parkerenImageView.setFitWidth(50);
        parkerenImageView.setFitHeight(50);
        Button parkerenBtn = new Button("", parkerenImageView);
        parkerenBtn.setId("icoontjesBtns");
        grid.add(parkerenBtn, 5, 3);

        Image parkerenWit = new Image("images/rijTechniek/parkerenWit.png");
        Image parkerenRood = new Image("images/rijTechniek/parkerenRood.png");
        Image parkerenOranje = new Image("images/rijTechniek/parkerenOranje.png");
        Image parkerenGroen = new Image("images/rijTechniek/parkerenGroen.png");

        parkerenBtn.setOnAction(e -> {
            if (dashboard.getLeerling().getRijtechniekDom().getParkeren() == Toestand.WIT) {
                dashboard.getLeerling().getRijtechniekDom().setParkeren(Toestand.ROOD);
                parkerenImageView.setImage(parkerenRood);
            } else if (dashboard.getLeerling().getRijtechniekDom().getParkeren() == Toestand.ROOD) {
                dashboard.getLeerling().getRijtechniekDom().setParkeren(Toestand.ORANJE);
                parkerenImageView.setImage(parkerenOranje);
            } else if (dashboard.getLeerling().getRijtechniekDom().getParkeren() == Toestand.ORANJE) {
                dashboard.getLeerling().getRijtechniekDom().setParkeren(Toestand.GROEN);
                parkerenImageView.setImage(parkerenGroen);
            } else if (dashboard.getLeerling().getRijtechniekDom().getParkeren() == Toestand.GROEN) {
                dashboard.getLeerling().getRijtechniekDom().setParkeren(Toestand.WIT);
                parkerenImageView.setImage(parkerenWit);
            }
        });

        Image kerenBegin = new Image("images/rijTechniek/keren" + dashboard.getLeerling().getRijtechniekDom().getKeren()+ ".png");
        ImageView kerenImageView = new ImageView(kerenBegin);
        kerenImageView.setFitWidth(50);
        kerenImageView.setFitHeight(50);
        Button kerenBtn = new Button("", kerenImageView);
        kerenBtn.setId("icoontjesBtns");
        grid.add(kerenBtn, 4, 4);

        Image kerenWit = new Image("images/rijTechniek/kerenWit.png");
        Image kerenRood = new Image("images/rijTechniek/kerenRood.png");
        Image kerenOranje = new Image("images/rijTechniek/kerenOranje.png");
        Image kerenGroen = new Image("images/rijTechniek/kerenGroen.png");

        kerenBtn.setOnAction(e -> {
            if (dashboard.getLeerling().getRijtechniekDom().getKeren()== Toestand.WIT) {
                dashboard.getLeerling().getRijtechniekDom().setKeren(Toestand.ROOD);
                kerenImageView.setImage(kerenRood);
            } else if (dashboard.getLeerling().getRijtechniekDom().getKeren()== Toestand.ROOD) {
                dashboard.getLeerling().getRijtechniekDom().setKeren(Toestand.ORANJE);
                kerenImageView.setImage(kerenOranje);
            } else if (dashboard.getLeerling().getRijtechniekDom().getKeren()== Toestand.ORANJE) {
                dashboard.getLeerling().getRijtechniekDom().setKeren(Toestand.GROEN);
                kerenImageView.setImage(kerenGroen);
            } else if (dashboard.getLeerling().getRijtechniekDom().getKeren()== Toestand.GROEN) {
                dashboard.getLeerling().getRijtechniekDom().setKeren(Toestand.WIT);
                kerenImageView.setImage(kerenWit);
            }
        });

        Image garageBegin = new Image("images/rijTechniek/garage" + dashboard.getLeerling().getRijtechniekDom().getGarage()+ ".png");
        ImageView garageImageView = new ImageView(garageBegin);
        garageImageView.setFitWidth(50);
        garageImageView.setFitHeight(50);
        Button garageBtn = new Button("", garageImageView);
        garageBtn.setId("icoontjesBtns");
        grid.add(garageBtn, 3, 5);

        Image garageWit = new Image("images/rijTechniek/garageWit.png");
        Image garageRood = new Image("images/rijTechniek/garageRood.png");
        Image garageOranje = new Image("images/rijTechniek/garageOranje.png");
        Image garageGroen = new Image("images/rijTechniek/garageGroen.png");

        garageBtn.setOnAction(e -> {
            if (dashboard.getLeerling().getRijtechniekDom().getGarage() == Toestand.WIT) {
                dashboard.getLeerling().getRijtechniekDom().setGarage(Toestand.ROOD);
                garageImageView.setImage(garageRood);
            } else if (dashboard.getLeerling().getRijtechniekDom().getGarage() == Toestand.ROOD) {
                dashboard.getLeerling().getRijtechniekDom().setGarage(Toestand.ORANJE);
                garageImageView.setImage(garageOranje);
            } else if (dashboard.getLeerling().getRijtechniekDom().getGarage() == Toestand.ORANJE) {
                dashboard.getLeerling().getRijtechniekDom().setGarage(Toestand.GROEN);
                garageImageView.setImage(garageGroen);
            } else if (dashboard.getLeerling().getRijtechniekDom().getGarage() == Toestand.GROEN) {
                dashboard.getLeerling().getRijtechniekDom().setGarage(Toestand.WIT);
                garageImageView.setImage(garageWit);
            }
        });

        Image achteruitBegin = new Image("images/rijTechniek/achteruit" + dashboard.getLeerling().getRijtechniekDom().getAchteruit()+ ".png");
        ImageView achteruitImageView = new ImageView(achteruitBegin);
        achteruitImageView.setFitWidth(50);
        achteruitImageView.setFitHeight(50);
        Button achteruitBtn = new Button("", achteruitImageView);
        achteruitBtn.setId("icoontjesBtns");
        grid.add(achteruitBtn, 2, 5);

        Image achteruitWit = new Image("images/rijTechniek/achteruitWit.png");
        Image achteruitRood = new Image("images/rijTechniek/achteruitRood.png");
        Image achteruitOranje = new Image("images/rijTechniek/achteruitOranje.png");
        Image achteruitGroen = new Image("images/rijTechniek/achteruitGroen.png");

        achteruitBtn.setOnAction(e -> {
            if (dashboard.getLeerling().getRijtechniekDom().getAchteruit()== Toestand.WIT) {
                dashboard.getLeerling().getRijtechniekDom().setAchteruit(Toestand.ROOD);
                achteruitImageView.setImage(achteruitRood);
            } else if (dashboard.getLeerling().getRijtechniekDom().getAchteruit()== Toestand.ROOD) {
                dashboard.getLeerling().getRijtechniekDom().setAchteruit(Toestand.ORANJE);
                achteruitImageView.setImage(achteruitOranje);
            } else if (dashboard.getLeerling().getRijtechniekDom().getAchteruit()== Toestand.ORANJE) {
                dashboard.getLeerling().getRijtechniekDom().setAchteruit(Toestand.GROEN);
                achteruitImageView.setImage(achteruitGroen);
            } else if (dashboard.getLeerling().getRijtechniekDom().getAchteruit()== Toestand.GROEN) {
                dashboard.getLeerling().getRijtechniekDom().setAchteruit(Toestand.WIT);
                achteruitImageView.setImage(achteruitWit);
            }
        });

        Image achtBegin = new Image("images/rijTechniek/acht" + dashboard.getLeerling().getRijtechniekDom().getAcht()+ ".png");
        ImageView achtImageView = new ImageView(achtBegin);
        achtImageView.setFitWidth(50);
        achtImageView.setFitHeight(50);
        Button achtBtn = new Button("", achtImageView);
        achtBtn.setId("icoontjesBtns");
        grid.add(achtBtn, 1, 4);

        Image achtWit = new Image("images/rijTechniek/achtWit.png");
        Image achtRood = new Image("images/rijTechniek/achtRood.png");
        Image achtOranje = new Image("images/rijTechniek/achtOranje.png");
        Image achtGroen = new Image("images/rijTechniek/achtGroen.png");
        
        achtBtn.setOnAction(e -> {
            if(dashboard.getLeerling().getRijtechniekDom().getAcht()== Toestand.WIT){
                dashboard.getLeerling().getRijtechniekDom().setAcht(Toestand.ROOD);
                achtImageView.setImage(achtRood);
            }else if(dashboard.getLeerling().getRijtechniekDom().getAcht()== Toestand.ROOD){
                dashboard.getLeerling().getRijtechniekDom().setAcht(Toestand.ORANJE);
                achtImageView.setImage(achtOranje);
            }else if(dashboard.getLeerling().getRijtechniekDom().getAcht()== Toestand.ORANJE){
                dashboard.getLeerling().getRijtechniekDom().setAcht(Toestand.GROEN);
                achtImageView.setImage(achtGroen);
            }else if(dashboard.getLeerling().getRijtechniekDom().getAcht()== Toestand.GROEN){
                dashboard.getLeerling().getRijtechniekDom().setAcht(Toestand.WIT);
                achtImageView.setImage(achtWit);
            }
        });
        
        HBox bergopHBox = new HBox();
        bergopHBox.setId("hellingHBox");
        Image hellingBegin = new Image("images/rijTechniek/helling" + dashboard.getLeerling().getRijtechniekDom().getHelling()+ ".png");
        ImageView hellingImageView = new ImageView(hellingBegin);
        hellingImageView.setFitWidth(50);
        hellingImageView.setFitHeight(50);
        Button hellingBtn = new Button("", hellingImageView);
        hellingBtn.setId("icoontjesBtns");
        //grid.add(bergopBtn, 0, 3);

        Image hellingWit = new Image("images/rijTechniek/hellingWit.png");
        Image hellingRood = new Image("images/rijTechniek/hellingRood.png");
        Image hellingOranje = new Image("images/rijTechniek/hellingOranje.png");
        Image hellingGroen = new Image("images/rijTechniek/hellingGroen.png");
        
        hellingBtn.setOnAction(e -> {
            if(dashboard.getLeerling().getRijtechniekDom().getHelling() == Toestand.WIT){
                dashboard.getLeerling().getRijtechniekDom().setHelling(Toestand.ROOD);
                hellingImageView.setImage(hellingRood);
            }else if(dashboard.getLeerling().getRijtechniekDom().getHelling()== Toestand.ROOD){
                dashboard.getLeerling().getRijtechniekDom().setHelling(Toestand.ORANJE);
                hellingImageView.setImage(hellingOranje);
            }else if(dashboard.getLeerling().getRijtechniekDom().getHelling()== Toestand.ORANJE){
                dashboard.getLeerling().getRijtechniekDom().setHelling(Toestand.GROEN);
                hellingImageView.setImage(hellingGroen);
            }else if(dashboard.getLeerling().getRijtechniekDom().getHelling()== Toestand.GROEN){
                dashboard.getLeerling().getRijtechniekDom().setHelling(Toestand.WIT);
                hellingImageView.setImage(hellingWit);
            }
        });
        
        Rectangle bergopEva1 = new Rectangle(12, 12, Color.WHITE);
        Rectangle bergopEva2 = new Rectangle(12, 12, Color.WHITE);
        Rectangle bergopEva3 = new Rectangle(12, 12, Color.WHITE);

        VBox bergopEvamomenten = new VBox();
        bergopEvamomenten.setId("evamomenten");
        bergopEvamomenten.getChildren().addAll(bergopEva1, bergopEva2, bergopEva3);

        bergopHBox.getChildren().addAll(hellingBtn, bergopEvamomenten);

        grid.add(bergopHBox, 0, 3);

        HBox zithoudingHBox = new HBox();
        zithoudingHBox.setId("zithoudingHBox");
        Image zithoudingBegin = new Image("images/rijTechniek/zithouding" + dashboard.getLeerling().getRijtechniekDom().getZithouding()+ ".png");
        ImageView zithoudingImageView = new ImageView(zithoudingBegin);
        zithoudingImageView.setFitWidth(50);
        zithoudingImageView.setFitHeight(50);
        Button zithoudingBtn = new Button("", zithoudingImageView);
        zithoudingBtn.setId("icoontjesBtns");
        //grid.add(zithoudingBtn, 0, 2);

        Image zithoudingWit = new Image("images/rijTechniek/zithoudingWit.png");
        Image zithoudingRood = new Image("images/rijTechniek/zithoudingRood.png");
        Image zithoudingOranje = new Image("images/rijTechniek/zithoudingOranje.png");
        Image zithoudingGroen = new Image("images/rijTechniek/zithoudingGroen.png");
        
        zithoudingBtn.setOnAction(e -> {
            if(dashboard.getLeerling().getRijtechniekDom().getZithouding()== Toestand.WIT){
                dashboard.getLeerling().getRijtechniekDom().setZithouding(Toestand.ROOD);
                zithoudingImageView.setImage(zithoudingRood);
            }else if(dashboard.getLeerling().getRijtechniekDom().getZithouding()== Toestand.ROOD){
                dashboard.getLeerling().getRijtechniekDom().setZithouding(Toestand.ORANJE);
                zithoudingImageView.setImage(zithoudingOranje);
            }else if(dashboard.getLeerling().getRijtechniekDom().getZithouding()== Toestand.ORANJE){
                dashboard.getLeerling().getRijtechniekDom().setZithouding(Toestand.GROEN);
                zithoudingImageView.setImage(zithoudingGroen);
            }else if(dashboard.getLeerling().getRijtechniekDom().getZithouding()== Toestand.GROEN){
                dashboard.getLeerling().getRijtechniekDom().setZithouding(Toestand.WIT);
                zithoudingImageView.setImage(zithoudingWit);
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
        Image remtechniekBegin = new Image("images/rijTechniek/rem" + dashboard.getLeerling().getRijtechniekDom().getRemtechniek()+ ".png");
        ImageView remtechniekImageView = new ImageView(remtechniekBegin);
        remtechniekImageView.setFitWidth(50);
        remtechniekImageView.setFitHeight(50);
        Button remtechniekBtn = new Button("", remtechniekImageView);
        remtechniekBtn.setId("icoontjesBtns");
        //grid.add(remtechniekBtn, 1, 1);

        Image remtechniekWit = new Image("images/rijTechniek/remWit.png");
        Image remtechniekRood = new Image("images/rijTechniek/remRood.png");
        Image remtechniekOranje = new Image("images/rijTechniek/remOranje.png");
        Image remtechniekGroen = new Image("images/rijTechniek/remGroen.png");
        
        remtechniekBtn.setOnAction(e -> {
            if(dashboard.getLeerling().getRijtechniekDom().getRemtechniek()== Toestand.WIT){
                dashboard.getLeerling().getRijtechniekDom().setRemtechniek(Toestand.ROOD);
                remtechniekImageView.setImage(remtechniekRood);
            }else if(dashboard.getLeerling().getRijtechniekDom().getRemtechniek()== Toestand.ROOD){
                dashboard.getLeerling().getRijtechniekDom().setRemtechniek(Toestand.ORANJE);
                remtechniekImageView.setImage(remtechniekOranje);
            }else if(dashboard.getLeerling().getRijtechniekDom().getRemtechniek()== Toestand.ORANJE){
                dashboard.getLeerling().getRijtechniekDom().setRemtechniek(Toestand.GROEN);
                remtechniekImageView.setImage(remtechniekGroen);
            }else if(dashboard.getLeerling().getRijtechniekDom().getRemtechniek()== Toestand.GROEN){
                dashboard.getLeerling().getRijtechniekDom().setRemtechniek(Toestand.WIT);
                remtechniekImageView.setImage(remtechniekWit);
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
        Image embrayageBegin = new Image("images/rijTechniek/embrayage" + dashboard.getLeerling().getRijtechniekDom().getKoppeling()+ ".png");
        ImageView embrayageImageView = new ImageView(embrayageBegin);
        embrayageImageView.setFitWidth(50);
        embrayageImageView.setFitHeight(50);
        Button embrayageBtn = new Button("", embrayageImageView);
        embrayageBtn.setId("icoontjesBtns");
        //grid.add(embrayageBtn, 2, 0);

        Image embrayageWit = new Image("images/rijTechniek/embrayageWit.png");
        Image embrayageRood = new Image("images/rijTechniek/embrayageRood.png");
        Image embrayageOranje = new Image("images/rijTechniek/embrayageOranje.png");
        Image embrayageGroen = new Image("images/rijTechniek/embrayageGroen.png");
        
        embrayageBtn.setOnAction(e -> {
            if(dashboard.getLeerling().getRijtechniekDom().getKoppeling()== Toestand.WIT){
                dashboard.getLeerling().getRijtechniekDom().setKoppeling(Toestand.ROOD);
                embrayageImageView.setImage(embrayageRood);
            }else if(dashboard.getLeerling().getRijtechniekDom().getKoppeling()== Toestand.ROOD){
                dashboard.getLeerling().getRijtechniekDom().setKoppeling(Toestand.ORANJE);
                embrayageImageView.setImage(embrayageOranje);
            }else if(dashboard.getLeerling().getRijtechniekDom().getKoppeling()== Toestand.ORANJE){
                dashboard.getLeerling().getRijtechniekDom().setKoppeling(Toestand.GROEN);
                embrayageImageView.setImage(embrayageGroen);
            }else if(dashboard.getLeerling().getRijtechniekDom().getKoppeling()== Toestand.GROEN){
                dashboard.getLeerling().getRijtechniekDom().setKoppeling(Toestand.WIT);
                embrayageImageView.setImage(embrayageWit);
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

        Image middenGrid = new Image("images/rijtechniekWit.png");
        ImageView middenGridImageView = new ImageView(middenGrid);
        middenGridImageView.setFitWidth(150);
        middenGridImageView.setFitHeight(150);
        grid.add(middenGridImageView, 2, 2, 2, 2);

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
        Image groenLicht = new Image("images/verkeerslicht-groen.png");

        Image roodLicht = new Image("images/verkeerslicht-rood.png");
        ImageView roodLichtImageView = new ImageView(roodLicht);
        roodLichtImageView.setFitWidth(40);
        roodLichtImageView.setFitHeight(40);
        Button roodLichtButton = new Button("", roodLichtImageView);
        roodLichtButton.setId("icoontjesBtns");

        Image oranjeLicht = new Image("images/verkeerslicht-oranje.png");
        ImageView oranjeLichtImageView = new ImageView(oranjeLicht);
        oranjeLichtImageView.setFitWidth(40);
        oranjeLichtImageView.setFitHeight(40);
        Button oranjeLichtButton = new Button("", oranjeLichtImageView);
        oranjeLichtButton.setId("icoontjesBtns");

        ImageView groenLichtImageView = new ImageView(groenLicht);
        groenLichtImageView.setFitWidth(40);
        groenLichtImageView.setFitHeight(40);
        Button groenLichtButton = new Button("", groenLichtImageView);
        groenLichtButton.setId("icoontjesBtns");

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
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
