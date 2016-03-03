package gui;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;

public class Rijtechniek extends HBox {

    public Rijtechniek() {
        GridPane grid = new GridPane();
//        grid.setGridLinesVisible(true);
        
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

        Image stuur = new Image("images/stuur.png");
        ImageView stuurImageView = new ImageView(stuur);
        stuurImageView.setFitWidth(50);
        stuurImageView.setFitHeight(50);
        Button stuurBtn = new Button("", stuurImageView);
        stuurBtn.setId("icoontjesBtns");
        grid.add(stuurBtn, 3, 0);

        Image schakelen = new Image("images/schakelen.png");
        ImageView schakelenImageView = new ImageView(schakelen);
        schakelenImageView.setFitWidth(50);
        schakelenImageView.setFitHeight(50);
        Button schakelenBtn = new Button("", schakelenImageView);
        schakelenBtn.setId("icoontjesBtns");
        grid.add(schakelenBtn, 4, 1);

        Image kijken = new Image("images/kijken.png");
        ImageView kijkenImageView = new ImageView(kijken);
        kijkenImageView.setFitWidth(50);
        kijkenImageView.setFitHeight(50);
        Button kijkenBtn = new Button("", kijkenImageView);
        kijkenBtn.setId("icoontjesBtns");
        grid.add(kijkenBtn, 5, 2);

        Image parkeren = new Image("images/Parkeren.png");
        ImageView parkerenImageView = new ImageView(parkeren);
        parkerenImageView.setFitWidth(50);
        parkerenImageView.setFitHeight(50);
        Button parkerenBtn = new Button("", parkerenImageView);
        parkerenBtn.setId("icoontjesBtns");
        grid.add(parkerenBtn, 5, 3);

        Image keren = new Image("images/keren.png");
        ImageView kerenImageView = new ImageView(keren);
        kerenImageView.setFitWidth(50);
        kerenImageView.setFitHeight(50);
        Button kerenBtn = new Button("", kerenImageView);
        kerenBtn.setId("icoontjesBtns");
        grid.add(kerenBtn, 4, 4);

        Image garage = new Image("images/garage.png");
        ImageView garageImageView = new ImageView(garage);
        garageImageView.setFitWidth(50);
        garageImageView.setFitHeight(50);
        Button garageBtn = new Button("", garageImageView);
        garageBtn.setId("icoontjesBtns");
        grid.add(garageBtn, 3, 5);

        Image achteruit = new Image("images/achteruit.png");
        ImageView achteruitImageView = new ImageView(achteruit);
        achteruitImageView.setFitWidth(50);
        achteruitImageView.setFitHeight(50);
        Button achteruitBtn = new Button("", achteruitImageView);
        achteruitBtn.setId("icoontjesBtns");
        grid.add(achteruitBtn, 2, 5);

        Image acht = new Image("images/acht.png");
        ImageView achtImageView = new ImageView(acht);
        achtImageView.setFitWidth(50);
        achtImageView.setFitHeight(50);
        Button achtBtn = new Button("", achtImageView);
        achtBtn.setId("icoontjesBtns");
        grid.add(achtBtn, 1, 4);

        Image bergop = new Image("images/bergop.png");
        ImageView bergopImageView = new ImageView(bergop);
        bergopImageView.setFitWidth(50);
        bergopImageView.setFitHeight(50);
        Button bergopBtn = new Button("", bergopImageView);
        bergopBtn.setId("icoontjesBtns");
        grid.add(bergopBtn, 0, 3);

        Image zithouding = new Image("images/zithouding.png");
        ImageView zithoudingImageView = new ImageView(zithouding);
        zithoudingImageView.setFitWidth(50);
        zithoudingImageView.setFitHeight(50);
        Button zithoudingBtn = new Button("", zithoudingImageView);
        zithoudingBtn.setId("icoontjesBtns");
        grid.add(zithoudingBtn, 0, 2);

        Image remtechniek = new Image("images/remtechniek.png");
        ImageView remtechniekImageView = new ImageView(remtechniek);
        remtechniekImageView.setFitWidth(50);
        remtechniekImageView.setFitHeight(50);
        Button remtechniekBtn = new Button("", remtechniekImageView);
        remtechniekBtn.setId("icoontjesBtns");
        grid.add(remtechniekBtn, 1, 1);

        Image embrayage = new Image("images/embrayage.png");
        ImageView embrayageImageView = new ImageView(embrayage);
        embrayageImageView.setFitWidth(50);
        embrayageImageView.setFitHeight(50);
        Button embrayageBtn = new Button("", embrayageImageView);
        embrayageBtn.setId("icoontjesBtns");
        grid.add(embrayageBtn, 2, 0);

        Image middenGrid = new Image("images/icoon-rijtechniek.png");
        ImageView middenGridImageView = new ImageView(middenGrid);
        middenGridImageView.setFitWidth(150);
        middenGridImageView.setFitHeight(150);
        grid.add(middenGridImageView, 2, 2, 2, 2);
        
        Image cirkel = new Image("images/cirkel.png");
        ImageView cirkelImageView = new ImageView(cirkel);
        cirkelImageView.setFitWidth(600);
        cirkelImageView.setFitHeight(600);
        //cirkelImageView.setBlendMode(BlendMode.ADD);

        grid.setBlendMode(BlendMode.ADD);

        Group evaluatieGroup = new Group();
        evaluatieGroup.setId("evaluatieGroup");
        evaluatieGroup.getChildren().add(cirkelImageView);
        evaluatieGroup.getChildren().add(grid);

        getChildren().addAll(evaluatieGroup);
    }

}
