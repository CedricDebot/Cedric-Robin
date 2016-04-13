/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.Leerling;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Robin
 */
public class Menu {

    private Rijtechniek rijtechniek;
    private VerkeersTechniek verkeerstechniek;
    private Attitude attitude;
    private Dashboard dashboard;

    private Scene scene;

    private Button menuTerug;
    private Button menuKnop;
    private Button dashboardTerug;

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

    public VBox buildMenu(Dashboard dashboard, int klasse) {

        VBox menuBalk = new VBox();
        menuBalk.setId("menuBox");

        Image attitudeImageM = new Image("images/menuAttitude.PNG");
        ImageView attitudeImageViewM = new ImageView(attitudeImageM);
        attitudeImageViewM.setFitWidth(100);
        attitudeImageViewM.setFitHeight(50);
        Button attitude = new Button("", attitudeImageViewM);
        attitude.setId("menuButton");

        attitude.setOnAction(e -> {
            Attitude attitudeScherm = new Attitude(dashboard);
            attitudeScherm.setScene(scene);
            scene.setRoot(attitudeScherm);
        });

        Image rijImageM = new Image("images/menuRijtechniek.PNG");
        ImageView rijImageViewM = new ImageView(rijImageM);
        rijImageViewM.setFitWidth(100);
        rijImageViewM.setFitHeight(50);
        Button rijTechniek = new Button("", rijImageViewM);
        rijTechniek.setId("menuButton");

        rijTechniek.setOnAction(e -> {
            Rijtechniek rijtechniekScherm = new Rijtechniek(dashboard);
            rijtechniekScherm.setScene(scene);
            scene.setRoot(rijtechniekScherm);
        });

        Image verkeersImageM = new Image("images/menuVerkeerstechniek.PNG");
        ImageView verkeersImageViewM = new ImageView(verkeersImageM);
        verkeersImageViewM.setFitWidth(100);
        verkeersImageViewM.setFitHeight(50);
        Button verkeersTechniek = new Button("", verkeersImageViewM);
        verkeersTechniek.setId("menuButton");

        verkeersTechniek.setOnAction(e -> {
            VerkeersTechniek verkeersTechniekScherm = new VerkeersTechniek(dashboard);
            verkeersTechniekScherm.setScene(scene);
            scene.setRoot(verkeersTechniekScherm);
        });

        Image menuTerugImageM = new Image("images/dashboardTerug.PNG");
        ImageView menuTerugImageViewM = new ImageView(menuTerugImageM);
        menuTerugImageViewM.setFitWidth(100);
        menuTerugImageViewM.setFitHeight(50);
        menuTerug = new Button("", menuTerugImageViewM);
        menuTerug.setId("menuButton");
        
        if (klasse == 1) {
            menuBalk.getChildren().addAll(attitude, rijTechniek, verkeersTechniek, menuTerug);
        }
        if (klasse == 2 ) {
            menuBalk.getChildren().addAll(attitude, verkeersTechniek, menuTerug);
        }

        if (klasse == 3) {
            menuBalk.getChildren().addAll(rijTechniek, verkeersTechniek, menuTerug);
        }

        if (klasse == 4) {
            menuBalk.getChildren().addAll(attitude, rijTechniek, menuTerug);
        }
        return menuBalk;
    }

    public VBox buildMenuDashboard(Leerling leerling) {
        VBox menuDashboard = new VBox();
        menuDashboard.setId("menuTest");

        //MenuKnoppenDashboard
        VBox menuKnoppenDashboard = new VBox();
        menuKnoppenDashboard.setId("menuKnoppen");
        Image dashboardMenuImage = new Image("images/MenuKnop.png");
        ImageView dashboardMenuImageView = new ImageView(dashboardMenuImage);
        dashboardMenuImageView.setFitWidth(60);
        dashboardMenuImageView.setFitHeight(50);
        menuKnop = new Button("", dashboardMenuImageView);
        menuKnop.setId("menuButton");

        Image dashboardTerugImage = new Image("images/dashboardTerug.PNG");
        ImageView dashboardTerugImageView = new ImageView(dashboardTerugImage);
        dashboardTerugImageView.setFitWidth(60);
        dashboardTerugImageView.setFitHeight(50);
        dashboardTerug = new Button("", dashboardTerugImageView);
        dashboardTerug.setId("menuButton");

        menuKnoppenDashboard.getChildren().addAll(menuKnop, dashboardTerug);

        menuDashboard.getChildren().addAll(InfoLeerling(leerling), EvaluatieMoment(), menuKnoppenDashboard);

        return menuDashboard;
    }

    public VBox buildMenuStandaard(Leerling leerling) {

        VBox menuStandaard = new VBox();
        menuStandaard.setId("menuStandaard");

        VBox menuKnoppen = new VBox();
        menuKnoppen.setId("menuKnoppen");

        Image menuTerugImage = new Image("images/menuArrowLeft.png");
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

        Image fotoLeerling = leerling.getFoto();
        ImageView leerlingImageView = new ImageView(fotoLeerling);
        leerlingImageView.setId("leerlingImageView");

        leerlingImageView.setFitWidth(130);
        leerlingImageView.setFitHeight(150);

        Label naamLeerling = new Label(leerling.getVoorNaam());
        naamLeerling.setId("lblNaamLeerling");

        //Inner border
        HBox hBox_inner = new HBox();

        //Outter border
        HBox hBox_outter = new HBox();
        hBox_outter.setId("hBox_outterImage");

        hBox_inner.getChildren().add(leerlingImageView);
        hBox_outter.getChildren().add(hBox_inner);

        infoLeerling.getChildren().addAll(hBox_outter, naamLeerling);

        return infoLeerling;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
