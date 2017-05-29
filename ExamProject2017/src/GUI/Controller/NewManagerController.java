/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

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
import javafx.scene.control.TextField;
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

     @FXML
    private void closeAction(ActionEvent event) {
        Stage stage = new Stage();
        if(MM.getLogintype() == MANAGER){
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("GUI/View/MainView.fxml"));

            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            Stage closeStage = (Stage) btnClose.getScene().getWindow();
            closeStage.close();
        } catch (IOException ex)
        {
            Logger.getLogger(VolunteersController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    else if(MM.getLogintype() == ADMIN){
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("GUI/View/AdminMainView.fxml"));

            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            Stage closeStage = (Stage) btnClose.getScene().getWindow();
            closeStage.close();
            
        } catch (IOException ex)
        {
            Logger.getLogger(VolunteersController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    }
    @FXML
    public void addManager(ActionEvent event) {
        MM.addManager(txtUserName.getText(), txtPassword.getText(), txtFirstName.getText(), txtLastName.getText(), txtEamil.getText(), txtPhone.getText());
    }
    
    }
    

