package myprivatetunescollection.gui.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Mark, Søren & Daniel.
 */
public class MyPrivateTunesCollectionController implements Initializable 
{
    private ObservableList list = FXCollections.observableArrayList();
    
    @FXML
    private Button previousBtn;
    @FXML
    private Button playBtn;
    @FXML
    private Button nextBtn;
    @FXML
    private Label speakerLbl;
    @FXML
    private Button searchBtn;
    @FXML
    private Button upBtn;
    @FXML
    private Button downBtn;
    @FXML
    private Button leftBtn;
    @FXML
    private ListView<String> playList;
    
    public MyPrivateTunesCollectionController()
    {
        
    }
    
    @FXML
    private void setImageAudioPlayerButtons() throws MalformedURLException
    {
        Path dir = FileSystems.getDefault().getPath("./src/images/Previous-icon.png");
        Image image = new Image(dir.toUri().toURL().toExternalForm());
        previousBtn.setGraphic(new ImageView(image));
        
        Path dir1 = FileSystems.getDefault().getPath("./src/images/Play-icon.png");
        Image image1 = new Image(dir1.toUri().toURL().toExternalForm());
        playBtn.setGraphic(new ImageView(image1));
        
        Path dir2 = FileSystems.getDefault().getPath("./src/images/Next-icon.png");
        Image image2 = new Image(dir2.toUri().toURL().toExternalForm());
        nextBtn.setGraphic(new ImageView(image2));
        
        Path dir3 = FileSystems.getDefault().getPath("./src/images/Speaker-icon.png");
        Image image3 = new Image(dir3.toUri().toURL().toExternalForm());
        speakerLbl.setGraphic(new ImageView(image3));
    }
    
    @FXML
    private void setImagePlaylistSearchButtons() throws MalformedURLException{
        Path dir = FileSystems.getDefault().getPath("./src/images/Arrow-up.jpg");
        Image image = new Image(dir.toUri().toURL().toExternalForm());
        upBtn.setGraphic(new ImageView(image));
        
        Path dir1 = FileSystems.getDefault().getPath("./src/images/Arrow-down.png");
        Image image1 = new Image(dir1.toUri().toURL().toExternalForm());
        downBtn.setGraphic(new ImageView(image1));
        
        Path dir2 = FileSystems.getDefault().getPath("./src/images/Arrow-left.png");
        Image image2 = new Image(dir2.toUri().toURL().toExternalForm());
        leftBtn.setGraphic(new ImageView(image2));
        
        Path dir3 = FileSystems.getDefault().getPath("./src/images/Search-icon.png");
        Image image3 = new Image(dir3.toUri().toURL().toExternalForm());
        searchBtn.setGraphic(new ImageView(image3));
    }
    
    @FXML
    private void handleNewEditSongButtonAction(ActionEvent event) throws IOException{
        Stage newEditSongWindow = new Stage();
        newEditSongWindow.initModality(Modality.NONE);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NewEditSong.fxml"));
        Parent root = loader.load();
        NewEditSongController nsc = loader.getController();
        nsc.setParentWindowController(this);
        
        Scene scene = new Scene(root);
        newEditSongWindow.setTitle("New / Edit Song");
        newEditSongWindow.setScene(scene);
        newEditSongWindow.showAndWait();
    }
    
    @FXML
    private void handleNewEditPlayListButtonAction(ActionEvent event) throws IOException{
        Stage newEditPlaylistWindow = new Stage();
        newEditPlaylistWindow.initModality(Modality.NONE);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NewEditPlayList.fxml"));
        Parent root = loader.load();
        NewEditPlayListController npc = loader.getController();
        npc.setParentWindowController(this);
        
        Scene scene = new Scene(root);
        newEditPlaylistWindow.setTitle("New / Edit Playlist");
        newEditPlaylistWindow.setScene(scene);
        newEditPlaylistWindow.showAndWait();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            setImagePlaylistSearchButtons();
            setImageAudioPlayerButtons();
        } catch (IOException ex) {
            Logger.getLogger(MyPrivateTunesCollectionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addPlaylist(String name){
        list.removeAll(list);
        String a = "Name \t\t Songs \t   Time";
        list.addAll(a, name);
        playList.getItems().addAll(list);
        //createNewPlayList();
    }
    
    private void createNewPlayList(){
        String b = "Party";
        String c = "Game";
        String d = "Score Music";
        String e = "Holiday";
        String f = "Driving";
        list.addAll(b, c, d, e, f);
        playList.getItems().addAll(list);
    }
}