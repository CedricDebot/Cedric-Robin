package gui;

import domein.AttitudeOpmerking;
import domein.EvaluatieGrafiek;
import domein.GezienNietGezien;
import domein.Leerling;
import javafx.animation.TranslateTransition;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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

public class Dashboard extends GridPane {
    
    private Scene scene;
    
    private EvaluatieGrafiek evaGraf;
    
    Rectangle[] grafiek;
    
    private Label voortgang;
    private Leerling leerling;
    
    public Dashboard(Beginscherm beginscherm, Leerling leerling) {
        
        this.leerling = leerling;
        this.evaGraf = leerling.getEvaGraf();
        
        this.voortgang = evaGraf.getVoortgangLabel();
        
        this.grafiek = new Rectangle[]{evaGraf.getBlok12(),
            evaGraf.getBlok11(),
            evaGraf.getBlok10(),
            evaGraf.getBlok9(),
            evaGraf.getBlok8(),
            evaGraf.getBlok7(),
            evaGraf.getBlok6(),
            evaGraf.getBlok5(),
            evaGraf.getBlok4(),
            evaGraf.getBlok3(),
            evaGraf.getBlok2(),
            evaGraf.getBlok1()};

        //Menu
        Menu menu = new Menu();
        
        HBox rootDashboard = new HBox();
        rootDashboard.setId("rootDashboard");

        //RIGHT
        VBox right = new VBox();
        //right.setId("dashboardRight");

        //MenuStandaard
        VBox menuStandaard = menu.buildMenuDashboard(leerling);
        menuStandaard.setId("dashboardRight");
        right.getChildren().add(menuStandaard);

        //Menu
        VBox menuBalk = menu.buildMenu(this, 1);
        
        menu.getMenuKnop().setOnAction(e -> {
            menu.setScene(scene);
            right.getChildren().remove(menuStandaard);
            
            TranslateTransition tt = new TranslateTransition(Duration.millis(500), menuBalk);
            
            tt.setFromX(100.0 + menuBalk.getLayoutX());
            tt.setByX(-100);
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
            tt.setByX(100);
            tt.setCycleCount(1);
            
            tt.play();
            tt.onFinishedProperty();
            
        });

        //EvaluatieMoment Buttons
        menu.getMoment1().setOnAction(e -> {
            if (menu.getMoment1().getText().equals(" ")) {
                menu.getMoment1().setText("1");
            } else {
                menu.getMoment1().setText(" ");
            }
        });
        menu.getMoment2().setOnAction(e -> {
            if (menu.getMoment2().getText().equals(" ")) {
                menu.getMoment2().setText("2");
            } else {
                menu.getMoment2().setText(" ");
            }
        });
        menu.getMoment3().setOnAction(e -> {
            if (menu.getMoment3().getText().equals(" ")) {
                menu.getMoment3().setText("3");
            } else {
                menu.getMoment3().setText(" ");
            }
        });
        
        menu.getDashboardTerug().setOnAction(e -> {
            beginscherm.setScene(scene);
            scene.setRoot(beginscherm);
        });

        //LEFT
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
        
        Image rijtechniek = new Image("images/rijtechniekIcoon/stuurWit.png");
        ImageView rijtechniekImageView = new ImageView(rijtechniek);
        rijtechniekImageView.setFitWidth(100);
        rijtechniekImageView.setFitHeight(100);
        Button rijtechniekBtn = new Button("", rijtechniekImageView);
        rijtechniekBtn.setId("groteBtnsDashboard");
        dashboard.add(rijtechniekBtn, 0, 0);
        
        rijtechniekBtn.setOnAction(e -> {
            Rijtechniek rijtechniekScherm = new Rijtechniek(this);
            rijtechniekScherm.setScene(scene);
            scene.setRoot(rijtechniekScherm);
        });
        Image attitudeD = new Image("images/attitude.png");
        ImageView attitudeImageView = new ImageView(attitudeD);
        attitudeImageView.setFitWidth(100);
        attitudeImageView.setFitHeight(100);
        Button attitudeBtn = new Button("", attitudeImageView);
        attitudeBtn.setId("groteBtnsDashboard");
        dashboard.add(attitudeBtn, 1, 0);
        
        attitudeBtn.setOnAction(e -> {
            Attitude attitude = new Attitude(this);
            attitude.setScene(scene);
            scene.setRoot(attitude);
        });
        
        Image verkeerstechniek = new Image("images/verkeerstechniekWit.png");
        ImageView verkeerstechniekImageView = new ImageView(verkeerstechniek);
        verkeerstechniekImageView.setFitWidth(100);
        verkeerstechniekImageView.setFitHeight(100);
        Button verkeerstechniekBtn = new Button("", verkeerstechniekImageView);
        verkeerstechniekBtn.setId("groteBtnsDashboard");
        dashboard.add(verkeerstechniekBtn, 2, 0);
        
        verkeerstechniekBtn.setOnAction(e -> {
            VerkeersTechniek verkeersTechniek = new VerkeersTechniek(this);
            verkeersTechniek.setScene(scene);
            scene.setRoot(verkeersTechniek);
        });

        //hBox met icoontjes
        HBox icoontjes = new HBox();
        icoontjes.setId("icoontjesDashboard");
        
        HBox icoontjesLinks = new HBox();
        icoontjesLinks.setId("icoontjesLinks");
        
        Image bandenSpanningBegin = new Image("images/dashboard/bandenspanning" + leerling.getDashboardDom().getBanden() + ".png");
        ImageView bandenSpanningImageView = new ImageView(bandenSpanningBegin);
        bandenSpanningImageView.setFitWidth(25);
        bandenSpanningImageView.setFitHeight(25);
        Button bandenSpanningBtn = new Button("", bandenSpanningImageView);
        bandenSpanningBtn.setId("icoontjesBtns");
        
        Image bandenSpanningWit = new Image("images/dashboard/bandenspanningNIETGEZIEN.png");
        Image bandenSpanningGroen = new Image("images/dashboard/bandenspanningGEZIEN.png");
        
        bandenSpanningBtn.setOnAction(e -> {
            if (leerling.getDashboardDom().getBanden() == GezienNietGezien.NIETGEZIEN) {
                leerling.getDashboardDom().setBanden(GezienNietGezien.GEZIEN);
                bandenSpanningImageView.setImage(bandenSpanningGroen);
            } else if (leerling.getDashboardDom().getBanden() == GezienNietGezien.GEZIEN) {
                leerling.getDashboardDom().setBanden(GezienNietGezien.NIETGEZIEN);
                bandenSpanningImageView.setImage(bandenSpanningWit);
            }
        });
        
        Image vloeistoffenBegin = new Image("images/dashboard/olie" + leerling.getDashboardDom().getVloeistoffen() + ".png");
        ImageView vloeistoffenImageView = new ImageView(vloeistoffenBegin);
        vloeistoffenImageView.setFitWidth(25);
        vloeistoffenImageView.setFitHeight(25);
        Button vloeistoffenBtn = new Button("", vloeistoffenImageView);
        vloeistoffenBtn.setId("icoontjesBtns");
        
        Image vloeistoffenWit = new Image("images/dashboard/olieNIETGEZIEN.png");
        Image vloeistoffenGroen = new Image("images/dashboard/olieGEZIEN.png");
        
        vloeistoffenBtn.setOnAction(e -> {
            if (leerling.getDashboardDom().getVloeistoffen() == GezienNietGezien.NIETGEZIEN) {
                leerling.getDashboardDom().setVloeistoffen(GezienNietGezien.GEZIEN);
                vloeistoffenImageView.setImage(vloeistoffenGroen);
            } else if (leerling.getDashboardDom().getVloeistoffen() == GezienNietGezien.GEZIEN) {
                leerling.getDashboardDom().setVloeistoffen(GezienNietGezien.NIETGEZIEN);
                vloeistoffenImageView.setImage(vloeistoffenWit);
            }
        });
        
        Image schakelaarsBegin = new Image("images/dashboard/schakelaars" + leerling.getDashboardDom().getSchakelaars() + ".png");
        ImageView schakelaarsImageView = new ImageView(schakelaarsBegin);
        schakelaarsImageView.setFitWidth(25);
        schakelaarsImageView.setFitHeight(25);
        Button schakelaarsBtn = new Button("", schakelaarsImageView);
        schakelaarsBtn.setId("icoontjesBtns");
        
        Image schakelaarsWit = new Image("images/dashboard/schakelaarsNIETGEZIEN.png");
        Image schakelaarsGroen = new Image("images/dashboard/schakelaarsGEZIEN.png");
        
        schakelaarsBtn.setOnAction(e -> {
            if (leerling.getDashboardDom().getSchakelaars() == GezienNietGezien.NIETGEZIEN) {
                leerling.getDashboardDom().setSchakelaars(GezienNietGezien.GEZIEN);
                schakelaarsImageView.setImage(schakelaarsGroen);
            } else if (leerling.getDashboardDom().getSchakelaars() == GezienNietGezien.GEZIEN) {
                leerling.getDashboardDom().setSchakelaars(GezienNietGezien.NIETGEZIEN);
                schakelaarsImageView.setImage(schakelaarsWit);
            }
        });
        
        icoontjesLinks.getChildren().addAll(bandenSpanningBtn, vloeistoffenBtn, schakelaarsBtn);
        
        HBox icoontjesMidden = new HBox();
        icoontjesMidden.setId("icoontjesMidden");
        
        Image rotondeBegin = new Image("images/dashboard/rotonde" + leerling.getDashboardDom().getRotonde() + ".png");
        ImageView rotondeImageView = new ImageView(rotondeBegin);
        rotondeImageView.setFitWidth(25);
        rotondeImageView.setFitHeight(25);
        Button rotondeBtn = new Button("", rotondeImageView);
        rotondeBtn.setId("icoontjesBtns");
        
        Image rotondeWit = new Image("images/dashboard/rotondeNIETGEZIEN.png");
        Image rotondeGroen = new Image("images/dashboard/rotondeGEZIEN.png");
        
        rotondeBtn.setOnAction(e -> {
            if (leerling.getDashboardDom().getRotonde() == GezienNietGezien.NIETGEZIEN) {
                leerling.getDashboardDom().setRotonde(GezienNietGezien.GEZIEN);
                rotondeImageView.setImage(rotondeGroen);
            } else if (leerling.getDashboardDom().getRotonde() == GezienNietGezien.GEZIEN) {
                leerling.getDashboardDom().setRotonde(GezienNietGezien.NIETGEZIEN);
                rotondeImageView.setImage(rotondeWit);
            }
        });
        
        Image rijbaanBegin = new Image("images/dashboard/rijbaan" + leerling.getDashboardDom().getRijbaan() + ".png");
        ImageView rijbaanImageView = new ImageView(rijbaanBegin);
        rijbaanImageView.setFitWidth(25);
        rijbaanImageView.setFitHeight(25);
        Button rijbaanBtn = new Button("", rijbaanImageView);
        rijbaanBtn.setId("icoontjesBtns");
        
        Image rijbaanWit = new Image("images/dashboard/rijbaanNIETGEZIEN.png");
        Image rijbaanGroen = new Image("images/dashboard/rijbaanGEZIEN.png");
        
        rijbaanBtn.setOnAction(e -> {
            if (leerling.getDashboardDom().getRijbaan() == GezienNietGezien.NIETGEZIEN) {
                leerling.getDashboardDom().setRijbaan(GezienNietGezien.GEZIEN);
                rijbaanImageView.setImage(rijbaanGroen);
            } else if (leerling.getDashboardDom().getRijbaan() == GezienNietGezien.GEZIEN) {
                leerling.getDashboardDom().setRijbaan(GezienNietGezien.NIETGEZIEN);
                rijbaanImageView.setImage(rijbaanWit);
            }
        });
        
        Image stadBegin = new Image("images/dashboard/stad" + leerling.getDashboardDom().getStad() + ".png");
        ImageView stadImageView = new ImageView(stadBegin);
        stadImageView.setFitWidth(25);
        stadImageView.setFitHeight(25);
        Button stadBtn = new Button("", stadImageView);
        stadBtn.setId("icoontjesBtns");
        
        Image stadWit = new Image("images/dashboard/stadNIETGEZIEN.png");
        Image stadGroen = new Image("images/dashboard/stadGEZIEN.png");
        
        stadBtn.setOnAction(e -> {
            if (leerling.getDashboardDom().getStad() == GezienNietGezien.NIETGEZIEN) {
                leerling.getDashboardDom().setStad(GezienNietGezien.GEZIEN);
                stadImageView.setImage(stadGroen);
            } else if (leerling.getDashboardDom().getStad() == GezienNietGezien.GEZIEN) {
                leerling.getDashboardDom().setStad(GezienNietGezien.NIETGEZIEN);
                stadImageView.setImage(stadWit);
            }
        });
        
        Image autosnelwegBegin = new Image("images/dashboard/autosnelweg" + leerling.getDashboardDom().getAutosnelweg() + ".png");
        ImageView autosnelwegImageView = new ImageView(autosnelwegBegin);
        autosnelwegImageView.setFitWidth(25);
        autosnelwegImageView.setFitHeight(25);
        Button autosnelwegBtn = new Button("", autosnelwegImageView);
        autosnelwegBtn.setId("icoontjesBtns");
        
        Image autosnelwegWit = new Image("images/dashboard/autosnelwegNIETGEZIEN.png");
        Image autosnelwegGroen = new Image("images/dashboard/autosnelwegGEZIEN.png");
        
        autosnelwegBtn.setOnAction(e -> {
            if (leerling.getDashboardDom().getAutosnelweg() == GezienNietGezien.NIETGEZIEN) {
                leerling.getDashboardDom().setAutosnelweg(GezienNietGezien.GEZIEN);
                autosnelwegImageView.setImage(autosnelwegGroen);
            } else if (leerling.getDashboardDom().getAutosnelweg() == GezienNietGezien.GEZIEN) {
                leerling.getDashboardDom().setAutosnelweg(GezienNietGezien.NIETGEZIEN);
                autosnelwegImageView.setImage(autosnelwegWit);
            }
        });
        
        icoontjesMidden.getChildren().addAll(rotondeBtn, rijbaanBtn, stadBtn, autosnelwegBtn);
        
        HBox icoontjesRechts = new HBox();
        icoontjesRechts.setId("icoontjesRechts");
        
        Image tankenBegin = new Image("images/dashboard/tanken" + leerling.getDashboardDom().getTanken() + ".png");
        ImageView tankenImageView = new ImageView(tankenBegin);
        tankenImageView.setFitWidth(25);
        tankenImageView.setFitHeight(25);
        Button tankenBtn = new Button("", tankenImageView);
        tankenBtn.setId("icoontjesBtns");
        
        Image tankenWit = new Image("images/dashboard/tankenNIETGEZIEN.png");
        Image tankenGroen = new Image("images/dashboard/tankenGEZIEN.png");
        
        tankenBtn.setOnAction(e -> {
            if (leerling.getDashboardDom().getTanken() == GezienNietGezien.NIETGEZIEN) {
                leerling.getDashboardDom().setTanken(GezienNietGezien.GEZIEN);
                tankenImageView.setImage(tankenGroen);
            } else if (leerling.getDashboardDom().getTanken() == GezienNietGezien.GEZIEN) {
                leerling.getDashboardDom().setTanken(GezienNietGezien.NIETGEZIEN);
                tankenImageView.setImage(tankenWit);
            }
        });
        
        Image gpsBegin = new Image("images/dashboard/gps" + leerling.getDashboardDom().getGps() + ".png");
        ImageView gpsImageView = new ImageView(gpsBegin);
        gpsImageView.setFitWidth(25);
        gpsImageView.setFitHeight(25);
        Button gpsBtn = new Button("", gpsImageView);
        gpsBtn.setId("icoontjesBtns");
        
        Image gpsWit = new Image("images/dashboard/gpsNIETGEZIEN.png");
        Image gpsGroen = new Image("images/dashboard/gpsGEZIEN.png");
        
        gpsBtn.setOnAction(e -> {
            if (leerling.getDashboardDom().getGps() == GezienNietGezien.NIETGEZIEN) {
                leerling.getDashboardDom().setGps(GezienNietGezien.GEZIEN);
                gpsImageView.setImage(gpsGroen);
            } else if (leerling.getDashboardDom().getGps() == GezienNietGezien.GEZIEN) {
                leerling.getDashboardDom().setGps(GezienNietGezien.NIETGEZIEN);
                gpsImageView.setImage(gpsWit);
            }
        });
        
        Image noodstopBegin = new Image("images/dashboard/noodstop" + leerling.getDashboardDom().getStop() + ".png");
        ImageView stopImageView = new ImageView(noodstopBegin);
        stopImageView.setFitWidth(25);
        stopImageView.setFitHeight(25);
        Button stopBtn = new Button("", stopImageView);
        stopBtn.setId("icoontjesBtns");
        
        Image noodstopWit = new Image("images/dashboard/noodstopNIETGEZIEN.png");
        Image noodstopGroen = new Image("images/dashboard/noodstopGEZIEN.png");
        
        stopBtn.setOnAction(e -> {
            if (leerling.getDashboardDom().getStop() == GezienNietGezien.NIETGEZIEN) {
                leerling.getDashboardDom().setStop(GezienNietGezien.GEZIEN);
                stopImageView.setImage(noodstopGroen);
            } else if (leerling.getDashboardDom().getStop() == GezienNietGezien.GEZIEN) {
                leerling.getDashboardDom().setStop(GezienNietGezien.NIETGEZIEN);
                stopImageView.setImage(noodstopWit);
            }
        });
        
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
            //minEen();
            Rectangle blokDelete = grafiek[evaGraf.getPositie()];
            blokDelete.setFill(Color.BLACK);
            grafiek[evaGraf.getPositie()] = blokDelete;
            
            evaGraf.minEen();
            
            Rectangle blokAdd = grafiek[evaGraf.getPositie()];
            blokAdd.setFill(Color.BLUE);
            grafiek[evaGraf.getPositie()] = blokAdd;
            setVoortgang();
        });

        //button plus
        plusBtn.setOnAction(e -> {
            evaGraf.plusEen();
            Rectangle blokAdd = grafiek[evaGraf.getPositie()];
            blokAdd.setFill(Color.BLUE);
            grafiek[evaGraf.getPositie()] = blokAdd;
            setVoortgang();
        });

        //OpmerkingVak
        VBox opmerkingenBox = new VBox();
        opmerkingenBox.setAlignment(Pos.TOP_CENTER);
        Label opmerkingenLbl = new Label("OPMERKINGEN:");
        opmerkingenLbl.setId("OpmerkingLabel");
        
        Label opmerkingenOnderwerp = new Label(leerling.getRecenteOpmerkingen().get(leerling.getHuidigeOpmerking()).getNaam());
        opmerkingenOnderwerp.setId("recenteOpmerkingenONDLabel");
        TextArea opmerkingen = new TextArea(leerling.getRecenteOpmerkingen().get(leerling.getHuidigeOpmerking()).getOpmerking());
        opmerkingen.setId("recenteOpmerkingenLabel");
        opmerkingen.setEditable(false);
        opmerkingen.setMinHeight(100);
        opmerkingen.setWrapText(true);
        
        HBox pijlen = new HBox();
        pijlen.setSpacing(20);
        pijlen.setAlignment(Pos.CENTER);
        
        ImageView pijlLinksView = new ImageView("images/dashboard/dashboardPijlLinks.png");
        pijlLinksView.maxHeight(50);
        pijlLinksView.maxWidth(50);
        Button pijlLinks = new Button("", pijlLinksView);
        pijlLinks.setId("pijl");
        
        ImageView pijlRechtsView = new ImageView("images/dashboard/dashboardPijlRechts.png");
        pijlRechtsView.maxHeight(50);
        pijlRechtsView.maxWidth(50);
        Button pijlRechts = new Button("", pijlRechtsView);
        pijlRechts.setId("pijl");
        
        pijlen.getChildren().addAll(pijlLinks, pijlRechts);
        
        opmerkingenBox.getChildren().addAll(opmerkingenLbl, opmerkingenOnderwerp, opmerkingen, pijlen);
        
        pijlLinks.setOnAction(e -> {
            try {
                AttitudeOpmerking huidigeOpmerking = leerling.vorigeRecenteOpmerking();
                opmerkingenOnderwerp.setText(huidigeOpmerking.getNaam());
                opmerkingen.setText(huidigeOpmerking.getOpmerking());
            } catch (IndexOutOfBoundsException IOBE) {
                opmerkingenOnderwerp.setText("Geen opmerking");
                opmerkingen.setText("Er is geen vorige Opmerking");
            }
        });
        
        pijlRechts.setOnAction(e -> {
            try{
                AttitudeOpmerking huidigeOpmerking = leerling.volgendeRecenteOpmerking();
            opmerkingenOnderwerp.setText(huidigeOpmerking.getNaam());
            opmerkingen.setText(huidigeOpmerking.getOpmerking());
            }catch(IndexOutOfBoundsException IOBE){
                opmerkingenOnderwerp.setText("Geen opmerking");
                opmerkingen.setText("Er is geen volgende Opmerking");
            }
        });

        //Grafiek
        grafiekOuter.getChildren().addAll(minusBtn, grafiekInner, plusBtn);
        
        voortgang.setId("voortgangLbl");
        grafiekMetLbl.getChildren().addAll(grafiekOuter, voortgang);
        
        HBox hBoxOnder = new HBox();
        hBoxOnder.setId("hBoxOnder");
        hBoxOnder.getChildren().addAll(grafiekMetLbl, opmerkingenBox);

