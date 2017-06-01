/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

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
public class NewManagerController implements Initializable {

    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextField txtEamil;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtUserName;
    @FXML
    private Button btnClose;
    
    ManagerModel MM = new ManagerModel();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    /**
     * Close Action if you click on the close button this method closes the window.
     * @param event 
     */
    @FXML
    private void closeAction(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        
    }
    /**
     * if you click on the save button the method will opens an Information alert window.
     * That shows you successfully added the new manager to the system.
     * @param event 
     */
    @FXML
    public void addManager(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        Stage Iconstage = (Stage) alert.getDialogPane().getScene().getWindow();
        Iconstage.getIcons().add(new Image("CSS/icon.png"));
        alert.setTitle("Successfully Added");
        alert.setContentText(txtFirstName.getText()+" "+txtLastName.getText() + " successfully added to the system as Manager");
        alert.show();
        MM.addManager(txtUserName.getText(), txtPassword.getText(), txtFirstName.getText(), txtLastName.getText(), txtEamil.getText(), txtPhone.getText());
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    } 
    }
    

