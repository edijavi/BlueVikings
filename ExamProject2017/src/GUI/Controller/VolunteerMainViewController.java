/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Guild;
import BE.Volunteer;
import BLL.SearchHandler;
import GUI.Model.GuildModel;
import GUI.Model.GuildVolunteerModel;
import GUI.Model.VolunteerModel;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author EdwinSilva
 */
public class VolunteerMainViewController implements Initializable
{

    @FXML
    private TableView<Guild> guildsTable;
    @FXML
    private TableColumn<String, Guild> guildClm;
    @FXML
    private Button btnClose;
    @FXML
    private ComboBox<String> cmbHours;
    @FXML
    private ComboBox<String> cmbSearch;
    @FXML
    private TableView<Volunteer> volunteerInGuildTbl;
    @FXML
    private TableColumn<?, ?> FstNameClm;
    @FXML
    private TableColumn<?, ?> lstNameClm;
    @FXML
    private Button btnSave;
    @FXML
    private Label lblDate;
    @FXML
    private Button btnLogOut;
    @FXML
    private TextField txtSearch;
    
    ObservableList<Guild> listOfGuilds;
    
    private Guild guild;
    private java.util.Date date = new java.util.Date();
    private SearchHandler.SearchType searchtype;
    
    GuildModel GM = new GuildModel();
    VolunteerModel vm = new VolunteerModel();
    GuildVolunteerModel GVM = new GuildVolunteerModel();
    
