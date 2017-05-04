/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Volunteer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import GUI.Model.VolunteerModel;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author boldi
 */
public class VolunteerDetailsController implements Initializable {

    @FXML
    private TextField Guild;
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

    private Volunteer vol;
    
    VolunteerModel vModel = new VolunteerModel();
   
    

    public VolunteerDetailsController() {
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
    
        
    }

    @FXML
    private void saveVolunteerBtb(ActionEvent event) { 
   
    Volunteer volunteer = new Volunteer();
    volunteer.setAddress(Address.getText());
    volunteer.setEmail(EmailAddress.getText());
    volunteer.setFirstName(firstName.getText());
    volunteer.setLastName(lastName.getText());
    volunteer.setPhoneNumber(PhoneNumber.getText());
    //volunteer.setVolunteerId(15);
   
   // VolunteerList().add(volunteer);
     vModel.addVolunteer( Address.getText(), lastName.getText(), EmailAddress.getText(), PhoneNumber.getText(),
     Address.getText());
    
    
        System.out.println(VolunteerList());
    }
    
    public List<Volunteer> VolunteerList(){
        
        return vModel.getlistOfVolunteer();
        
    }
    public void setVolunteerFirstName(){
     vol.setFirstName(firstName.getText());
    
    }
    public void setVolunteerLastName(){
     vol.setLastName(  lastName.getText());
    }
    public void setVolunteerEmail(){
     vol.setEmail(EmailAddress.getText());
    }
    public void setVolunteerPhoneNumber(){
    vol.setPhoneNumber(PhoneNumber.getText());
    }
    public void setVolunteerAddress(){
     vol.setAddress(Address.getText());
    }
    public void setVolunteerId(){
    vol.setVolunteerId(11000) ;  
    }
   
    
    

}
