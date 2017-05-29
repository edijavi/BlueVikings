/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Volunteer;
import static GUI.Controller.LogInController.loginType.ADMIN;
import static GUI.Controller.LogInController.loginType.MANAGER;
import GUI.Model.ManagerModel;
import GUI.Model.VolunteerModel;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
public class NewVolunteerController implements Initializable {

    @FXML
    private Button saveVol;
    @FXML
    private Button btnClose;
    @FXML
    private TextField prefGuild1;
    @FXML
    private TextField prefGuild2;
   
    ManagerModel MM = new ManagerModel();
   
    @FXML
    private TextArea AddInfoTxtArea;
    
    VolunteerModel vModel = new VolunteerModel();
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtPhone;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    @FXML
    private void saveVolunteerBtb(ActionEvent event)
    {

        vModel.addVolunteer(txtFirstName.getText(), txtLastName.getText(), txtEmail.getText(), txtPhone.getText(),
                txtAddress.getText(),AddInfoTxtArea.getText());
        Stage closeStage = (Stage) btnClose.getScene().getWindow();
        closeStage.close();
        
    }

    public List<Volunteer> VolunteerList()
    {

        return vModel.getlistOfVolunteer();

    }

    @FXML
    private void closeAction(ActionEvent event) {
        Stage closeStage = (Stage) btnClose.getScene().getWindow();
        closeStage.close();
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
