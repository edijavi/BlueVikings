/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Volunteer;
import GUI.Model.ManagerModel;
import GUI.Model.VolunteerModel;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    @FXML
    private TextArea AddInfoTxtArea;
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
    @FXML
    private TextField prefGuild3;  
    @FXML
    private Button saveI;
    @FXML
    private ImageView imageV;
    
    ManagerModel MM = new ManagerModel();
     
    VolunteerModel vModel = new VolunteerModel();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    /**
     * if you click on the save volunter button the method will load an information window that 
     * you saved the volunteer successfully.
     * Jesper
     * @param event 
     */
    @FXML
    private void saveVolunteerBtb(ActionEvent event)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("CSS/icon.png"));
        alert.setTitle("Successfully Added");
        alert.setContentText("You successfully added "+ txtFirstName.getText() + " " + txtLastName.getText()+" to the system!");
        alert.show();
        vModel.addVolunteer(txtFirstName.getText(), txtLastName.getText(), txtEmail.getText(), txtPhone.getText(),
        txtAddress.getText(),AddInfoTxtArea.getText());
        Stage closeStage = (Stage) btnClose.getScene().getWindow();
        closeStage.close();
        
    }
/**
 * Jesper
 * @return 
 */
    public List<Volunteer> VolunteerList()
    {
        return vModel.getlistOfVolunteer();
    }
/**
 * Close button Action, closes the window.
 * @param event 
 */
    @FXML
    private void closeAction(ActionEvent event) {
        Stage closeStage = (Stage) btnClose.getScene().getWindow();
        closeStage.close();
    }   
}
