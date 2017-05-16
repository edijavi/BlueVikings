/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author boldi
 */
public class MainViewController implements Initializable {

    @FXML
    private Button btnVolunteers;
    @FXML
    private Button btnGuilds;
    @FXML
    private Button btnClose;
    @FXML
    private AnchorPane paneItem;
    
    private Date date = new Date();
    private String[] weekdays = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
    @FXML
    private Label lblDate;
    @FXML
    private Button btnLogOut;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
             openItem("/GUI/View/Volunteers.fxml");
            } catch(IOException e) {
                System.out.println("FXML probably not found");
                System.out.println(e);
            }
        setDate();
        // TODO
    }   
    @FXML
    private void pressedButton(ActionEvent event) {
        Button pressedButton = (Button) event.getSource();
        System.out.println("pressed button: "+event.getSource());
        switch(pressedButton.getId()) {
            case "btnVolunteers":
                try {
                    openItem("/GUI/View/Volunteers.fxml");
                } catch(IOException e) {
                    System.out.println("FXML probably not found");
                    System.out.println(e);
                }
                break;
                
            case "btnGuilds":
                try
                {
                    openItem("/GUI/View/Guilds.fxml");
                } catch(IOException e)
                {
                    System.out.println("FXML probably not found");
                    System.out.println(e);
                }
                break;
            case "btnClose":
                System.exit(0);
                break;
        }
    }
        public void openItem(String url) throws IOException {
        FXMLLoader itemLoader = new FXMLLoader(getClass().getResource(url));
        AnchorPane itemPane = itemLoader.load();
        Object controller = itemLoader.getController();
        paneItem.getChildren().clear();
        paneItem.getChildren().add(itemPane);
    }
public void setDate()
{
    int y = date.getYear()+1900;
    int m = date.getMonth()+1;
    lblDate.setText(weekdays[date.getDay()]+", "+date.getDate()+"-"+m+"-"+y);
}
@FXML
public void logOutEvent(ActionEvent event)
{
    Stage stage = null;
        stage = (Stage) btnLogOut.getScene().getWindow();
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("GUI/View/LogIn.fxml"));

            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex)
        {
            Logger.getLogger(VolunteersController.class.getName()).log(Level.SEVERE, null, ex);
        }

}
    
}

    
    

