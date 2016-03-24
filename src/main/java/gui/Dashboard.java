package gui;

import domein.DashboardDom;
import domein.EvaluatieGrafiek;
import domein.GezienNietGezien;
import javafx.animation.TranslateTransition;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
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

public class Dashboard extends GridPane {

    private Scene scene;
    private EvaluatieGrafiek evaGraf = new EvaluatieGrafiek();
    private DashboardDom dashboardDom = new DashboardDom();

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

    public Dashboard() {
        Menu menu = new Menu();

        HBox rootDashboard = new HBox();
        rootDashboard.setId("rootDashboard");

        //RIGHT
        VBox right = new VBox();
        //right.setId("dashboardRight");

        //MenuStandaard
        VBox menuStandaard = menu.buildMenuDashboard();
        menuStandaard.setId("dashboardRight");
        right.getChildren().add(menuStandaard);

        //Menu
        VBox menuBalk = menu.buildMenu();

        menu.getMenuKnop().setOnAction(e -> {
            menu.setScene(scene);
            right.getChildren().remove(menuStandaard);

            TranslateTransition tt = new TranslateTransition(Duration.millis(500), menuBalk);

            tt.setFromX(100.0 + menuBalk.getLayoutX());
            tt.setByX(-100);
            tt.setCycleCount(1);

            tt.play();

            right.getChildren().add(menuBalk);
        });

        menu.getMenuTerug().setOnAction(e -> {
            TranslateTransition tt = new TranslateTransition(Duration.millis(500), menuBalk);
            tt.setOnFinished(ev -> {
                right.getChildren().removeAll(menuBalk);
                right.getChildren().add(menuStandaard);
            });

            tt.setFromX(menuBalk.getLayoutX());
            tt.setByX(107);
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

        Image rijtechniek = new Image("images/rijtechniekWit.png");
        ImageView rijtechniekImageView = new ImageView(rijtechniek);
        rijtechniekImageView.setFitWidth(100);
        rijtechniekImageView.setFitHeight(100);
        Button rijtechniekBtn = new Button("", rijtechniekImageView);
        rijtechniekBtn.setId("groteBtnsDashboard");
        dashboard.add(rijtechniekBtn, 0, 0);

        rijtechniekBtn.setOnAction(e -> {
            Rijtechniek rijtechniekScherm = new Rijtechniek();
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
            Attitude attitude = new Attitude();
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
            VerkeersTechniek verkeersTechniek = new VerkeersTechniek();
            verkeersTechniek.setScene(scene);
            scene.setRoot(verkeersTechniek);
        });

        //hBox met icoontjes
        HBox icoontjes = new HBox();
        icoontjes.setId("icoontjesDashboard");

        HBox icoontjesLinks = new HBox();
        icoontjesLinks.setId("icoontjesLinks");

        Image bandenSpanningWit = new Image("images/bandenspanning.png");
        ImageView bandenSpanningImageView = new ImageView(bandenSpanningWit);
        bandenSpanningImageView.setFitWidth(25);
        bandenSpanningImageView.setFitHeight(25);
        Button bandenSpanningBtn = new Button("", bandenSpanningImageView);
        bandenSpanningBtn.setId("icoontjesBtns");

        Image bandenSpanningGroen = new Image("images/bandenspanningGroen.png");

        bandenSpanningBtn.setOnAction(e -> {
            if (dashboardDom.getBanden() == GezienNietGezien.NIETGEZIEN) {
                dashboardDom.setBanden(GezienNietGezien.GEZIEN);
                bandenSpanningImageView.setImage(bandenSpanningGroen);
            } else if (dashboardDom.getBanden() == GezienNietGezien.GEZIEN) {
                dashboardDom.setBanden(GezienNietGezien.NIETGEZIEN);
                bandenSpanningImageView.setImage(bandenSpanningWit);
            }
        });

        Image vloeistoffenWit = new Image("images/olieWit.png");
        ImageView vloeistoffenImageView = new ImageView(vloeistoffenWit);
        vloeistoffenImageView.setFitWidth(25);
        vloeistoffenImageView.setFitHeight(25);
        Button vloeistoffenBtn = new Button("", vloeistoffenImageView);
        vloeistoffenBtn.setId("icoontjesBtns");

        Image vloeistoffenGroen = new Image("images/olieGroen.png");

        vloeistoffenBtn.setOnAction(e -> {
            if (dashboardDom.getVloeistoffen() == GezienNietGezien.NIETGEZIEN) {
                dashboardDom.setVloeistoffen(GezienNietGezien.GEZIEN);
                vloeistoffenImageView.setImage(vloeistoffenGroen);
            } else if (dashboardDom.getVloeistoffen() == GezienNietGezien.GEZIEN) {
                dashboardDom.setVloeistoffen(GezienNietGezien.NIETGEZIEN);
                vloeistoffenImageView.setImage(vloeistoffenWit);
            }
        });

        Image schakelaarsWit = new Image("images/schakelaarsWit.png");
        ImageView schakelaarsImageView = new ImageView(schakelaarsWit);
        schakelaarsImageView.setFitWidth(25);
        schakelaarsImageView.setFitHeight(25);
        Button schakelaarsBtn = new Button("", schakelaarsImageView);
        schakelaarsBtn.setId("icoontjesBtns");

        Image schakelaarsGroen = new Image("images/schakelaarsGroen.png");

        schakelaarsBtn.setOnAction(e -> {
            if (dashboardDom.getSchakelaars() == GezienNietGezien.NIETGEZIEN) {
                dashboardDom.setSchakelaars(GezienNietGezien.GEZIEN);
                schakelaarsImageView.setImage(schakelaarsGroen);
            } else if (dashboardDom.getSchakelaars() == GezienNietGezien.GEZIEN) {
                dashboardDom.setSchakelaars(GezienNietGezien.NIETGEZIEN);
                schakelaarsImageView.setImage(schakelaarsWit);
            }
        });

        icoontjesLinks.getChildren().addAll(bandenSpanningBtn, vloeistoffenBtn, schakelaarsBtn);

        HBox icoontjesMidden = new HBox();
        icoontjesMidden.setId("icoontjesMidden");

        Image rotondeWit = new Image("images/rotondeWit.png");
        ImageView rotondeImageView = new ImageView(rotondeWit);
        rotondeImageView.setFitWidth(25);
        rotondeImageView.setFitHeight(25);
        Button rotondeBtn = new Button("", rotondeImageView);
        rotondeBtn.setId("icoontjesBtns");

        Image rotondeGroen = new Image("images/rotondeGroen.png");

        rotondeBtn.setOnAction(e -> {
            if (dashboardDom.getRotonde() == GezienNietGezien.NIETGEZIEN) {
                dashboardDom.setRotonde(GezienNietGezien.GEZIEN);
                rotondeImageView.setImage(rotondeGroen);
            } else if (dashboardDom.getRotonde() == GezienNietGezien.GEZIEN) {
                dashboardDom.setRotonde(GezienNietGezien.NIETGEZIEN);
                rotondeImageView.setImage(rotondeWit);
            }
        });

        Image rijbaanWit = new Image("images/rijbaanWit.png");
        ImageView rijbaanImageView = new ImageView(rijbaanWit);
        rijbaanImageView.setFitWidth(25);
        rijbaanImageView.setFitHeight(25);
        Button rijbaanBtn = new Button("", rijbaanImageView);
        rijbaanBtn.setId("icoontjesBtns");

        Image rijbaanGroen = new Image("images/rijbaanGroen.png");

        rijbaanBtn.setOnAction(e -> {
            if (dashboardDom.getRijbaan() == GezienNietGezien.NIETGEZIEN) {
                dashboardDom.setRijbaan(GezienNietGezien.GEZIEN);
                rijbaanImageView.setImage(rijbaanGroen);
            } else if (dashboardDom.getRijbaan() == GezienNietGezien.GEZIEN) {
                dashboardDom.setRijbaan(GezienNietGezien.NIETGEZIEN);
                rijbaanImageView.setImage(rijbaanWit);
            }
        });

        Image stadWit = new Image("images/stadWit.png");
        ImageView stadImageView = new ImageView(stadWit);
        stadImageView.setFitWidth(25);
        stadImageView.setFitHeight(25);
        Button stadBtn = new Button("", stadImageView);
        stadBtn.setId("icoontjesBtns");

        Image stadGroen = new Image("images/stadGroen.png");

        stadBtn.setOnAction(e -> {
            if (dashboardDom.getStad() == GezienNietGezien.NIETGEZIEN) {
                dashboardDom.setStad(GezienNietGezien.GEZIEN);
                stadImageView.setImage(stadGroen);
            } else if (dashboardDom.getStad() == GezienNietGezien.GEZIEN) {
                dashboardDom.setStad(GezienNietGezien.NIETGEZIEN);
                stadImageView.setImage(stadWit);
            }
        });

        Image autosnelwegWit = new Image("images/autosnelwegWit.png");
        ImageView autosnelwegImageView = new ImageView(autosnelwegWit);
        autosnelwegImageView.setFitWidth(25);
        autosnelwegImageView.setFitHeight(25);
        Button autosnelwegBtn = new Button("", autosnelwegImageView);
        autosnelwegBtn.setId("icoontjesBtns");

        Image autosnelwegGroen = new Image("images/autosnelwegGroen.png");

        autosnelwegBtn.setOnAction(e -> {
            if (dashboardDom.getAutosnelweg() == GezienNietGezien.NIETGEZIEN) {
                dashboardDom.setAutosnelweg(GezienNietGezien.GEZIEN);
                autosnelwegImageView.setImage(autosnelwegGroen);
            } else if (dashboardDom.getAutosnelweg() == GezienNietGezien.GEZIEN) {
                dashboardDom.setAutosnelweg(GezienNietGezien.NIETGEZIEN);
                autosnelwegImageView.setImage(autosnelwegWit);
            }
        });

        icoontjesMidden.getChildren().addAll(rotondeBtn, rijbaanBtn, stadBtn, autosnelwegBtn);

        HBox icoontjesRechts = new HBox();
        icoontjesRechts.setId("icoontjesRechts");

        Image tankenWit = new Image("images/tankenWit.png");
        ImageView tankenImageView = new ImageView(tankenWit);
        tankenImageView.setFitWidth(25);
        tankenImageView.setFitHeight(25);
        Button tankenBtn = new Button("", tankenImageView);
        tankenBtn.setId("icoontjesBtns");

        Image tankenGroen = new Image("images/tankenGroen.png");

        tankenBtn.setOnAction(e -> {
            if (dashboardDom.getTanken() == GezienNietGezien.NIETGEZIEN) {
                dashboardDom.setTanken(GezienNietGezien.GEZIEN);
                tankenImageView.setImage(tankenGroen);
            } else if (dashboardDom.getTanken() == GezienNietGezien.GEZIEN) {
                dashboardDom.setTanken(GezienNietGezien.NIETGEZIEN);
                tankenImageView.setImage(tankenWit);
            }
        });

        Image gpsWit = new Image("images/gpsWit.png");
        ImageView gpsImageView = new ImageView(gpsWit);
        gpsImageView.setFitWidth(25);
        gpsImageView.setFitHeight(25);
        Button gpsBtn = new Button("", gpsImageView);
        gpsBtn.setId("icoontjesBtns");

        Image gpsGroen = new Image("images/gpsGroen.png");

        gpsBtn.setOnAction(e -> {
            if (dashboardDom.getGps() == GezienNietGezien.NIETGEZIEN) {
                dashboardDom.setGps(GezienNietGezien.GEZIEN);
                gpsImageView.setImage(gpsGroen);
            } else if (dashboardDom.getGps() == GezienNietGezien.GEZIEN) {
                dashboardDom.setGps(GezienNietGezien.NIETGEZIEN);
                gpsImageView.setImage(gpsWit);
            }
        });

        Image noodstopWit = new Image("images/noodstopWit.png");
        ImageView stopImageView = new ImageView(noodstopWit);
        stopImageView.setFitWidth(25);
        stopImageView.setFitHeight(25);
        Button stopBtn = new Button("", stopImageView);
        stopBtn.setId("icoontjesBtns");

        Image noodstopGroen = new Image("images/noodstopGroen.png");

        stopBtn.setOnAction(e -> {
            if (dashboardDom.getStop() == GezienNietGezien.NIETGEZIEN) {
                dashboardDom.setStop(GezienNietGezien.GEZIEN);
                stopImageView.setImage(noodstopGroen);
            } else if (dashboardDom.getStop() == GezienNietGezien.GEZIEN) {
                dashboardDom.setStop(GezienNietGezien.NIETGEZIEN);
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

//    public void minEen() {
//        if (niveau != 11) {
//            Rectangle blokDelete = grafiek[niveau];
//            blokDelete.setFill(Color.BLACK);
//            grafiek[niveau] = blokDelete;
//            
//            niveau++;
//            Rectangle blokAdd = grafiek[niveau];
//            blokAdd.setFill(Color.BLUE);
//            grafiek[niveau] = blokAdd;
//        }
//    }
//    public void plusEen() {
//        if (niveau != 0) {
//            niveau--;
//            Rectangle blokAdd = grafiek[niveau];
//            blokAdd.setFill(Color.BLUE);
//            grafiek[niveau] = blokAdd;
//        }
//    }
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
        Label opmerkingen = new Label("OPMERKINGEN:");
        opmerkingen.setId("OpmerkingLabel");
        TextField opmerkingField = new TextField();
        opmerkingField.setId("OpmerkingVeld");
        opmerkingField.setEditable(false);

        opmerkingenBox.getChildren().addAll(opmerkingen, opmerkingField);

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
        subRow0.setPercentHeight(70);
        subRow0.setValignment(VPos.CENTER);
        RowConstraints subRow1 = new RowConstraints();
        subRow1.setPercentHeight(30);
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
        if (evaGraf.getPositie() >= 3 && evaGraf.getPositie() <= 8) {
            evaGraf.setVoortgang("Klaar om met begeleider te oefenen");
            voortgang.setText(evaGraf.getVoortgang());
        }

        if (evaGraf.getPositie() >= 9 && evaGraf.getPositie() <= 10) {
            evaGraf.setVoortgang("Klaar om alleen te oefenen");
            voortgang.setText(evaGraf.getVoortgang());
        }

        if (evaGraf.getPositie() == 0) {
            evaGraf.setVoortgang("Klaar voor praktijk examen");
            voortgang.setText(evaGraf.getVoortgang());
        }

        if (evaGraf.getPositie() < 3) {
            voortgang.setText("");
        }
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
