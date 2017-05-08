/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author boldi
 */
public class MainViewController implements Initializable {

    @FXML
    private Button btnVolunteers;
    @FXML
    private Button btnGuilds;
    @FXML
    private Button btnClose;
    @FXML
    private AnchorPane paneItem;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    @FXML
    private void pressedButton(ActionEvent event) {
        Button pressedButton = (Button) event.getSource();
        System.out.println("pressed button: "+event.getSource());
        switch(pressedButton.getId()) {
            case "btnVolunteers":
                try {
                    openItem("/GUI/View/Volunteers.fxml");
                } catch(IOException e) {
                    System.out.println("FXML probably not found");
                    System.out.println(e);
                }
                break;
                
            case "btnGuilds":
                try
                {
                    openItem("/GUI/View/Guilds.fxml");
                } catch(IOException e)
                {
                    System.out.println("FXML probably not found");
                    System.out.println(e);
                }
                break;
            case "btnClose":
                System.exit(0);
                break;
        }
    }
        public void openItem(String url) throws IOException {
        FXMLLoader itemLoader = new FXMLLoader(getClass().getResource(url));
        AnchorPane itemPane = itemLoader.load();
        Object controller = itemLoader.getController();
        paneItem.getChildren().clear();
        paneItem.getChildren().add(itemPane);
    }

    
}

    
    

