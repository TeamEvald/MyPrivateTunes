package myprivatetunescollection;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Mark, Søren & Daniel.
 */
public class MyPrivateTunesCollection extends Application 
{
    
    @Override
    public void start(Stage stage) throws Exception 
    {
        Parent root = FXMLLoader.load(getClass().getResource("gui/MyPrivateTunesCollection.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("My Private Tunes Collection");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
}