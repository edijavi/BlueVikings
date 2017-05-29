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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
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

    ObservableList<Guild> listOfGuilds;

    ObservableList<Volunteer> listOfVolunteersBasedOnGuild;

    GuildModel GM = new GuildModel();
    VolunteerModel VM = new VolunteerModel();

    private Guild guild;

    @FXML
    private ComboBox<String> cmbSearch;
    
    @FXML
    private TableView<Volunteer> volunteerInGuildTbl;
    
    @FXML
    private TableColumn<?, ?> FstNameClm;

    private java.util.Date date = new java.util.Date();
    
    @FXML
    private TableColumn<?, ?> lstNameClm;
    VolunteerModel vm = new VolunteerModel();
    GuildModel gm = new GuildModel();
    
    @FXML
    private Button btnSave;
    private SearchHandler.SearchType searchtype;
    java.sql.Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());
    
    
    private String[] weekdays = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
    
    @FXML
    private Label lblDate;
    
    @FXML
    private Button btnLogOut;
    @FXML
    private TextField txtSearch;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        showguilds();
        try
        {
            listOfGuilds = FXCollections.observableArrayList(GM.listOfGuilds());
        } catch (IOException ex)
        {
            Logger.getLogger(VolunteerMainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        guildsTable.setItems(listOfGuilds);
        setHoursComboItem();
        setSearchComboItem();
        System.out.println(listOfGuilds);
        setHoursComboItem();
        setSearchComboItem();
        txtSearch.setDisable(true);
        setDate();
        
        
    }
    @FXML
    private void search(KeyEvent event)
    {
        if(searchtype != null && (event.getCode().isLetterKey() || event.getCode().isDigitKey() || event.getCode() == KeyCode.BACK_SPACE)) {
            List<Volunteer> volunteers;
            List<Guild> guilds;
            String guild = guildsTable.getSelectionModel().getSelectedItem().getGuildName();
            if(searchtype == SearchHandler.SearchType.FIRSTNAME) {
                    volunteers = vm.getVolunteersBasedOnGuild(guild);  
                    volunteerInGuildTbl.setItems(FXCollections.observableArrayList(vm.doSearch(txtSearch.getText(),volunteers, searchtype)));
                
                }else if(searchtype == SearchHandler.SearchType.LASTNAME) {
                    volunteers = vm.getVolunteersBasedOnGuild(guild);
                    volunteerInGuildTbl.setItems(FXCollections.observableArrayList(vm.doSearch(txtSearch.getText(),volunteers, searchtype)));
                }else if(searchtype == SearchHandler.SearchType.GUILD) {
                    try{
                    guilds = gm.listOfGuilds();
                    guildsTable.setItems(FXCollections.observableArrayList(gm.doSearch(txtSearch.getText(),guilds, searchtype)));
                    }catch (IOException ex)
                    {
                        Logger.getLogger(GuildController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
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

    public void showguilds()
    {
        guildClm.setCellValueFactory(new PropertyValueFactory<>("GuildName"));

    }

    public void setSearchComboItem()
    {
        ObservableList<String> comboItems = FXCollections.observableArrayList("First Name", "Last Name", "Guilds");
        cmbSearch.setItems(comboItems);

    }

    public void setVolunteersBasedOnGuild()
    {
        
    }

    public void setHoursComboItem()
    {
        ObservableList<String> comboItems = FXCollections.observableArrayList("0.5","1","1.5","2","2.5","3","3.5","4","4.5","5","5.5","6","6.5","7","7.5", "8","8.5","9","9.5","10","10.5", "11", "11.5","12","12.5","13","13.5","14","14.5","15","15.5","16","16.5","17","17.5","18","18.5","19","19.5","20");

        cmbHours.setItems(comboItems);

    }
    public void setDate()
{
    int y = date.getYear()+1900;
    int m = date.getMonth()+1;
    lblDate.setText(weekdays[date.getDay()]+", "+date.getDate()+"-"+m+"-"+y);
}

    //Taking selected item from combobox and adding into the selected guild
    @FXML
    private void saveHoursBtn(ActionEvent event) throws IOException
    {   
        for (Guild p : GM.listOfGuilds())
        {
            if (p.getGuildName().equals(guildsTable.getSelectionModel().getSelectedItem().getGuildName()))
            {
                double y = Double.parseDouble(cmbHours.getSelectionModel().getSelectedItem());
                GM.setGuildHours(y + p.getGuildHours(), guildsTable.getSelectionModel().getSelectedItem().getGuildId());
                int CurrentVolunteer = volunteerInGuildTbl.getSelectionModel().getSelectedItem().getVolunteerId();
                System.out.println(y);
                System.out.println(GM.listOfGuilds());
                System.out.println(y + p.getGuildHours());
                GM.addVolunteerWork(timeNow, y, p.getGuildId(), CurrentVolunteer);
                
            }
        }
        
    }

    

    @FXML
    private void btnWorkAction(MouseEvent event){
    if(event.isPrimaryButtonDown())
    {
        lstNameClm.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        FstNameClm.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        
        
        
        listOfVolunteersBasedOnGuild = FXCollections.observableArrayList(VM.getVolunteersBasedOnGuild(guildsTable.getSelectionModel().getSelectedItem().getGuildName()));
        volunteerInGuildTbl.setItems(listOfVolunteersBasedOnGuild);
        
    }

    }

   
    

    @FXML
    private void closeAction (ActionEvent event)
    {
    System.exit(0);
    }
    
    /*public void setDate()
    {
        int y = date.getYear()+1900;
        int m = date.getMonth()+1;
        lblDate.setText(weekdays[date.getDay()]+", "+date.getDate()+"-"+m+"-"+y);
    }*/
    
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
