package domein;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class OpmerkingListCell extends ListCell<AttitudeOpmerking> {

    private final HBox inhoud;
    private final Label naam;
    private final ImageView uitroepteken;

    public OpmerkingListCell() {
        inhoud = new HBox();
        inhoud.setAlignment(Pos.CENTER_LEFT);
        inhoud.setSpacing(50);
        naam = new Label();
        naam.setMaxWidth(Double.MAX_VALUE);
        inhoud.setHgrow(naam, Priority.ALWAYS);
        uitroepteken = new ImageView("images/uitroepTeken.png");
        uitroepteken.setFitHeight(40);
        uitroepteken.setFitWidth(40);
        uitroepteken.setVisible(false);

        inhoud.getChildren().addAll(naam, uitroepteken);

    }

    @Override
    protected void updateItem(AttitudeOpmerking item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setGraphic(null);
            return;
        }
        
        naam.setText(item.getNaam());
        if(item.isUitroeptekenActive()){
            uitroepteken.setVisible(true);
        }

        setGraphic(inhoud);
    }

}
