/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Guild;
import GUI.Model.GuildModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class VolunteerMainViewController implements Initializable {

    @FXML
    private TableView<Guild> guildsTable;
    
    @FXML
    private TableColumn<String, Guild> guildClm;
    @FXML
    private Button btnClose;
    @FXML
    private ComboBox<String> cmbHours;
    
    ObservableList<Guild> listOfGuilds;
    
    GuildModel GM = new GuildModel();
    
    private Guild guild;
    
    @FXML
    private ComboBox<String> cmbSearch;
    @FXML
    private TableView<?> volunteerInGuildTbl;
    @FXML
    private TableColumn<?, ?> FstNameClm;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      showguilds();
      listOfGuilds = FXCollections.observableArrayList(GM.listOfGuilds());
      guildsTable.setItems(listOfGuilds);
      setHoursComboItem();
      setSearchComboItem();
      System.out.println(listOfGuilds);
      setHoursComboItem();
      setSearchComboItem();
      
    }    
    public void showguilds(){
        guildClm.setCellValueFactory(new PropertyValueFactory<>("GuildName"));
     
    }
    public void setSearchComboItem()
    {
        ObservableList<String> comboItems = FXCollections.observableArrayList("Search","First Name","Last Name","Guilds");
        cmbSearch.setItems(comboItems);
        cmbSearch.getSelectionModel().selectFirst();

    }
     public void setHoursComboItem()
     {
         ObservableList<String> comboItems = FXCollections.observableArrayList("Hours","1","2","3","4","5","6","7","8","9");
         cmbHours.setItems(comboItems);
         cmbHours.getSelectionModel().selectFirst();
         
             
     
     }
}
