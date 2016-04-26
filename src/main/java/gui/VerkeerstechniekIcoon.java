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

    
}
