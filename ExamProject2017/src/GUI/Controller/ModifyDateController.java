/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.GuildVolunteerWork;
import BE.Volunteer;
import GUI.Model.GuildVolunteerWorkModel;
import GUI.Model.ManagerModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

 
/**
 * FXML Controller class
 * @authors Boldizsár Koppány, Deividas Tamošiūnas, Edwin Mhoy Silva, Jesper Enemark,
 * Edison J. Lamar Toapanta
 *
 */

public class ModifyDateController implements Initializable {


    private static Volunteer vol;
    private static GuildVolunteerWork GVW;
    
    @FXML
    private Label lblDate;
    @FXML
    private Label lblFirstName;
    @FXML
    private Label lblLastName; 
    @FXML
    private Button btnModify;
    @FXML
    private Label lblHours;
    @FXML
    private ComboBox<String> cmbTime; 
    
    ManagerModel MM = new ManagerModel();
    GuildVolunteerWorkModel GVWM = new GuildVolunteerWorkModel();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showData();
        setHoursComboItem();
    }   
    /**
     * Creates a variable what we use to get the selected item from the other view and load the data of it.
     * @param gvww 
     */
    public static void setDate(GuildVolunteerWork gvww)
    {
    GVW=gvww;
    }
    /**
    * Creates a variable what we use to get the selected item from the other view and load the data of it.
    * @param voll
    */
    public static void setVolunteer(Volunteer voll)
    {
    vol=voll;
    }
    /**
     * Gets and load the data of the selected item.
     */
    private void showData()
    {
    String date = String.valueOf(GVW.getDate());
    lblDate.setText(date);
    lblFirstName.setText(vol.getFirstName());
    lblLastName.setText(vol.getLastName());
    String hour = String.valueOf(GVW.getHour());
    lblHours.setText(hour);
    }
    /**
     * Sets the combo box items.
     */
    public void setHoursComboItem()
    {
        ObservableList<String> comboItems = FXCollections.observableArrayList("0.5","1","1.5","2","2.5","3","3.5","4","4.5","5","5.5","6","6.5","7","7.5", "8","8.5","9","9.5","10","10.5", "11", "11.5","12","12.5","13","13.5","14","14.5","15","15.5","16","16.5","17","17.5","18","18.5","19","19.5","20");

        cmbTime.setItems(comboItems);

    }
    /**
     * This Action event runs if you click on the modify button.
     * Opens an Information alert window which inform you that the modification was successfully.
     * Afterwards a string is being parsed into a double, next it is UPDATING the hour value from WorkTable based on WorkId.
     * Lastly it is closing the stage.
     * @param event 
     */
    @FXML
    private void modifyAction(ActionEvent event)
    {
        String date = String.valueOf(GVW.getDate());
        String hour = String.valueOf(GVW.getHour());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("CSS/icon.png"));
        alert.setTitle("Successfully Edited");
        alert.setContentText(vol.getFirstName()+" "+vol.getFirstName() + " successfully Edited in " + date+ " from " + hour +" hours to " + cmbTime.getSelectionModel().getSelectedItem()+" hours.");
        alert.show();
        double y = Double.parseDouble(cmbTime.getSelectionModel().getSelectedItem());
        GVWM.editHourOnWork(y,GVW.getWorkId());
        Stage closeStage = (Stage) btnModify.getScene().getWindow();
        closeStage.close(); 
        
    }
}
