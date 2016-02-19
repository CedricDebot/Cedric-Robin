package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Dashboard extends HBox {

    public Dashboard() {

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

        right.getChildren().addAll(hBox_outter, naamLeerling, evaluatieMoment);

        //rootDashboard
        rootDashboard.getChildren().addAll(right);

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

        getChildren().add(rootDashboard);

    }
}
