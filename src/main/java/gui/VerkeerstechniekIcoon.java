package gui;

import domein.DomeinController;
import domein.Toestand;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VerkeerstechniekIcoon {

    private DomeinController controller;
    private Group verkeerstechniekGroup;
    private ImageView middenGridImageView;

    public VerkeerstechniekIcoon(DomeinController controller) {
        this.controller = controller;

        verkeerstechniekGroup = new Group();

        Image middenGrid = new Image("images/verkeerstechniekIcoon/verkeerstechniekWit.png");
        middenGridImageView = new ImageView(middenGrid);
        middenGridImageView.setFitWidth(150);
        middenGridImageView.setFitHeight(150);

        verkeerstechniekGroup.getChildren().add(middenGridImageView);
    }

    public Group getVerkeerstechniekGroup() {
        return verkeerstechniekGroup;
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

        if (getVerkeerstechniekIcoonLinks() == Toestand.GROEN) {
            Image rotondeGroenLinks = new Image("images/verkeerstechniekIcoon/rotondeGroenLinks.png");
            rotondeLinks.setImage(rotondeGroenLinks);
        } else if (getVerkeerstechniekIcoonLinks() == Toestand.ORANJE) {
            Image rotondeOranjeLinks = new Image("images/verkeerstechniekIcoon/rotondeOranjeLinks.png");
            rotondeLinks.setImage(rotondeOranjeLinks);
        } else if (getVerkeerstechniekIcoonLinks() == Toestand.ROOD) {
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

        if (getVerkeerstechniekIcoonRechts() == Toestand.GROEN) {
            Image rotondeGroenRechts = new Image("images/verkeerstechniekIcoon/rotondeGroenRechts.png");
            rotondeRechts.setImage(rotondeGroenRechts);
        } else if (getVerkeerstechniekIcoonRechts() == Toestand.ORANJE) {
            Image rotondeOranjeRechts = new Image("images/verkeerstechniekIcoon/rotondeOranjeRechts.png");
            rotondeRechts.setImage(rotondeOranjeRechts);
        } else if (getVerkeerstechniekIcoonRechts() == Toestand.ROOD) {
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

        if (getVerkeerstechniekIcoonBeneden() == Toestand.GROEN) {
            Image rotondeGroenBeneden = new Image("images/verkeerstechniekIcoon/rotondeGroenBeneden.png");
            rotondeBeneden.setImage(rotondeGroenBeneden);
        } else if (getVerkeerstechniekIcoonBeneden() == Toestand.ORANJE) {
            Image rotondeOranjeBeneden = new Image("images/verkeerstechniekIcoon/rotondeOranjeBeneden.png");
            rotondeBeneden.setImage(rotondeOranjeBeneden);
        } else if (getVerkeerstechniekIcoonBeneden() == Toestand.ROOD) {
            Image rotondeRoodBeneden = new Image("images/verkeerstechniekIcoon/rotondeRoodBeneden.png");
            rotondeBeneden.setImage(rotondeRoodBeneden);
        }

        verkeerstechniekGroup.getChildren().add(rotondeBeneden);
    }
    
    private Toestand verkeerstechniekIcoonLinks;

    public Toestand getVerkeerstechniekIcoonLinks() {
        return verkeerstechniekIcoonLinks;
    }

    public void setVerkeerstechniekIcoonLinks(Toestand verkeerstechniekIcoonLinks) {
        this.verkeerstechniekIcoonLinks = verkeerstechniekIcoonLinks;
    }

    public void bepaalToestandLinks() {
        //8 = pinkers
        //5 = kruisen
        //4 = inhalen
        if (controller.getButtonVerkeersTechniek(8).getHuidigeToestand() == Toestand.GROEN 
                && controller.getButtonVerkeersTechniek(5).getHuidigeToestand() == Toestand.GROEN 
                && controller.getButtonVerkeersTechniek(4).getHuidigeToestand() == Toestand.GROEN) {
            setVerkeerstechniekIcoonLinks(Toestand.GROEN);
        } else if (controller.getButtonVerkeersTechniek(8).getHuidigeToestand() == Toestand.ROOD 
                || controller.getButtonVerkeersTechniek(5).getHuidigeToestand() == Toestand.ROOD 
                || controller.getButtonVerkeersTechniek(4).getHuidigeToestand() == Toestand.ROOD) {
            setVerkeerstechniekIcoonLinks(Toestand.ROOD);
        } else {
            setVerkeerstechniekIcoonLinks(Toestand.ORANJE);
        }
    }

    private Toestand verkeerstechniekIcoonRechts;

    public Toestand getVerkeerstechniekIcoonRechts() {
        return verkeerstechniekIcoonRechts;
    }

    public void setVerkeerstechniekIcoonRechts(Toestand verkeerstechniekIcoonRechts) {
        this.verkeerstechniekIcoonRechts = verkeerstechniekIcoonRechts;
    }

    public void bepaalToestandRechts() {
        //9 = OpenbareWeg
        //6 = linksaf
        //7 = rechtsaf
        //3 = afstand
        if (controller.getButtonVerkeersTechniek(9).getHuidigeToestand() == Toestand.GROEN 
                && controller.getButtonVerkeersTechniek(6).getHuidigeToestand() == Toestand.GROEN 
                && controller.getButtonVerkeersTechniek(7).getHuidigeToestand() == Toestand.GROEN 
                && controller.getButtonVerkeersTechniek(3).getHuidigeToestand() == Toestand.GROEN) {
            setVerkeerstechniekIcoonRechts(Toestand.GROEN);
        } else if (controller.getButtonVerkeersTechniek(9).getHuidigeToestand() == Toestand.ROOD 
                || controller.getButtonVerkeersTechniek(6).getHuidigeToestand() == Toestand.ROOD 
                || controller.getButtonVerkeersTechniek(7).getHuidigeToestand() == Toestand.ROOD 
                || controller.getButtonVerkeersTechniek(3).getHuidigeToestand() == Toestand.ROOD) {
            setVerkeerstechniekIcoonRechts(Toestand.ROOD);
        } else {
            setVerkeerstechniekIcoonRechts(Toestand.ORANJE);
        }
    }

    private Toestand verkeerstechniekIcoonBeneden;

    public Toestand getVerkeerstechniekIcoonBeneden() {
        return verkeerstechniekIcoonBeneden;
    }

    public void setVerkeerstechniekIcoonBeneden(Toestand verkeerstechniekIcoonBeneden) {
        this.verkeerstechniekIcoonBeneden = verkeerstechniekIcoonBeneden;
    }

    public void bepaalToestandBeneden() {
        //0 = voorrang
        //1 = orders
        //2 = snelheid
        if (controller.getButtonVerkeersTechniek(0).getHuidigeToestand() == Toestand.GROEN 
                && controller.getButtonVerkeersTechniek(1).getHuidigeToestand() == Toestand.GROEN 
                && controller.getButtonVerkeersTechniek(2).getHuidigeToestand() == Toestand.GROEN) {
            setVerkeerstechniekIcoonBeneden(Toestand.GROEN);
        } else if (controller.getButtonVerkeersTechniek(0).getHuidigeToestand() == Toestand.ROOD 
                || controller.getButtonVerkeersTechniek(1).getHuidigeToestand() == Toestand.ROOD
                || controller.getButtonVerkeersTechniek(2).getHuidigeToestand() == Toestand.ROOD) {
            setVerkeerstechniekIcoonBeneden(Toestand.ROOD);
        } else {
            setVerkeerstechniekIcoonBeneden(Toestand.ORANJE);
        }
    }
}