//        //rootDashboard
//        rootDashboard.getChildren().addAll(left, right);
//        
//        getChildren().add(rootDashboard);
        //HoofdGrid
        GridPane dashboardGrid = new GridPane();
        
        ColumnConstraints subCol0 = new ColumnConstraints();
        subCol0.setPercentWidth(100);
        subCol0.setHalignment(HPos.CENTER);
        
        RowConstraints subRow0 = new RowConstraints();
        subRow0.setPercentHeight(60);
        subRow0.setValignment(VPos.CENTER);
        RowConstraints subRow1 = new RowConstraints();
        subRow1.setPercentHeight(40);
        subRow1.setValignment(VPos.CENTER);
        
        dashboardGrid.getColumnConstraints().add(subCol0);
        dashboardGrid.getRowConstraints().addAll(subRow0, subRow1);
        
        dashboardGrid.add(dashboardGroup, 0, 0);
        dashboardGrid.add(hBoxOnder, 0, 1);
        dashboardGrid.setId("dashboardLeft");
        
        ColumnConstraints hoofdCol0 = new ColumnConstraints();
        hoofdCol0.setPercentWidth(80);
        hoofdCol0.setHalignment(HPos.CENTER);
        ColumnConstraints hoofdCol1 = new ColumnConstraints();
        hoofdCol1.setPercentWidth(20);
        hoofdCol1.setHalignment(HPos.CENTER);
        
        getColumnConstraints().addAll(hoofdCol0, hoofdCol1);
        
        RowConstraints hoofdRow0 = new RowConstraints();
        hoofdRow0.setPercentHeight(100);
        
        getRowConstraints().add(hoofdRow0);
        
        add(dashboardGrid, 0, 0);
        add(right, 1, 0);
        
        setGridLinesVisible(false);
        dashboardGrid.setGridLinesVisible(false);
        
    }
    
    public void setVoortgang() {
        if (evaGraf.getPositie() <= 9 && evaGraf.getPositie() >= 4) {
            evaGraf.setVoortgang("Klaar om met begeleider te oefenen");
            voortgang.setText(evaGraf.getVoortgang());
        }
        
        if (evaGraf.getPositie() <= 3 && evaGraf.getPositie() >= 1) {
            evaGraf.setVoortgang("Klaar om alleen te oefenen");
            voortgang.setText(evaGraf.getVoortgang());
        }
        
        if (evaGraf.getPositie() == 0) {
            evaGraf.setVoortgang("Klaar voor praktijk examen");
            voortgang.setText(evaGraf.getVoortgang());
        }
        
        if (evaGraf.getPositie() > 9) {
            evaGraf.setVoortgang("");
            voortgang.setText(evaGraf.getVoortgang());
        }
    }
    
    public Leerling getLeerling() {
        return leerling;
    }
    
    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
