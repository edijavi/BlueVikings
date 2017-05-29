package GUI.Controller;

import BE.Adminstrator;
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
import static GUI.Controller.LogInController.loginType.ADMIN;
import GUI.Model.AdminModel;
import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import javafx.animation.ParallelTransition;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

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
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private BorderPane borderPane;
    @FXML
    private GridPane loginGrid;
    
    public enum loginType{ADMIN,MANAGER};
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
      
        loginGrid.setVisible(false);
        toggleGroup();

        TranslateTransition transition1 = new TranslateTransition(Duration.seconds(2.5), btnLogIn);
        transition1.setToY(-20);

        ParallelTransition transition = new ParallelTransition();

        transition.setOnFinished((e)
                -> 
                {
                    FadeTransition fadeOut = new FadeTransition(Duration.seconds(1.5), anchorPane);
                    fadeOut.setFromValue(0.0);
                    fadeOut.setToValue(1.0);
                    fadeOut.play();
        });

        transition.play();
        transition1.play();
    }

    AdminModel AM = new AdminModel();

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
            loginGrid.setVisible(true);
            txtFieldUserName.setDisable(false);
            pwField.setDisable(false);

        } else if (rbtnVolunteer.isPressed())
        {
            warninglbl.setVisible(false);
            loginGrid.setVisible(false);
        }
    }

    public void AdminLogin()
    {if (rbtnAdministrator.isSelected()){
        List<Adminstrator> Admins = AM.getAdminstrators();
        for (int i = 0; i < Admins.size(); i++)
        {
            Adminstrator ad = Admins.get(i);
            if (txtFieldUserName.getText().equals(ad.getUsername().trim()) && pwField.getText().equals(ad.getPassword().trim()))

            { MM.setLogintype(ADMIN);
                Stage stage = null;
                //Parent root = null;
                stage = (Stage) btnLogIn.getScene().getWindow();

                try
                {
                    
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("GUI/View/AdminMainView.fxml"));
                    Parent root = fxmlLoader.load();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    stage.getIcons().add(new Image("CSS/icon.png"));
                    stage.setResizable(false);
                } catch (IOException ex)
                {
                    Logger.getLogger(VolunteersController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
    }
    public void volunteerLogin()
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
                stage.getIcons().add(new Image("CSS/icon.png"));
                stage.setResizable(false);
            } catch (IOException ex)
            {
                Logger.getLogger(VolunteersController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        }
        public void managerLogIn(){
        
            if (rbtnAdministrator.isSelected())
            {
            List<Manager> managers = MM.getManager();
            for (int i = 0; i < managers.size(); i++)
            {
                Manager ma = managers.get(i);

                if (txtFieldUserName.getText().equals(ma.getUsername().trim())
                        && pwField.getText().equals(ma.getPassword().trim()))

                {
                    MM.setLogintype(loginType.MANAGER);
                    Stage stage = null;
                    stage = (Stage) btnLogIn.getScene().getWindow();
                    try
                    {
                        
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("GUI/View/MainView.fxml"));
                        Parent root = fxmlLoader.load();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                        stage.getIcons().add(new Image("CSS/icon.png"));
                        stage.setResizable(false);

                    } catch (IOException ex)
                    {
                        Logger.getLogger(VolunteersController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else
                {
                    warninglbl.setText("Password or Username is invalid");
                }
            }
        }
    }

    @FXML
    public void logInEvent(ActionEvent event)
    {
        AdminLogin();
        managerLogIn();
      
    }

    @FXML
    private void EnterKeyPressed(KeyEvent event)
    {
        if (event.getCode().toString().equals("ENTER"))
        {
            AdminLogin();
            
            managerLogIn();
        }
    }

}
