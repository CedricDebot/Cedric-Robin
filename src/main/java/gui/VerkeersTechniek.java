package gui;

import domein.AttitudeOpmerking;
import domein.Toestand;
import domein.VerkeerstechniekDom;
import java.util.ArrayList;
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

    private Scene scene;
    private VerkeerstechniekDom verkeerstechniekDom = new VerkeerstechniekDom();
    private ImageView middenGridImageView;
    private Group verkeerstechniekGroup;
    
    public VerkeersTechniek() {
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
        Image voorrangWit = new Image("images/verkeersTechniek/voorrangWit.png");
        ImageView voorrangImageView = new ImageView(voorrangWit);
        voorrangImageView.setFitWidth(50);
        voorrangImageView.setFitHeight(50);
        Button voorrangBtn = new Button("", voorrangImageView);
        voorrangBtn.setId("icoontjesBtns");
        //grid.add(voorrangBtn, 2, 0, 2, 1);

        Image voorrangRood = new Image("images/verkeersTechniek/voorrangRood.png");
        Image voorrangOranje = new Image("images/verkeersTechniek/voorrangOranje.png");
        Image voorrangGroen = new Image("images/verkeersTechniek/voorrangGroen.png");

        voorrangBtn.setOnAction(e -> {
            if (verkeerstechniekDom.getVoorrang() == Toestand.WIT) {
                verkeerstechniekDom.setVoorrang(Toestand.ROOD);
                voorrangImageView.setImage(voorrangRood);
                verkeerstechniekDom.bepaalToestandBeneden();
                kleurRotonde();
            } else if (verkeerstechniekDom.getVoorrang() == Toestand.ROOD) {
                verkeerstechniekDom.setVoorrang(Toestand.ORANJE);
                voorrangImageView.setImage(voorrangOranje);
                verkeerstechniekDom.bepaalToestandBeneden();
                kleurRotonde();
            } else if (verkeerstechniekDom.getVoorrang() == Toestand.ORANJE) {
                verkeerstechniekDom.setVoorrang(Toestand.GROEN);
                voorrangImageView.setImage(voorrangGroen);
                verkeerstechniekDom.bepaalToestandBeneden();
                kleurRotonde();
            } else if (verkeerstechniekDom.getVoorrang() == Toestand.GROEN) {
                verkeerstechniekDom.setVoorrang(Toestand.WIT);
                voorrangImageView.setImage(voorrangWit);
                verkeerstechniekDom.bepaalToestandBeneden();
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
        Image orderOpvolgenWit = new Image("images/verkeersTechniek/ordersWit.png");
        ImageView ordersOpvolgenView = new ImageView(orderOpvolgenWit);
        ordersOpvolgenView.setFitWidth(50);
        ordersOpvolgenView.setFitHeight(50);
        Button orderOpvolgenBtn = new Button("", ordersOpvolgenView);
        orderOpvolgenBtn.setId("icoontjesBtns");
        //grid.add(orderOpvolgenBtn, 4, 1);

        Image orderOpvolgenRood = new Image("images/verkeersTechniek/ordersRood.png");
        Image orderOpvolgenOranje = new Image("images/verkeersTechniek/ordersOranje.png");
        Image orderOpvolgenGroen = new Image("images/verkeersTechniek/ordersGroen.png");

        orderOpvolgenBtn.setOnAction(e -> {
            if (verkeerstechniekDom.getVerkeerstekens() == Toestand.WIT) {
                verkeerstechniekDom.setVerkeerstekens(Toestand.ROOD);
                ordersOpvolgenView.setImage(orderOpvolgenRood);
                verkeerstechniekDom.bepaalToestandBeneden();
                kleurRotonde();
            } else if (verkeerstechniekDom.getVerkeerstekens() == Toestand.ROOD) {
                verkeerstechniekDom.setVerkeerstekens(Toestand.ORANJE);
                ordersOpvolgenView.setImage(orderOpvolgenOranje);
                verkeerstechniekDom.bepaalToestandBeneden();
                kleurRotonde();
            } else if (verkeerstechniekDom.getVerkeerstekens() == Toestand.ORANJE) {
                verkeerstechniekDom.setVerkeerstekens(Toestand.GROEN);
                ordersOpvolgenView.setImage(orderOpvolgenGroen);
                verkeerstechniekDom.bepaalToestandBeneden();
                kleurRotonde();
            } else if (verkeerstechniekDom.getVerkeerstekens() == Toestand.GROEN) {
                verkeerstechniekDom.setVerkeerstekens(Toestand.WIT);
                ordersOpvolgenView.setImage(orderOpvolgenWit);
                verkeerstechniekDom.bepaalToestandBeneden();
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
        Image snelheidWit = new Image("images/verkeersTechniek/snelheidWit.png");
        ImageView snelheidView = new ImageView(snelheidWit);
        snelheidView.setFitWidth(50);
        snelheidView.setFitHeight(50);
        Button snelheidBtn = new Button("", snelheidView);
        snelheidBtn.setId("icoontjesBtns");
        //grid.add(snelheidBtn, 5, 2);

        Image snelheidRood = new Image("images/verkeersTechniek/snelheidRood.png");
        Image snelheidOranje = new Image("images/verkeersTechniek/snelheidOranje.png");
        Image snelheidGroen = new Image("images/verkeersTechniek/snelheidGroen.png");

        snelheidBtn.setOnAction(e -> {
            if (verkeerstechniekDom.getSnelheid() == Toestand.WIT) {
                verkeerstechniekDom.setSnelheid(Toestand.ROOD);
                snelheidView.setImage(snelheidRood);
                verkeerstechniekDom.bepaalToestandBeneden();
                kleurRotonde();
            } else if (verkeerstechniekDom.getSnelheid() == Toestand.ROOD) {
                verkeerstechniekDom.setSnelheid(Toestand.ORANJE);
                snelheidView.setImage(snelheidOranje);
                verkeerstechniekDom.bepaalToestandBeneden();
                kleurRotonde();
            } else if (verkeerstechniekDom.getSnelheid() == Toestand.ORANJE) {
                verkeerstechniekDom.setSnelheid(Toestand.GROEN);
                snelheidView.setImage(snelheidGroen);
                verkeerstechniekDom.bepaalToestandBeneden();
                kleurRotonde();
            } else if (verkeerstechniekDom.getSnelheid() == Toestand.GROEN) {
                verkeerstechniekDom.setSnelheid(Toestand.WIT);
                snelheidView.setImage(snelheidWit);
                verkeerstechniekDom.bepaalToestandBeneden();
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
        Image afstandWit = new Image("images/verkeersTechniek/afstandWit.png");
        ImageView afstandView = new ImageView(afstandWit);
        afstandView.setFitWidth(50);
        afstandView.setFitHeight(50);
        Button afstandBtn = new Button("", afstandView);
        afstandBtn.setId("icoontjesBtns");
        //grid.add(afstandBtn, 5, 3);

        Image afstandRood = new Image("images/verkeersTechniek/afstandRood.png");
        Image afstandOranje = new Image("images/verkeersTechniek/afstandOranje.png");
        Image afstandGroen = new Image("images/verkeersTechniek/afstandGroen.png");

        afstandBtn.setOnAction(e -> {
            if (verkeerstechniekDom.getAfstandHouden() == Toestand.WIT) {
                verkeerstechniekDom.setAfstandHouden(Toestand.ROOD);
                afstandView.setImage(afstandRood);
                verkeerstechniekDom.bepaalToestandRechts();
                kleurRotonde();
            } else if (verkeerstechniekDom.getAfstandHouden() == Toestand.ROOD) {
                verkeerstechniekDom.setAfstandHouden(Toestand.ORANJE);
                afstandView.setImage(afstandOranje);
                verkeerstechniekDom.bepaalToestandRechts();
                kleurRotonde();
            } else if (verkeerstechniekDom.getAfstandHouden() == Toestand.ORANJE) {
                verkeerstechniekDom.setAfstandHouden(Toestand.GROEN);
                afstandView.setImage(afstandGroen);
                verkeerstechniekDom.bepaalToestandRechts();
                kleurRotonde();
            } else if (verkeerstechniekDom.getAfstandHouden() == Toestand.GROEN) {
                verkeerstechniekDom.setAfstandHouden(Toestand.WIT);
                afstandView.setImage(afstandWit);
                verkeerstechniekDom.bepaalToestandRechts();
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
        Image inhalenWit = new Image("images/verkeersTechniek/inhalenWit.png");
        ImageView inhalenView = new ImageView(inhalenWit);
        inhalenView.setFitWidth(50);
        inhalenView.setFitHeight(50);
        Button inhalenBtn = new Button("", inhalenView);
        inhalenBtn.setId("icoontjesBtns");
        //grid.add(voorrang2Btn, 4, 4);

        Image inhalenRood = new Image("images/verkeersTechniek/inhalenRood.png");
        Image inhalenOranje = new Image("images/verkeersTechniek/inhalenOranje.png");
        Image inhalenGroen = new Image("images/verkeersTechniek/inhalenGroen.png");

        inhalenBtn.setOnAction(e -> {
            if (verkeerstechniekDom.getInhalen() == Toestand.WIT) {
                verkeerstechniekDom.setInhalen(Toestand.ROOD);
                inhalenView.setImage(inhalenRood);
                verkeerstechniekDom.bepaalToestandLinks();
                kleurRotonde();
            } else if (verkeerstechniekDom.getInhalen() == Toestand.ROOD) {
                verkeerstechniekDom.setInhalen(Toestand.ORANJE);
                inhalenView.setImage(inhalenOranje);
                verkeerstechniekDom.bepaalToestandLinks();
                kleurRotonde();
            } else if (verkeerstechniekDom.getInhalen() == Toestand.ORANJE) {
                verkeerstechniekDom.setInhalen(Toestand.GROEN);
                inhalenView.setImage(inhalenGroen);
                verkeerstechniekDom.bepaalToestandLinks();
                kleurRotonde();
            } else if (verkeerstechniekDom.getInhalen() == Toestand.GROEN) {
                verkeerstechniekDom.setInhalen(Toestand.WIT);
                inhalenView.setImage(inhalenWit);
                verkeerstechniekDom.bepaalToestandLinks();
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
        Image kruisenWit = new Image("images/verkeersTechniek/kruisenWit.png");
        ImageView kruisenView = new ImageView(kruisenWit);
        kruisenView.setFitWidth(50);
        kruisenView.setFitHeight(50);
        Button kruisenlBtn = new Button("", kruisenView);
        kruisenlBtn.setId("icoontjesBtns");
        //grid.add(groenePijlBtn, 2, 5, 2, 1);

        Image kruisenRood = new Image("images/verkeersTechniek/kruisenRood.png");
        Image kruisenOranje = new Image("images/verkeersTechniek/kruisenOranje.png");
        Image kruisenGroen = new Image("images/verkeersTechniek/kruisenGroen.png");

        kruisenlBtn.setOnAction(e -> {
            if (verkeerstechniekDom.getKruisen() == Toestand.WIT) {
                verkeerstechniekDom.setKruisen(Toestand.ROOD);
                kruisenView.setImage(kruisenRood);
                verkeerstechniekDom.bepaalToestandLinks();
                kleurRotonde();
            } else if (verkeerstechniekDom.getKruisen() == Toestand.ROOD) {
                verkeerstechniekDom.setKruisen(Toestand.ORANJE);
                kruisenView.setImage(kruisenOranje);
                verkeerstechniekDom.bepaalToestandLinks();
                kleurRotonde();
            } else if (verkeerstechniekDom.getKruisen() == Toestand.ORANJE) {
                verkeerstechniekDom.setKruisen(Toestand.GROEN);
                kruisenView.setImage(kruisenGroen);
                verkeerstechniekDom.bepaalToestandLinks();
                kleurRotonde();
            } else if (verkeerstechniekDom.getKruisen() == Toestand.GROEN) {
                verkeerstechniekDom.setKruisen(Toestand.WIT);
                kruisenView.setImage(kruisenWit);
                verkeerstechniekDom.bepaalToestandLinks();
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
        Image linksAfslaanWit = new Image("images/verkeersTechniek/linksAfWit.png");
        ImageView linksAfslaanView = new ImageView(linksAfslaanWit);
        linksAfslaanView.setFitWidth(50);
        linksAfslaanView.setFitHeight(50);
        Button linksAfslaanBtn = new Button("", linksAfslaanView);
        linksAfslaanBtn.setId("icoontjesBtns");
        //grid.add(linksAfslaanBtn, 1, 4);

        Image linksAfslaanRood = new Image("images/verkeersTechniek/linksAfRood.png");
        Image linksAfslaanOranje = new Image("images/verkeersTechniek/linksAfOranje.png");
        Image linksAfslaanGroen = new Image("images/verkeersTechniek/linksAfGroen.png");

        linksAfslaanBtn.setOnAction(e -> {
            if (verkeerstechniekDom.getLinksaf() == Toestand.WIT) {
                verkeerstechniekDom.setLinksaf(Toestand.ROOD);
                linksAfslaanView.setImage(linksAfslaanRood);
                verkeerstechniekDom.bepaalToestandRechts();
                kleurRotonde();
            } else if (verkeerstechniekDom.getLinksaf() == Toestand.ROOD) {
                verkeerstechniekDom.setLinksaf(Toestand.ORANJE);
                linksAfslaanView.setImage(linksAfslaanOranje);
                verkeerstechniekDom.bepaalToestandRechts();
                kleurRotonde();
            } else if (verkeerstechniekDom.getLinksaf() == Toestand.ORANJE) {
                verkeerstechniekDom.setLinksaf(Toestand.GROEN);
                linksAfslaanView.setImage(linksAfslaanGroen);
                verkeerstechniekDom.bepaalToestandRechts();
                kleurRotonde();
            } else if (verkeerstechniekDom.getLinksaf() == Toestand.GROEN) {
                verkeerstechniekDom.setLinksaf(Toestand.WIT);
                linksAfslaanView.setImage(linksAfslaanWit);
                verkeerstechniekDom.bepaalToestandRechts();
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
        Image rechtsAfslaanWit = new Image("images/verkeersTechniek/rechtsAfWit.png");
        ImageView rechtsAfslaanView = new ImageView(rechtsAfslaanWit);
        rechtsAfslaanView.setFitWidth(50);
        rechtsAfslaanView.setFitHeight(50);
        Button rechtsAfslaanBtn = new Button("", rechtsAfslaanView);
        rechtsAfslaanBtn.setId("icoontjesBtns");
        //grid.add(rechtsAfslaanBtn, 0, 3);

        Image rechtsAfslaanRood = new Image("images/verkeersTechniek/rechtsAfRood.png");
        Image rechtsAfslaanOranje = new Image("images/verkeersTechniek/rechtsAfOranje.png");
        Image rechtsAfslaanGroen = new Image("images/verkeersTechniek/rechtsAfGroen.png");

        rechtsAfslaanBtn.setOnAction(e -> {
            if (verkeerstechniekDom.getRechtsaf() == Toestand.WIT) {
                verkeerstechniekDom.setRechtsaf(Toestand.ROOD);
                rechtsAfslaanView.setImage(rechtsAfslaanRood);
                verkeerstechniekDom.bepaalToestandRechts();
                kleurRotonde();
            } else if (verkeerstechniekDom.getRechtsaf() == Toestand.ROOD) {
                verkeerstechniekDom.setRechtsaf(Toestand.ORANJE);
                rechtsAfslaanView.setImage(rechtsAfslaanOranje);
                verkeerstechniekDom.bepaalToestandRechts();
                kleurRotonde();
            } else if (verkeerstechniekDom.getRechtsaf() == Toestand.ORANJE) {
                verkeerstechniekDom.setRechtsaf(Toestand.GROEN);
                rechtsAfslaanView.setImage(rechtsAfslaanGroen);
                verkeerstechniekDom.bepaalToestandRechts();
                kleurRotonde();
            } else if (verkeerstechniekDom.getRechtsaf() == Toestand.GROEN) {
                verkeerstechniekDom.setRechtsaf(Toestand.WIT);
                rechtsAfslaanView.setImage(rechtsAfslaanWit);
                verkeerstechniekDom.bepaalToestandRechts();
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
        Image pinkersWit = new Image("images/verkeersTechniek/pinkersWit.png");
        ImageView pinkersView = new ImageView(pinkersWit);
        pinkersView.setFitWidth(50);
        pinkersView.setFitHeight(50);
        Button pinkersBtn = new Button("", pinkersView);
        pinkersBtn.setId("icoontjesBtns");
        //grid.add(pinkersBtn, 0, 2);

        Image pinkersRood = new Image("images/verkeersTechniek/pinkersRood.png");
        Image pinkersOranje = new Image("images/verkeersTechniek/pinkersOranje.png");
        Image pinkersGroen = new Image("images/verkeersTechniek/pinkersGroen.png");

        pinkersBtn.setOnAction(e -> {
            if (verkeerstechniekDom.getRichtingaanwijzers() == Toestand.WIT) {
                verkeerstechniekDom.setRichtingaanwijzers(Toestand.ROOD);
                pinkersView.setImage(pinkersRood);
                verkeerstechniekDom.bepaalToestandLinks();
                kleurRotonde();
            } else if (verkeerstechniekDom.getRichtingaanwijzers() == Toestand.ROOD) {
                verkeerstechniekDom.setRichtingaanwijzers(Toestand.ORANJE);
                pinkersView.setImage(pinkersOranje);
                verkeerstechniekDom.bepaalToestandLinks();
                kleurRotonde();
            } else if (verkeerstechniekDom.getRichtingaanwijzers() == Toestand.ORANJE) {
                verkeerstechniekDom.setRichtingaanwijzers(Toestand.GROEN);
                pinkersView.setImage(pinkersGroen);
                verkeerstechniekDom.bepaalToestandLinks();
                kleurRotonde();
            } else if (verkeerstechniekDom.getRichtingaanwijzers() == Toestand.GROEN) {
                verkeerstechniekDom.setRichtingaanwijzers(Toestand.WIT);
                pinkersView.setImage(pinkersWit);
                verkeerstechniekDom.bepaalToestandLinks();
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
        Image OWWit = new Image("images/verkeersTechniek/OWWit.png");
        ImageView OWView = new ImageView(OWWit);
        OWView.setFitWidth(50);
        OWView.setFitHeight(50);
        Button OWBtn = new Button("", OWView);
        OWBtn.setId("icoontjesBtns");
        //grid.add(OWBtn, 1, 1);

        Image OWRood = new Image("images/verkeersTechniek/OWRood.png");
        Image OWOranje = new Image("images/verkeersTechniek/OWOranje.png");
        Image OWGroen = new Image("images/verkeersTechniek/OWGroen.png");

        OWBtn.setOnAction(e -> {
            if (verkeerstechniekDom.getOpenbareWeg() == Toestand.WIT) {
                verkeerstechniekDom.setOpenbareWeg(Toestand.ROOD);
                OWView.setImage(OWRood);
                verkeerstechniekDom.bepaalToestandRechts();
                kleurRotonde();
            } else if (verkeerstechniekDom.getOpenbareWeg() == Toestand.ROOD) {
                verkeerstechniekDom.setOpenbareWeg(Toestand.ORANJE);
                OWView.setImage(OWOranje);
                verkeerstechniekDom.bepaalToestandRechts();
                kleurRotonde();
            } else if (verkeerstechniekDom.getOpenbareWeg() == Toestand.ORANJE) {
                verkeerstechniekDom.setOpenbareWeg(Toestand.GROEN);
                OWView.setImage(OWGroen);
                verkeerstechniekDom.bepaalToestandRechts();
                kleurRotonde();
            } else if (verkeerstechniekDom.getOpenbareWeg() == Toestand.GROEN) {
                verkeerstechniekDom.setOpenbareWeg(Toestand.WIT);
                OWView.setImage(OWWit);
                verkeerstechniekDom.bepaalToestandRechts();
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
            menu.setScene(scene);
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

        //Opmerkingen
        voorrangBtn.setOnMouseDragged(e -> {
            ArrayList<AttitudeOpmerking> VoorrangOpmerkingen = new ArrayList<>();

            AttitudeOpmerking Voorrang = new AttitudeOpmerking("Voorrang", "");
            VoorrangOpmerkingen.add(Voorrang);

            if (verkeerstechniekDom.getVoorrang() == Toestand.ROOD) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(VoorrangOpmerkingen, "images/verkeersTechniek/voorrangRood.png");
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (verkeerstechniekDom.getVoorrang() == Toestand.ORANJE) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(VoorrangOpmerkingen, "images/verkeersTechniek/voorrangOranje.png");
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (verkeerstechniekDom.getVoorrang() == Toestand.GROEN) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(VoorrangOpmerkingen, "images/verkeersTechniek/voorrangGroen.png");
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }
        });

        OWBtn.setOnMouseDragged(e -> {
            ArrayList<AttitudeOpmerking> OwOpmerkingen = new ArrayList<>();

            AttitudeOpmerking Openbaar = new AttitudeOpmerking("Openbare weg", "");
            AttitudeOpmerking voorsorteren = new AttitudeOpmerking("Voorsorteren", "");

            OwOpmerkingen.add(Openbaar);
            OwOpmerkingen.add(voorsorteren);

            if (verkeerstechniekDom.getOpenbareWeg() == Toestand.ROOD) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(OwOpmerkingen, "images/verkeersTechniek/OWRood.png");
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (verkeerstechniekDom.getOpenbareWeg() == Toestand.ORANJE) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(OwOpmerkingen, "images/verkeersTechniek/OWOranje.png");
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (verkeerstechniekDom.getOpenbareWeg() == Toestand.GROEN) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(OwOpmerkingen, "images/verkeersTechniek/OWGroen.png");
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }
        });
        pinkersBtn.setOnMouseDragged(e -> {
            ArrayList<AttitudeOpmerking> PinkersOpmerkingen = new ArrayList<>();

            AttitudeOpmerking gebruik = new AttitudeOpmerking("Gebruik", "");
            AttitudeOpmerking tijdig = new AttitudeOpmerking("Tijdig aangeven", "");

            PinkersOpmerkingen.add(gebruik);
            PinkersOpmerkingen.add(tijdig);

            if (verkeerstechniekDom.getRichtingaanwijzers() == Toestand.ROOD) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(PinkersOpmerkingen, "images/verkeersTechniek/pinkersRood.png");
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (verkeerstechniekDom.getRichtingaanwijzers() == Toestand.ORANJE) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(PinkersOpmerkingen, "images/verkeersTechniek/pinkersOranje.png");
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (verkeerstechniekDom.getRichtingaanwijzers() == Toestand.GROEN) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(PinkersOpmerkingen, "images/verkeersTechniek/pinkersGroen.png");
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

        });

        orderOpvolgenBtn.setOnMouseDragged(e -> {
            ArrayList<AttitudeOpmerking> orderOpmerkingen = new ArrayList<>();

            AttitudeOpmerking verkeerstekens = new AttitudeOpmerking("Verkeerstekens", "");
            AttitudeOpmerking bevelen = new AttitudeOpmerking("Bevelen", "");

            orderOpmerkingen.add(verkeerstekens);
            orderOpmerkingen.add(bevelen);

            if (verkeerstechniekDom.getVerkeerstekens() == Toestand.ROOD) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(orderOpmerkingen, "images/verkeersTechniek/ordersRood.png");
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (verkeerstechniekDom.getVerkeerstekens() == Toestand.ORANJE) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(orderOpmerkingen, "images/verkeersTechniek/ordersOranje.png");
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (verkeerstechniekDom.getVerkeerstekens() == Toestand.GROEN) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(orderOpmerkingen, "images/verkeersTechniek/ordersGroen.png");
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

        });
        snelheidBtn.setOnMouseDragged(e -> {
            ArrayList<AttitudeOpmerking> snelheidOpmerkingen = new ArrayList<>();

            AttitudeOpmerking snelheid = new AttitudeOpmerking("Snelheid", "");

            snelheidOpmerkingen.add(snelheid);

            if (verkeerstechniekDom.getSnelheid() == Toestand.ROOD) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(snelheidOpmerkingen, "images/verkeersTechniek/snelheidRood.png");
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (verkeerstechniekDom.getSnelheid() == Toestand.ORANJE) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(snelheidOpmerkingen, "images/verkeersTechniek/snelheidOranje.png");
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (verkeerstechniekDom.getSnelheid() == Toestand.GROEN) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(snelheidOpmerkingen, "images/verkeersTechniek/snelheidGroen.png");
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }
        });
        afstandBtn.setOnMouseDragged(e -> {
            ArrayList<AttitudeOpmerking> afstandOpmerkingen = new ArrayList<>();

            AttitudeOpmerking volgAfstand = new AttitudeOpmerking("Volgafstand", "");
            AttitudeOpmerking zijdeAfstand = new AttitudeOpmerking("Zijdelingse afstand", "");

            afstandOpmerkingen.add(volgAfstand);
            afstandOpmerkingen.add(zijdeAfstand);

            if (verkeerstechniekDom.getAfstandHouden() == Toestand.ROOD) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(afstandOpmerkingen, "images/verkeersTechniek/afstandRood.png");
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (verkeerstechniekDom.getAfstandHouden() == Toestand.ORANJE) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(afstandOpmerkingen, "images/verkeersTechniek/afstandOranje.png");
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (verkeerstechniekDom.getAfstandHouden() == Toestand.GROEN) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(afstandOpmerkingen, "images/verkeersTechniek/afstandGroen.png");
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }
        });

        inhalenBtn.setOnMouseDragged(e -> {
            ArrayList<AttitudeOpmerking> inhalenOpmerkingen = new ArrayList<>();

            AttitudeOpmerking inhalen = new AttitudeOpmerking("Inhalen", "");
            AttitudeOpmerking voorbijrijden = new AttitudeOpmerking("Voorbijrijden", "");

            inhalenOpmerkingen.add(inhalen);
            inhalenOpmerkingen.add(voorbijrijden);

            if (verkeerstechniekDom.getInhalen() == Toestand.ROOD) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(inhalenOpmerkingen, "images/verkeersTechniek/inhalenRood.png");
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (verkeerstechniekDom.getInhalen() == Toestand.ORANJE) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(inhalenOpmerkingen, "images/verkeersTechniek/inhalenOranje.png");
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (verkeerstechniekDom.getInhalen() == Toestand.GROEN) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(inhalenOpmerkingen, "images/verkeersTechniek/inhalenGroen.png");
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }
        });

        kruisenlBtn.setOnMouseDragged(e -> {
            ArrayList<AttitudeOpmerking> kruisenOpmerkingen = new ArrayList<>();

            AttitudeOpmerking kruisen = new AttitudeOpmerking("Kruisen", "");

            kruisenOpmerkingen.add(kruisen);

            if (verkeerstechniekDom.getKruisen() == Toestand.ROOD) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(kruisenOpmerkingen, "images/verkeersTechniek/kruisenRood.png");
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (verkeerstechniekDom.getKruisen() == Toestand.ORANJE) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(kruisenOpmerkingen, "images/verkeersTechniek/kruisenOranje.png");
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (verkeerstechniekDom.getKruisen() == Toestand.GROEN) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(kruisenOpmerkingen, "images/verkeersTechniek/kruisenGroen.png");
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }
        });
        linksAfslaanBtn.setOnMouseDragged(e -> {
            ArrayList<AttitudeOpmerking> linksAfslaanOpmerkingen = new ArrayList<>();

            AttitudeOpmerking linksafslaan = new AttitudeOpmerking("Linksaf", "");
            AttitudeOpmerking opstelling = new AttitudeOpmerking("Opstelling", "");
            AttitudeOpmerking uitvoering = new AttitudeOpmerking("Uitvoering", "");

            linksAfslaanOpmerkingen.add(linksafslaan);
            linksAfslaanOpmerkingen.add(opstelling);
            linksAfslaanOpmerkingen.add(uitvoering);

            if (verkeerstechniekDom.getLinksaf() == Toestand.ROOD) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(linksAfslaanOpmerkingen, "images/verkeersTechniek/linksAfRood.png");
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (verkeerstechniekDom.getLinksaf() == Toestand.ORANJE) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(linksAfslaanOpmerkingen, "images/verkeersTechniek/linksAfOranje.png");
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (verkeerstechniekDom.getLinksaf() == Toestand.GROEN) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(linksAfslaanOpmerkingen, "images/verkeersTechniek/linksAfGroen.png");
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }
        });
        rechtsAfslaanBtn.setOnMouseDragged(e -> {
            ArrayList<AttitudeOpmerking> rechtsAfslaanOpmerkingen = new ArrayList<>();

            AttitudeOpmerking rechtsaf = new AttitudeOpmerking("Rechtsaf", "");
            AttitudeOpmerking opstelling = new AttitudeOpmerking("Opstelling", "");
            AttitudeOpmerking uitvoering = new AttitudeOpmerking("Uitvoering", "");

            rechtsAfslaanOpmerkingen.add(rechtsaf);
            rechtsAfslaanOpmerkingen.add(opstelling);
            rechtsAfslaanOpmerkingen.add(uitvoering);

            if (verkeerstechniekDom.getRechtsaf() == Toestand.ROOD) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(rechtsAfslaanOpmerkingen, "images/verkeersTechniek/rechtsAfRood.png");
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (verkeerstechniekDom.getRechtsaf() == Toestand.ORANJE) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(rechtsAfslaanOpmerkingen, "images/verkeersTechniek/rechtsAfOranje.png");
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (verkeerstechniekDom.getRechtsaf() == Toestand.GROEN) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(rechtsAfslaanOpmerkingen, "images/verkeersTechniek/rechtsAfGroen.png");
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
        
        if(verkeerstechniekGroup.getChildren().contains(rotondeLinks)){
            verkeerstechniekGroup.getChildren().remove(rotondeLinks);
        }
        
        if(verkeerstechniekDom.getVerkeerstechniekIcoonLinks() == Toestand.GROEN){
            Image rotondeGroenLinks = new Image("images/verkeerstechniekIcoon/rotondeGroenLinks.png");
            rotondeLinks.setImage(rotondeGroenLinks);
        }else if(verkeerstechniekDom.getVerkeerstechniekIcoonLinks() == Toestand.ORANJE){
            Image rotondeOranjeLinks = new Image("images/verkeerstechniekIcoon/rotondeOranjeLinks.png");
            rotondeLinks.setImage(rotondeOranjeLinks);
        }else if (verkeerstechniekDom.getVerkeerstechniekIcoonLinks() == Toestand.ROOD){
            Image rotondeRoodLinks = new Image("images/verkeerstechniekIcoon/rotondeRoodLinks.png");
            rotondeLinks.setImage(rotondeRoodLinks);
        }
                  
        verkeerstechniekGroup.getChildren().add(rotondeLinks);
    }

    public void kleurRotondeRechts() {
        ImageView rotondeRechts = new ImageView();
        rotondeRechts.setFitWidth(150);
        rotondeRechts.setFitHeight(150);
        
        if(verkeerstechniekGroup.getChildren().contains(rotondeRechts)){
            verkeerstechniekGroup.getChildren().remove(rotondeRechts);
        }
        
        if(verkeerstechniekDom.getVerkeerstechniekIcoonRechts() == Toestand.GROEN){
            Image rotondeGroenRechts =  new Image("images/verkeerstechniekIcoon/rotondeGroenRechts.png");
            rotondeRechts.setImage(rotondeGroenRechts);
        }else if(verkeerstechniekDom.getVerkeerstechniekIcoonRechts() == Toestand.ORANJE){
            Image rotondeOranjeRechts = new Image("images/verkeerstechniekIcoon/rotondeOranjeRechts.png");
            rotondeRechts.setImage(rotondeOranjeRechts);
        }else if(verkeerstechniekDom.getVerkeerstechniekIcoonRechts() == Toestand.ROOD){
            Image rotondeRoodRechts = new Image("images/verkeerstechniekIcoon/rotondeRoodRechts.png");
            rotondeRechts.setImage(rotondeRoodRechts);
        }
        
        verkeerstechniekGroup.getChildren().add(rotondeRechts);
    }

    public void kleurRotondeBeneden() {
        ImageView rotondeBeneden = new ImageView();
        rotondeBeneden.setFitWidth(150);
        rotondeBeneden.setFitHeight(150);
        
        if(verkeerstechniekGroup.getChildren().contains(rotondeBeneden)){
            verkeerstechniekGroup.getChildren().remove(rotondeBeneden);
        }
        
        if(verkeerstechniekDom.getVerkeerstechniekIcoonBeneden() == Toestand.GROEN){
            Image rotondeGroenBeneden = new Image("images/verkeerstechniekIcoon/rotondeGroenBeneden.png");
            rotondeBeneden.setImage(rotondeGroenBeneden);
        }else if(verkeerstechniekDom.getVerkeerstechniekIcoonBeneden() == Toestand.ORANJE){
            Image rotondeOranjeBeneden = new Image("images/verkeerstechniekIcoon/rotondeOranjeBeneden.png");
            rotondeBeneden.setImage(rotondeOranjeBeneden);
        }else if(verkeerstechniekDom.getVerkeerstechniekIcoonBeneden() == Toestand.ROOD){
            Image rotondeRoodBeneden =  new Image("images/verkeerstechniekIcoon/rotondeRoodBeneden.png");
            rotondeBeneden.setImage(rotondeRoodBeneden);
        }
        
        verkeerstechniekGroup.getChildren().add(rotondeBeneden);
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
