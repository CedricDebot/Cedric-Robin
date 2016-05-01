package gui;

import domein.DomeinController;
import domein.Toestand;
import javafx.scene.Group;
import javafx.scene.control.Button;
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
        middenGridImageView.setFitWidth(100);
        middenGridImageView.setFitHeight(100);

        verkeerstechniekGroup.getChildren().add(middenGridImageView);
    }

    public Group getVerkeerstechniekGroup() {
        return verkeerstechniekGroup;
    }
    
    public void kleurRotonde() {
        controller.getIcoonToestanden().bepaalToestandenVerkeerstechniek();
        kleurRotondeLinks();
        kleurRotondeRechts();
        kleurRotondeBeneden();
    }

    public void kleurRotondeLinks() {
        ImageView rotondeLinks = new ImageView();
        rotondeLinks.setFitWidth(100);
        rotondeLinks.setFitHeight(100);

        if (verkeerstechniekGroup.getChildren().contains(rotondeLinks)) {
            verkeerstechniekGroup.getChildren().remove(rotondeLinks);
        }

        if (controller.getIcoonToestanden().getVerkeerstechniekIcoonLinks() == Toestand.GROEN) {
            Image rotondeGroenLinks = new Image("images/verkeerstechniekIcoon/rotondeGroenLinks.png");
            rotondeLinks.setImage(rotondeGroenLinks);
        } else if (controller.getIcoonToestanden().getVerkeerstechniekIcoonLinks() == Toestand.ORANJE) {
            Image rotondeOranjeLinks = new Image("images/verkeerstechniekIcoon/rotondeOranjeLinks.png");
            rotondeLinks.setImage(rotondeOranjeLinks);
        } else if (controller.getIcoonToestanden().getVerkeerstechniekIcoonLinks() == Toestand.ROOD) {
            Image rotondeRoodLinks = new Image("images/verkeerstechniekIcoon/rotondeRoodLinks.png");
            rotondeLinks.setImage(rotondeRoodLinks);
        }else{
            //Doe niets/laat wit
        }

        verkeerstechniekGroup.getChildren().add(rotondeLinks);
    }

    public void kleurRotondeRechts() {
        ImageView rotondeRechts = new ImageView();
        rotondeRechts.setFitWidth(100);
        rotondeRechts.setFitHeight(100);

        if (verkeerstechniekGroup.getChildren().contains(rotondeRechts)) {
            verkeerstechniekGroup.getChildren().remove(rotondeRechts);
        }

        if (controller.getIcoonToestanden().getVerkeerstechniekIcoonRechts() == Toestand.GROEN) {
            Image rotondeGroenRechts = new Image("images/verkeerstechniekIcoon/rotondeGroenRechts.png");
            rotondeRechts.setImage(rotondeGroenRechts);
        } else if (controller.getIcoonToestanden().getVerkeerstechniekIcoonRechts() == Toestand.ORANJE) {
            Image rotondeOranjeRechts = new Image("images/verkeerstechniekIcoon/rotondeOranjeRechts.png");
            rotondeRechts.setImage(rotondeOranjeRechts);
        } else if (controller.getIcoonToestanden().getVerkeerstechniekIcoonRechts() == Toestand.ROOD) {
            Image rotondeRoodRechts = new Image("images/verkeerstechniekIcoon/rotondeRoodRechts.png");
            rotondeRechts.setImage(rotondeRoodRechts);
        }else{
            //doe niets / laat wit
        }

        verkeerstechniekGroup.getChildren().add(rotondeRechts);
    }

    public void kleurRotondeBeneden() {
        ImageView rotondeBeneden = new ImageView();
        rotondeBeneden.setFitWidth(100);
        rotondeBeneden.setFitHeight(100);

        if (verkeerstechniekGroup.getChildren().contains(rotondeBeneden)) {
            verkeerstechniekGroup.getChildren().remove(rotondeBeneden);
        }

        if (controller.getIcoonToestanden().getVerkeerstechniekIcoonBeneden() == Toestand.GROEN) {
            Image rotondeGroenBeneden = new Image("images/verkeerstechniekIcoon/rotondeGroenBeneden.png");
            rotondeBeneden.setImage(rotondeGroenBeneden);
        } else if (controller.getIcoonToestanden().getVerkeerstechniekIcoonBeneden() == Toestand.ORANJE) {
            Image rotondeOranjeBeneden = new Image("images/verkeerstechniekIcoon/rotondeOranjeBeneden.png");
            rotondeBeneden.setImage(rotondeOranjeBeneden);
        } else if (controller.getIcoonToestanden().getVerkeerstechniekIcoonBeneden() == Toestand.ROOD) {
            Image rotondeRoodBeneden = new Image("images/verkeerstechniekIcoon/rotondeRoodBeneden.png");
            rotondeBeneden.setImage(rotondeRoodBeneden);
        }else{
            //doe niets/ laat  wit
        }

        verkeerstechniekGroup.getChildren().add(rotondeBeneden);
    }
    
    public Button getVerkeerstechniekKnop() {
        return new Button("", verkeerstechniekGroup);
    }

    
}
