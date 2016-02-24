
import gui.Beginscherm;
import gui.Dashboard;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class StartUp extends Application
{

    @Override
    public void start(Stage stage) throws Exception
    {
        Beginscherm beginscherm = new Beginscherm();
        Dashboard dashboard = new Dashboard();
        Scene scene = new Scene(dashboard, 1024, 768);
        stage.setScene(scene);
        stage.setTitle("App rijschool");
        scene.getStylesheets().add("css/Beginscherm.css");
        stage.show();
        
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}
