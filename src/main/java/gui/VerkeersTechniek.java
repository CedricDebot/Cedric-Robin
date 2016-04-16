package gui;

import domein.DomeinController;
import domein.SchermType;
import domein.Toestand;
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

public class VerkeersTechniek extends HBox {
    
    private DomeinController controller;

    private Scene scene;
    private ImageView middenGridImageView;
    private Group verkeerstechniekGroup;

    private boolean roodLichtActive = false;
    private boolean oranjeLichtActive = false;
    private boolean groenLichtActive = false;

    public VerkeersTechniek(DomeinController controller) {
        this.controller = controller;
        
        setId("rijtechniekHBox");
        GridPane grid = new GridPane();
        //grid.setGridLinesVisible(true);

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
        voorrangHBox.setId("voorrangHBox");
        Image voorrangBegin = new Image("images/verkeersTechniek/voorrang" + controller.getLeerling().getVerkeerstechniekDom().getVoorrang() + ".png");
        ImageView voorrangImageView = new ImageView(voorrangBegin);
        voorrangImageView.setFitWidth(50);
        voorrangImageView.setFitHeight(50);
        Button voorrangBtn = new Button("", voorrangImageView);
        voorrangBtn.setId("icoontjesBtns");
        //grid.add(voorrangBtn, 2, 0, 2, 1);

        Image voorrangWit = new Image("images/verkeersTechniek/voorrangWit.png");
        Image voorrangRood = new Image("images/verkeersTechniek/voorrangRood.png");
        Image voorrangOranje = new Image("images/verkeersTechniek/voorrangOranje.png");
        Image voorrangGroen = new Image("images/verkeersTechniek/voorrangGroen.png");

        voorrangBtn.setOnAction(e -> {
            if (controller.getLeerling().getVerkeerstechniekDom().getVoorrang() == Toestand.WIT) {
                controller.getLeerling().getVerkeerstechniekDom().setVoorrang(Toestand.ROOD);
                voorrangImageView.setImage(voorrangRood);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandBeneden();
                kleurRotonde();
            } else if (controller.getLeerling().getVerkeerstechniekDom().getVoorrang() == Toestand.ROOD) {
                controller.getLeerling().getVerkeerstechniekDom().setVoorrang(Toestand.ORANJE);
                voorrangImageView.setImage(voorrangOranje);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandBeneden();
                kleurRotonde();
            } else if (controller.getLeerling().getVerkeerstechniekDom().getVoorrang() == Toestand.ORANJE) {
                controller.getLeerling().getVerkeerstechniekDom().setVoorrang(Toestand.GROEN);
                voorrangImageView.setImage(voorrangGroen);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandBeneden();
                kleurRotonde();
            } else if (controller.getLeerling().getVerkeerstechniekDom().getVoorrang() == Toestand.GROEN) {
                controller.getLeerling().getVerkeerstechniekDom().setVoorrang(Toestand.WIT);
                voorrangImageView.setImage(voorrangWit);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandBeneden();
                kleurRotonde();
            }
        });

        Rectangle voorrangEva1 = new Rectangle(12, 12, Color.WHITE);
        Rectangle voorrangEva2 = new Rectangle(12, 12, Color.WHITE);
        Rectangle voorrangEva3 = new Rectangle(12, 12, Color.WHITE);

        VBox voorrangEvamomenten = new VBox();
        voorrangEvamomenten.setId("evamomenten");
        voorrangEvamomenten.getChildren().addAll(voorrangEva1, voorrangEva2, voorrangEva3);

        voorrangHBox.getChildren().addAll(voorrangBtn, voorrangEvamomenten);

        grid.add(voorrangHBox, 2, 0, 2, 1);

        HBox orderOpvolgenHBox = new HBox();
        orderOpvolgenHBox.setId("orderOpvolgenHBox");
        Image orderOpvolgenBegin = new Image("images/verkeersTechniek/orders" + controller.getLeerling().getVerkeerstechniekDom().getVerkeerstekens() + ".png");
        ImageView ordersOpvolgenView = new ImageView(orderOpvolgenBegin);
        ordersOpvolgenView.setFitWidth(50);
        ordersOpvolgenView.setFitHeight(50);
        Button orderOpvolgenBtn = new Button("", ordersOpvolgenView);
        orderOpvolgenBtn.setId("icoontjesBtns");
        //grid.add(orderOpvolgenBtn, 4, 1);
        Image orderOpvolgenWit = new Image("images/verkeersTechniek/ordersWit.png");
        Image orderOpvolgenRood = new Image("images/verkeersTechniek/ordersRood.png");
        Image orderOpvolgenOranje = new Image("images/verkeersTechniek/ordersOranje.png");
        Image orderOpvolgenGroen = new Image("images/verkeersTechniek/ordersGroen.png");

        orderOpvolgenBtn.setOnAction(e -> {
            if (controller.getLeerling().getVerkeerstechniekDom().getVerkeerstekens() == Toestand.WIT) {
                controller.getLeerling().getVerkeerstechniekDom().setVerkeerstekens(Toestand.ROOD);
                ordersOpvolgenView.setImage(orderOpvolgenRood);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandBeneden();
                kleurRotonde();
            } else if (controller.getLeerling().getVerkeerstechniekDom().getVerkeerstekens() == Toestand.ROOD) {
                controller.getLeerling().getVerkeerstechniekDom().setVerkeerstekens(Toestand.ORANJE);
                ordersOpvolgenView.setImage(orderOpvolgenOranje);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandBeneden();
                kleurRotonde();
            } else if (controller.getLeerling().getVerkeerstechniekDom().getVerkeerstekens() == Toestand.ORANJE) {
                controller.getLeerling().getVerkeerstechniekDom().setVerkeerstekens(Toestand.GROEN);
                ordersOpvolgenView.setImage(orderOpvolgenGroen);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandBeneden();
                kleurRotonde();
            } else if (controller.getLeerling().getVerkeerstechniekDom().getVerkeerstekens() == Toestand.GROEN) {
                controller.getLeerling().getVerkeerstechniekDom().setVerkeerstekens(Toestand.WIT);
                ordersOpvolgenView.setImage(orderOpvolgenWit);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandBeneden();
                kleurRotonde();
            }
        });

        Rectangle orderOpvolgenEva1 = new Rectangle(12, 12, Color.WHITE);
        Rectangle orderOpvolgenEva2 = new Rectangle(12, 12, Color.WHITE);
        Rectangle orderOpvolgenEva3 = new Rectangle(12, 12, Color.WHITE);

        VBox orderOpvolgenEvamomenten = new VBox();
        orderOpvolgenEvamomenten.setId("evamomenten");
        orderOpvolgenEvamomenten.getChildren().addAll(orderOpvolgenEva1, orderOpvolgenEva2, orderOpvolgenEva3);

        orderOpvolgenHBox.getChildren().addAll(orderOpvolgenBtn, orderOpvolgenEvamomenten);

        grid.add(orderOpvolgenHBox, 4, 1);

        HBox snelheidHBox = new HBox();
        snelheidHBox.setId("snelheidHBox");
        Image snelheidBegin = new Image("images/verkeersTechniek/snelheid" + controller.getLeerling().getVerkeerstechniekDom().getSnelheid() + ".png");
        ImageView snelheidView = new ImageView(snelheidBegin);
        snelheidView.setFitWidth(50);
        snelheidView.setFitHeight(50);
        Button snelheidBtn = new Button("", snelheidView);
        snelheidBtn.setId("icoontjesBtns");
        //grid.add(snelheidBtn, 5, 2);
        Image snelheidWit = new Image("images/verkeersTechniek/snelheidWit.png");
        Image snelheidRood = new Image("images/verkeersTechniek/snelheidRood.png");
        Image snelheidOranje = new Image("images/verkeersTechniek/snelheidOranje.png");
        Image snelheidGroen = new Image("images/verkeersTechniek/snelheidGroen.png");

        snelheidBtn.setOnAction(e -> {
            if (controller.getLeerling().getVerkeerstechniekDom().getSnelheid() == Toestand.WIT) {
                controller.getLeerling().getVerkeerstechniekDom().setSnelheid(Toestand.ROOD);
                snelheidView.setImage(snelheidRood);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandBeneden();
                kleurRotonde();
            } else if (controller.getLeerling().getVerkeerstechniekDom().getSnelheid() == Toestand.ROOD) {
                controller.getLeerling().getVerkeerstechniekDom().setSnelheid(Toestand.ORANJE);
                snelheidView.setImage(snelheidOranje);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandBeneden();
                kleurRotonde();
            } else if (controller.getLeerling().getVerkeerstechniekDom().getSnelheid() == Toestand.ORANJE) {
                controller.getLeerling().getVerkeerstechniekDom().setSnelheid(Toestand.GROEN);
                snelheidView.setImage(snelheidGroen);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandBeneden();
                kleurRotonde();
            } else if (controller.getLeerling().getVerkeerstechniekDom().getSnelheid() == Toestand.GROEN) {
                controller.getLeerling().getVerkeerstechniekDom().setSnelheid(Toestand.WIT);
                snelheidView.setImage(snelheidWit);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandBeneden();
                kleurRotonde();
            }
        });

        Rectangle snelheidEva1 = new Rectangle(12, 12, Color.WHITE);
        Rectangle snelheidEva2 = new Rectangle(12, 12, Color.WHITE);
        Rectangle snelheidEva3 = new Rectangle(12, 12, Color.WHITE);

        VBox snelheidEvamomenten = new VBox();
        snelheidEvamomenten.setId("evamomenten");
        snelheidEvamomenten.getChildren().addAll(snelheidEva1, snelheidEva2, snelheidEva3);

        snelheidHBox.getChildren().addAll(snelheidBtn, snelheidEvamomenten);

        grid.add(snelheidHBox, 5, 2);

        HBox afstandHBox = new HBox();
        afstandHBox.setId("afstandHBox");
        Image afstandBegin = new Image("images/verkeersTechniek/afstand" + controller.getLeerling().getVerkeerstechniekDom().getAfstandHouden() + ".png");
        ImageView afstandView = new ImageView(afstandBegin);
        afstandView.setFitWidth(50);
        afstandView.setFitHeight(50);
        Button afstandBtn = new Button("", afstandView);
        afstandBtn.setId("icoontjesBtns");
        //grid.add(afstandBtn, 5, 3);
        Image afstandWit = new Image("images/verkeersTechniek/afstandWit.png");
        Image afstandRood = new Image("images/verkeersTechniek/afstandRood.png");
        Image afstandOranje = new Image("images/verkeersTechniek/afstandOranje.png");
        Image afstandGroen = new Image("images/verkeersTechniek/afstandGroen.png");

        afstandBtn.setOnAction(e -> {
            if (controller.getLeerling().getVerkeerstechniekDom().getAfstandHouden() == Toestand.WIT) {
                controller.getLeerling().getVerkeerstechniekDom().setAfstandHouden(Toestand.ROOD);
                afstandView.setImage(afstandRood);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandRechts();
                kleurRotonde();
            } else if (controller.getLeerling().getVerkeerstechniekDom().getAfstandHouden() == Toestand.ROOD) {
                controller.getLeerling().getVerkeerstechniekDom().setAfstandHouden(Toestand.ORANJE);
                afstandView.setImage(afstandOranje);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandRechts();
                kleurRotonde();
            } else if (controller.getLeerling().getVerkeerstechniekDom().getAfstandHouden() == Toestand.ORANJE) {
                controller.getLeerling().getVerkeerstechniekDom().setAfstandHouden(Toestand.GROEN);
                afstandView.setImage(afstandGroen);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandRechts();
                kleurRotonde();
            } else if (controller.getLeerling().getVerkeerstechniekDom().getAfstandHouden() == Toestand.GROEN) {
                controller.getLeerling().getVerkeerstechniekDom().setAfstandHouden(Toestand.WIT);
                afstandView.setImage(afstandWit);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandRechts();
                kleurRotonde();
            }
        });

        Rectangle afstandEva1 = new Rectangle(12, 12, Color.WHITE);
        Rectangle afstandEva2 = new Rectangle(12, 12, Color.WHITE);
        Rectangle afstandEva3 = new Rectangle(12, 12, Color.WHITE);

        VBox afstandEvamomenten = new VBox();
        afstandEvamomenten.setId("evamomenten");
        afstandEvamomenten.getChildren().addAll(afstandEva1, afstandEva2, afstandEva3);

        afstandHBox.getChildren().addAll(afstandBtn, afstandEvamomenten);

        grid.add(afstandHBox, 5, 3);

        HBox inhalenHBox = new HBox();
        inhalenHBox.setId("inhalenHBox");
        Image inhalenBegin = new Image("images/verkeersTechniek/inhalen" + controller.getLeerling().getVerkeerstechniekDom().getInhalen() + ".png");
        ImageView inhalenView = new ImageView(inhalenBegin);
        inhalenView.setFitWidth(50);
        inhalenView.setFitHeight(50);
        Button inhalenBtn = new Button("", inhalenView);
        inhalenBtn.setId("icoontjesBtns");
        //grid.add(voorrang2Btn, 4, 4);

        Image inhalenWit = new Image("images/verkeersTechniek/inhalenWit.png");
        Image inhalenRood = new Image("images/verkeersTechniek/inhalenRood.png");
        Image inhalenOranje = new Image("images/verkeersTechniek/inhalenOranje.png");
        Image inhalenGroen = new Image("images/verkeersTechniek/inhalenGroen.png");

        inhalenBtn.setOnAction(e -> {
            if (controller.getLeerling().getVerkeerstechniekDom().getInhalen() == Toestand.WIT) {
                controller.getLeerling().getVerkeerstechniekDom().setInhalen(Toestand.ROOD);
                inhalenView.setImage(inhalenRood);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandLinks();
                kleurRotonde();
            } else if (controller.getLeerling().getVerkeerstechniekDom().getInhalen() == Toestand.ROOD) {
                controller.getLeerling().getVerkeerstechniekDom().setInhalen(Toestand.ORANJE);
                inhalenView.setImage(inhalenOranje);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandLinks();
                kleurRotonde();
            } else if (controller.getLeerling().getVerkeerstechniekDom().getInhalen() == Toestand.ORANJE) {
                controller.getLeerling().getVerkeerstechniekDom().setInhalen(Toestand.GROEN);
                inhalenView.setImage(inhalenGroen);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandLinks();
                kleurRotonde();
            } else if (controller.getLeerling().getVerkeerstechniekDom().getInhalen() == Toestand.GROEN) {
                controller.getLeerling().getVerkeerstechniekDom().setInhalen(Toestand.WIT);
                inhalenView.setImage(inhalenWit);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandLinks();
                kleurRotonde();
            }
        });

        Rectangle voorrang2Eva1 = new Rectangle(12, 12, Color.WHITE);
        Rectangle voorrang2Eva2 = new Rectangle(12, 12, Color.WHITE);
        Rectangle voorrang2Eva3 = new Rectangle(12, 12, Color.WHITE);

        VBox voorrang2Evamomenten = new VBox();
        voorrang2Evamomenten.setId("evamomenten");
        voorrang2Evamomenten.getChildren().addAll(voorrang2Eva1, voorrang2Eva2, voorrang2Eva3);

        inhalenHBox.getChildren().addAll(inhalenBtn, voorrang2Evamomenten);

        grid.add(inhalenHBox, 4, 4);

        HBox kruisenHBox = new HBox();
        kruisenHBox.setId("kruisenHBox");
        Image kruisenBegin = new Image("images/verkeersTechniek/kruisen" + controller.getLeerling().getVerkeerstechniekDom().getKruisen() + ".png");
        ImageView kruisenView = new ImageView(kruisenBegin);
        kruisenView.setFitWidth(50);
        kruisenView.setFitHeight(50);
        Button kruisenlBtn = new Button("", kruisenView);
        kruisenlBtn.setId("icoontjesBtns");
        //grid.add(groenePijlBtn, 2, 5, 2, 1);

        Image kruisenWit = new Image("images/verkeersTechniek/kruisenWit.png");
        Image kruisenRood = new Image("images/verkeersTechniek/kruisenRood.png");
        Image kruisenOranje = new Image("images/verkeersTechniek/kruisenOranje.png");
        Image kruisenGroen = new Image("images/verkeersTechniek/kruisenGroen.png");

        kruisenlBtn.setOnAction(e -> {
            if (controller.getLeerling().getVerkeerstechniekDom().getKruisen() == Toestand.WIT) {
                controller.getLeerling().getVerkeerstechniekDom().setKruisen(Toestand.ROOD);
                kruisenView.setImage(kruisenRood);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandLinks();
                kleurRotonde();
            } else if (controller.getLeerling().getVerkeerstechniekDom().getKruisen() == Toestand.ROOD) {
                controller.getLeerling().getVerkeerstechniekDom().setKruisen(Toestand.ORANJE);
                kruisenView.setImage(kruisenOranje);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandLinks();
                kleurRotonde();
            } else if (controller.getLeerling().getVerkeerstechniekDom().getKruisen() == Toestand.ORANJE) {
                controller.getLeerling().getVerkeerstechniekDom().setKruisen(Toestand.GROEN);
                kruisenView.setImage(kruisenGroen);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandLinks();
                kleurRotonde();
            } else if (controller.getLeerling().getVerkeerstechniekDom().getKruisen() == Toestand.GROEN) {
                controller.getLeerling().getVerkeerstechniekDom().setKruisen(Toestand.WIT);
                kruisenView.setImage(kruisenWit);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandLinks();
                kleurRotonde();
            }
        });

        Rectangle groenePijlEva1 = new Rectangle(12, 12, Color.WHITE);
        Rectangle groenePijlEva2 = new Rectangle(12, 12, Color.WHITE);
        Rectangle groenePijlEva3 = new Rectangle(12, 12, Color.WHITE);

        VBox groenePijlEvamomenten = new VBox();
        groenePijlEvamomenten.setId("evamomenten");
        groenePijlEvamomenten.getChildren().addAll(groenePijlEva1, groenePijlEva2, groenePijlEva3);

        kruisenHBox.getChildren().addAll(kruisenlBtn, groenePijlEvamomenten);

        grid.add(kruisenHBox, 2, 5, 2, 1);

        HBox linksAfslaanHBox = new HBox();
        linksAfslaanHBox.setId("linksAfslaanHBox");
        Image linksAfslaanBegin = new Image("images/verkeersTechniek/linksAf" + controller.getLeerling().getVerkeerstechniekDom().getLinksaf() + ".png");
        ImageView linksAfslaanView = new ImageView(linksAfslaanBegin);
        linksAfslaanView.setFitWidth(50);
        linksAfslaanView.setFitHeight(50);
        Button linksAfslaanBtn = new Button("", linksAfslaanView);
        linksAfslaanBtn.setId("icoontjesBtns");
        //grid.add(linksAfslaanBtn, 1, 4);

        Image linksAfslaanWit = new Image("images/verkeersTechniek/linksAfWit.png");
        Image linksAfslaanRood = new Image("images/verkeersTechniek/linksAfRood.png");
        Image linksAfslaanOranje = new Image("images/verkeersTechniek/linksAfOranje.png");
        Image linksAfslaanGroen = new Image("images/verkeersTechniek/linksAfGroen.png");

        linksAfslaanBtn.setOnAction(e -> {
            if (controller.getLeerling().getVerkeerstechniekDom().getLinksaf() == Toestand.WIT) {
                controller.getLeerling().getVerkeerstechniekDom().setLinksaf(Toestand.ROOD);
                linksAfslaanView.setImage(linksAfslaanRood);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandRechts();
                kleurRotonde();
            } else if (controller.getLeerling().getVerkeerstechniekDom().getLinksaf() == Toestand.ROOD) {
                controller.getLeerling().getVerkeerstechniekDom().setLinksaf(Toestand.ORANJE);
                linksAfslaanView.setImage(linksAfslaanOranje);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandRechts();
                kleurRotonde();
            } else if (controller.getLeerling().getVerkeerstechniekDom().getLinksaf() == Toestand.ORANJE) {
                controller.getLeerling().getVerkeerstechniekDom().setLinksaf(Toestand.GROEN);
                linksAfslaanView.setImage(linksAfslaanGroen);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandRechts();
                kleurRotonde();
            } else if (controller.getLeerling().getVerkeerstechniekDom().getLinksaf() == Toestand.GROEN) {
                controller.getLeerling().getVerkeerstechniekDom().setLinksaf(Toestand.WIT);
                linksAfslaanView.setImage(linksAfslaanWit);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandRechts();
                kleurRotonde();
            }
        });

        Rectangle linksAfslaanEva1 = new Rectangle(12, 12, Color.WHITE);
        Rectangle linksAfslaanEva2 = new Rectangle(12, 12, Color.WHITE);
        Rectangle linksAfslaanEva3 = new Rectangle(12, 12, Color.WHITE);

        VBox linksAfslaanEvamomenten = new VBox();
        linksAfslaanEvamomenten.setId("evamomenten");
        linksAfslaanEvamomenten.getChildren().addAll(linksAfslaanEva1, linksAfslaanEva2, linksAfslaanEva3);

        linksAfslaanHBox.getChildren().addAll(linksAfslaanBtn, linksAfslaanEvamomenten);

        grid.add(linksAfslaanHBox, 1, 4);

        HBox rechtsAfslaanHBox = new HBox();
        rechtsAfslaanHBox.setId("rechtsAfslaanHBox");
        Image rechtsAfslaanBegin = new Image("images/verkeersTechniek/rechtsAf" + controller.getLeerling().getVerkeerstechniekDom().getRechtsaf() + ".png");
        ImageView rechtsAfslaanView = new ImageView(rechtsAfslaanBegin);
        rechtsAfslaanView.setFitWidth(50);
        rechtsAfslaanView.setFitHeight(50);
        Button rechtsAfslaanBtn = new Button("", rechtsAfslaanView);
        rechtsAfslaanBtn.setId("icoontjesBtns");
        //grid.add(rechtsAfslaanBtn, 0, 3);

        Image rechtsAfslaanWit = new Image("images/verkeersTechniek/rechtsAfWit.png");
        Image rechtsAfslaanRood = new Image("images/verkeersTechniek/rechtsAfRood.png");
        Image rechtsAfslaanOranje = new Image("images/verkeersTechniek/rechtsAfOranje.png");
        Image rechtsAfslaanGroen = new Image("images/verkeersTechniek/rechtsAfGroen.png");

        rechtsAfslaanBtn.setOnAction(e -> {
            if (controller.getLeerling().getVerkeerstechniekDom().getRechtsaf() == Toestand.WIT) {
                controller.getLeerling().getVerkeerstechniekDom().setRechtsaf(Toestand.ROOD);
                rechtsAfslaanView.setImage(rechtsAfslaanRood);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandRechts();
                kleurRotonde();
            } else if (controller.getLeerling().getVerkeerstechniekDom().getRechtsaf() == Toestand.ROOD) {
                controller.getLeerling().getVerkeerstechniekDom().setRechtsaf(Toestand.ORANJE);
                rechtsAfslaanView.setImage(rechtsAfslaanOranje);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandRechts();
                kleurRotonde();
            } else if (controller.getLeerling().getVerkeerstechniekDom().getRechtsaf() == Toestand.ORANJE) {
                controller.getLeerling().getVerkeerstechniekDom().setRechtsaf(Toestand.GROEN);
                rechtsAfslaanView.setImage(rechtsAfslaanGroen);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandRechts();
                kleurRotonde();
            } else if (controller.getLeerling().getVerkeerstechniekDom().getRechtsaf() == Toestand.GROEN) {
                controller.getLeerling().getVerkeerstechniekDom().setRechtsaf(Toestand.WIT);
                rechtsAfslaanView.setImage(rechtsAfslaanWit);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandRechts();
                kleurRotonde();
            }
        });

        Rectangle rechtsAfslaanEva1 = new Rectangle(12, 12, Color.WHITE);
        Rectangle rechtsAfslaanEva2 = new Rectangle(12, 12, Color.WHITE);
        Rectangle rechtsAfslaanEva3 = new Rectangle(12, 12, Color.WHITE);

        VBox rechtsAfslaanEvamomenten = new VBox();
        rechtsAfslaanEvamomenten.setId("evamomenten");
        rechtsAfslaanEvamomenten.getChildren().addAll(rechtsAfslaanEva1, rechtsAfslaanEva2, rechtsAfslaanEva3);

        rechtsAfslaanHBox.getChildren().addAll(rechtsAfslaanBtn, rechtsAfslaanEvamomenten);

        grid.add(rechtsAfslaanHBox, 0, 3);

        HBox pinkersHBox = new HBox();
        pinkersHBox.setId("pinkersHBox");
        Image pinkersBegin = new Image("images/verkeersTechniek/pinkers" + controller.getLeerling().getVerkeerstechniekDom().getRichtingaanwijzers() + ".png");
        ImageView pinkersView = new ImageView(pinkersBegin);
        pinkersView.setFitWidth(50);
        pinkersView.setFitHeight(50);
        Button pinkersBtn = new Button("", pinkersView);
        pinkersBtn.setId("icoontjesBtns");
        //grid.add(pinkersBtn, 0, 2);

        Image pinkersWit = new Image("images/verkeersTechniek/pinkersWit.png");
        Image pinkersRood = new Image("images/verkeersTechniek/pinkersRood.png");
        Image pinkersOranje = new Image("images/verkeersTechniek/pinkersOranje.png");
        Image pinkersGroen = new Image("images/verkeersTechniek/pinkersGroen.png");

        pinkersBtn.setOnAction(e -> {
            if (controller.getLeerling().getVerkeerstechniekDom().getRichtingaanwijzers() == Toestand.WIT) {
                controller.getLeerling().getVerkeerstechniekDom().setRichtingaanwijzers(Toestand.ROOD);
                pinkersView.setImage(pinkersRood);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandLinks();
                kleurRotonde();
            } else if (controller.getLeerling().getVerkeerstechniekDom().getRichtingaanwijzers() == Toestand.ROOD) {
                controller.getLeerling().getVerkeerstechniekDom().setRichtingaanwijzers(Toestand.ORANJE);
                pinkersView.setImage(pinkersOranje);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandLinks();
                kleurRotonde();
            } else if (controller.getLeerling().getVerkeerstechniekDom().getRichtingaanwijzers() == Toestand.ORANJE) {
                controller.getLeerling().getVerkeerstechniekDom().setRichtingaanwijzers(Toestand.GROEN);
                pinkersView.setImage(pinkersGroen);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandLinks();
                kleurRotonde();
            } else if (controller.getLeerling().getVerkeerstechniekDom().getRichtingaanwijzers() == Toestand.GROEN) {
                controller.getLeerling().getVerkeerstechniekDom().setRichtingaanwijzers(Toestand.WIT);
                pinkersView.setImage(pinkersWit);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandLinks();
                kleurRotonde();
            }
        });

        Rectangle pinkersEva1 = new Rectangle(12, 12, Color.WHITE);
        Rectangle pinkersEva2 = new Rectangle(12, 12, Color.WHITE);
        Rectangle pinkersEva3 = new Rectangle(12, 12, Color.WHITE);

        VBox pinkersEvamomenten = new VBox();
        pinkersEvamomenten.setId("evamomenten");
        pinkersEvamomenten.getChildren().addAll(pinkersEva1, pinkersEva2, pinkersEva3);

        pinkersHBox.getChildren().addAll(pinkersBtn, pinkersEvamomenten);

        grid.add(pinkersHBox, 0, 2);

        HBox OWHBox = new HBox();
        OWHBox.setId("OWHBox");
        Image OWBegin = new Image("images/verkeersTechniek/OW" + controller.getLeerling().getVerkeerstechniekDom().getOpenbareWeg() + ".png");
        ImageView OWView = new ImageView(OWBegin);
        OWView.setFitWidth(50);
        OWView.setFitHeight(50);
        Button OWBtn = new Button("", OWView);
        OWBtn.setId("icoontjesBtns");
        //grid.add(OWBtn, 1, 1);

        Image OWWit = new Image("images/verkeersTechniek/OWWit.png");
        Image OWRood = new Image("images/verkeersTechniek/OWRood.png");
        Image OWOranje = new Image("images/verkeersTechniek/OWOranje.png");
        Image OWGroen = new Image("images/verkeersTechniek/OWGroen.png");

        OWBtn.setOnAction(e -> {
            if (controller.getLeerling().getVerkeerstechniekDom().getOpenbareWeg() == Toestand.WIT) {
                controller.getLeerling().getVerkeerstechniekDom().setOpenbareWeg(Toestand.ROOD);
                OWView.setImage(OWRood);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandRechts();
                kleurRotonde();
            } else if (controller.getLeerling().getVerkeerstechniekDom().getOpenbareWeg() == Toestand.ROOD) {
                controller.getLeerling().getVerkeerstechniekDom().setOpenbareWeg(Toestand.ORANJE);
                OWView.setImage(OWOranje);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandRechts();
                kleurRotonde();
            } else if (controller.getLeerling().getVerkeerstechniekDom().getOpenbareWeg() == Toestand.ORANJE) {
                controller.getLeerling().getVerkeerstechniekDom().setOpenbareWeg(Toestand.GROEN);
                OWView.setImage(OWGroen);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandRechts();
                kleurRotonde();
            } else if (controller.getLeerling().getVerkeerstechniekDom().getOpenbareWeg() == Toestand.GROEN) {
                controller.getLeerling().getVerkeerstechniekDom().setOpenbareWeg(Toestand.WIT);
                OWView.setImage(OWWit);
                controller.getLeerling().getVerkeerstechniekDom().bepaalToestandRechts();
                kleurRotonde();
            }
        });

        Rectangle OWEva1 = new Rectangle(12, 12, Color.WHITE);
        Rectangle OWEva2 = new Rectangle(12, 12, Color.WHITE);
        Rectangle OWEva3 = new Rectangle(12, 12, Color.WHITE);

        VBox OWEvamomenten = new VBox();
        OWEvamomenten.setId("evamomenten");
        OWEvamomenten.getChildren().addAll(OWEva1, OWEva2, OWEva3);

        OWHBox.getChildren().addAll(OWBtn, OWEvamomenten);

        grid.add(OWHBox, 1, 1);

        Image middenGrid = new Image("images/verkeerstechniekIcoon/verkeerstechniekWit.png");
        middenGridImageView = new ImageView(middenGrid);
        middenGridImageView.setFitWidth(150);
        middenGridImageView.setFitHeight(150);

        verkeerstechniekGroup = new Group();
        verkeerstechniekGroup.getChildren().add(middenGridImageView);
        grid.add(verkeerstechniekGroup, 2, 2, 2, 2);

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
            controller.getDashboard().setScene(scene);
            scene.setRoot(controller.getDashboard());
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

        roodLichtButton.setOnAction(e -> {
            Toestand[] icoontjesToestand = {controller.getLeerling().getVerkeerstechniekDom().getVoorrang(),
                controller.getLeerling().getVerkeerstechniekDom().getVerkeerstekens(),
                controller.getLeerling().getVerkeerstechniekDom().getSnelheid(),
                controller.getLeerling().getVerkeerstechniekDom().getAfstandHouden(),
                controller.getLeerling().getVerkeerstechniekDom().getInhalen(),
                controller.getLeerling().getVerkeerstechniekDom().getKruisen(),
                controller.getLeerling().getVerkeerstechniekDom().getLinksaf(),
                controller.getLeerling().getVerkeerstechniekDom().getRechtsaf(),
                controller.getLeerling().getVerkeerstechniekDom().getRichtingaanwijzers(),
                controller.getLeerling().getVerkeerstechniekDom().getOpenbareWeg()};
            HBox[] icoontjesDisplay = {voorrangHBox, orderOpvolgenHBox, snelheidHBox, afstandHBox, inhalenHBox, kruisenHBox, linksAfslaanHBox, rechtsAfslaanHBox, pinkersHBox, OWHBox};

            if (oranjeLichtActive || groenLichtActive) {
                for (HBox icoontjes : icoontjesDisplay) {
                    icoontjes.setVisible(true);
                }

                oranjeLichtActive = false;
                groenLichtActive = false;
            }

            if (!roodLichtActive) {
                for (int i = 0; i < icoontjesToestand.length; i++) {
                    Toestand toestand = icoontjesToestand[i];
                    if (toestand != Toestand.ROOD) {
                        for (int j = 0; j < icoontjesDisplay.length; j++) {
                            HBox icoontje = icoontjesDisplay[j];
                            if (i == j) {
                                icoontje.setVisible(false);
                            }
                        }
                    }
                }
                roodLichtActive = true;
            } else {
                for (HBox icoontjes : icoontjesDisplay) {
                    icoontjes.setVisible(true);
                }
                roodLichtActive = false;
            }
        });

        Image oranjeLicht = new Image("images/verkeerslicht-oranje.png");
        ImageView oranjeLichtImageView = new ImageView(oranjeLicht);
        oranjeLichtImageView.setFitWidth(40);
        oranjeLichtImageView.setFitHeight(40);
        Button oranjeLichtButton = new Button("", oranjeLichtImageView);
        oranjeLichtButton.setId("icoontjesBtns");

        oranjeLichtButton.setOnAction(e -> {
            Toestand[] icoontjesToestand = {controller.getLeerling().getVerkeerstechniekDom().getVoorrang(),
                controller.getLeerling().getVerkeerstechniekDom().getVerkeerstekens(),
                controller.getLeerling().getVerkeerstechniekDom().getSnelheid(),
                controller.getLeerling().getVerkeerstechniekDom().getAfstandHouden(),
                controller.getLeerling().getVerkeerstechniekDom().getInhalen(),
                controller.getLeerling().getVerkeerstechniekDom().getKruisen(),
                controller.getLeerling().getVerkeerstechniekDom().getLinksaf(),
                controller.getLeerling().getVerkeerstechniekDom().getRechtsaf(),
                controller.getLeerling().getVerkeerstechniekDom().getRichtingaanwijzers(),
                controller.getLeerling().getVerkeerstechniekDom().getOpenbareWeg()};
            HBox[] icoontjesDisplay = {voorrangHBox, orderOpvolgenHBox, snelheidHBox, afstandHBox, inhalenHBox, kruisenHBox, linksAfslaanHBox, rechtsAfslaanHBox, pinkersHBox, OWHBox};

            if (roodLichtActive || groenLichtActive) {
                for (HBox icoontjes : icoontjesDisplay) {
                    icoontjes.setVisible(true);
                }

                roodLichtActive = false;
                groenLichtActive = false;
            }

            if (!oranjeLichtActive) {
                for (int i = 0; i < icoontjesToestand.length; i++) {
                    Toestand toestand = icoontjesToestand[i];
                    if (toestand != Toestand.ORANJE) {
                        for (int j = 0; j < icoontjesDisplay.length; j++) {
                            HBox icoontje = icoontjesDisplay[j];
                            if (i == j) {
                                icoontje.setVisible(false);
                            }
                        }
                    }
                }
                oranjeLichtActive = true;
            } else {
                for (HBox icoontjes : icoontjesDisplay) {
                    icoontjes.setVisible(true);
                }
                oranjeLichtActive = false;
            }
        });

        ImageView groenLichtImageView = new ImageView(groenLicht);
        groenLichtImageView.setFitWidth(40);
        groenLichtImageView.setFitHeight(40);
        Button groenLichtButton = new Button("", groenLichtImageView);
        groenLichtButton.setId("icoontjesBtns");

        groenLichtButton.setOnAction(e -> {
            Toestand[] icoontjesToestand = {controller.getLeerling().getVerkeerstechniekDom().getVoorrang(),
                controller.getLeerling().getVerkeerstechniekDom().getVerkeerstekens(),
                controller.getLeerling().getVerkeerstechniekDom().getSnelheid(),
                controller.getLeerling().getVerkeerstechniekDom().getAfstandHouden(),
                controller.getLeerling().getVerkeerstechniekDom().getInhalen(),
                controller.getLeerling().getVerkeerstechniekDom().getKruisen(),
                controller.getLeerling().getVerkeerstechniekDom().getLinksaf(),
                controller.getLeerling().getVerkeerstechniekDom().getRechtsaf(),
                controller.getLeerling().getVerkeerstechniekDom().getRichtingaanwijzers(),
                controller.getLeerling().getVerkeerstechniekDom().getOpenbareWeg()};
            HBox[] icoontjesDisplay = {voorrangHBox, orderOpvolgenHBox, snelheidHBox, afstandHBox, inhalenHBox, kruisenHBox, linksAfslaanHBox, rechtsAfslaanHBox, pinkersHBox, OWHBox};

            if (roodLichtActive || oranjeLichtActive) {
                for (HBox icoontjes : icoontjesDisplay) {
                    icoontjes.setVisible(true);
                }

                roodLichtActive = false;
                oranjeLichtActive = false;
            }

            if (!groenLichtActive) {
                for (int i = 0; i < icoontjesToestand.length; i++) {
                    Toestand toestand = icoontjesToestand[i];
                    if (toestand != Toestand.GROEN) {
                        for (int j = 0; j < icoontjesDisplay.length; j++) {
                            HBox icoontje = icoontjesDisplay[j];
                            if (i == j) {
                                icoontje.setVisible(false);
                            }
                        }
                    }
                }
                groenLichtActive = true;
            } else {
                for (HBox icoontjes : icoontjesDisplay) {
                    icoontjes.setVisible(true);
                }
                groenLichtActive = false;
            }
        });

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
        VBox menuStandaard = menu.buildMenuStandaard(controller.getLeerling());

        right.getChildren().add(menuStandaard);

        VBox menuBalk = menu.buildMenu(controller, 4);

        menu.getMenuKnop().setOnAction(e -> {
            menu.setScene(scene);
            right.getChildren().remove(menuStandaard);

            TranslateTransition tt = new TranslateTransition(Duration.millis(500), menuBalk);

            tt.setFromX(150.0 + menuBalk.getLayoutX());
            tt.setByX(-140);
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

            tt.setFromX(menuBalk.getLayoutX() + 50);
            tt.setByX(100);
            tt.setCycleCount(1);

            tt.play();
            tt.onFinishedProperty();
        });

        getChildren().addAll(left, evaluatieGroup, right);

        //Opmerkingen
        voorrangBtn.setOnMouseDragged(e -> {

            if (controller.getLeerling().getVerkeerstechniekDom().getVoorrang() == Toestand.ROOD) {
                TechniekOpmerkingen voorrangOpmerkingen = new TechniekOpmerkingen(controller.getLeerling().getVoorrangOpmerkingen(), controller, "images/verkeersTechniek/voorrangRood.png", SchermType.VERKEERSTECHNIEK);
                voorrangOpmerkingen.setScene(scene);
                scene.setRoot(voorrangOpmerkingen);
            }

            if (controller.getLeerling().getVerkeerstechniekDom().getVoorrang() == Toestand.ORANJE) {
                TechniekOpmerkingen voorrangOpmerkingen = new TechniekOpmerkingen(controller.getLeerling().getVoorrangOpmerkingen(), controller, "images/verkeersTechniek/voorrangOranje.png", SchermType.VERKEERSTECHNIEK);
                voorrangOpmerkingen.setScene(scene);
                scene.setRoot(voorrangOpmerkingen);
            }

            if (controller.getLeerling().getVerkeerstechniekDom().getVoorrang() == Toestand.GROEN) {       
                TechniekOpmerkingen voorrangOpmerkingen = new TechniekOpmerkingen(controller.getLeerling().getVoorrangOpmerkingen(), controller, "images/verkeersTechniek/voorrangGroen.png", SchermType.VERKEERSTECHNIEK);
                voorrangOpmerkingen.setScene(scene);
                scene.setRoot(voorrangOpmerkingen);
            }
        });

        OWBtn.setOnMouseDragged(e -> {

            if (controller.getLeerling().getVerkeerstechniekDom().getOpenbareWeg() == Toestand.ROOD) {
                TechniekOpmerkingen openBareWegOpmerkingen = new TechniekOpmerkingen(controller.getLeerling().getOwOpmerkingen(), controller,"images/verkeersTechniek/OWRood.png", SchermType.VERKEERSTECHNIEK);
                openBareWegOpmerkingen.setScene(scene);
                scene.setRoot(openBareWegOpmerkingen);
            }

            if (controller.getLeerling().getVerkeerstechniekDom().getOpenbareWeg() == Toestand.ORANJE) {
                TechniekOpmerkingen openBareWegOpmerkingen = new TechniekOpmerkingen(controller.getLeerling().getOwOpmerkingen(), controller,"images/verkeersTechniek/OWOranje.png", SchermType.VERKEERSTECHNIEK);
                openBareWegOpmerkingen.setScene(scene);
                scene.setRoot(openBareWegOpmerkingen);
            }

            if (controller.getLeerling().getVerkeerstechniekDom().getOpenbareWeg() == Toestand.GROEN) {
                TechniekOpmerkingen openBareWegOpmerkingen = new TechniekOpmerkingen(controller.getLeerling().getOwOpmerkingen(), controller,"images/verkeersTechniek/OWGroen.png", SchermType.VERKEERSTECHNIEK);
                openBareWegOpmerkingen.setScene(scene);
                scene.setRoot(openBareWegOpmerkingen);
            }
        });
        pinkersBtn.setOnMouseDragged(e -> {

            if (controller.getLeerling().getVerkeerstechniekDom().getRichtingaanwijzers() == Toestand.ROOD) {
                TechniekOpmerkingen pinkersOpmerkingen = new TechniekOpmerkingen(controller.getLeerling().getPinkersOpmerkingen(), controller, "images/verkeersTechniek/pinkersRood.png", SchermType.VERKEERSTECHNIEK);
                pinkersOpmerkingen.setScene(scene);
                scene.setRoot(pinkersOpmerkingen);
            }

            if (controller.getLeerling().getVerkeerstechniekDom().getRichtingaanwijzers() == Toestand.ORANJE) {
                TechniekOpmerkingen pinkersOpmerkingen = new TechniekOpmerkingen(controller.getLeerling().getPinkersOpmerkingen(), controller, "images/verkeersTechniek/pinkersOranje.png", SchermType.VERKEERSTECHNIEK);
                pinkersOpmerkingen.setScene(scene);
                scene.setRoot(pinkersOpmerkingen);
            }

            if (controller.getLeerling().getVerkeerstechniekDom().getRichtingaanwijzers() == Toestand.GROEN) {
                TechniekOpmerkingen pinkersOpmerkingen = new TechniekOpmerkingen(controller.getLeerling().getPinkersOpmerkingen(), controller, "images/verkeersTechniek/pinkersGroen.png", SchermType.VERKEERSTECHNIEK);
                pinkersOpmerkingen.setScene(scene);
                scene.setRoot(pinkersOpmerkingen);
            }

        });

        orderOpvolgenBtn.setOnMouseDragged(e -> {

            if (controller.getLeerling().getVerkeerstechniekDom().getVerkeerstekens() == Toestand.ROOD) {
                TechniekOpmerkingen ordersOpvolgenOpmerkingen = new TechniekOpmerkingen(controller.getLeerling().getOrderOpmerkingen(), controller, "images/verkeersTechniek/ordersRood.png", SchermType.VERKEERSTECHNIEK);
                ordersOpvolgenOpmerkingen.setScene(scene);
                scene.setRoot(ordersOpvolgenOpmerkingen);
            }

            if (controller.getLeerling().getVerkeerstechniekDom().getVerkeerstekens() == Toestand.ORANJE) {
                TechniekOpmerkingen ordersOpvolgenOpmerkingen = new TechniekOpmerkingen(controller.getLeerling().getOrderOpmerkingen(), controller, "images/verkeersTechniek/ordersOranje.png", SchermType.VERKEERSTECHNIEK);
                ordersOpvolgenOpmerkingen.setScene(scene);
                scene.setRoot(ordersOpvolgenOpmerkingen);
            }

            if (controller.getLeerling().getVerkeerstechniekDom().getVerkeerstekens() == Toestand.GROEN) {
                TechniekOpmerkingen ordersOpvolgenOpmerkingen = new TechniekOpmerkingen(controller.getLeerling().getOrderOpmerkingen(), controller, "images/verkeersTechniek/ordersGroen.png", SchermType.VERKEERSTECHNIEK);
                ordersOpvolgenOpmerkingen.setScene(scene);
                scene.setRoot(ordersOpvolgenOpmerkingen);
            }

        });
        snelheidBtn.setOnMouseDragged(e -> {

            if (controller.getLeerling().getVerkeerstechniekDom().getSnelheid() == Toestand.ROOD) {
                TechniekOpmerkingen snelheidOpmerkingen = new TechniekOpmerkingen(controller.getLeerling().getSnelheidOpmerkingen(), controller, "images/verkeersTechniek/snelheidRood.png", SchermType.VERKEERSTECHNIEK);
                snelheidOpmerkingen.setScene(scene);
                scene.setRoot(snelheidOpmerkingen);
            }

            if (controller.getLeerling().getVerkeerstechniekDom().getSnelheid() == Toestand.ORANJE) {
                TechniekOpmerkingen snelheidOpmerkingen = new TechniekOpmerkingen(controller.getLeerling().getSnelheidOpmerkingen(), controller, "images/verkeersTechniek/snelheidOranje.png", SchermType.VERKEERSTECHNIEK);
                snelheidOpmerkingen.setScene(scene);
                scene.setRoot(snelheidOpmerkingen);
            }

            if (controller.getLeerling().getVerkeerstechniekDom().getSnelheid() == Toestand.GROEN) {
                TechniekOpmerkingen snelheidOpmerkingen = new TechniekOpmerkingen(controller.getLeerling().getSnelheidOpmerkingen(), controller, "images/verkeersTechniek/snelheidGroen.png", SchermType.VERKEERSTECHNIEK);
                snelheidOpmerkingen.setScene(scene);
                scene.setRoot(snelheidOpmerkingen);
            }
        });
        afstandBtn.setOnMouseDragged(e -> {

            if (controller.getLeerling().getVerkeerstechniekDom().getAfstandHouden() == Toestand.ROOD) {
                TechniekOpmerkingen afstandOpmerkingen = new TechniekOpmerkingen(controller.getLeerling().getAfstandOpmerkingen(), controller, "images/verkeersTechniek/afstandRood.png", SchermType.VERKEERSTECHNIEK);
                afstandOpmerkingen.setScene(scene);
                scene.setRoot(afstandOpmerkingen);
            }

            if (controller.getLeerling().getVerkeerstechniekDom().getAfstandHouden() == Toestand.ORANJE) {
                TechniekOpmerkingen afstandOpmerkingen = new TechniekOpmerkingen(controller.getLeerling().getAfstandOpmerkingen(), controller, "images/verkeersTechniek/afstandOranje.png", SchermType.VERKEERSTECHNIEK);
                afstandOpmerkingen.setScene(scene);
                scene.setRoot(afstandOpmerkingen);
            }

            if (controller.getLeerling().getVerkeerstechniekDom().getAfstandHouden() == Toestand.GROEN) {
                TechniekOpmerkingen afstandOpmerkingen = new TechniekOpmerkingen(controller.getLeerling().getAfstandOpmerkingen(), controller, "images/verkeersTechniek/afstandGroen.png", SchermType.VERKEERSTECHNIEK);
                afstandOpmerkingen.setScene(scene);
                scene.setRoot(afstandOpmerkingen);
            }
        });

        inhalenBtn.setOnMouseDragged(e -> {

            if (controller.getLeerling().getVerkeerstechniekDom().getInhalen() == Toestand.ROOD) {
                TechniekOpmerkingen inhalenOpmerkingen = new TechniekOpmerkingen(controller.getLeerling().getInhalenOpmerkingen(), controller, "images/verkeersTechniek/inhalenRood.png", SchermType.VERKEERSTECHNIEK);
                inhalenOpmerkingen.setScene(scene);
                scene.setRoot(inhalenOpmerkingen);
            }

            if (controller.getLeerling().getVerkeerstechniekDom().getInhalen() == Toestand.ORANJE) {
                TechniekOpmerkingen inhalenOpmerkingen = new TechniekOpmerkingen(controller.getLeerling().getInhalenOpmerkingen(), controller, "images/verkeersTechniek/inhalenOranje.png", SchermType.VERKEERSTECHNIEK);
                inhalenOpmerkingen.setScene(scene);
                scene.setRoot(inhalenOpmerkingen);
            }

            if (controller.getLeerling().getVerkeerstechniekDom().getInhalen() == Toestand.GROEN) {
                TechniekOpmerkingen inhalenOpmerkingen = new TechniekOpmerkingen(controller.getLeerling().getInhalenOpmerkingen(), controller, "images/verkeersTechniek/inhalenGroen.png", SchermType.VERKEERSTECHNIEK);
                inhalenOpmerkingen.setScene(scene);
                scene.setRoot(inhalenOpmerkingen);
            }
        });

        kruisenlBtn.setOnMouseDragged(e -> {

            if (controller.getLeerling().getVerkeerstechniekDom().getKruisen() == Toestand.ROOD) {
                TechniekOpmerkingen kruisenOpmerkingen = new TechniekOpmerkingen(controller.getLeerling().getKruisenOpmerkingen(), controller, "images/verkeersTechniek/kruisenRood.png", SchermType.VERKEERSTECHNIEK);
                kruisenOpmerkingen.setScene(scene);
                scene.setRoot(kruisenOpmerkingen);
            }

            if (controller.getLeerling().getVerkeerstechniekDom().getKruisen() == Toestand.ORANJE) {
                TechniekOpmerkingen kruisenOpmerkingen = new TechniekOpmerkingen(controller.getLeerling().getKruisenOpmerkingen(), controller, "images/verkeersTechniek/kruisenOranje.png", SchermType.VERKEERSTECHNIEK);
                kruisenOpmerkingen.setScene(scene);
                scene.setRoot(kruisenOpmerkingen);
            }

            if (controller.getLeerling().getVerkeerstechniekDom().getKruisen() == Toestand.GROEN) {
                TechniekOpmerkingen kruisenOpmerkingen = new TechniekOpmerkingen(controller.getLeerling().getKruisenOpmerkingen(), controller, "images/verkeersTechniek/kruisenGroen.png", SchermType.VERKEERSTECHNIEK);
                kruisenOpmerkingen.setScene(scene);
                scene.setRoot(kruisenOpmerkingen);
            }
        });
        linksAfslaanBtn.setOnMouseDragged(e -> {

            if (controller.getLeerling().getVerkeerstechniekDom().getLinksaf() == Toestand.ROOD) {
                TechniekOpmerkingen linksAfOpmerkingen = new TechniekOpmerkingen(controller.getLeerling().getLinksAfslaanOpmerkingen(), controller, "images/verkeersTechniek/linksAfRood.png", SchermType.VERKEERSTECHNIEK);
                linksAfOpmerkingen.setScene(scene);
                scene.setRoot(linksAfOpmerkingen);
            }

            if (controller.getLeerling().getVerkeerstechniekDom().getLinksaf() == Toestand.ORANJE) {
                TechniekOpmerkingen linksAfOpmerkingen = new TechniekOpmerkingen(controller.getLeerling().getLinksAfslaanOpmerkingen(), controller, "images/verkeersTechniek/linksAfOranje.png", SchermType.VERKEERSTECHNIEK);
                linksAfOpmerkingen.setScene(scene);
                scene.setRoot(linksAfOpmerkingen);
            }

            if (controller.getLeerling().getVerkeerstechniekDom().getLinksaf() == Toestand.GROEN) {
                TechniekOpmerkingen linksAfOpmerkingen = new TechniekOpmerkingen(controller.getLeerling().getLinksAfslaanOpmerkingen(), controller, "images/verkeersTechniek/linksAfGroen.png", SchermType.VERKEERSTECHNIEK);
                linksAfOpmerkingen.setScene(scene);
                scene.setRoot(linksAfOpmerkingen);
            }
        });
        rechtsAfslaanBtn.setOnMouseDragged(e -> {

            if (controller.getLeerling().getVerkeerstechniekDom().getRechtsaf() == Toestand.ROOD) {
                TechniekOpmerkingen rechtsAfOpmerkingen = new TechniekOpmerkingen(controller.getLeerling().getRechtsAfslaanOpmerkingen(), controller, "images/verkeersTechniek/rechtsAfRood.png", SchermType.VERKEERSTECHNIEK);
                rechtsAfOpmerkingen.setScene(scene);
                scene.setRoot(rechtsAfOpmerkingen);
            }

            if (controller.getLeerling().getVerkeerstechniekDom().getRechtsaf() == Toestand.ORANJE) {
                TechniekOpmerkingen verkeersTechniek = new TechniekOpmerkingen(controller.getLeerling().getRechtsAfslaanOpmerkingen(), controller, "images/verkeersTechniek/rechtsAfOranje.png", SchermType.VERKEERSTECHNIEK);
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (controller.getLeerling().getVerkeerstechniekDom().getRechtsaf() == Toestand.GROEN) {
                TechniekOpmerkingen verkeersTechniek = new TechniekOpmerkingen(controller.getLeerling().getRechtsAfslaanOpmerkingen(), controller, "images/verkeersTechniek/rechtsAfGroen.png", SchermType.VERKEERSTECHNIEK);
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }
        });
    }

    public void kleurRotonde() {
        kleurRotondeLinks();
        kleurRotondeRechts();
        kleurRotondeBeneden();
    }

    public void kleurRotondeLinks() {
        ImageView rotondeLinks = new ImageView();
        rotondeLinks.setFitWidth(150);
        rotondeLinks.setFitHeight(150);

        if (verkeerstechniekGroup.getChildren().contains(rotondeLinks)) {
            verkeerstechniekGroup.getChildren().remove(rotondeLinks);
        }

        if (controller.getLeerling().getVerkeerstechniekDom().getVerkeerstechniekIcoonLinks() == Toestand.GROEN) {
            Image rotondeGroenLinks = new Image("images/verkeerstechniekIcoon/rotondeGroenLinks.png");
            rotondeLinks.setImage(rotondeGroenLinks);
        } else if (controller.getLeerling().getVerkeerstechniekDom().getVerkeerstechniekIcoonLinks() == Toestand.ORANJE) {
            Image rotondeOranjeLinks = new Image("images/verkeerstechniekIcoon/rotondeOranjeLinks.png");
            rotondeLinks.setImage(rotondeOranjeLinks);
        } else if (controller.getLeerling().getVerkeerstechniekDom().getVerkeerstechniekIcoonLinks() == Toestand.ROOD) {
            Image rotondeRoodLinks = new Image("images/verkeerstechniekIcoon/rotondeRoodLinks.png");
            rotondeLinks.setImage(rotondeRoodLinks);
        }

        verkeerstechniekGroup.getChildren().add(rotondeLinks);
    }

    public void kleurRotondeRechts() {
        ImageView rotondeRechts = new ImageView();
        rotondeRechts.setFitWidth(150);
        rotondeRechts.setFitHeight(150);

        if (verkeerstechniekGroup.getChildren().contains(rotondeRechts)) {
            verkeerstechniekGroup.getChildren().remove(rotondeRechts);
        }

        if (controller.getLeerling().getVerkeerstechniekDom().getVerkeerstechniekIcoonRechts() == Toestand.GROEN) {
            Image rotondeGroenRechts = new Image("images/verkeerstechniekIcoon/rotondeGroenRechts.png");
            rotondeRechts.setImage(rotondeGroenRechts);
        } else if (controller.getLeerling().getVerkeerstechniekDom().getVerkeerstechniekIcoonRechts() == Toestand.ORANJE) {
            Image rotondeOranjeRechts = new Image("images/verkeerstechniekIcoon/rotondeOranjeRechts.png");
            rotondeRechts.setImage(rotondeOranjeRechts);
        } else if (controller.getLeerling().getVerkeerstechniekDom().getVerkeerstechniekIcoonRechts() == Toestand.ROOD) {
            Image rotondeRoodRechts = new Image("images/verkeerstechniekIcoon/rotondeRoodRechts.png");
            rotondeRechts.setImage(rotondeRoodRechts);
        }

        verkeerstechniekGroup.getChildren().add(rotondeRechts);
    }

    public void kleurRotondeBeneden() {
        ImageView rotondeBeneden = new ImageView();
        rotondeBeneden.setFitWidth(150);
        rotondeBeneden.setFitHeight(150);

        if (verkeerstechniekGroup.getChildren().contains(rotondeBeneden)) {
            verkeerstechniekGroup.getChildren().remove(rotondeBeneden);
        }

        if (controller.getLeerling().getVerkeerstechniekDom().getVerkeerstechniekIcoonBeneden() == Toestand.GROEN) {
            Image rotondeGroenBeneden = new Image("images/verkeerstechniekIcoon/rotondeGroenBeneden.png");
            rotondeBeneden.setImage(rotondeGroenBeneden);
        } else if (controller.getLeerling().getVerkeerstechniekDom().getVerkeerstechniekIcoonBeneden() == Toestand.ORANJE) {
            Image rotondeOranjeBeneden = new Image("images/verkeerstechniekIcoon/rotondeOranjeBeneden.png");
            rotondeBeneden.setImage(rotondeOranjeBeneden);
        } else if (controller.getLeerling().getVerkeerstechniekDom().getVerkeerstechniekIcoonBeneden() == Toestand.ROOD) {
            Image rotondeRoodBeneden = new Image("images/verkeerstechniekIcoon/rotondeRoodBeneden.png");
            rotondeBeneden.setImage(rotondeRoodBeneden);
        }

        verkeerstechniekGroup.getChildren().add(rotondeBeneden);
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
