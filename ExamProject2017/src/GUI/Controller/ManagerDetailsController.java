/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Manager;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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


