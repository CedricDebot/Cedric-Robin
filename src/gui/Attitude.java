/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 *
 * @author Robin Lanneer
 */
public class Attitude extends GridPane{

    private Scene scene;
    
    public Attitude() {
        
        //HoofdGrid
         gridLinesVisibleProperty().set(true);
         ColumnConstraints col0 = new ColumnConstraints();
         col0.setPercentWidth(40);
         
         ColumnConstraints col1 = new ColumnConstraints();
         col1.setPercentWidth(40);
         col1.setHalignment(HPos.CENTER);
         
         ColumnConstraints col2 = new ColumnConstraints();
         col2.setPercentWidth(20);
         
         getColumnConstraints().addAll(col0, col1, col2);
            
         RowConstraints row1 = new RowConstraints();
         row1.setPercentHeight(100);
         
         getRowConstraints().addAll(row1);
         
         //OpmerkingPane
         GridPane OpmerkingenPane = new GridPane();
         OpmerkingenPane.gridLinesVisibleProperty().set(false);
         ColumnConstraints col0OpmerkingPane = new ColumnConstraints();
         col0OpmerkingPane.setPercentWidth(100);
         col0OpmerkingPane.setHalignment(HPos.CENTER);
         RowConstraints row0AttitudeLogo = new RowConstraints();
         row0AttitudeLogo.setPercentHeight(45);
         
         RowConstraints row1Label = new RowConstraints();
         row1Label.setPercentHeight(10);
         
         RowConstraints row2Text = new RowConstraints();
         row2Text.setPercentHeight(45);
         row2Text.setValignment(VPos.TOP);
         
         OpmerkingenPane.getColumnConstraints().add(col0OpmerkingPane);
         OpmerkingenPane.getRowConstraints().addAll(row0AttitudeLogo,row1Label,row2Text);
         
         Image attitude = new Image("images/attitude-placeholder.png");
         ImageView attitudeView = new ImageView(attitude);
         attitudeView.setId("AttitudeImage");
         OpmerkingenPane.add(attitudeView,0 , 0);
         
         Label opmerking = new Label("Opmerking");
         opmerking.setId("OpmerkingLabel");
         OpmerkingenPane.add(opmerking,0 , 1);
         
         TextArea opmerkingVeld = new TextArea();
         opmerkingVeld.setId("OpmerkingenVeld");
         OpmerkingenPane.add(opmerkingVeld, 0, 2);
         
         
         
         //listview
         ListView opmerkingenList = new ListView();
         opmerkingenList.setId("OpmeringenList");
         ObservableList<String> standaarOpmerkingen = 
                 FXCollections.observableArrayList("Zenuwachtig",
                         "Concentratie", "Schrik", "Asociaal","Verkeersgevaarlijk",
                         "Ongeduldig", "Agressief rijgedrag", "Inzet", "Verstrooid",
                         "Eigenwijs");
         opmerkingenList.setItems(standaarOpmerkingen);
         
         Button voegToe = new Button("Voeg Toe");
         TextField nieuw = new TextField();
         HBox nieuwHB = new HBox();
         nieuwHB.setId("nieuwHB");
         nieuwHB.getChildren().addAll(nieuw, voegToe);
         
         voegToe.setId("attitudeVoegToe");
         VBox attitudeList = new VBox();
         attitudeList.setId("attitudeList");
         
         attitudeList.getChildren().addAll(opmerkingenList, nieuwHB);
         
         
         //Menu
        Menu menu = new Menu();
        //RIGHT
        VBox right = new VBox();
        //MenuStandaard
        VBox menuStandaard = menu.buildMenuStandaard();
        menuStandaard.setId("menuRight");
        right.getChildren().add(menuStandaard);
        
        
        //Menu
        VBox menuBalk = menu.buildMenu();
        
        menu.getMenuKnop().setOnAction(e -> {
            right.getChildren().remove(menuStandaard);        
                       
            TranslateTransition tt = new TranslateTransition(Duration.millis(500), menuBalk);
            
            tt.setFromX(100.0 + menuBalk.getLayoutX());
            tt.setByX(-90);
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
            tt.setByX(120);
            tt.setCycleCount(1);
            
            tt.play();
            tt.onFinishedProperty();
            
        });
        
        
         add(OpmerkingenPane,0,0);
         add(attitudeList, 1, 0);
         add(right, 2 , 0);
         
         voegToe.setOnAction(e ->{
             standaarOpmerkingen.add(nieuw.getText());
             nieuw.clear();
         });
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
