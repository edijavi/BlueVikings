/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import GUI.Model.ManagerModel;
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
    @FXML
    private Label lblDate;
    @FXML
    private Button btnLogOut; 
    @FXML
    private Button btnStatistics;
    @FXML
    private Button btnVolunteerStat;
    @FXML
    private Label lblFN;
    @FXML
    private Label lblLN;
    
    private Date date = new Date();
    
    private String[] weekdays = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};

    ManagerModel MM = new ManagerModel();


    /**
     * Makes the Volunteer FXML default in the main view.
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
    /**
    * Handle the Menu options when a button pressed it loads the right FXML to the Admin main view
    * log out from the program or close it.
    * @param event 
    */
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
            case "btnStatistics":
                try {
                    openItem("/GUI/View/Statistics.fxml");
                } catch(IOException e) {
                    System.out.println("FXML probably not found");
                    System.out.println(e);
                }
                break;
            case "btnVolunteerStat":
                try {
                    openItem("/GUI/View/VolunteerStatistics.fxml");
                } catch(IOException e) {
                    System.out.println("FXML probably not found");
                    System.out.println(e);
                }
                break;
            case "btnLogOut":
                Stage stage = null;
                stage = (Stage) btnLogOut.getScene().getWindow();
                try{
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("GUI/View/LogIn.fxml"));
                    Parent root = fxmlLoader.load();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    } catch (IOException ex)
                    {
                        Logger.getLogger(VolunteersController.class.getName()).log(Level.SEVERE, null, ex);
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
    /**
    * This method creates an item loader to an Anchor pane in the Main View we use
    * this every time when a button pressed in the menu
    * @param url
    * @throws IOException 
    */
    public void openItem(String url) throws IOException {
        FXMLLoader itemLoader = new FXMLLoader(getClass().getResource(url));
        AnchorPane itemPane = itemLoader.load();
        Object controller = itemLoader.getController();
        paneItem.getChildren().clear();
        paneItem.getChildren().add(itemPane);
    }
    /**
    * This method using 2 int to store the date and the months and with the date.getDay command we get the day. 
    * and write the date of today to a label.
    */
public void setDate()
{
    int y = date.getYear()+1900;
    int m = date.getMonth()+1;
    lblDate.setText(weekdays[date.getDay()]+", "+date.getDate()+"-"+m+"-"+y);
}
    
}

    
    

