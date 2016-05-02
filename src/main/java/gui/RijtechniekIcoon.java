package gui;

import domein.DomeinController;
import domein.Toestand;
import javafx.scene.Group;
import javafx.scene.control.Button;
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

    public void kleurStuur() {
        controller.getIcoonToestanden().bepaalToestandenRijtechniek();
        kleurStuurBoven();
        kleurStuurRechts();
        kleurStuurLinks();
    }

    public void kleurStuurBoven() {
        ImageView stuurBoven = new ImageView();
        stuurBoven.setFitWidth(100);
        stuurBoven.setFitHeight(100);
        if (rijtechniekIcoonGroup.getChildren().contains(stuurBoven)) {
            rijtechniekIcoonGroup.getChildren().remove(stuurBoven);
        }

        if (controller.getIcoonToestanden().getRijtechniekIcoonBoven() == Toestand.GROEN) {
            Image stuurGroenBoven = new Image("images/rijtechniekIcoon/stuurGroenBoven.png");
            stuurBoven.setImage(stuurGroenBoven);
        } else if (controller.getIcoonToestanden().getRijtechniekIcoonBoven() == Toestand.ORANJE) {
            Image stuurOranjeBoven = new Image("images/rijtechniekIcoon/stuurOranjeBoven.png");
            stuurBoven.setImage(stuurOranjeBoven);
        } else {
            //Doe niets/ laat wit
        }
        rijtechniekIcoonGroup.getChildren().add(stuurBoven);
    }

    public void kleurStuurRechts() {
        ImageView stuurRechts = new ImageView();
        stuurRechts.setFitWidth(100);
        stuurRechts.setFitHeight(100);
        if (rijtechniekIcoonGroup.getChildren().contains(stuurRechts)) {
            rijtechniekIcoonGroup.getChildren().remove(stuurRechts);
        }

        if (controller.getIcoonToestanden().getRijtechniekIcoonRechts() == Toestand.GROEN) {
            Image stuurGroenRechts = new Image("images/rijtechniekIcoon/stuurGroenRechts.png");
            stuurRechts.setImage(stuurGroenRechts);
        } else if (controller.getIcoonToestanden().getRijtechniekIcoonRechts() == Toestand.ORANJE) {
            Image stuurOranjeRechts = new Image("images/rijtechniekIcoon/stuurOranjeRechts.png");
            stuurRechts.setImage(stuurOranjeRechts);
        } else {
            //Doe niets / laat wit
        }

        rijtechniekIcoonGroup.getChildren().add(stuurRechts);
    }

    public void kleurStuurLinks() {
        ImageView stuurLinks = new ImageView();
        stuurLinks.setFitWidth(100);
        stuurLinks.setFitHeight(100);
        if (rijtechniekIcoonGroup.getChildren().contains(stuurLinks)) {
            rijtechniekIcoonGroup.getChildren().remove(stuurLinks);
        }

        if (controller.getIcoonToestanden().getRijtechniekIcoonLinks() == Toestand.GROEN) {
            Image stuurGroenLinks = new Image("images/rijtechniekIcoon/stuurGroenLinks.png");
            stuurLinks.setImage(stuurGroenLinks);
        } else if (controller.getIcoonToestanden().getRijtechniekIcoonLinks() == Toestand.ORANJE) {
            Image stuurOranjeLinks = new Image("images/rijtechniekIcoon/stuurOranjeLinks.png");
            stuurLinks.setImage(stuurOranjeLinks);
        } else {
            //doe niets, laat wit
        }

        rijtechniekIcoonGroup.getChildren().add(stuurLinks);
    }

    public Button getRijtechniekKnop() {
        return new Button("", rijtechniekIcoonGroup);
    }

    public Group getRijtechniekIcoonGroup() {
        return rijtechniekIcoonGroup;
    }

    public void setRijtechniekIcoonGroup(Group rijtechniekIcoonGroup) {
        this.rijtechniekIcoonGroup = rijtechniekIcoonGroup;
    }

}
