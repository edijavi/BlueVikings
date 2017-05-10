/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import GUI.Model.GuildVolunteerModel;
import BE.Guild;
import BE.Volunteer;
import GUI.Model.GuildModel;
import GUI.Model.VolunteerModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
        
/**
 * FXML Controller class
 *
 * @author boldi
 */
public class GuildController implements Initializable {

    @FXML
    private TableView<Guild> tblGuilds;
    @FXML
    private TableColumn<?, ?> colMembers;
    @FXML
    private TableColumn<?, ?> colHours;
    @FXML
    private Button btnAddMember;
    @FXML
    private TableView<Volunteer> tblVolunteers;
    @FXML
    private TableColumn<?,? > GuildNameClm;
    @FXML
    private TableColumn<?, ?> FirstNameClm;
    @FXML
    private TableColumn<?, ?> LastNameClm;
    
    ObservableList<Guild> listOfGuilds;
    ObservableList<Volunteer> listOfVolunteer;
    
    GuildVolunteerModel GVmodel = new GuildVolunteerModel();
    GuildModel GModel = new GuildModel();
    VolunteerModel VModel = new VolunteerModel();
    int GuildId;
    int VolunteerId;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    ShowInView();
    
    listOfVolunteer = FXCollections.observableArrayList(VModel.getlistOfVolunteer());
    listOfGuilds = FXCollections.observableArrayList(GModel.listOfGuilds());
    tblVolunteers.setItems(listOfVolunteer);
    tblGuilds.setItems(listOfGuilds);
   
    
    }    

    @FXML
    private void AddMemberToGuiild(ActionEvent event) {
    GuildVolunteerModel GVmodel = new GuildVolunteerModel(); 
    getSelectedValues();
    GVmodel.addMemebertoGuild(VolunteerId,GuildId );
        System.out.println("GuildId"+GuildId);
        System.out.println("VolunteerId"+VolunteerId);
    
    }
    public void ShowInView()
    {
    
    GuildNameClm.setCellValueFactory(new PropertyValueFactory<>("GuildName"));
    FirstNameClm.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    LastNameClm.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    
    }
    public void getSelectedValues(){
    VolunteerId  = tblVolunteers.getSelectionModel().getSelectedItem().getVolunteerId();
    GuildId =       tblGuilds.getSelectionModel().getSelectedItem().getGuildId();
    }
}
