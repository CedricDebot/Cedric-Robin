package gui;

import domein.RijtechniekDom;
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
    private RijtechniekDom rijtechniekdom = new RijtechniekDom();

    public Rijtechniek() {
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
        Image stuurWit = new Image("images/stuurWit.png");
        ImageView stuurImageView = new ImageView(stuurWit);
        stuurImageView.setFitWidth(50);
        stuurImageView.setFitHeight(50);
        Button stuurBtn = new Button("", stuurImageView);
        stuurBtn.setId("icoontjesBtns");
        //grid.add(stuurBtn, 3, 0);

        stuurBtn.setOnMouseDragged(e ->{
            IcoonStuurOpm icoonStuur = new IcoonStuurOpm();
            icoonStuur.setScene(scene);
            scene.setRoot(icoonStuur);
        });
        Image stuurRood = new Image("images/stuurRood.png");
        Image stuurOranje = new Image("images/stuurOranje.png");
        Image stuurGroen = new Image("images/stuurGroen.png");

        stuurBtn.setOnAction(e -> {
            if (rijtechniekdom.getStuurTechniek() == Toestand.WIT) {
                rijtechniekdom.setStuurTechniek(Toestand.ROOD);
                stuurImageView.setImage(stuurRood);
            } else if (rijtechniekdom.getStuurTechniek() == Toestand.ROOD) {
                rijtechniekdom.setStuurTechniek(Toestand.ORANJE);
                stuurImageView.setImage(stuurOranje);
            } else if (rijtechniekdom.getStuurTechniek() == Toestand.ORANJE) {
                rijtechniekdom.setStuurTechniek(Toestand.GROEN);
                stuurImageView.setImage(stuurGroen);
            } else if (rijtechniekdom.getStuurTechniek() == Toestand.GROEN) {
                rijtechniekdom.setStuurTechniek(Toestand.WIT);
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
        Image schakelenWit = new Image("images/schakelenWit.png");
        ImageView schakelenImageView = new ImageView(schakelenWit);
        schakelenImageView.setFitWidth(50);
        schakelenImageView.setFitHeight(50);
        Button schakelenBtn = new Button("", schakelenImageView);
        schakelenBtn.setId("icoontjesBtns");
        //grid.add(schakelenBtn, 4, 1);

        Image schakelenRood = new Image("images/schakelenRood.png");
        Image schakelenOranje = new Image("images/schakelenOranje.png");
        Image schakelenGroen = new Image("images/schakelenGroen.png");

        schakelenBtn.setOnAction(e -> {
            if (rijtechniekdom.getSchakelTechniek() == Toestand.WIT) {
                rijtechniekdom.setSchakelTechniek(Toestand.ROOD);
                schakelenImageView.setImage(schakelenRood);
            } else if (rijtechniekdom.getSchakelTechniek() == Toestand.ROOD) {
                rijtechniekdom.setSchakelTechniek(Toestand.ORANJE);
                schakelenImageView.setImage(schakelenOranje);
            } else if (rijtechniekdom.getSchakelTechniek() == Toestand.ORANJE) {
                rijtechniekdom.setSchakelTechniek(Toestand.GROEN);
                schakelenImageView.setImage(schakelenGroen);
            } else if (rijtechniekdom.getSchakelTechniek() == Toestand.GROEN) {
                rijtechniekdom.setSchakelTechniek(Toestand.WIT);
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
        Image kijkenWit = new Image("images/kijkenWit.png");
        ImageView kijkenImageView = new ImageView(kijkenWit);
        kijkenImageView.setFitWidth(50);
        kijkenImageView.setFitHeight(50);
        Button kijkenBtn = new Button("", kijkenImageView);
        kijkenBtn.setId("icoontjesBtns");
        //grid.add(kijkenBtn, 5, 2);

        Image kijkenRood = new Image("images/kijkenRood.png");
        Image kijkenOranje = new Image("images/kijkenOranje.png");
        Image kijkenGroen = new Image("images/kijkenGroen.png");

        kijkenBtn.setOnAction(e -> {
            if (rijtechniekdom.getKijkTechniek() == Toestand.WIT) {
                rijtechniekdom.setKijkTechniek(Toestand.ROOD);
                kijkenImageView.setImage(kijkenRood);
            } else if (rijtechniekdom.getKijkTechniek() == Toestand.ROOD) {
                rijtechniekdom.setKijkTechniek(Toestand.ORANJE);
                kijkenImageView.setImage(kijkenOranje);
            } else if (rijtechniekdom.getKijkTechniek() == Toestand.ORANJE) {
                rijtechniekdom.setKijkTechniek(Toestand.GROEN);
                kijkenImageView.setImage(kijkenGroen);
            } else if (rijtechniekdom.getKijkTechniek() == Toestand.GROEN) {
                rijtechniekdom.setKijkTechniek(Toestand.WIT);
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

        Image parkerenWit = new Image("images/parkerenWit.png");
        ImageView parkerenImageView = new ImageView(parkerenWit);
        parkerenImageView.setId("parkerenIcoon");
        parkerenImageView.setFitWidth(50);
        parkerenImageView.setFitHeight(50);
        Button parkerenBtn = new Button("", parkerenImageView);
        parkerenBtn.setId("icoontjesBtns");
        grid.add(parkerenBtn, 5, 3);

        Image parkerenRood = new Image("images/parkerenRood.png");
        Image parkerenOranje = new Image("images/parkerenOranje.png");
        Image parkerenGroen = new Image("images/parkerenGroen.png");

        parkerenBtn.setOnAction(e -> {
            if (rijtechniekdom.getParkeren() == Toestand.WIT) {
                rijtechniekdom.setParkeren(Toestand.ROOD);
                parkerenImageView.setImage(parkerenRood);
            } else if (rijtechniekdom.getParkeren() == Toestand.ROOD) {
                rijtechniekdom.setParkeren(Toestand.ORANJE);
                parkerenImageView.setImage(parkerenOranje);
            } else if (rijtechniekdom.getParkeren() == Toestand.ORANJE) {
                rijtechniekdom.setParkeren(Toestand.GROEN);
                parkerenImageView.setImage(parkerenGroen);
            } else if (rijtechniekdom.getParkeren() == Toestand.GROEN) {
                rijtechniekdom.setParkeren(Toestand.WIT);
                parkerenImageView.setImage(parkerenWit);
            }
        });

        Image kerenWit = new Image("images/kerenWit.png");
        ImageView kerenImageView = new ImageView(kerenWit);
        kerenImageView.setFitWidth(50);
        kerenImageView.setFitHeight(50);
        Button kerenBtn = new Button("", kerenImageView);
        kerenBtn.setId("icoontjesBtns");
        grid.add(kerenBtn, 4, 4);

        Image kerenRood = new Image("images/kerenRood.png");
        Image kerenOranje = new Image("images/kerenOranje.png");
        Image kerenGroen = new Image("images/kerenGroen.png");

        kerenBtn.setOnAction(e -> {
            if (rijtechniekdom.getKeren()== Toestand.WIT) {
                rijtechniekdom.setKeren(Toestand.ROOD);
                kerenImageView.setImage(kerenRood);
            } else if (rijtechniekdom.getKeren()== Toestand.ROOD) {
                rijtechniekdom.setKeren(Toestand.ORANJE);
                kerenImageView.setImage(kerenOranje);
            } else if (rijtechniekdom.getKeren()== Toestand.ORANJE) {
                rijtechniekdom.setKeren(Toestand.GROEN);
                kerenImageView.setImage(kerenGroen);
            } else if (rijtechniekdom.getKeren()== Toestand.GROEN) {
                rijtechniekdom.setKeren(Toestand.WIT);
                kerenImageView.setImage(kerenWit);
            }
        });

        Image garageWit = new Image("images/garageWit.png");
        ImageView garageImageView = new ImageView(garageWit);
        garageImageView.setFitWidth(50);
        garageImageView.setFitHeight(50);
        Button garageBtn = new Button("", garageImageView);
        garageBtn.setId("icoontjesBtns");
        grid.add(garageBtn, 3, 5);

        Image garageRood = new Image("images/garageRood.png");
        Image garageOranje = new Image("images/garageOranje.png");
        Image garageGroen = new Image("images/garageGroen.png");

        garageBtn.setOnAction(e -> {
            if (rijtechniekdom.getGarage() == Toestand.WIT) {
                rijtechniekdom.setGarage(Toestand.ROOD);
                garageImageView.setImage(garageRood);
            } else if (rijtechniekdom.getGarage() == Toestand.ROOD) {
                rijtechniekdom.setGarage(Toestand.ORANJE);
                garageImageView.setImage(garageOranje);
            } else if (rijtechniekdom.getGarage() == Toestand.ORANJE) {
                rijtechniekdom.setGarage(Toestand.GROEN);
                garageImageView.setImage(garageGroen);
            } else if (rijtechniekdom.getGarage() == Toestand.GROEN) {
                rijtechniekdom.setGarage(Toestand.WIT);
                garageImageView.setImage(garageWit);
            }
        });

        Image achteruitWit = new Image("images/achteruitWit.png");
        ImageView achteruitImageView = new ImageView(achteruitWit);
        achteruitImageView.setFitWidth(50);
        achteruitImageView.setFitHeight(50);
        Button achteruitBtn = new Button("", achteruitImageView);
        achteruitBtn.setId("icoontjesBtns");
        grid.add(achteruitBtn, 2, 5);

        Image achteruitRood = new Image("images/achteruitRood.png");
        Image achteruitOranje = new Image("images/achteruitOranje.png");
        Image achteruitGroen = new Image("images/achteruitGroen.png");

        achteruitBtn.setOnAction(e -> {
            if (rijtechniekdom.getAchteruit()== Toestand.WIT) {
                rijtechniekdom.setAchteruit(Toestand.ROOD);
                achteruitImageView.setImage(achteruitRood);
            } else if (rijtechniekdom.getAchteruit()== Toestand.ROOD) {
                rijtechniekdom.setAchteruit(Toestand.ORANJE);
                achteruitImageView.setImage(achteruitOranje);
            } else if (rijtechniekdom.getAchteruit()== Toestand.ORANJE) {
                rijtechniekdom.setAchteruit(Toestand.GROEN);
                achteruitImageView.setImage(achteruitGroen);
            } else if (rijtechniekdom.getAchteruit()== Toestand.GROEN) {
                rijtechniekdom.setAchteruit(Toestand.WIT);
                achteruitImageView.setImage(achteruitWit);
            }
        });

        Image achtWit = new Image("images/achtWit.png");
        ImageView achtImageView = new ImageView(achtWit);
        achtImageView.setFitWidth(50);
        achtImageView.setFitHeight(50);
        Button achtBtn = new Button("", achtImageView);
        achtBtn.setId("icoontjesBtns");
        grid.add(achtBtn, 1, 4);

        Image achtRood = new Image("images/achtRood.png");
        Image achtOranje = new Image("images/achtOranje.png");
        Image achtGroen = new Image("images/achtGroen.png");
        
        achtBtn.setOnAction(e -> {
            if(rijtechniekdom.getAcht()== Toestand.WIT){
                rijtechniekdom.setAcht(Toestand.ROOD);
                achtImageView.setImage(achtRood);
            }else if(rijtechniekdom.getAcht()== Toestand.ROOD){
                rijtechniekdom.setAcht(Toestand.ORANJE);
                achtImageView.setImage(achtOranje);
            }else if(rijtechniekdom.getAcht()== Toestand.ORANJE){
                rijtechniekdom.setAcht(Toestand.GROEN);
                achtImageView.setImage(achtGroen);
            }else if(rijtechniekdom.getAcht()== Toestand.GROEN){
                rijtechniekdom.setAcht(Toestand.WIT);
                achtImageView.setImage(achtWit);
            }
        });
        
        HBox bergopHBox = new HBox();
        bergopHBox.setId("hellingHBox");
        Image hellingWit = new Image("images/hellingWit.png");
        ImageView hellingImageView = new ImageView(hellingWit);
        hellingImageView.setFitWidth(50);
        hellingImageView.setFitHeight(50);
        Button hellingBtn = new Button("", hellingImageView);
        hellingBtn.setId("icoontjesBtns");
        //grid.add(bergopBtn, 0, 3);

        Image hellingRood = new Image("images/hellingRood.png");
        Image hellingOranje = new Image("images/hellingOranje.png");
        Image hellingGroen = new Image("images/hellingGroen.png");
        
        hellingBtn.setOnAction(e -> {
            if(rijtechniekdom.getHelling() == Toestand.WIT){
                rijtechniekdom.setHelling(Toestand.ROOD);
                hellingImageView.setImage(hellingRood);
            }else if(rijtechniekdom.getHelling()== Toestand.ROOD){
                rijtechniekdom.setHelling(Toestand.ORANJE);
                hellingImageView.setImage(hellingOranje);
            }else if(rijtechniekdom.getHelling()== Toestand.ORANJE){
                rijtechniekdom.setHelling(Toestand.GROEN);
                hellingImageView.setImage(hellingGroen);
            }else if(rijtechniekdom.getHelling()== Toestand.GROEN){
                rijtechniekdom.setHelling(Toestand.WIT);
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
        Image zithoudingWit = new Image("images/zithoudingWit.png");
        ImageView zithoudingImageView = new ImageView(zithoudingWit);
        zithoudingImageView.setFitWidth(50);
        zithoudingImageView.setFitHeight(50);
        Button zithoudingBtn = new Button("", zithoudingImageView);
        zithoudingBtn.setId("icoontjesBtns");
        //grid.add(zithoudingBtn, 0, 2);

        Image zithoudingRood = new Image("images/zithoudingRood.png");
        Image zithoudingOranje = new Image("images/zithoudingOranje.png");
        Image zithoudingGroen = new Image("images/zithoudingGroen.png");
        
        zithoudingBtn.setOnAction(e -> {
            if(rijtechniekdom.getZithouding()== Toestand.WIT){
                rijtechniekdom.setZithouding(Toestand.ROOD);
                zithoudingImageView.setImage(zithoudingRood);
            }else if(rijtechniekdom.getZithouding()== Toestand.ROOD){
                rijtechniekdom.setZithouding(Toestand.ORANJE);
                zithoudingImageView.setImage(zithoudingOranje);
            }else if(rijtechniekdom.getZithouding()== Toestand.ORANJE){
                rijtechniekdom.setZithouding(Toestand.GROEN);
                zithoudingImageView.setImage(zithoudingGroen);
            }else if(rijtechniekdom.getZithouding()== Toestand.GROEN){
                rijtechniekdom.setZithouding(Toestand.WIT);
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
        Image remtechniekWit = new Image("images/remWit.png");
        ImageView remtechniekImageView = new ImageView(remtechniekWit);
        remtechniekImageView.setFitWidth(50);
        remtechniekImageView.setFitHeight(50);
        Button remtechniekBtn = new Button("", remtechniekImageView);
        remtechniekBtn.setId("icoontjesBtns");
        //grid.add(remtechniekBtn, 1, 1);

        Image remtechniekRood = new Image("images/remRood.png");
        Image remtechniekOranje = new Image("images/remOranje.png");
        Image remtechniekGroen = new Image("images/remGroen.png");
        
        remtechniekBtn.setOnAction(e -> {
            if(rijtechniekdom.getRemtechniek()== Toestand.WIT){
                rijtechniekdom.setRemtechniek(Toestand.ROOD);
                remtechniekImageView.setImage(remtechniekRood);
            }else if(rijtechniekdom.getRemtechniek()== Toestand.ROOD){
                rijtechniekdom.setRemtechniek(Toestand.ORANJE);
                remtechniekImageView.setImage(remtechniekOranje);
            }else if(rijtechniekdom.getRemtechniek()== Toestand.ORANJE){
                rijtechniekdom.setRemtechniek(Toestand.GROEN);
                remtechniekImageView.setImage(remtechniekGroen);
            }else if(rijtechniekdom.getRemtechniek()== Toestand.GROEN){
                rijtechniekdom.setRemtechniek(Toestand.WIT);
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
        Image embrayageWit = new Image("images/embrayageWit.png");
        ImageView embrayageImageView = new ImageView(embrayageWit);
        embrayageImageView.setFitWidth(50);
        embrayageImageView.setFitHeight(50);
        Button embrayageBtn = new Button("", embrayageImageView);
        embrayageBtn.setId("icoontjesBtns");
        //grid.add(embrayageBtn, 2, 0);

        Image embrayageRood = new Image("images/embrayageRood.png");
        Image embrayageOranje = new Image("images/embrayageOranje.png");
        Image embrayageGroen = new Image("images/embrayageGroen.png");
        
        embrayageBtn.setOnAction(e -> {
            if(rijtechniekdom.getKoppeling()== Toestand.WIT){
                rijtechniekdom.setKoppeling(Toestand.ROOD);
                embrayageImageView.setImage(embrayageRood);
            }else if(rijtechniekdom.getKoppeling()== Toestand.ROOD){
                rijtechniekdom.setKoppeling(Toestand.ORANJE);
                embrayageImageView.setImage(embrayageOranje);
            }else if(rijtechniekdom.getKoppeling()== Toestand.ORANJE){
                rijtechniekdom.setKoppeling(Toestand.GROEN);
                embrayageImageView.setImage(embrayageGroen);
            }else if(rijtechniekdom.getKoppeling()== Toestand.GROEN){
                rijtechniekdom.setKoppeling(Toestand.WIT);
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

        Image middenGrid = new Image("images/icoon-rijtechniek.png");
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
            Dashboard dashboard = new Dashboard();
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

        VBox menuStandaard = menu.buildMenuStandaard();

        right.getChildren().add(menuStandaard);

        VBox menuBalk = menu.buildMenu();

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
