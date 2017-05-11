/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Guild;
import BE.Volunteer;
import GUI.Model.GuildModel;
import GUI.Model.VolunteerModel;
import com.sun.org.apache.bcel.internal.classfile.PMGClass;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

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

    private Guild guild;

    @FXML
    private ComboBox<String> cmbSearch;
    @FXML
    private TableView<Volunteer> volunteerInGuildTbl;
    @FXML
    private TableColumn<?, ?> FstNameClm;

    VolunteerModel VM = new VolunteerModel();
    @FXML
    private TableColumn<?, ?> lstNameClm;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnWork;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        showguilds();
        listOfGuilds = FXCollections.observableArrayList(GM.listOfGuilds());
        guildsTable.setItems(listOfGuilds);
        setHoursComboItem();
        setSearchComboItem();
        System.out.println(listOfGuilds);
        setHoursComboItem();
        setSearchComboItem();
        
        
    }

    public void showguilds()
    {
        guildClm.setCellValueFactory(new PropertyValueFactory<>("GuildName"));

    }

    public void setSearchComboItem()
    {
        ObservableList<String> comboItems = FXCollections.observableArrayList("Search", "First Name", "Last Name", "Guilds");
        cmbSearch.setItems(comboItems);
        cmbSearch.getSelectionModel().selectFirst();

    }

    public void setVolunteersBasedOnGuild()
    {
        
    }

    public void setHoursComboItem()
    {
        ObservableList<String> comboItems = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");

        cmbHours.setItems(comboItems);
        cmbHours.getSelectionModel().selectFirst();

    }

    //Taking selected item from combobox and adding into the selected guild
    @FXML
    private void saveHoursBtn(ActionEvent event)
    {
        for (Guild p : GM.listOfGuilds())
        {
            if (p.getGuildName().equals(guildsTable.getSelectionModel().getSelectedItem().getGuildName()))
            {
                int y = Integer.parseInt(cmbHours.getSelectionModel().getSelectedItem());
                GM.setGuildHours(y, guildsTable.getSelectionModel().getSelectedItem().getGuildId());

                System.out.println(GM.listOfGuilds());
                System.out.println(y + p.getGuildHours());
            }
        }

    }

    

    @FXML
    private void btnWorkAction(ActionEvent event)
    {
        lstNameClm.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        FstNameClm.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        
        
        
        listOfVolunteersBasedOnGuild = FXCollections.observableArrayList(VM.getVolunteersBasedOnGuild(guildsTable.getSelectionModel().getSelectedItem().getGuildName()));
        volunteerInGuildTbl.setItems(listOfVolunteersBasedOnGuild);
        
    }
    @FXML
    private void closeAction (ActionEvent event)
    {
    System.exit(0);
    }

}
