package gui;

import domein.ButtonTechniekDomein;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Robin
 */
public class ButtonTechniek extends HBox {

    private ImageView imageView;
    private Button button;
    private ButtonTechniekDomein btnDomein;

    public ButtonTechniek(ButtonTechniekDomein btnDomein, boolean eva) {
        this.btnDomein = btnDomein;

        Image image = new Image(btnDomein.getHuidigeKleur());
        imageView = new ImageView(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        button = new Button("", imageView);
        button.setId("icoontjesBtns");

//        controller.getLeerling().getRijtechniekDom().bepaalToestandBoven();
//                kleurStuur();
        button.setOnAction(e -> {
            btnDomein.volgendeKleur();
            imageView.setImage(new Image(btnDomein.getHuidigeKleur()));
        });

        Rectangle rectangle1 = new Rectangle(12, 12, btnDomein.getRectangle1());

        Rectangle rectangle2 = new Rectangle(12, 12, btnDomein.getRectangle2());

        Rectangle rectangle3 = new Rectangle(12, 12, btnDomein.getRectangle3());

        VBox EvaMomenten = new VBox();
        EvaMomenten.setId("evamomenten");

        EvaMomenten.getChildren().addAll(rectangle1, rectangle2, rectangle3);

        if(eva){
            getChildren().addAll(button, EvaMomenten);
        }else{
            getChildren().addAll(button);
        }
        

    }

    public Button getButton() {
        return button;
    }

    public String getKleur() {
        return btnDomein.getHuidigeKleur();
    }

    public boolean isGekleurd() {
        return btnDomein.isGekleurd();
    }

}
