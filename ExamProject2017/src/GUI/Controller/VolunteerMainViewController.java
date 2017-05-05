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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    private ComboBox<?> cmbHours;
    @FXML
    private TableView<?> volunteerInGuildTbl;
    @FXML
    private TableColumn<?, ?> FstNameClm;
    @FXML
    private TableColumn<?, ?> LstNameClm;
    ObservableList<Guild> listOfGuilds;
    GuildModel GM = new GuildModel();
    private Guild guild;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      showguilds();
      listOfGuilds = FXCollections.observableArrayList(GM.listOfGuilds());
      guildsTable.setItems(listOfGuilds);
      System.out.println(listOfGuilds);
    }    
    public void showguilds(){
        guildClm.setCellValueFactory(new PropertyValueFactory<>("GuildName"));
     
    }
}
