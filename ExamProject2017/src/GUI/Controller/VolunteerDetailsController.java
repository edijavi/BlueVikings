/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Volunteer;
import GUI.Model.ManagerModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import GUI.Model.VolunteerModel;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author boldi
 */
public class VolunteerDetailsController implements Initializable
{

    @FXML
    private TextField Address;   
    @FXML
    private TextField EmailAddress;   
    @FXML
    private TextField PhoneNumber;   
    @FXML
    private TextField lastName;  
    @FXML
    private TextField firstName;   
    @FXML
    private Button saveVol;
    @FXML
    private Button btnClose;
    @FXML
    private TextArea AddInfoTxtArea;
    @FXML
    private TextField prefGuild3;
    @FXML
    private TextField prefGuild1;
    @FXML
    private TextField prefGuild2;
    @FXML
    private Button btnEdit;
    @FXML
    private Button saveI;
    @FXML
    private ImageView imageV;
    
    private static Volunteer vol;

    VolunteerModel vModel = new VolunteerModel();
    ManagerModel MM = new ManagerModel();
   
    public VolunteerDetailsController()
    {

    }    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        setVolunteerItems();        
    }
    /**
    * Close button Action, closes the window.
    * @param event 
    */
    @FXML
    private void closeAction(ActionEvent event)
    {
        Stage closeStage = (Stage) btnClose.getScene().getWindow();
        closeStage.close();
        
    }
    /**
     * Opens an Information alert window which says that you successfully edited the selected volunteer.
     * Jesper
     * @param event 
     */
    @FXML
    private void saveVolunteerBtb(ActionEvent event)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        Stage Iconstage = (Stage) alert.getDialogPane().getScene().getWindow();
        Iconstage.getIcons().add(new Image("CSS/icon.png"));
        alert.setTitle("Successfully Edited");
        alert.setContentText("You edited "+ firstName.getText() + " " + lastName.getText());
        alert.show();
        vModel.updateVolunteer(firstName.getText(), lastName.getText(), EmailAddress.getText(), PhoneNumber.getText(),
        Address.getText(),AddInfoTxtArea.getText(), vol.getVolunteerId());
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
    public List<Volunteer> VolunteerList()
    {
        return vModel.getlistOfVolunteer();
    }

    public void setVolunteerFirstName()
    {
        vol.setFirstName(firstName.getText());
    }
    public void setVolunteerLastName()
    {
        vol.setLastName(lastName.getText());
    }
    public void setVolunteerEmail()
    {
        vol.setEmail(EmailAddress.getText());
    }
    public void setVolunteerPhoneNumber()
    {
        vol.setPhoneNumber(PhoneNumber.getText());
    }
    public void setVolunteerAddress()
    {
        vol.setAddress(Address.getText());
    }
    /**
     * Loads all the information of the selected volunteer to the text fields and sets all of them disabled.
     */
    private void setVolunteerItems()
    { 
        EmailAddress.setText(vol.getEmail());
        Address.setText(vol.getAddress());
        firstName.setText(vol.getFirstName());
        lastName.setText(vol.getLastName());
        PhoneNumber.setText(vol.getPhoneNumber());
        EmailAddress.setDisable(true);
        Address.setDisable(true);
        firstName.setDisable(true);
        lastName.setDisable(true);
        PhoneNumber.setDisable(true);
        prefGuild1.setDisable(true);
        prefGuild2.setDisable(true);
        prefGuild3.setDisable(true);
        AddInfoTxtArea.setDisable(true);
    }
   /**
    * We use this method to get the information of the selected volunteer from the volunteer view and load it here.  
    * @param mann 
    */
    public static void setVolunteer(Volunteer voll)
    {
    vol = voll;
    }
    /**
     * Sets all the text fields enable to edit.
     * @param event 
     */
    @FXML
    public void editAction(ActionEvent event)
    {
    EmailAddress.setDisable(false);
    Address.setDisable(false);
    firstName.setDisable(false);
    lastName.setDisable(false);
    PhoneNumber.setDisable(false);
    prefGuild1.setDisable(false);
    prefGuild2.setDisable(false);
    prefGuild3.setDisable(false);
    AddInfoTxtArea.setDisable(false);
    }       
}
