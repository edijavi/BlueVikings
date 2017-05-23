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
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
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

    @FXML
    private void saveVolunteerBtb(ActionEvent event)
    {
        
        
        
        vModel.updateVolunteer(firstName.getText(), lastName.getText(), EmailAddress.getText(), PhoneNumber.getText(),
                Address.getText(),AddInfoTxtArea.getText(), vol.getVolunteerId());
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
    private Button btnPic;
    
    @FXML
    private ListView viewPic ;
    
    
    public void ButtonPicAction(ActionEvent event){
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        
        if (selectedFile !=null){
            viewPic.getItems().add(selectedFile.getName());
        }else{
            System.out.println("file is not valid");
        }
    
    
    }
    
}
