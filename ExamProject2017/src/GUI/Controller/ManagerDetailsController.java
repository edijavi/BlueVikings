/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;



import BE.Manager;
import BE.Volunteer;
import GUI.Model.ManagerModel;
import java.net.URL;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author boldi
 */
public class ManagerDetailsController implements Initializable {

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
    private TextField txtAddress;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtEmail;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
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
        txtEmail.setDisable(true);
        txtFirstName.setDisable(true);
        txtLastName.setDisable(true);
        txtUserName.setDisable(true);
        txtPassword.setDisable(true);
        txtPhone.setDisable(true);
        txtAddress.setDisable(true);
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
        txtAddress.setDisable(false);
    }

    @FXML
    private void closeAction(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
}
