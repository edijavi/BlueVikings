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
    private Button btnEdit;
    @FXML
    private TextField prefGuild1;
    @FXML
    private TextField prefGuild2;
    @FXML
    private TextField prefGuild3;
    @FXML
    private TextField Address;
    @FXML
    private TextField EmailAddress;
    @FXML
    private TextField lastName;
    @FXML
    private TextField firstName;
    @FXML
    private TextField PhoneNumber;
    @FXML
    private TextArea AddInfoTxtArea;
    
    VolunteerModel vModel = new VolunteerModel();

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
        Volunteer volunteer = new Volunteer();
        volunteer.setAddress(Address.getText());
        volunteer.setEmail(EmailAddress.getText());
        volunteer.setFirstName(firstName.getText());
        volunteer.setLastName(lastName.getText());
        volunteer.setPhoneNumber(PhoneNumber.getText());
        volunteer.setAdditionalInfo(AddInfoTxtArea.getText());
        // VolunteerList().add(volunteer);
        vModel.addVolunteer(firstName.getText(), lastName.getText(), EmailAddress.getText(), PhoneNumber.getText(),
                Address.getText(),AddInfoTxtArea.getText());
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
