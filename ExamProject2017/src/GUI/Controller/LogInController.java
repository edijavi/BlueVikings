package GUI.Controller;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import BE.Manager;
import java.util.List;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author boldi
 */
public class LogInController implements Initializable
{

    @FXML
    private TextField txtFieldUserName;
    @FXML
    private PasswordField pwField;
    @FXML
    private RadioButton rbtnAdministrator;
    @FXML
    private RadioButton rbtnVolunteer;
    @FXML
    private Button btnLogIn;
    ToggleGroup group = new ToggleGroup();

    ManagerModel MM = new ManagerModel();
    @FXML
    private Label warninglbl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        List<Manager> managers = MM.getManager();
        for (int i = 0; i < managers.size(); i++)
        {
            Manager ma = managers.get(i);
            System.out.println(ma.getUsername());
            System.out.println(ma.getPassword());
        }

        toggleGroup();
    }

    public void toggleGroup()
    {
        rbtnAdministrator.setToggleGroup(group);
        rbtnVolunteer.setToggleGroup(group);
        rbtnVolunteer.setSelected(true);

        txtFieldUserName.setDisable(true);
        pwField.setDisable(true);

    }

    @FXML
    public void setTxtFieldEnabled(MouseEvent event)
    {
        if (rbtnAdministrator.isPressed())
        {
            txtFieldUserName.setDisable(false);
            pwField.setDisable(false);

        } else if (rbtnVolunteer.isPressed())
        {
            txtFieldUserName.setDisable(true);
            pwField.setDisable(true);
        }
    }

    @FXML
    public void logInEvent(ActionEvent event)
    {
        if (rbtnVolunteer.isSelected())
        {
            
            Stage stage = null;
            //Parent root = null;
            stage = (Stage) btnLogIn.getScene().getWindow();

            try
            {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("GUI/View/VolunteerMainView.fxml"));
                Parent root = fxmlLoader.load();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex)
            {
                Logger.getLogger(VolunteersController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (rbtnAdministrator.isSelected())
        {
            List<Manager> managers = MM.getManager();
            for (int i = 0; i < managers.size(); i++)
            {
                Manager ma = managers.get(i);
                
                if (txtFieldUserName.getText().equals(ma.getUsername().trim())
                        && pwField.getText().equals(ma.getPassword().trim()))
                    
                {
                    
                    Stage stage = null;
                    stage = (Stage) btnLogIn.getScene().getWindow();
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
                else
                    warninglbl.setText("Password or Username is invalid");
            }
        }
    }

}