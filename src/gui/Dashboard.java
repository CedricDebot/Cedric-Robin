package gui;

import javafx.animation.TranslateTransition;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

public class Dashboard extends HBox
{

    private int niveau = 11;
    private Rectangle blok1 = new Rectangle(15, 30, Color.BLUE);
    private Rectangle blok2 = new Rectangle(15, 40, Color.BLACK);
    private Rectangle blok3 = new Rectangle(15, 50, Color.BLACK);
    private Rectangle blok4 = new Rectangle(15, 60, Color.BLACK);
    private Rectangle blok5 = new Rectangle(15, 70, Color.BLACK);
    private Rectangle blok6 = new Rectangle(15, 80, Color.BLACK);
    private Rectangle blok7 = new Rectangle(15, 90, Color.BLACK);
    private Rectangle blok8 = new Rectangle(15, 100, Color.BLACK);
    private Rectangle blok9 = new Rectangle(15, 110, Color.BLACK);
    private Rectangle blok10 = new Rectangle(15, 120, Color.BLACK);
    private Rectangle blok11 = new Rectangle(15, 130, Color.BLACK);
    private Rectangle blok12 = new Rectangle(15, 140, Color.BLACK);

    Rectangle[] grafiek = {blok12, blok11, blok10, blok9, blok8, blok7, blok6, blok5, blok4, blok3, blok2, blok1};

    private Label voortgang = new Label();

