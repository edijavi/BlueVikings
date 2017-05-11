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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    private Volunteer vol;

    VolunteerModel vModel = new VolunteerModel();
    @FXML
    private Button btnClose;
    @FXML
    private TextField Guild;

    public VolunteerDetailsController()
    {

    }

    /**
     * Initializes the controller class.
     */
    @Override

    public void initialize(URL url, ResourceBundle rb)
    {
        
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

        Volunteer volunteer = new Volunteer();
        volunteer.setAddress(Address.getText());
        volunteer.setEmail(EmailAddress.getText());
        volunteer.setFirstName(firstName.getText());
        volunteer.setLastName(lastName.getText());
        volunteer.setPhoneNumber(PhoneNumber.getText());

        // VolunteerList().add(volunteer);
        vModel.addVolunteer(Address.getText(), lastName.getText(), EmailAddress.getText(), PhoneNumber.getText(),
                Address.getText());

        
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

        System.out.println(VolunteerList());
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
    public void setVolunteer(Volunteer voll)
    {
        vol = voll;
    }
  
   /* public void setVolunteerItems()
    {
        EmailAddress.setText(vol.getEmail());
        Address.setText(vol.getAddress());
        firstName.setText(vol.getFirstName());
        lastName.setText(vol.getLastName());
        PhoneNumber.setText(vol.getPhoneNumber());
    }
*/
}
