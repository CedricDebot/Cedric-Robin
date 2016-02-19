package gui;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Dashboard extends HBox
{

    public Dashboard()
    {         
        getChildren().add(buildGui());
    }

    public HBox buildGui()
    {
        HBox rootDashboard = new HBox();
        
        rootDashboard.getChildren().addAll(right());
        
        return rootDashboard;
    }

    public VBox right()
    {
        VBox right = new VBox(); 
        right.setId("dashboardRight");
      
        Image fotoLeerling = new Image("images/character.png");
        ImageView leerlingImageView = new ImageView(fotoLeerling);
        leerlingImageView.setId("leerlingImageView");
        
        //lay-out (nog proberen in css te zetten)
        leerlingImageView.setFitWidth(120);
        leerlingImageView.setFitHeight(150);
        
        Label naamLeerling = new Label("Jules");
        naamLeerling.setId("lblNaamLeerling");        

      //Inner border

      HBox hBox_inner = new HBox();

      //Outter border

      HBox hBox_outter = new HBox();
      hBox_outter.setId("hBox_outterImage");
      
      hBox_inner.getChildren().add(leerlingImageView);
      hBox_outter.getChildren().add(hBox_inner);
     
      right.getChildren().addAll(hBox_outter, naamLeerling);
      
      return right;  
    }

}
