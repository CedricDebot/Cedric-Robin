package Main;


import gui.Beginscherm;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;



public class StartUp extends Application
{

    @Override
    public void start(Stage stage) throws Exception
    { 
        Rectangle2D bounds = Screen.getPrimary().getBounds();
        Beginscherm beginscherm = new Beginscherm();
        Scene scene = new Scene(beginscherm, bounds.getWidth(), bounds.getHeight());   
        beginscherm.setScene(scene);
        stage.setScene(scene);
        stage.setTitle("App rijschool");
        scene.getStylesheets().add("css/Beginscherm.css");
        stage.show();
        stage.setFullScreen(true); 
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}
