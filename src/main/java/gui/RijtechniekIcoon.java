package gui;

import domein.DomeinController;
import domein.Toestand;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RijtechniekIcoon {

    private DomeinController controller;
    private Group rijtechniekIcoonGroup;
    private ImageView middenGridImageView;

    public RijtechniekIcoon(DomeinController controller) {
        this.controller = controller;

        rijtechniekIcoonGroup = new Group();

        Image middenGrid = new Image("images/rijtechniekIcoon/stuurWit.png");
        middenGridImageView = new ImageView(middenGrid);
        middenGridImageView.setFitWidth(100);
        middenGridImageView.setFitHeight(100);

        rijtechniekIcoonGroup.getChildren().add(middenGridImageView);
    }

    public Group getRijtechniekIcoonGroup() {
        return rijtechniekIcoonGroup;
    }

    public void setRijtechniekIcoonGroup(Group rijtechniekIcoonGroup) {
        this.rijtechniekIcoonGroup = rijtechniekIcoonGroup;
    }

    public void kleurStuur() {
        kleurStuurBoven();
        kleurStuurRechts();
        kleurStuurLinks();
    }
    
    
    private Toestand rijtechniekIcoonBoven = Toestand.WIT;
    private Toestand rijtechniekIcoonLinks = Toestand.WIT;
    private Toestand rijtechniekIcoonRechts = Toestand.WIT;

    public Toestand getRijtechniekIcoonBoven() {
        return rijtechniekIcoonBoven;
    }

    public void setRijtechniekIcoonBoven(Toestand rijtechniekIcoonBoven) {
        this.rijtechniekIcoonBoven = rijtechniekIcoonBoven;
    }

    public Toestand getRijtechniekIcoonLinks() {
        return rijtechniekIcoonLinks;
    }

    public void setRijtechniekIcoonLinks(Toestand rijtechniekIcoonLinks) {
        this.rijtechniekIcoonLinks = rijtechniekIcoonLinks;
    }

    public Toestand getRijtechniekIcoonRechts() {
        return rijtechniekIcoonRechts;
    }

    public void setRijtechniekIcoonRechts(Toestand rijtechniekIcoonRechts) {
        this.rijtechniekIcoonRechts = rijtechniekIcoonRechts;
    }
    

    public void kleurStuurBoven() {
        ImageView stuurBoven = new ImageView();
        stuurBoven.setFitWidth(150);
        stuurBoven.setFitHeight(150);
        if (rijtechniekIcoonGroup.getChildren().contains(stuurBoven)) {
            rijtechniekIcoonGroup.getChildren().remove(stuurBoven);
        }
        
        if (getRijtechniekIcoonBoven() == Toestand.GROEN) {
            Image stuurGroenBoven = new Image("images/rijtechniekIcoon/stuurGroenBoven.png");
            stuurBoven.setImage(stuurGroenBoven);
        } else if (getRijtechniekIcoonBoven() == Toestand.ORANJE) {
            Image stuurOranjeBoven = new Image("images/rijtechniekIcoon/stuurOranjeBoven.png");
            stuurBoven.setImage(stuurOranjeBoven);
        }
        rijtechniekIcoonGroup.getChildren().add(stuurBoven);
    }

    public void kleurStuurRechts() {
        ImageView stuurRechts = new ImageView();
        stuurRechts.setFitWidth(150);
        stuurRechts.setFitHeight(150);
        if (rijtechniekIcoonGroup.getChildren().contains(stuurRechts)) {
            rijtechniekIcoonGroup.getChildren().remove(stuurRechts);
        }

        if (getRijtechniekIcoonRechts() == Toestand.GROEN) {
            Image stuurGroenRechts = new Image("images/rijtechniekIcoon/stuurGroenRechts.png");
            stuurRechts.setImage(stuurGroenRechts);
        } else if (getRijtechniekIcoonRechts() == Toestand.ORANJE) {
            Image stuurOranjeRechts = new Image("images/rijtechniekIcoon/stuurOranjeRechts.png");
            stuurRechts.setImage(stuurOranjeRechts);
        }

        rijtechniekIcoonGroup.getChildren().add(stuurRechts);
    }

    public void kleurStuurLinks() {
        ImageView stuurLinks = new ImageView();
        stuurLinks.setFitWidth(150);
        stuurLinks.setFitHeight(150);
        if (rijtechniekIcoonGroup.getChildren().contains(stuurLinks)) {
            rijtechniekIcoonGroup.getChildren().remove(stuurLinks);
        }

        if (getRijtechniekIcoonLinks() == Toestand.GROEN) {
            Image stuurGroenLinks = new Image("images/rijtechniekIcoon/stuurGroenLinks.png");
            stuurLinks.setImage(stuurGroenLinks);
        } else if (getRijtechniekIcoonLinks() == Toestand.ORANJE) {
            Image stuurOranjeLinks = new Image("images/rijtechniekIcoon/stuurOranjeLinks.png");
            stuurLinks.setImage(stuurOranjeLinks);
        }

        rijtechniekIcoonGroup.getChildren().add(stuurLinks);
    }
    

    public void bepaalToestandBoven() {
        //10 = zithouding
        //0 = koppelng
        //11 = remtechniek
        //1 = stuur
        //2 = schakelen
        //3 = kijken
        if (controller.getButtonRijTechniek(10).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonRijTechniek(0).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonRijTechniek(11).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonRijTechniek(1).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonRijTechniek(2).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonRijTechniek(3).getHuidigeToestand() == Toestand.GROEN) {
            setRijtechniekIcoonBoven(Toestand.GROEN);
        } else {
            setRijtechniekIcoonBoven(Toestand.ORANJE);
        }
    }


    public void bepaalToestandRechts() {
        // 4 = parkeren
        // 5 = keren

        if (controller.getButtonRijTechniek(4).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonRijTechniek(5).getHuidigeToestand() == Toestand.GROEN) {
            setRijtechniekIcoonRechts(Toestand.GROEN);
        } else {
            setRijtechniekIcoonRechts(Toestand.ORANJE);
        }
    }

    public void bepaalToestandLinks() {
        //6 = garage
        //7 = achteruit
        //8 = acht
        //9 = helling
        if (controller.getButtonRijTechniek(6).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonRijTechniek(7).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonRijTechniek(8).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonRijTechniek(9).getHuidigeToestand() == Toestand.GROEN) {
            setRijtechniekIcoonLinks(Toestand.GROEN);
        } else {
            setRijtechniekIcoonLinks(Toestand.ORANJE);
        }
    }
}
