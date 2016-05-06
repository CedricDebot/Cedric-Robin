package domein;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class OpmerkingListCell extends ListCell<AttitudeOpmerking> {

    private final HBox inhoud;
    private final Label naam;
    private final ImageView uitroepteken;
    private final Button uitroeptekenBtn;
    private DomeinController controller;

    public OpmerkingListCell(DomeinController controller) {
        this.controller = controller;
        inhoud = new HBox();
        inhoud.setAlignment(Pos.CENTER_LEFT);
        inhoud.setSpacing(50);
        naam = new Label();
        naam.setId("cellNaam");
        naam.setMaxWidth(Double.MAX_VALUE);
        inhoud.setHgrow(naam, Priority.ALWAYS);
        uitroepteken = new ImageView("images/uitroepTeken.png");
        uitroepteken.setFitHeight(40);
        uitroepteken.setFitWidth(40);
        uitroeptekenBtn = new Button("", uitroepteken);
        uitroeptekenBtn.setId("uitroeptekenBtn");

        inhoud.getChildren().addAll(naam, uitroeptekenBtn);

    }

    @Override
    protected void updateItem(AttitudeOpmerking item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setGraphic(null);
            return;
        }

        naam.setText(item.getNaam());
        if (item.isUitroeptekenActive()) {
            Image uitroeptekenImage = new Image("images/uitroepTekenActive2.png");
            uitroepteken.setImage(uitroeptekenImage);
        }
        
        uitroeptekenBtn.setOnAction(e -> {
            if (item.isUitroeptekenActive()) {
                item.setUitroeptekenActive(false);
                controller.getLeerling().getRecenteOpmerkingen().remove(item);
                Image uitroeptekenImage = new Image("images/uitroepTeken.png");
                uitroepteken.setImage(uitroeptekenImage);
            } else {
                item.setUitroeptekenActive(true);
                controller.getLeerling().getRecenteOpmerkingen().add(item);
                Image uitroeptekenImage = new Image("images/uitroepTekenActive2.png");
                uitroepteken.setImage(uitroeptekenImage);
            }
        });

        setGraphic(inhoud);
    }

}
