package gui;

import domein.AttitudeOpmerking;
import domein.Leerling;
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

/**
 *
 * @author Robin
 */
public class VerkeersTechniek extends HBox {

    private Scene scene;
//    private VerkeerstechniekDom verkeerstechniekDom = new VerkeerstechniekDom();

    public VerkeersTechniek(Dashboard dashboard) {
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
        Image voorrangBegin = new Image("images/verkeersTechniek/voorrang" +  dashboard.getLeerling().getVerkeerstechniekDom().getVoorrang()+ ".png");
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
            if (dashboard.getLeerling().getVerkeerstechniekDom().getVoorrang() == Toestand.WIT) {
                dashboard.getLeerling().getVerkeerstechniekDom().setVoorrang(Toestand.ROOD);
                voorrangImageView.setImage(voorrangRood);
            } else if (dashboard.getLeerling().getVerkeerstechniekDom().getVoorrang() == Toestand.ROOD) {
                dashboard.getLeerling().getVerkeerstechniekDom().setVoorrang(Toestand.ORANJE);
                voorrangImageView.setImage(voorrangOranje);
            } else if (dashboard.getLeerling().getVerkeerstechniekDom().getVoorrang() == Toestand.ORANJE) {
                dashboard.getLeerling().getVerkeerstechniekDom().setVoorrang(Toestand.GROEN);
                voorrangImageView.setImage(voorrangGroen);
            } else if (dashboard.getLeerling().getVerkeerstechniekDom().getVoorrang() == Toestand.GROEN) {
                dashboard.getLeerling().getVerkeerstechniekDom().setVoorrang(Toestand.WIT);
                voorrangImageView.setImage(voorrangWit);
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
        Image orderOpvolgenBegin = new Image("images/verkeersTechniek/orders" +  dashboard.getLeerling().getVerkeerstechniekDom().getVerkeerstekens()+ ".png");
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
            if (dashboard.getLeerling().getVerkeerstechniekDom().getVerkeerstekens() == Toestand.WIT) {
                dashboard.getLeerling().getVerkeerstechniekDom().setVerkeerstekens(Toestand.ROOD);
                ordersOpvolgenView.setImage(orderOpvolgenRood);
            } else if (dashboard.getLeerling().getVerkeerstechniekDom().getVerkeerstekens() == Toestand.ROOD) {
                dashboard.getLeerling().getVerkeerstechniekDom().setVerkeerstekens(Toestand.ORANJE);
                ordersOpvolgenView.setImage(orderOpvolgenOranje);
            } else if (dashboard.getLeerling().getVerkeerstechniekDom().getVerkeerstekens() == Toestand.ORANJE) {
                dashboard.getLeerling().getVerkeerstechniekDom().setVerkeerstekens(Toestand.GROEN);
                ordersOpvolgenView.setImage(orderOpvolgenGroen);
            } else if (dashboard.getLeerling().getVerkeerstechniekDom().getVerkeerstekens() == Toestand.GROEN) {
                dashboard.getLeerling().getVerkeerstechniekDom().setVerkeerstekens(Toestand.WIT);
                ordersOpvolgenView.setImage(orderOpvolgenWit);
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
        Image snelheidBegin = new Image("images/verkeersTechniek/snelheid" +  dashboard.getLeerling().getVerkeerstechniekDom().getSnelheid()+ ".png");
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
            if (dashboard.getLeerling().getVerkeerstechniekDom().getSnelheid() == Toestand.WIT) {
                dashboard.getLeerling().getVerkeerstechniekDom().setSnelheid(Toestand.ROOD);
                snelheidView.setImage(snelheidRood);
            } else if (dashboard.getLeerling().getVerkeerstechniekDom().getSnelheid() == Toestand.ROOD) {
                dashboard.getLeerling().getVerkeerstechniekDom().setSnelheid(Toestand.ORANJE);
                snelheidView.setImage(snelheidOranje);
            } else if (dashboard.getLeerling().getVerkeerstechniekDom().getSnelheid() == Toestand.ORANJE) {
                dashboard.getLeerling().getVerkeerstechniekDom().setSnelheid(Toestand.GROEN);
                snelheidView.setImage(snelheidGroen);
            } else if (dashboard.getLeerling().getVerkeerstechniekDom().getSnelheid() == Toestand.GROEN) {
                dashboard.getLeerling().getVerkeerstechniekDom().setSnelheid(Toestand.WIT);
                snelheidView.setImage(snelheidWit);
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
        Image afstandBegin = new Image("images/verkeersTechniek/afstand" +  dashboard.getLeerling().getVerkeerstechniekDom().getAfstandHouden()+ ".png");
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
            if (dashboard.getLeerling().getVerkeerstechniekDom().getAfstandHouden() == Toestand.WIT) {
                dashboard.getLeerling().getVerkeerstechniekDom().setAfstandHouden(Toestand.ROOD);
                afstandView.setImage(afstandRood);
            } else if (dashboard.getLeerling().getVerkeerstechniekDom().getAfstandHouden() == Toestand.ROOD) {
                dashboard.getLeerling().getVerkeerstechniekDom().setAfstandHouden(Toestand.ORANJE);
                afstandView.setImage(afstandOranje);
            } else if (dashboard.getLeerling().getVerkeerstechniekDom().getAfstandHouden() == Toestand.ORANJE) {
                dashboard.getLeerling().getVerkeerstechniekDom().setAfstandHouden(Toestand.GROEN);
                afstandView.setImage(afstandGroen);
            } else if (dashboard.getLeerling().getVerkeerstechniekDom().getAfstandHouden() == Toestand.GROEN) {
                dashboard.getLeerling().getVerkeerstechniekDom().setAfstandHouden(Toestand.WIT);
                afstandView.setImage(afstandWit);
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
        Image inhalenBegin = new Image("images/verkeersTechniek/inhalen" +  dashboard.getLeerling().getVerkeerstechniekDom().getInhalen()+ ".png");
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
            if (dashboard.getLeerling().getVerkeerstechniekDom().getInhalen() == Toestand.WIT) {
                dashboard.getLeerling().getVerkeerstechniekDom().setInhalen(Toestand.ROOD);
                inhalenView.setImage(inhalenRood);
            } else if (dashboard.getLeerling().getVerkeerstechniekDom().getInhalen() == Toestand.ROOD) {
                dashboard.getLeerling().getVerkeerstechniekDom().setInhalen(Toestand.ORANJE);
                inhalenView.setImage(inhalenOranje);
            } else if (dashboard.getLeerling().getVerkeerstechniekDom().getInhalen() == Toestand.ORANJE) {
                dashboard.getLeerling().getVerkeerstechniekDom().setInhalen(Toestand.GROEN);
                inhalenView.setImage(inhalenGroen);
            } else if (dashboard.getLeerling().getVerkeerstechniekDom().getInhalen() == Toestand.GROEN) {
                dashboard.getLeerling().getVerkeerstechniekDom().setInhalen(Toestand.WIT);
                inhalenView.setImage(inhalenWit);
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
        Image kruisenBegin = new Image("images/verkeersTechniek/kruisen" +  dashboard.getLeerling().getVerkeerstechniekDom().getKruisen()+ ".png");
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
            if (dashboard.getLeerling().getVerkeerstechniekDom().getKruisen() == Toestand.WIT) {
                dashboard.getLeerling().getVerkeerstechniekDom().setKruisen(Toestand.ROOD);
                kruisenView.setImage(kruisenRood);
            } else if (dashboard.getLeerling().getVerkeerstechniekDom().getKruisen() == Toestand.ROOD) {
                dashboard.getLeerling().getVerkeerstechniekDom().setKruisen(Toestand.ORANJE);
                kruisenView.setImage(kruisenOranje);
            } else if (dashboard.getLeerling().getVerkeerstechniekDom().getKruisen() == Toestand.ORANJE) {
                dashboard.getLeerling().getVerkeerstechniekDom().setKruisen(Toestand.GROEN);
                kruisenView.setImage(kruisenGroen);
            } else if (dashboard.getLeerling().getVerkeerstechniekDom().getKruisen() == Toestand.GROEN) {
                dashboard.getLeerling().getVerkeerstechniekDom().setKruisen(Toestand.WIT);
                kruisenView.setImage(kruisenWit);
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
        Image linksAfslaanBegin = new Image("images/verkeersTechniek/linksAf" +  dashboard.getLeerling().getVerkeerstechniekDom().getLinksaf()+ ".png");
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
            if (dashboard.getLeerling().getVerkeerstechniekDom().getLinksaf() == Toestand.WIT) {
                dashboard.getLeerling().getVerkeerstechniekDom().setLinksaf(Toestand.ROOD);
                linksAfslaanView.setImage(linksAfslaanRood);
            } else if (dashboard.getLeerling().getVerkeerstechniekDom().getLinksaf() == Toestand.ROOD) {
                dashboard.getLeerling().getVerkeerstechniekDom().setLinksaf(Toestand.ORANJE);
                linksAfslaanView.setImage(linksAfslaanOranje);
            } else if (dashboard.getLeerling().getVerkeerstechniekDom().getLinksaf() == Toestand.ORANJE) {
                dashboard.getLeerling().getVerkeerstechniekDom().setLinksaf(Toestand.GROEN);
                linksAfslaanView.setImage(linksAfslaanGroen);
            } else if (dashboard.getLeerling().getVerkeerstechniekDom().getLinksaf() == Toestand.GROEN) {
                dashboard.getLeerling().getVerkeerstechniekDom().setLinksaf(Toestand.WIT);
                linksAfslaanView.setImage(linksAfslaanWit);
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
        Image rechtsAfslaanBegin = new Image("images/verkeersTechniek/rechtsAf" +  dashboard.getLeerling().getVerkeerstechniekDom().getRechtsaf()+ ".png");
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
            if (dashboard.getLeerling().getVerkeerstechniekDom().getRechtsaf() == Toestand.WIT) {
                dashboard.getLeerling().getVerkeerstechniekDom().setRechtsaf(Toestand.ROOD);
                rechtsAfslaanView.setImage(rechtsAfslaanRood);
            } else if (dashboard.getLeerling().getVerkeerstechniekDom().getRechtsaf() == Toestand.ROOD) {
                dashboard.getLeerling().getVerkeerstechniekDom().setRechtsaf(Toestand.ORANJE);
                rechtsAfslaanView.setImage(rechtsAfslaanOranje);
            } else if (dashboard.getLeerling().getVerkeerstechniekDom().getRechtsaf() == Toestand.ORANJE) {
                dashboard.getLeerling().getVerkeerstechniekDom().setRechtsaf(Toestand.GROEN);
                rechtsAfslaanView.setImage(rechtsAfslaanGroen);
            } else if (dashboard.getLeerling().getVerkeerstechniekDom().getRechtsaf() == Toestand.GROEN) {
                dashboard.getLeerling().getVerkeerstechniekDom().setRechtsaf(Toestand.WIT);
                rechtsAfslaanView.setImage(rechtsAfslaanWit);
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
        Image pinkersBegin = new Image("images/verkeersTechniek/pinkers" +  dashboard.getLeerling().getVerkeerstechniekDom().getRichtingaanwijzers()+ ".png");
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
            if (dashboard.getLeerling().getVerkeerstechniekDom().getRichtingaanwijzers() == Toestand.WIT) {
                dashboard.getLeerling().getVerkeerstechniekDom().setRichtingaanwijzers(Toestand.ROOD);
                pinkersView.setImage(pinkersRood);
            } else if (dashboard.getLeerling().getVerkeerstechniekDom().getRichtingaanwijzers() == Toestand.ROOD) {
                dashboard.getLeerling().getVerkeerstechniekDom().setRichtingaanwijzers(Toestand.ORANJE);
                pinkersView.setImage(pinkersOranje);
            } else if (dashboard.getLeerling().getVerkeerstechniekDom().getRichtingaanwijzers() == Toestand.ORANJE) {
                dashboard.getLeerling().getVerkeerstechniekDom().setRichtingaanwijzers(Toestand.GROEN);
                pinkersView.setImage(pinkersGroen);
            } else if (dashboard.getLeerling().getVerkeerstechniekDom().getRichtingaanwijzers() == Toestand.GROEN) {
                dashboard.getLeerling().getVerkeerstechniekDom().setRichtingaanwijzers(Toestand.WIT);
                pinkersView.setImage(pinkersWit);
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
        Image OWBegin = new Image("images/verkeersTechniek/OW" +  dashboard.getLeerling().getVerkeerstechniekDom().getOpenbareWeg()+ ".png");
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
            if (dashboard.getLeerling().getVerkeerstechniekDom().getOpenbareWeg() == Toestand.WIT) {
                dashboard.getLeerling().getVerkeerstechniekDom().setOpenbareWeg(Toestand.ROOD);
                OWView.setImage(OWRood);
            } else if (dashboard.getLeerling().getVerkeerstechniekDom().getOpenbareWeg() == Toestand.ROOD) {
                dashboard.getLeerling().getVerkeerstechniekDom().setOpenbareWeg(Toestand.ORANJE);
                OWView.setImage(OWOranje);
            } else if (dashboard.getLeerling().getVerkeerstechniekDom().getOpenbareWeg() == Toestand.ORANJE) {
                dashboard.getLeerling().getVerkeerstechniekDom().setOpenbareWeg(Toestand.GROEN);
                OWView.setImage(OWGroen);
            } else if (dashboard.getLeerling().getVerkeerstechniekDom().getOpenbareWeg() == Toestand.GROEN) {
                dashboard.getLeerling().getVerkeerstechniekDom().setOpenbareWeg(Toestand.WIT);
                OWView.setImage(OWWit);
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

        Image middenGrid = new Image("images/verkeerstechniekWit.png");
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
        VBox menuStandaard = menu.buildMenuStandaard(dashboard.getLeerling());

        right.getChildren().add(menuStandaard);

        VBox menuBalk = menu.buildMenu(dashboard);

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
            ArrayList<AttitudeOpmerking> VoorrangOpmerkingen = new ArrayList<>();

            AttitudeOpmerking Voorrang = new AttitudeOpmerking("Voorrang", "");
            VoorrangOpmerkingen.add(Voorrang);

            if (dashboard.getLeerling().getVerkeerstechniekDom().getVoorrang() == Toestand.ROOD) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(VoorrangOpmerkingen, "images/verkeersTechniek/voorrangRood.png", dashboard);
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (dashboard.getLeerling().getVerkeerstechniekDom().getVoorrang() == Toestand.ORANJE) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(VoorrangOpmerkingen, "images/verkeersTechniek/voorrangOranje.png", dashboard);
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (dashboard.getLeerling().getVerkeerstechniekDom().getVoorrang() == Toestand.GROEN) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(VoorrangOpmerkingen, "images/verkeersTechniek/voorrangGroen.png", dashboard);
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

            if (dashboard.getLeerling().getVerkeerstechniekDom().getOpenbareWeg() == Toestand.ROOD) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(OwOpmerkingen, "images/verkeersTechniek/OWRood.png", dashboard);
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (dashboard.getLeerling().getVerkeerstechniekDom().getOpenbareWeg() == Toestand.ORANJE) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(OwOpmerkingen, "images/verkeersTechniek/OWOranje.png", dashboard);
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (dashboard.getLeerling().getVerkeerstechniekDom().getOpenbareWeg() == Toestand.GROEN) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(OwOpmerkingen, "images/verkeersTechniek/OWGroen.png", dashboard);
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

            if (dashboard.getLeerling().getVerkeerstechniekDom().getRichtingaanwijzers() == Toestand.ROOD) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(PinkersOpmerkingen, "images/verkeersTechniek/pinkersRood.png", dashboard);
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (dashboard.getLeerling().getVerkeerstechniekDom().getRichtingaanwijzers() == Toestand.ORANJE) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(PinkersOpmerkingen, "images/verkeersTechniek/pinkersOranje.png", dashboard);
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (dashboard.getLeerling().getVerkeerstechniekDom().getRichtingaanwijzers() == Toestand.GROEN) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(PinkersOpmerkingen, "images/verkeersTechniek/pinkersGroen.png", dashboard);
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

            if (dashboard.getLeerling().getVerkeerstechniekDom().getVerkeerstekens() == Toestand.ROOD) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(orderOpmerkingen, "images/verkeersTechniek/ordersRood.png", dashboard);
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (dashboard.getLeerling().getVerkeerstechniekDom().getVerkeerstekens() == Toestand.ORANJE) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(orderOpmerkingen, "images/verkeersTechniek/ordersOranje.png", dashboard);
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (dashboard.getLeerling().getVerkeerstechniekDom().getVerkeerstekens() == Toestand.GROEN) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(orderOpmerkingen, "images/verkeersTechniek/ordersGroen.png", dashboard);
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

        });
        snelheidBtn.setOnMouseDragged(e -> {
            ArrayList<AttitudeOpmerking> snelheidOpmerkingen = new ArrayList<>();

            AttitudeOpmerking snelheid = new AttitudeOpmerking("Snelheid", "");

            snelheidOpmerkingen.add(snelheid);

            if (dashboard.getLeerling().getVerkeerstechniekDom().getSnelheid() == Toestand.ROOD) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(snelheidOpmerkingen, "images/verkeersTechniek/snelheidRood.png", dashboard);
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (dashboard.getLeerling().getVerkeerstechniekDom().getSnelheid() == Toestand.ORANJE) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(snelheidOpmerkingen, "images/verkeersTechniek/snelheidOranje.png", dashboard);
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (dashboard.getLeerling().getVerkeerstechniekDom().getSnelheid() == Toestand.GROEN) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(snelheidOpmerkingen, "images/verkeersTechniek/snelheidGroen.png", dashboard);
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

            if (dashboard.getLeerling().getVerkeerstechniekDom().getAfstandHouden() == Toestand.ROOD) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(afstandOpmerkingen, "images/verkeersTechniek/afstandRood.png", dashboard);
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (dashboard.getLeerling().getVerkeerstechniekDom().getAfstandHouden() == Toestand.ORANJE) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(afstandOpmerkingen, "images/verkeersTechniek/afstandOranje.png", dashboard);
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (dashboard.getLeerling().getVerkeerstechniekDom().getAfstandHouden() == Toestand.GROEN) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(afstandOpmerkingen, "images/verkeersTechniek/afstandGroen.png", dashboard);
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

            if (dashboard.getLeerling().getVerkeerstechniekDom().getInhalen() == Toestand.ROOD) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(inhalenOpmerkingen, "images/verkeersTechniek/inhalenRood.png", dashboard);
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (dashboard.getLeerling().getVerkeerstechniekDom().getInhalen() == Toestand.ORANJE) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(inhalenOpmerkingen, "images/verkeersTechniek/inhalenOranje.png", dashboard);
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (dashboard.getLeerling().getVerkeerstechniekDom().getInhalen() == Toestand.GROEN) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(inhalenOpmerkingen, "images/verkeersTechniek/inhalenGroen.png", dashboard);
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }
        });

        kruisenlBtn.setOnMouseDragged(e -> {
            ArrayList<AttitudeOpmerking> kruisenOpmerkingen = new ArrayList<>();

            AttitudeOpmerking kruisen = new AttitudeOpmerking("Kruisen", "");

            kruisenOpmerkingen.add(kruisen);

            if (dashboard.getLeerling().getVerkeerstechniekDom().getKruisen() == Toestand.ROOD) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(kruisenOpmerkingen, "images/verkeersTechniek/kruisenRood.png", dashboard);
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (dashboard.getLeerling().getVerkeerstechniekDom().getKruisen() == Toestand.ORANJE) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(kruisenOpmerkingen, "images/verkeersTechniek/kruisenOranje.png", dashboard);
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (dashboard.getLeerling().getVerkeerstechniekDom().getKruisen() == Toestand.GROEN) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(kruisenOpmerkingen, "images/verkeersTechniek/kruisenGroen.png", dashboard);
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

            if (dashboard.getLeerling().getVerkeerstechniekDom().getLinksaf() == Toestand.ROOD) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(linksAfslaanOpmerkingen, "images/verkeersTechniek/linksAfRood.png", dashboard);
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (dashboard.getLeerling().getVerkeerstechniekDom().getLinksaf() == Toestand.ORANJE) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(linksAfslaanOpmerkingen, "images/verkeersTechniek/linksAfOranje.png", dashboard);
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }

            if (dashboard.getLeerling().getVerkeerstechniekDom().getLinksaf() == Toestand.GROEN) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(linksAfslaanOpmerkingen, "images/verkeersTechniek/linksAfGroen.png", dashboard);
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

            if (dashboard.getLeerling().getVerkeerstechniekDom().getRechtsaf() == Toestand.ROOD) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(rechtsAfslaanOpmerkingen, "images/verkeersTechniek/rechtsAfRood.png", dashboard);
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }
            
            if (dashboard.getLeerling().getVerkeerstechniekDom().getRechtsaf() == Toestand.ORANJE) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(rechtsAfslaanOpmerkingen, "images/verkeersTechniek/rechtsAfOranje.png", dashboard);
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }
            
            if (dashboard.getLeerling().getVerkeerstechniekDom().getRechtsaf() == Toestand.GROEN) {
                VerkeersTechniekOpmerkingen verkeersTechniek = new VerkeersTechniekOpmerkingen(rechtsAfslaanOpmerkingen, "images/verkeersTechniek/rechtsAfGroen.png", dashboard);
                verkeersTechniek.setScene(scene);
                scene.setRoot(verkeersTechniek);
            }
        });

    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
