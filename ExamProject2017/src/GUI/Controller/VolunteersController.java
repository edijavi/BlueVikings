/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VolunteerManager.GUI.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author boldi
 */
public class VolunteersController implements Initializable {

    @FXML
    private ComboBox<?> cmbGuilds;
    @FXML
    private TextField txtFieldSearch;
    @FXML
    private RadioButton rbtnFirstName;
    @FXML
    private RadioButton rbtnLastName;
    @FXML
    private TableView<?> tblAllVol;
    @FXML
    private TableColumn<?, ?> colFirstName;
    @FXML
    private TableColumn<?, ?> colLastName;
    @FXML
    private TableColumn<?, ?> colGuilds;
    @FXML
    private TableColumn<?, ?> colHours;
    @FXML
    private Button btnNewVol;
    @FXML
    private Button btnRemoveVol;
    @FXML
    private Button btnEditVol;
    @FXML
    private Button btnClose;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    @FXML
    private void newVolunteer(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/View/VolunteerDetails.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }
    
    public void fillVolunteer() {
        
        //tblAllVol.setItems(value);
    }
}
