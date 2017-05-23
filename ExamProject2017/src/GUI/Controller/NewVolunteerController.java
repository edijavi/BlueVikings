/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Volunteer;
import GUI.Model.VolunteerModel;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author boldi
 */
public class NewVolunteerController implements Initializable {

    @FXML
    private Button saveVol;
    @FXML
    private Button btnClose;
    @FXML
    private TextField prefGuild1;
    @FXML
    private TextField prefGuild2;
  
   
    @FXML
    private TextArea AddInfoTxtArea;
    
    VolunteerModel vModel = new VolunteerModel();
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtPhone;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    @FXML
    private void saveVolunteerBtb(ActionEvent event)
    {

        vModel.addVolunteer(txtFirstName.getText(), txtLastName.getText(), txtEmail.getText(), txtPhone.getText(),
                txtAddress.getText(),AddInfoTxtArea.getText());
        Stage stage = null;
        stage = (Stage) btnClose.getScene().getWindow();
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("GUI/View/MainView.fxml"));

            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex)
        {
            Logger.getLogger(VolunteersController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

    public List<Volunteer> VolunteerList()
    {

        return vModel.getlistOfVolunteer();

    }

    @FXML
    private void closeAction(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
    
}