    public Dashboard()
    {

        HBox rootDashboard = new HBox();
        rootDashboard.setId("rootDashboard");

        //RIGHT
        VBox right = new VBox();
        right.setId("dashboardRight");

        VBox infoLeerling = new VBox();
        infoLeerling.setId("infoLeerling");
        
        Image fotoLeerling = new Image("images/character.png");
        ImageView leerlingImageView = new ImageView(fotoLeerling);
        leerlingImageView.setId("leerlingImageView");

        //lay-out (nog proberen in css te zetten)
        leerlingImageView.setFitWidth(120);
        leerlingImageView.setFitHeight(150);

        Label naamLeerling = new Label("Jules");
        naamLeerling.setId("lblNaamLeerling");

        //Inner border
        HBox hBox_inner = new HBox();

        //Outter border
        HBox hBox_outter = new HBox();
        hBox_outter.setId("hBox_outterImage");

        hBox_inner.getChildren().add(leerlingImageView);
        hBox_outter.getChildren().add(hBox_inner);

        infoLeerling.getChildren().addAll(hBox_outter, naamLeerling);
        //EvaluatieMoment
        VBox evaluatieMoment = new VBox();
        evaluatieMoment.setId("evaluatieMoment");

        Label evaTitel = new Label("Evaluatie Moment");
        evaTitel.setId("evaTitel");

        HBox momenten = new HBox();
        momenten.setId("momenten");
        Button moment1 = new Button(" ");
        moment1.setId("momentKnop");
        Button moment2 = new Button(" ");
        moment2.setId("momentKnop");
        Button moment3 = new Button(" ");
        moment3.setId("momentKnop");
        momenten.getChildren().addAll(moment1, moment2, moment3);
        evaluatieMoment.getChildren().addAll(evaTitel, momenten);
        
        //MenuKnoppen
        VBox menuKnoppen = new VBox();
        menuKnoppen.setId("menuKnoppen");
        Image dashboardMenuImage = new Image("images/MenuKnop.png");
        ImageView dashboardMenuImageView = new ImageView(dashboardMenuImage);
        dashboardMenuImageView.setFitWidth(60);
        dashboardMenuImageView.setFitHeight(50);
        Button dashboardMenu = new Button("", dashboardMenuImageView);
        dashboardMenu.setId("menuButton");
        
        Image dashboardTerugImage = new Image("images/dashboardTerug.PNG");
        ImageView dashboardTerugImageView = new ImageView(dashboardTerugImage);
        dashboardTerugImageView.setFitWidth(60);
        dashboardTerugImageView.setFitHeight(50);
        Button dashboardTerug = new Button("",dashboardTerugImageView);
        dashboardTerug.setId("menuButton");
        
        menuKnoppen.getChildren().addAll( dashboardMenu, dashboardTerug);
        right.getChildren().addAll(infoLeerling, evaluatieMoment, menuKnoppen);
        
        //Menu
        VBox menu = new VBox();
        menu.setId("menuBox");
        
        Image attitudeImageM = new Image("images/menuAttitude.PNG");
        ImageView attitudeImageViewM = new ImageView(attitudeImageM);
        attitudeImageViewM.setFitWidth(100);
        attitudeImageViewM.setFitHeight(50);
        Button attitude = new Button("", attitudeImageViewM);
        attitude.setId("menuButton");
        
        Image rijImageM = new Image("images/menuRijtechniek.PNG");
        ImageView rijImageViewM = new ImageView(rijImageM);
        rijImageViewM.setFitWidth(100);
        rijImageViewM.setFitHeight(50);
        Button rijTechniek = new Button("", rijImageViewM);
        rijTechniek.setId("menuButton");
        
        Image verkeersImageM = new Image("images/menuVerkeerstechniek.PNG");
        ImageView verkeersImageViewM = new ImageView(verkeersImageM);
        verkeersImageViewM.setFitWidth(100);
        verkeersImageViewM.setFitHeight(50);
        Button verkeersTechniek = new Button("", verkeersImageViewM);
        verkeersTechniek.setId("menuButton");
        
        Image menuTerugImageM = new Image("images/dashboardTerug.PNG");
        ImageView menuTerugImageViewM = new ImageView(menuTerugImageM);
        menuTerugImageViewM.setFitWidth(100);
        menuTerugImageViewM.setFitHeight(50);
        Button menuTerug = new Button("", menuTerugImageViewM);
        menuTerug.setId("menuButton");
        
        
        menu.getChildren().addAll(attitude, rijTechniek, verkeersTechniek, menuTerug);
        
        dashboardMenu.setOnAction(e -> {
            right.getChildren().removeAll(infoLeerling, evaluatieMoment,menuKnoppen);
            
            TranslateTransition tt = new TranslateTransition(Duration.millis(2000), menu);
            
            tt.setFromX(100.0 + menu.getLayoutX());
            tt.setByX(-107);
            tt.setCycleCount(1);
            
            tt.play();
            
            right.getChildren().addAll(menu);
        });
        menuTerug.setOnAction(e ->{      
            TranslateTransition tt = new TranslateTransition(Duration.millis(2000), menu);
            tt.setOnFinished(ev ->{
                right.getChildren().removeAll(menu);
                right.getChildren().addAll(infoLeerling, evaluatieMoment,menuKnoppen);
            });
            
            tt.setFromX(menu.getLayoutX());
            tt.setByX(107);
            tt.setCycleCount(1);
            
            tt.play();
            tt.onFinishedProperty();
            
        });
        
        //buttons
        moment1.setOnAction(e -> {
            if (moment1.getText().equals(" ")) {
                moment1.setText("1");
            } else {
                moment1.setText(" ");
            }
        });
        moment2.setOnAction(e -> {
            if (moment2.getText().equals(" ")) {
                moment2.setText("2");
            } else {
                moment2.setText(" ");
            }
        });
        moment3.setOnAction(e -> {
            if (moment3.getText().equals(" ")) {
                moment3.setText("3");
            } else {
                moment3.setText(" ");
            }
        });

        //LEFT
        VBox left = new VBox();
        left.setId("dashboardLeft");

        Image dashboardLayer1 = new Image("images/dashboard.png");
        ImageView dashboardLayer1ImageView = new ImageView(dashboardLayer1);
        dashboardLayer1ImageView.setId("dashboardLayer1ImageView");
        dashboardLayer1ImageView.setFitWidth(800);
        dashboardLayer1ImageView.setFitHeight(400);

        GridPane dashboard = new GridPane();
        dashboard.setId("dashboard");
        dashboard.setHgap(5);
        dashboard.setVgap(50);

        ColumnConstraints col1 = new ColumnConstraints(266);
        col1.setHalignment(HPos.CENTER);
        ColumnConstraints col2 = new ColumnConstraints(250);
        col2.setHalignment(HPos.CENTER);
        ColumnConstraints col3 = new ColumnConstraints(260);
        col3.setHalignment(HPos.CENTER);
        
        dashboard.getColumnConstraints().addAll(col1, col2, col3);
        
        RowConstraints row1 = new RowConstraints(250);
        row1.setValignment(VPos.BOTTOM);
        RowConstraints row2 = new RowConstraints(50);
        row2.setValignment(VPos.BOTTOM);
//        RowConstraints row3 = new RowConstraints(0);
//        row3.setValignment(VPos.TOP);
        
        dashboard.getRowConstraints().addAll(row1, row2);
        
        Image rijtechniek = new Image("images/icoon-rijtechniek.png");
        ImageView rijtechniekImageView = new ImageView(rijtechniek);
        rijtechniekImageView.setFitWidth(100);
        rijtechniekImageView.setFitHeight(100);
        Button rijtechniekBtn = new Button("", rijtechniekImageView);
        rijtechniekBtn.setId("groteBtnsDashboard");
        dashboard.add(rijtechniekBtn, 0, 0);
        
        Image attitudeD = new Image("images/attitude.png");
        ImageView attitudeImageView = new ImageView(attitudeD);
        attitudeImageView.setFitWidth(100);
        attitudeImageView.setFitHeight(100);
        Button attitudeBtn = new Button("",attitudeImageView);
        attitudeBtn.setId("groteBtnsDashboard");
        dashboard.add(attitudeBtn,1, 0);
        
        Image verkeerstechniek = new Image("images/icoon-verkeerstechniek.png");
        ImageView verkeerstechniekImageView = new ImageView(verkeerstechniek);
        verkeerstechniekImageView.setFitWidth(100);
        verkeerstechniekImageView.setFitHeight(100);
        Button verkeerstechniekBtn = new Button("", verkeerstechniekImageView);
        verkeerstechniekBtn.setId("groteBtnsDashboard");
        dashboard.add(verkeerstechniekBtn, 2, 0);
        
        //hBox met icoontjes
        HBox icoontjes = new HBox();
        icoontjes.setId("icoontjesDashboard");

        HBox icoontjesLinks = new HBox();
        icoontjesLinks.setId("icoontjesLinks");

        Image bandenSpanning = new Image("images/banden-spanning.png");
        ImageView bandenSpanningImageView = new ImageView(bandenSpanning);
        bandenSpanningImageView.setFitWidth(25);
        bandenSpanningImageView.setFitHeight(25);
        Button bandenSpanningBtn = new Button("", bandenSpanningImageView);
        bandenSpanningBtn.setId("icoontjesBtns");

        Image olie = new Image("images/olie.png");
        ImageView olieImageView = new ImageView(olie);
        olieImageView.setFitWidth(25);
        olieImageView.setFitHeight(25);
        Button olieBtn = new Button("", olieImageView);
        olieBtn.setId("icoontjesBtns");
        
        Image lichten = new Image("images/lichten.png");
        ImageView lichtenImageView = new ImageView(lichten);
        lichtenImageView.setFitWidth(25);
        lichtenImageView.setFitHeight(25);
        Button lichtenBtn = new Button("", lichtenImageView);
        lichtenBtn.setId("icoontjesBtns");
        
        icoontjesLinks.getChildren().addAll(bandenSpanningBtn, olieBtn, lichtenBtn);
                
        HBox icoontjesMidden = new HBox();
        icoontjesMidden.setId("icoontjesMidden");
        
        Image rondpunt = new Image("images/rondpunt.png");
        ImageView rondpuntImageView = new ImageView(rondpunt);
        rondpuntImageView.setFitWidth(25);
        rondpuntImageView.setFitHeight(25);
        Button rondpuntBtn = new Button("", rondpuntImageView);
        rondpuntBtn.setId("icoontjesBtns");
        
        Image rijbaan = new Image("images/rijbaan.png");
        ImageView rijbaanImageView = new ImageView(rijbaan);
        rijbaanImageView.setFitWidth(25);
        rijbaanImageView.setFitHeight(25);
        Button rijbaanBtn = new Button("", rijbaanImageView);
        rijbaanBtn.setId("icoontjesBtns");
        
        Image stad = new Image("images/stad.png");
        ImageView stadImageView = new ImageView(stad);
        stadImageView.setFitWidth(25);
        stadImageView.setFitHeight(25);
        Button stadBtn = new Button("", stadImageView);
        stadBtn.setId("icoontjesBtns");
        
        Image autosnelweg = new Image("images/autosnelweg.png");
        ImageView autosnelwegImageView = new ImageView(autosnelweg);
        autosnelwegImageView.setFitWidth(25);
        autosnelwegImageView.setFitHeight(25);
        Button autosnelwegBtn = new Button("", autosnelwegImageView);
        autosnelwegBtn.setId("icoontjesBtns");
        
        icoontjesMidden.getChildren().addAll(rondpuntBtn, rijbaanBtn, stadBtn, autosnelwegBtn);
        
        HBox icoontjesRechts = new HBox();
        icoontjesRechts.setId("icoontjesRechts");

        Image tanken  = new Image("images/tanken.png");
        ImageView tankenImageView = new ImageView(tanken);
        tankenImageView.setFitWidth(25);
        tankenImageView.setFitHeight(25);
        Button tankenBtn = new Button("", tankenImageView);
        tankenBtn.setId("icoontjesBtns");
        
        Image gps = new Image("images/GPS.png");
        ImageView gpsImageView = new ImageView(gps);
        gpsImageView.setFitWidth(25);
        gpsImageView.setFitHeight(25);
        Button gpsBtn = new Button("", gpsImageView);
        gpsBtn.setId("icoontjesBtns");
        
        Image stop = new Image("images/stop.png");
        ImageView stopImageView = new ImageView(stop);
        stopImageView.setFitWidth(25);
        stopImageView.setFitHeight(25);
        Button stopBtn = new Button("", stopImageView);
        stopBtn.setId("icoontjesBtns");
        
        icoontjesRechts.getChildren().addAll(tankenBtn, gpsBtn, stopBtn);
        
        icoontjes.getChildren().addAll(icoontjesLinks, icoontjesMidden, icoontjesRechts);
        icoontjes.setBlendMode(BlendMode.ADD);
        dashboard.add(icoontjes, 1, 1);
        
//        HBox hBoxLichten = new HBox();
//        hBoxLichten.setId("hBoxLichten");
//        
//        Image groenLicht = new Image("images/verkeerslicht-groen.png");
//        ImageView groenLichtImageView = new ImageView(groenLicht);
//        groenLichtImageView.setFitWidth(25);
//        groenLichtImageView.setFitHeight(25);
//        
//        Image oranjeLicht = new Image("images/verkeerslicht-oranje.png");
//        ImageView oranjeLichtImageView = new ImageView(oranjeLicht);
//        oranjeLichtImageView.setFitWidth(25);
//        oranjeLichtImageView.setFitHeight(25);
//        
//        Image roodLicht = new Image("images/verkeerslicht-rood.png");
//        ImageView roodLichtImageView = new ImageView(roodLicht);
//        roodLichtImageView.setFitWidth(25);
//        roodLichtImageView.setFitHeight(25);
//                
//        hBoxLichten.getChildren().addAll(groenLichtImageView, oranjeLichtImageView, roodLichtImageView);
//        hBoxLichten.setBlendMode(BlendMode.ADD);
//        dashboard.add(hBoxLichten, 1, 2);
       
        dashboard.setBlendMode(BlendMode.ADD);
        
        Group dashboardGroup = new Group();
        dashboardGroup.setId("dashboardGroup");
        dashboardGroup.getChildren().add(dashboardLayer1ImageView);
        dashboardGroup.getChildren().add(dashboard);

        VBox grafiekMetLbl = new VBox();
        grafiekMetLbl.setId("grafiekMetLbl");

        HBox grafiekOuter = new HBox();
        grafiekOuter.setId("evaluatiegrafiekOuter");

        Image min = new Image("images/minus-circle.png");
        ImageView minImageView = new ImageView(min);

        Button minusBtn = new Button("", minImageView);
        minusBtn.setId("btnGrafiek");

        HBox grafiekInner = new HBox();
        grafiekInner.setId("evaluatiegrafiek");

        grafiekInner.getChildren().addAll(grafiek);

        Image plus = new Image("images/icon-plus.png");
        ImageView plusImageView = new ImageView(plus);

        Button plusBtn = new Button("", plusImageView);
        plusBtn.setId("btnGrafiek");

        //Button minus
        minusBtn.setOnAction(e -> {
            minEen();
            setVoortgang();
        });

        //button plus
        plusBtn.setOnAction(e -> {
            plusEen();
            setVoortgang();
        });
        
        //OpmerkingVak
        VBox opmerkingenBox = new VBox();
        Label opmerkingen = new Label("OPMERKINGEN:");
        opmerkingen.setId("OpmerkingLabel");
        TextField opmerkingField = new TextField();
        opmerkingField.setId("OpmerkingVeld");
        opmerkingField.setEditable(false);
        
        opmerkingenBox.getChildren().addAll(opmerkingen, opmerkingField);
        
        HBox hBoxOnder = new HBox();
        hBoxOnder.setId("hBoxOnder");
        
        grafiekOuter.getChildren().addAll(minusBtn, grafiekInner, plusBtn);

        voortgang.setId("voortgangLbl");
        grafiekMetLbl.getChildren().addAll(grafiekOuter, voortgang);
        
        hBoxOnder.getChildren().addAll(grafiekMetLbl, opmerkingenBox);

        left.getChildren().addAll(dashboardGroup, hBoxOnder);

        //rootDashboard
        rootDashboard.getChildren().addAll(left, right);

        getChildren().add(rootDashboard);

    }

    public void plusEen()
    {
        if (niveau != 0){
            niveau--;
            Rectangle blokAdd = grafiek[niveau];
            blokAdd.setFill(Color.BLUE);
            grafiek[niveau] = blokAdd;
        }
    }

    public void minEen()
    {
        if (niveau != 11) {
            Rectangle blokDelete = grafiek[niveau];
            blokDelete.setFill(Color.BLACK);
            grafiek[niveau] = blokDelete;

            niveau++;
            Rectangle blokAdd = grafiek[niveau];
            blokAdd.setFill(Color.BLUE);
            grafiek[niveau] = blokAdd;
        }
    }

    public void setVoortgang()
    {
        if (niveau <= 7 && niveau >= 4) {
            voortgang.setText("Klaar om met begeleider te oefenen");
        }

        if (niveau <= 3 && niveau >= 1) {
            voortgang.setText("Klaar om alleen te oefenen");
        }

        if (niveau == 0) {
            voortgang.setText("Klaar voor praktisch examen");
        }
        
        if (niveau > 7){
            voortgang.setText("");
        }
    }
}
