package gui;

import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

public class Synchroniseer extends GridPane {

    private Scene scene;

    private ListView lijstleerlingenDB = new ListView();
    private ListView lijstleerlingenApp = new ListView();

    public Synchroniseer() {
        //setGridLinesVisible(true);
        setHgap(50);

        ColumnConstraints col0 = new ColumnConstraints();
        col0.setPercentWidth(40);
        col0.setHalignment(HPos.CENTER);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(15);
        col1.setHalignment(HPos.CENTER);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(40);
        col2.setHalignment(HPos.CENTER);
        
        getColumnConstraints().addAll(col0, col1, col2);
        
        RowConstraints row0 = new RowConstraints();
        row0.setPercentHeight(60);
        
        getRowConstraints().addAll(row0);

        add(left(), 0, 0);
        add(center(), 1, 0);
        add(right(), 2, 0);

    }

    public VBox left() {
        VBox left = new VBox();
        left.setId("syncLeft");
        
        VBox lijstleerlingenDBWithLabel = new VBox();
        lijstleerlingenDBWithLabel.setId("syncLijst");
        Label lijstleerlingenDBTitle = new Label("Leerlingen in de databank");
        lijstleerlingenDBTitle.setId("listViewTitle");

        lijstleerlingenDBWithLabel.getChildren().addAll(lijstleerlingenDBTitle, lijstleerlingenDB);

        TextField zoekenTF = new TextField();
        zoekenTF.setId("syncTextField");
        zoekenTF.setPromptText("zoeken...");

        left.getChildren().addAll(lijstleerlingenDBWithLabel, zoekenTF);

        return left;
    }

    public VBox right() {
        VBox right = new VBox();
        right.setId("syncRight");
        
        VBox lijstleerlingenAppWithLabel = new VBox();
        lijstleerlingenAppWithLabel.setId("syncLijst");
        Label lijstleerlingenAppTitle = new Label("Leerlingen lokaal opgeslagen");
        lijstleerlingenAppTitle.setId("listViewTitle");

        lijstleerlingenAppWithLabel.getChildren().addAll(lijstleerlingenAppTitle, lijstleerlingenApp);

        TextField zoekenTF = new TextField();
        zoekenTF.setId("syncTextField");
        zoekenTF.setPromptText("zoeken...");

        right.getChildren().addAll(lijstleerlingenAppWithLabel, zoekenTF);

        return right;
    }

    public VBox center() {
        VBox center = new VBox();
        center.setId("syncCenter");
        
        VBox arrowsVBox = new VBox();
        arrowsVBox.setId("arrowsVBox");
        
        Image rightArrow = new Image("images/arrow-right.png");
        ImageView rightArrowImageView = new ImageView(rightArrow);
        rightArrowImageView.setFitWidth(100);
        rightArrowImageView.setFitHeight(50);
        Button rightBtn = new Button("", rightArrowImageView);
        rightBtn.setId("menuButton");
        
        Image leftArrow = new Image("images/arrow-left.png");
        ImageView leftArrowImageView = new ImageView(leftArrow);
        leftArrowImageView.setFitWidth(100);
        leftArrowImageView.setFitHeight(50);
        Button leftBtn = new Button("", leftArrowImageView);
        leftBtn.setId("menuButton");
        
        arrowsVBox.getChildren().addAll(rightBtn, leftBtn);
        
        Button bevestigBtn = new Button("Bevestig");
        bevestigBtn.setId("btnSync");
        
        bevestigBtn.setOnAction(e -> {
            Beginscherm beginscherm = new Beginscherm();
            beginscherm.setScene(scene);
            scene.setRoot(beginscherm);
        });
        
        
        center.getChildren().addAll(arrowsVBox, bevestigBtn);
        
        return center;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

}
