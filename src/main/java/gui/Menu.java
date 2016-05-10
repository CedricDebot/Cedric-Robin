package gui;

import domein.DomeinController;
import domein.Leerling;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Menu {

    private DomeinController controller;

    private Scene scene;

    private Button menuTerug;
    private Button menuKnop;
    private Button dashboardTerug;
    private Button vorigScherm;

    private Button moment1;
    private Button moment2;
    private Button moment3;

    public Button getMenuTerug() {
        return menuTerug;
    }

    public Button getMenuKnop() {
        return menuKnop;
    }

    public Button getDashboardTerug() {
        return dashboardTerug;
    }

    public Button getMoment1() {
        return moment1;
    }

    public Button getMoment2() {
        return moment2;
    }

    public Button getMoment3() {
        return moment3;
    }

    public Button getVorigScherm() {
        return vorigScherm;
    }

    public VBox buildMenu(DomeinController controller, int klasse) {
        this.controller = controller;

        VBox menuBalk = new VBox();
        menuBalk.setId("menuBox");

        Image attitudeImageM = new Image("images/Attitude2.png");
        ImageView attitudeImageViewM = new ImageView(attitudeImageM);
        attitudeImageViewM.setFitWidth(70);
        attitudeImageViewM.setFitHeight(50);
        Button attitude = new Button("", attitudeImageViewM);
        attitude.setId("menuButton");

        attitude.setOnAction(e -> {
            Attitude attitudeScherm = new Attitude(controller);
            attitudeScherm.setScene(scene);
            scene.setRoot(attitudeScherm);
        });

        Image rijImageM = new Image("images/rijtechniekIcoon/stuurWit.png");
        ImageView rijImageViewM = new ImageView(rijImageM);
        rijImageViewM.setFitWidth(70);
        rijImageViewM.setFitHeight(50);
        Button rijTechniek = new Button("", rijImageViewM);
        rijTechniek.setId("menuButton");

        rijTechniek.setOnAction(e -> {
            controller.getDashboard().knopRijtechniek();
            Rijtechniek rijtechniekScherm = new Rijtechniek(controller);
            rijtechniekScherm.setScene(scene);
            scene.setRoot(rijtechniekScherm);
        });

        Image verkeersImageM = new Image("images/rotonde.png");
        ImageView verkeersImageViewM = new ImageView(verkeersImageM);
        verkeersImageViewM.setFitWidth(70);
        verkeersImageViewM.setFitHeight(50);
        Button verkeersTechniek = new Button("", verkeersImageViewM);
        verkeersTechniek.setId("menuButton");

        verkeersTechniek.setOnAction(e -> {
            controller.getDashboard().knopVerkeerstechniek();
            VerkeersTechniek verkeersTechniekScherm = new VerkeersTechniek(controller);
            verkeersTechniekScherm.setScene(scene);
            scene.setRoot(verkeersTechniekScherm);
        });

        VBox terugKnoppen = new VBox();

        Image menuTerugImageM = new Image("images/menusluiten.png");
        ImageView menuTerugImageViewM = new ImageView(menuTerugImageM);
        menuTerugImageViewM.setFitWidth(70);
        menuTerugImageViewM.setFitHeight(50);
        menuTerug = new Button("", menuTerugImageViewM);
        menuTerug.setId("menuButton");

        Image vorigSchermI = new Image("images/dashboardTerug2.png");
        ImageView vorigSchermIV = new ImageView(vorigSchermI);
        vorigSchermIV.setFitWidth(70);
        vorigSchermIV.setFitHeight(50);
        vorigScherm = new Button("", vorigSchermIV);
        vorigScherm.setId("menuButton");

        terugKnoppen.getChildren().addAll(vorigScherm, menuTerug);
        terugKnoppen.setSpacing(90);
        terugKnoppen.setAlignment(Pos.CENTER);

        if (klasse == 1) {
            menuBalk.getChildren().addAll(attitude, rijTechniek, verkeersTechniek, terugKnoppen);
        }
        if (klasse == 2) {
            menuBalk.getChildren().addAll(attitude, verkeersTechniek, terugKnoppen);
        }

        if (klasse == 3) {
            menuBalk.getChildren().addAll(rijTechniek, verkeersTechniek, terugKnoppen);
        }

        if (klasse == 4) {
            menuBalk.getChildren().addAll(attitude, rijTechniek, terugKnoppen);
        }
        return menuBalk;
    }

    private VBox menuDashboard;
    private Label zekerheidLbl;
    private VBox waarschuwingsBox;
    private Button ja;
    private Button nee;

    public VBox buildMenuDashboard(Leerling leerling) {
        menuDashboard = new VBox();
        menuDashboard.setId("menuDashboard");

        //MenuKnoppenDashboard
        VBox menuKnoppenDashboard = new VBox();
        menuKnoppenDashboard.setId("menuKnoppen");
        Image dashboardMenuImage = new Image("images/MenuKnop.png");
        ImageView dashboardMenuImageView = new ImageView(dashboardMenuImage);
        dashboardMenuImageView.setFitWidth(60);
        dashboardMenuImageView.setFitHeight(50);
        menuKnop = new Button("", dashboardMenuImageView);
        menuKnop.setId("menuButton");

        Image dashboardTerugImage = new Image("images/Home.png");
        ImageView dashboardTerugImageView = new ImageView(dashboardTerugImage);
        dashboardTerugImageView.setFitWidth(60);
        dashboardTerugImageView.setFitHeight(50);
        dashboardTerug = new Button("", dashboardTerugImageView);
        dashboardTerug.setId("menuButton");

        menuKnoppenDashboard.getChildren().addAll(menuKnop, dashboardTerug);

        waarschuwingsBox = new VBox();
        waarschuwingsBox.setId("waarschuwingsBox");

        zekerheidLbl = new Label("");
        zekerheidLbl.setWrapText(true);

        HBox knoppen = new HBox();
        knoppen.setId("waarschuwingKnoppen");
        ja = new Button("Ja");
        ja.setId("waarschuwingsknop");
        nee = new Button("Nee");
        nee.setId("waarschuwingsknop");
        knoppen.getChildren().addAll(ja, nee);

        waarschuwingsBox.getChildren().addAll(zekerheidLbl, knoppen);

        menuDashboard.getChildren().addAll(InfoLeerling(leerling), EvaluatieMoment(), waarschuwingsBox, menuKnoppenDashboard);
        waarschuwingsBox.setVisible(false);

        return menuDashboard;
    }

    public VBox buildMenuStandaard(Leerling leerling) {

        VBox menuStandaard = new VBox();
        menuStandaard.setId("menuStandaard");

        VBox menuKnoppen = new VBox();
        menuKnoppen.setId("menuKnoppen");

        Image menuTerugImage = new Image("images/arrow-left.png");
        ImageView menuTerugImageView = new ImageView(menuTerugImage);
        menuTerugImageView.setFitWidth(60);
        menuTerugImageView.setFitHeight(50);
        menuTerug = new Button("", menuTerugImageView);
        menuTerug.setId("menuButton");

        Image dashboardMenuImage = new Image("images/MenuKnop.png");
        ImageView dashboardMenuImageView = new ImageView(dashboardMenuImage);
        dashboardMenuImageView.setFitWidth(60);
        dashboardMenuImageView.setFitHeight(50);
        menuKnop = new Button("", dashboardMenuImageView);
        menuKnop.setId("menuButton");

        menuKnoppen.getChildren().addAll(menuKnop);

        menuStandaard.getChildren().addAll(InfoLeerling(leerling), menuKnoppen);

        return menuStandaard;
    }

    public VBox EvaluatieMoment() {

        //EvaluatieMoment
        VBox evaluatieMoment = new VBox();
        evaluatieMoment.setId("evaluatieMoment");

        Label evaTitel = new Label("Evaluatie Moment");
        evaTitel.setId("evaTitel");

        HBox momenten = new HBox();
        momenten.setId("momenten");
        moment1 = new Button(" ");
        moment1.setId("momentKnop");
        moment2 = new Button(" ");
        moment2.setId("momentKnop");
        moment3 = new Button(" ");
        moment3.setId("momentKnop");
        momenten.getChildren().addAll(moment1, moment2, moment3);
        evaluatieMoment.getChildren().addAll(evaTitel, momenten);

        return evaluatieMoment;
    }

    public VBox InfoLeerling(Leerling leerling) {
        VBox infoLeerling = new VBox();
        infoLeerling.setId("infoLeerling");

//        Image fotoLeerling = leerling.getFoto();
//        ImageView leerlingImageView = new ImageView(fotoLeerling);
//        leerlingImageView.setId("leerlingImageView");
//
//        leerlingImageView.setFitWidth(130);
//        leerlingImageView.setFitHeight(150);
        Label naamLeerling = new Label(leerling.getVoorNaam() + " " + leerling.getFamillieNaam());
        naamLeerling.setId("lblNaamLeerling");

        //Inner border
        HBox hBox_inner = new HBox();

        //Outter border
        HBox hBox_outter = new HBox();
//        hBox_outter.setId("hBox_outterImage");

//        hBox_inner.getChildren().add(leerlingImageView);
        hBox_outter.getChildren().add(hBox_inner);

        infoLeerling.getChildren().addAll(hBox_outter, naamLeerling);

        return infoLeerling;
    }

    public void waarschuwing(int moment) {
        zekerheidLbl.setText("Weet je zeker dat je evaluatiemoment" + " " + moment + " " + "wilt starten");
        waarschuwingsBox.setVisible(true);

        switch (moment) {
            case 1:
                ja.setOnAction(e -> {
                    controller.setEva1();
                    getMoment1().setText("1");
                    waarschuwingsBox.setVisible(false);
                }); nee.setOnAction(e -> {
                    waarschuwingsBox.setVisible(false);
                }); break;
            case 2:
                ja.setOnAction(e -> {
                    controller.setEva2();
                    getMoment2().setText("2");
                    waarschuwingsBox.setVisible(false);
                }); nee.setOnAction(e -> {
                    waarschuwingsBox.setVisible(false);
                }); break;
            default:
                ja.setOnAction(e -> {
                    controller.setEva3();
                    getMoment3().setText("3");
                    waarschuwingsBox.setVisible(false);
                }); nee.setOnAction(e -> {
                    waarschuwingsBox.setVisible(false);
                }); break;
        }

    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