    java.sql.Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());
    
    private String[] weekdays = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        showguilds();        
        guildsTable.setItems(GM.getListOfGuilds());
        setHoursComboItem();
        setSearchComboItem();
        System.out.println(listOfGuilds);
        setHoursComboItem();
        setSearchComboItem();
        txtSearch.setDisable(true);
        setDate(); 
    }
    /**
     * This method checks the searchtype if null or not, all the characters in the keyboard and the backspace as well.
     * If the combo box seted to First Name, Last Name or Guild the method will enable the text field,
     * and reset the items in the right table view according what is in the text field.
     * @param event 
     */
    @FXML
    private void search(KeyEvent event)
    {
        if(searchtype != null && (event.getCode().isLetterKey() || event.getCode().isDigitKey() || event.getCode() == KeyCode.BACK_SPACE)) {

            String guild = guildsTable.getSelectionModel().getSelectedItem().getGuildName();
            if(searchtype == SearchHandler.SearchType.FIRSTNAME) {
 
                    volunteerInGuildTbl.setItems(FXCollections.observableArrayList(vm.doSearch(txtSearch.getText(),GVM.getVolunteersBasedOnGuild(guild), searchtype)));
                
                }else if(searchtype == SearchHandler.SearchType.LASTNAME) {
                    
                    volunteerInGuildTbl.setItems(FXCollections.observableArrayList(vm.doSearch(txtSearch.getText(),GVM.getVolunteersBasedOnGuild(guild), searchtype)));
                }else if(searchtype == SearchHandler.SearchType.GUILD) {
                    
                    guildsTable.setItems(FXCollections.observableArrayList(GM.doSearch(txtSearch.getText(),GM.getListOfGuilds(), searchtype)));
                    
                }
            }
        }
    /**
    * This method sets the serch type according to waht is in the combo box and set the search text field enable to edit.
    * @param event 
    */
    @FXML
    private void setSearchType(ActionEvent event)
    {
    if("First Name".equals(cmbSearch.getSelectionModel().getSelectedItem()))
        {
            this.searchtype = SearchHandler.SearchType.FIRSTNAME;
            txtSearch.setDisable(false);
        }
    if("Last Name".equals(cmbSearch.getSelectionModel().getSelectedItem()))
        {
            this.searchtype = SearchHandler.SearchType.LASTNAME;
            txtSearch.setDisable(false);
        }
    if("Guilds".equals(cmbSearch.getSelectionModel().getSelectedItem()))
        {
            this.searchtype = SearchHandler.SearchType.GUILD;
            txtSearch.setDisable(false);
        }
    }
    /**
     * Prepare the information. (Jesper)
     */
    public void showguilds()
    {
        guildClm.setCellValueFactory(new PropertyValueFactory<>("GuildName"));

    }
    /**
     * Sets the items in the Search combo box.
     */
    public void setSearchComboItem()
    {
        ObservableList<String> comboItems = FXCollections.observableArrayList("First Name", "Last Name", "Guilds");
        cmbSearch.setItems(comboItems);
    }
    /**    
     * Sets the items in the Hours combo box.
     */
    public void setHoursComboItem()
    {
        ObservableList<String> comboItems = FXCollections.observableArrayList("0.5","1","1.5","2","2.5","3","3.5","4","4.5","5","5.5","6","6.5","7","7.5", "8","8.5","9","9.5","10","10.5", "11", "11.5","12","12.5","13","13.5","14","14.5","15","15.5","16","16.5","17","17.5","18","18.5","19","19.5","20");
        cmbHours.setItems(comboItems);
    }
    /**
    * This method using 2 int to contain the date and the months and with the date.getDay command we get the day. 
    * and write the date of today to a label.
    */
    public void setDate()
    {
    int y = date.getYear()+1900;
    int m = date.getMonth()+1;
    lblDate.setText(weekdays[date.getDay()]+", "+date.getDate()+"-"+m+"-"+y);
    }
    /**
     * If one of the information the Guild, Volunteer or the Hours is empty it will load an allert window that something is missing.
     * Jesper
     * Else it will load an other allert window that the save was successfully.
     * @param event
     * @throws IOException 
     */
    @FXML
    private void saveHoursBtn(ActionEvent event) throws IOException
    {   
        if (guildsTable.getSelectionModel().isEmpty() || volunteerInGuildTbl.getSelectionModel().isEmpty() || cmbHours.getSelectionModel().isEmpty()/*equals(null)*/ )
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Something is missing");
            alert.setContentText("You have to select the guild, the volunteer, and the hours first!");
            alert.show();
        }else{
        

        for (Guild p : GM.getListOfGuilds())

        {
            if (p.getGuildName().equals(guildsTable.getSelectionModel().getSelectedItem().getGuildName()))
            {   Alert alert = new Alert(Alert.AlertType.INFORMATION);
                Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                stage.getIcons().add(new Image("CSS/icon.png"));
                alert.setTitle("Saved");
                alert.setHeaderText("Successfully Saved");
                alert.setContentText("Thank you for your help today, your hours have been saved");
                alert.show();
                double y = Double.parseDouble(cmbHours.getSelectionModel().getSelectedItem());
                GM.setGuildHours(y + p.getGuildHours(), guildsTable.getSelectionModel().getSelectedItem().getGuildId());
                int CurrentVolunteer = volunteerInGuildTbl.getSelectionModel().getSelectedItem().getVolunteerId();
                System.out.println(y);
                System.out.println(GM.getListOfGuilds());
                System.out.println(y + p.getGuildHours());
                GM.addVolunteerWork(timeNow, y, p.getGuildId(), CurrentVolunteer);
                
            }
        }

        }       
    }
    /**
     * If you click on a volunteer this Action event will load the hours and the dates of work for the specific volunteer.
     * @param event 
     */
    @FXML
    private void btnWorkAction(MouseEvent event)
    {
        if(event.isPrimaryButtonDown())
        {
            lstNameClm.setCellValueFactory(new PropertyValueFactory<>("LastName"));
            FstNameClm.setCellValueFactory(new PropertyValueFactory<>("FirstName"));     
            volunteerInGuildTbl.setItems(GVM.getVolunteersBasedOnGuild(guildsTable.getSelectionModel().getSelectedItem().getGuildName())); 
        }

    }
    /**
     * Closes the program
     * @param event 
     */
    @FXML
    private void closeAction (ActionEvent event)
    {
    System.exit(0);
    }
    /**
     * Logs out from the program and loads the Login FXML.
     * @param event 
     */
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
