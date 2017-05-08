/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import DAL.VolunteerDataManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    
       
    }    

    private void VolunterBtb(ActionEvent event) {
    if (event.getSource() == btnVolunteers) {
            Stage stage = null;
            Parent root = null;
            stage = (Stage) btnVolunteers.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/View/Volunteers.fxml"));
            try {
                root = fxmlLoader.load();
            } catch (IOException ex) {
                Logger.getLogger(VolunteersController.class.getName()).log(Level.SEVERE, null, ex);
            }

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }    

    @FXML
    private void pressedButton(ActionEvent event) {
    }
        
    }

    
    

