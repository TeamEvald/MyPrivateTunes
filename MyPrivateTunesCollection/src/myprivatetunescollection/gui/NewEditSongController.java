package myprivatetunescollection.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Daniel K. Edwards
 */
public class NewEditSongController implements Initializable {
    
    private MyPrivateTunesCollectionController parent;
    
    public void setParentWindowController(MyPrivateTunesCollectionController parent){
        this.parent = parent;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}