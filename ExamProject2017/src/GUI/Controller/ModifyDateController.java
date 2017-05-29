/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Guild;
import BE.GuildVolunteerWork;
import BE.Volunteer;
import static GUI.Controller.LogInController.loginType.ADMIN;
import static GUI.Controller.LogInController.loginType.MANAGER;
import GUI.Model.ManagerModel;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author boldi
 */

public class ModifyDateController implements Initializable {

private static Guild guild;
private static Volunteer vol;
private static GuildVolunteerWork GVW;
    @FXML
    private Label lblDate;
    @FXML
    private Label lblFirstName;
    @FXML
    private Label lblLastName;
    @FXML
    private TextField txtYear;
    @FXML
    private TextField txtHours;
    @FXML
    private Button btnModify;
    @FXML
    private Label lblHours;
    
    ManagerModel MM = new ManagerModel();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showData();
    }    
    public static void setDate(GuildVolunteerWork gvww)
    {
    GVW=gvww;
    }

    public static void setVolunteer(Volunteer voll)
    {
    vol=voll;
    }
    private void showData()
    {
    String date = String.valueOf(GVW.getDate());
    lblDate.setText(date);
    lblFirstName.setText(vol.getFirstName());
    lblLastName.setText(vol.getLastName());
    String hour = String.valueOf(GVW.getHour());
    lblHours.setText(hour);
    }
    @FXML
    private void modifyAction(ActionEvent event)
    {
        Stage closeStage = (Stage) btnModify.getScene().getWindow();
        closeStage.close();
    }
}
