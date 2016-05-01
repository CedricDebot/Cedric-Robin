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
}
