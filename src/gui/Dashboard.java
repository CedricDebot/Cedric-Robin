package gui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

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

        //RIGHT
        VBox right = new VBox();
        right.setId("dashboardRight");

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
        right.getChildren().addAll(hBox_outter, naamLeerling, evaluatieMoment, menuKnoppen);
        
        //Menu
        VBox menu = new VBox();
        menu.setId("menuBox");
        
        Image attitudeImage = new Image("images/menuAttitude.PNG");
        ImageView attitudeImageView = new ImageView(attitudeImage);
        attitudeImageView.setFitWidth(100);
        attitudeImageView.setFitHeight(50);
        Button attitude = new Button("", attitudeImageView);
        attitude.setId("menuButton");
        
        Image rijImage = new Image("images/menuRijtechniek.PNG");
        ImageView rijImageView = new ImageView(rijImage);
        rijImageView.setFitWidth(100);
        rijImageView.setFitHeight(50);
        Button rijTechniek = new Button("", rijImageView);
        rijTechniek.setId("menuButton");
        
        Image verkeersImage = new Image("images/menuVerkeerstechniek.PNG");
        ImageView verkeersImageView = new ImageView(verkeersImage);
        verkeersImageView.setFitWidth(100);
        verkeersImageView.setFitHeight(50);
        Button verkeersTechniek = new Button("", verkeersImageView);
        verkeersTechniek.setId("menuButton");
        
        Image menuTerugImage = new Image("images/dashboardTerug.PNG");
        ImageView menuTerugImageView = new ImageView(menuTerugImage);
        menuTerugImageView.setFitWidth(100);
        menuTerugImageView.setFitHeight(50);
        Button menuTerug = new Button("", menuTerugImageView);
        menuTerug.setId("menuButton");
        
        menu.getChildren().addAll(attitude, rijTechniek, verkeersTechniek, menuTerug);
        
        dashboardMenu.setOnAction(e ->{
            right.getChildren().removeAll(hBox_outter, naamLeerling, evaluatieMoment,menuKnoppen);
            right.getChildren().addAll(menu);
        });
        menuTerug.setOnAction(e ->{
            right.getChildren().removeAll(menu);
            right.getChildren().addAll(hBox_outter, naamLeerling, evaluatieMoment,menuKnoppen);
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
        grafiekOuter.getChildren().addAll(minusBtn, grafiekInner, plusBtn);

        voortgang.setId("voortgangLbl");
        grafiekMetLbl.getChildren().addAll(grafiekOuter, voortgang);

        left.getChildren().addAll(grafiekMetLbl);

        //rootDashboard
        rootDashboard.getChildren().addAll(left, right);

        getChildren().add(rootDashboard);

    }

    public void plusEen()
    {
        if (niveau != 0) {
            Rectangle blokDelete = grafiek[niveau];
            blokDelete.setFill(Color.BLACK);
            grafiek[niveau] = blokDelete;

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
    }
}
