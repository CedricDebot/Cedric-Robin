package gui;

import javafx.animation.TranslateTransition;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

/**
 *
 * @author Robin
 */
public class VerkeersTechniek extends HBox {

    private Scene scene;

    public VerkeersTechniek() {
        setId("rijtechniekHBox");
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(false);

        ColumnConstraints col0 = new ColumnConstraints(100);
        col0.setHalignment(HPos.RIGHT);
        ColumnConstraints col1 = new ColumnConstraints(100);
        col1.setHalignment(HPos.LEFT);
        ColumnConstraints col2 = new ColumnConstraints(100);
        col2.setHalignment(HPos.CENTER);
        ColumnConstraints col3 = new ColumnConstraints(100);
        col3.setHalignment(HPos.RIGHT);
        ColumnConstraints col4 = new ColumnConstraints(100);
        col4.setHalignment(HPos.RIGHT);
        ColumnConstraints col5 = new ColumnConstraints(100);
        col5.setHalignment(HPos.LEFT);

        grid.getColumnConstraints().addAll(col0, col1, col2, col3, col4, col5);

        RowConstraints row0 = new RowConstraints(100);
        row0.setValignment(VPos.BOTTOM);
        RowConstraints row1 = new RowConstraints(100);
        row1.setValignment(VPos.TOP);
        RowConstraints row2 = new RowConstraints(100);
        row2.setValignment(VPos.CENTER);
        RowConstraints row3 = new RowConstraints(100);
        row3.setValignment(VPos.CENTER);
        RowConstraints row4 = new RowConstraints(100);
        row4.setValignment(VPos.BOTTOM);
        RowConstraints row5 = new RowConstraints(100);
        row5.setValignment(VPos.TOP);

        grid.getRowConstraints().addAll(row0, row1, row2, row3, row4, row5);

        //Buttons met images
        HBox voorrangHBox = new HBox();
        voorrangHBox.setId("icoonMetEva");
        Image voorrang = new Image("images/verkeersTechniek/voorrang.png");
        ImageView voorrangImageView = new ImageView(voorrang);
        voorrangImageView.setFitWidth(50);
        voorrangImageView.setFitHeight(50);
        Button voorrangBtn = new Button("", voorrangImageView);
        voorrangBtn.setId("icoontjesBtns");
        //grid.add(voorrangBtn, 2, 0, 2, 1);

        Rectangle voorrangEva1 = new Rectangle(12, 12, Color.WHITE);
        Rectangle voorrangEva2 = new Rectangle(12, 12, Color.WHITE);
        Rectangle voorrangEva3 = new Rectangle(12, 12, Color.WHITE);

        VBox voorrangEvamomenten = new VBox();
        voorrangEvamomenten.setId("evamomenten");
        voorrangEvamomenten.getChildren().addAll(voorrangEva1, voorrangEva2, voorrangEva3);

        voorrangHBox.getChildren().addAll(voorrangBtn, voorrangEvamomenten);

        grid.add(voorrangHBox, 2, 0, 2, 1);

        HBox orderOpvolgenHBox = new HBox();
        orderOpvolgenHBox.setId("icoonMetEva");
        Image orderOpvolgen = new Image("images/verkeersTechniek/ordersOpvolgen.png");
        ImageView ordersOpvolgenView = new ImageView(orderOpvolgen);
        ordersOpvolgenView.setFitWidth(50);
        ordersOpvolgenView.setFitHeight(50);
        Button orderOpvolgenBtn = new Button("", ordersOpvolgenView);
        orderOpvolgenBtn.setId("icoontjesBtns");
        //grid.add(orderOpvolgenBtn, 4, 1);

        Rectangle orderOpvolgenEva1 = new Rectangle(12, 12, Color.WHITE);
        Rectangle orderOpvolgenEva2 = new Rectangle(12, 12, Color.WHITE);
        Rectangle orderOpvolgenEva3 = new Rectangle(12, 12, Color.WHITE);

        VBox orderOpvolgenEvamomenten = new VBox();
        orderOpvolgenEvamomenten.setId("evamomenten");
        orderOpvolgenEvamomenten.getChildren().addAll(orderOpvolgenEva1, orderOpvolgenEva2, orderOpvolgenEva3);

        orderOpvolgenHBox.getChildren().addAll(orderOpvolgenBtn, orderOpvolgenEvamomenten);

        grid.add(orderOpvolgenHBox, 4, 1);

        HBox snelheidHBox = new HBox();
        snelheidHBox.setId("icoonMetEva");
        Image snelheid = new Image("images/verkeersTechniek/snelheid.png");
        ImageView snelheidView = new ImageView(snelheid);
        snelheidView.setFitWidth(50);
        snelheidView.setFitHeight(50);
        Button snelheidBtn = new Button("", snelheidView);
        snelheidBtn.setId("icoontjesBtns");
        //grid.add(snelheidBtn, 5, 2);

        Rectangle snelheidEva1 = new Rectangle(12, 12, Color.WHITE);
        Rectangle snelheidEva2 = new Rectangle(12, 12, Color.WHITE);
        Rectangle snelheidEva3 = new Rectangle(12, 12, Color.WHITE);

        VBox snelheidEvamomenten = new VBox();
        snelheidEvamomenten.setId("evamomenten");
        snelheidEvamomenten.getChildren().addAll(snelheidEva1, snelheidEva2, snelheidEva3);

        snelheidHBox.getChildren().addAll(snelheidBtn, snelheidEvamomenten);

        grid.add(snelheidHBox, 5, 2);

        HBox afstandHBox = new HBox();
        afstandHBox.setId("icoonMetEva");
        Image afstand = new Image("images/verkeersTechniek/afstand.png");
        ImageView afstandView = new ImageView(afstand);
        afstandView.setFitWidth(50);
        afstandView.setFitHeight(50);
        Button afstandBtn = new Button("", afstandView);
        afstandBtn.setId("icoontjesBtns");
        //grid.add(afstandBtn, 5, 3);

        Rectangle afstandEva1 = new Rectangle(12, 12, Color.WHITE);
        Rectangle afstandEva2 = new Rectangle(12, 12, Color.WHITE);
        Rectangle afstandEva3 = new Rectangle(12, 12, Color.WHITE);

        VBox afstandEvamomenten = new VBox();
        afstandEvamomenten.setId("evamomenten");
        afstandEvamomenten.getChildren().addAll(afstandEva1, afstandEva2, afstandEva3);

        afstandHBox.getChildren().addAll(afstandBtn, afstandEvamomenten);

        grid.add(afstandHBox, 5, 3);

        HBox voorrang2HBox = new HBox();
        voorrang2HBox.setId("icoonMetEva");
        Image voorrang2 = new Image("images/verkeersTechniek/Voorrang2.png");
        ImageView voorrang2View = new ImageView(voorrang2);
        voorrang2View.setFitWidth(50);
        voorrang2View.setFitHeight(50);
        Button voorrang2Btn = new Button("", voorrang2View);
        voorrang2Btn.setId("icoontjesBtns");
        //grid.add(voorrang2Btn, 4, 4);

        Rectangle voorrang2Eva1 = new Rectangle(12, 12, Color.WHITE);
        Rectangle voorrang2Eva2 = new Rectangle(12, 12, Color.WHITE);
        Rectangle voorrang2Eva3 = new Rectangle(12, 12, Color.WHITE);

        VBox voorrang2Evamomenten = new VBox();
        voorrang2Evamomenten.setId("evamomenten");
        voorrang2Evamomenten.getChildren().addAll(voorrang2Eva1, voorrang2Eva2, voorrang2Eva3);

        voorrang2HBox.getChildren().addAll(voorrang2Btn, voorrang2Evamomenten);

        grid.add(voorrang2HBox, 4, 4);

        HBox groenePijlHBox = new HBox();
        groenePijlHBox.setId("icoonMetEva");
        Image groenePijl = new Image("images/verkeersTechniek/1.png");
        ImageView groenePijlView = new ImageView(groenePijl);
        groenePijlView.setFitWidth(50);
        groenePijlView.setFitHeight(50);
        Button groenePijlBtn = new Button("", groenePijlView);
        groenePijlBtn.setId("icoontjesBtns");
        //grid.add(groenePijlBtn, 2, 5, 2, 1);

        Rectangle groenePijlEva1 = new Rectangle(12, 12, Color.WHITE);
        Rectangle groenePijlEva2 = new Rectangle(12, 12, Color.WHITE);
        Rectangle groenePijlEva3 = new Rectangle(12, 12, Color.WHITE);

        VBox groenePijlEvamomenten = new VBox();
        groenePijlEvamomenten.setId("icoonMetEva");
        groenePijlEvamomenten.getChildren().addAll(groenePijlEva1, groenePijlEva2, groenePijlEva3);

        groenePijlHBox.getChildren().addAll(groenePijlBtn, groenePijlEvamomenten);

        grid.add(groenePijlHBox, 2, 5, 2, 1);

        HBox linksAfslaanHBox = new HBox();
        linksAfslaanHBox.setId("icoonMetEva");
        Image linksAfslaan = new Image("images/verkeersTechniek/linksAfslaan.png");
        ImageView linksAfslaanView = new ImageView(linksAfslaan);
        linksAfslaanView.setFitWidth(50);
        linksAfslaanView.setFitHeight(50);
        Button linksAfslaanBtn = new Button("", linksAfslaanView);
        linksAfslaanBtn.setId("icoontjesBtns");
        //grid.add(linksAfslaanBtn, 1, 4);

        Rectangle linksAfslaanEva1 = new Rectangle(12, 12, Color.WHITE);
        Rectangle linksAfslaanEva2 = new Rectangle(12, 12, Color.WHITE);
        Rectangle linksAfslaanEva3 = new Rectangle(12, 12, Color.WHITE);

        VBox linksAfslaanEvamomenten = new VBox();
        linksAfslaanEvamomenten.setId("icoonMetEva");
        linksAfslaanEvamomenten.getChildren().addAll(linksAfslaanEva1, linksAfslaanEva2, linksAfslaanEva3);

        linksAfslaanHBox.getChildren().addAll(linksAfslaanBtn, linksAfslaanEvamomenten);

        grid.add(linksAfslaanHBox, 1, 4);

        HBox rechtsAfslaanHBox = new HBox();
        rechtsAfslaanHBox.setId("icoonMetEva");
        Image rechtsAfslaan = new Image("images/verkeersTechniek/rechtsAfslaan.png");
        ImageView rechtsAfslaanView = new ImageView(rechtsAfslaan);
        rechtsAfslaanView.setFitWidth(50);
        rechtsAfslaanView.setFitHeight(50);
        Button rechtsAfslaanBtn = new Button("", rechtsAfslaanView);
        rechtsAfslaanBtn.setId("icoontjesBtns");
        //grid.add(rechtsAfslaanBtn, 0, 3);

        Rectangle rechtsAfslaanEva1 = new Rectangle(12, 12, Color.WHITE);
        Rectangle rechtsAfslaanEva2 = new Rectangle(12, 12, Color.WHITE);
        Rectangle rechtsAfslaanEva3 = new Rectangle(12, 12, Color.WHITE);

        VBox rechtsAfslaanEvamomenten = new VBox();
        rechtsAfslaanEvamomenten.setId("icoonMetEva");
        rechtsAfslaanEvamomenten.getChildren().addAll(rechtsAfslaanEva1, rechtsAfslaanEva2, rechtsAfslaanEva3);

        rechtsAfslaanHBox.getChildren().addAll(rechtsAfslaanBtn, rechtsAfslaanEvamomenten);

        grid.add(rechtsAfslaanHBox, 0, 3);

        HBox pinkersHBox = new HBox();
        pinkersHBox.setId("icoonMetEva");
        Image pinkers = new Image("images/verkeersTechniek/pinkers.png");
        ImageView pinkersView = new ImageView(pinkers);
        pinkersView.setFitWidth(50);
        pinkersView.setFitHeight(50);
        Button pinkersBtn = new Button("", pinkersView);
        pinkersBtn.setId("icoontjesBtns");
        //grid.add(pinkersBtn, 0, 2);

        Rectangle pinkersEva1 = new Rectangle(12, 12, Color.WHITE);
        Rectangle pinkersEva2 = new Rectangle(12, 12, Color.WHITE);
        Rectangle pinkersEva3 = new Rectangle(12, 12, Color.WHITE);

        VBox pinkersEvamomenten = new VBox();
        pinkersEvamomenten.setId("icoonMetEva");
        pinkersEvamomenten.getChildren().addAll(linksAfslaanEva1, linksAfslaanEva2, linksAfslaanEva3);

        pinkersHBox.getChildren().addAll(pinkersBtn, pinkersEvamomenten);

        grid.add(pinkersHBox, 0, 2);

        HBox OWHBox = new HBox();
        OWHBox.setId("icoonMetEva");
        Image OW = new Image("images/verkeersTechniek/OW.png");
        ImageView OWView = new ImageView(OW);
        OWView.setFitWidth(50);
        OWView.setFitHeight(50);
        Button OWBtn = new Button("", OWView);
        OWBtn.setId("icoontjesBtns");
        //grid.add(OWBtn, 1, 1);

        Rectangle OWEva1 = new Rectangle(12, 12, Color.WHITE);
        Rectangle OWEva2 = new Rectangle(12, 12, Color.WHITE);
        Rectangle OWEva3 = new Rectangle(12, 12, Color.WHITE);

        VBox OWEvamomenten = new VBox();
        OWEvamomenten.setId("icoonMetEva");
        OWEvamomenten.getChildren().addAll(OWEva1, OWEva2, OWEva3);

        OWHBox.getChildren().addAll(OWBtn, OWEvamomenten);

        grid.add(OWHBox, 1, 1);

        Image middenGrid = new Image("images/verkeersTechniek/icoon-verkeerstechniek.png");
        ImageView middenGridImageView = new ImageView(middenGrid);
        middenGridImageView.setFitWidth(150);
        middenGridImageView.setFitHeight(150);
        grid.add(middenGridImageView, 2, 2, 2, 2);

        Image cirkel = new Image("images/verkeersTechniek/cirkel.png");
        ImageView cirkelImageView = new ImageView(cirkel);
        cirkelImageView.setFitWidth(600);
        cirkelImageView.setFitHeight(600);

        grid.setBlendMode(BlendMode.ADD);

        Group evaluatieGroup = new Group();
        evaluatieGroup.setId("evaluatieGroup");
        evaluatieGroup.getChildren().add(cirkelImageView);
        evaluatieGroup.getChildren().add(grid);

        //RandInfo
        VBox left = new VBox();
        left.setId("randinfoLeft");

        Image terugPijl = new Image("images/terug-pijl.png");
        ImageView terugPijlImageView = new ImageView(terugPijl);
        terugPijlImageView.setFitWidth(100);
        terugPijlImageView.setFitHeight(50);
        Button terugBtn = new Button("", terugPijlImageView);
        terugBtn.setId("menuButton");

        terugBtn.setOnAction(e -> {
            Dashboard dashboard = new Dashboard();
            dashboard.setScene(scene);
            scene.setRoot(dashboard);
        });
        Image rechthoek = new Image("images/verkeerslicht.png");
        ImageView rechthoekImageView = new ImageView(rechthoek);
        rechthoekImageView.setFitWidth(70);
        rechthoekImageView.setFitHeight(200);

        VBox lichten = new VBox();
        lichten.setId("lichten");
        Image groenLicht = new Image("images/verkeerslicht-groen.png");

        Image roodLicht = new Image("images/verkeerslicht-rood.png");
        ImageView roodLichtImageView = new ImageView(roodLicht);
        roodLichtImageView.setFitWidth(40);
        roodLichtImageView.setFitHeight(40);
        Button roodLichtButton = new Button("", roodLichtImageView);
        roodLichtButton.setId("icoontjesBtns");

        Image oranjeLicht = new Image("images/verkeerslicht-oranje.png");
        ImageView oranjeLichtImageView = new ImageView(oranjeLicht);
        oranjeLichtImageView.setFitWidth(40);
        oranjeLichtImageView.setFitHeight(40);
        Button oranjeLichtButton = new Button("", oranjeLichtImageView);
        oranjeLichtButton.setId("icoontjesBtns");

        ImageView groenLichtImageView = new ImageView(groenLicht);
        groenLichtImageView.setFitWidth(40);
        groenLichtImageView.setFitHeight(40);
        Button groenLichtButton = new Button("", groenLichtImageView);
        groenLichtButton.setId("icoontjesBtns");

        lichten.getChildren().addAll(roodLichtButton, oranjeLichtButton, groenLichtButton);
        lichten.setBlendMode(BlendMode.ADD);

        Group verkeerslicht = new Group();
        verkeerslicht.setId("groupVerkeerslicht");
        verkeerslicht.getChildren().add(rechthoekImageView);
        verkeerslicht.getChildren().add(lichten);

        left.getChildren().addAll(terugBtn, verkeerslicht);

        //Menu
        Menu menu = new Menu();
        VBox right = new VBox();
        VBox menuStandaard = menu.buildMenuStandaard();

        right.getChildren().add(menuStandaard);

        VBox menuBalk = menu.buildMenu();

        menu.getMenuKnop().setOnAction(e -> {
            right.getChildren().remove(menuStandaard);

            TranslateTransition tt = new TranslateTransition(Duration.millis(500), menuBalk);

            tt.setFromX(150.0 + menuBalk.getLayoutX());
            tt.setByX(-80);
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

            tt.setFromX(menuBalk.getLayoutX() + 100);
            tt.setByX(100);
            tt.setCycleCount(1);

            tt.play();
            tt.onFinishedProperty();
        });

        getChildren().addAll(left, evaluatieGroup, right);
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
