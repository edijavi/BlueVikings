/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Manager;
import GUI.Model.ManagerModel;
import java.net.URL;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author boldi
 */
public class ManagerDetailsController implements Initializable
{

    private static Manager man;

    ManagerModel mModel = new ManagerModel();

    @FXML
    private Button btnSave;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnClose;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtEmail;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

        setManagerItems();
    }

    public static void setManager(Manager mann)
    {
        man = mann;
    }

    private void setManagerItems()
    {
        txtPassword.setText(man.getPassword());
        txtEmail.setText(man.getEmail());
        txtFirstName.setText(man.getFirstname());
        txtLastName.setText(man.getLastname());
        txtUserName.setText(man.getUsername());
        txtPhone.setText(man.getPhone());
        txtEmail.setDisable(true);
        txtFirstName.setDisable(true);
        txtLastName.setDisable(true);
        txtUserName.setDisable(true);
        txtPassword.setDisable(true);
        txtPhone.setDisable(true);
        
    }

    @FXML
    private void editAction(ActionEvent event)
    {
        txtEmail.setDisable(false);
        txtFirstName.setDisable(false);
        txtLastName.setDisable(false);
        txtUserName.setDisable(false);
        txtPassword.setDisable(false);
        txtPhone.setDisable(false);
        
    }

    
    
    
    @FXML
    public void editManagerEvent(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        Stage Iconstage = (Stage) alert.getDialogPane().getScene().getWindow();
        Iconstage.getIcons().add(new Image("CSS/icon.png"));
        alert.setTitle("Successfully Edited");
        alert.setContentText("You edited "+ txtFirstName.getText() + " " + txtLastName.getText());
        alert.show();
        mModel.editManager(txtUserName.getText(), txtPassword.getText(), txtFirstName.getText(),
        txtLastName.getText(), txtEmail.getText(), txtPhone.getText(), man.getManagerId());
        
    }
    @FXML
    private void closeAction(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
         }
}


