/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Volunteer;
import GUI.Controller.LogInController.loginType;
import static GUI.Controller.LogInController.loginType.ADMIN;
import static GUI.Controller.LogInController.loginType.MANAGER;
import GUI.Model.ManagerModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import GUI.Model.VolunteerModel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
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

    private static Volunteer vol;

    VolunteerModel vModel = new VolunteerModel();
    
    ManagerModel MM = new ManagerModel();
    
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
    
    private loginType logintype;

    public VolunteerDetailsController()
    {

    }
 
    /**
     * Initializes the controller class.
     */
    
    @Override

    public void initialize(URL url, ResourceBundle rb)
    {
        setVolunteerItems();
        
    }

    @FXML
    private void closeAction(ActionEvent event)
    {
        Stage closeStage = (Stage) btnClose.getScene().getWindow();
        closeStage.close();
        
    }

    @FXML
    private void saveVolunteerBtb(ActionEvent event)
    {
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
    public static void setVolunteer(Volunteer voll)
    {
    vol = voll;
    }
    
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
    
    
    @FXML
    private Button saveI;
    @FXML
    private ImageView imageV;
    
    @FXML
    private void handleUploadImage(ActionEvent event)
      {
        FileChooser fileChooser = new FileChooser();

        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.JPG", "*.jpg", "*.png", "*.JPEG", "*.jpeg"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null)
        {
            Image image = new Image(file.toURI().toString());
            imageV.setImage(image);
        }
      }
        
}
