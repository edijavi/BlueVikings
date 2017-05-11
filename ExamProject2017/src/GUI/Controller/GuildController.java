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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import GUI.Model.GuildVolunteerModel;
import BE.Guild;
import BE.Volunteer;
import GUI.Model.GuildModel;
import GUI.Model.VolunteerModel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
        
/**
 * FXML Controller class
 *
 * @author boldi
 */
public class GuildController implements Initializable {

    @FXML
    private TableView<Guild> tblGuilds;
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
    @FXML
    private TextField txtFieldSearch;
    @FXML
    private ComboBox<String> cmbSearch;
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
    setSearchComboItem();
    
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
    colHours.setCellValueFactory(new PropertyValueFactory<>("GuildHours"));
    FirstNameClm.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    LastNameClm.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    
    }
    public void getSelectedValues(){
    VolunteerId  = tblVolunteers.getSelectionModel().getSelectedItem().getVolunteerId();
    GuildId =       tblGuilds.getSelectionModel().getSelectedItem().getGuildId();
    }
    
    @FXML
    private void ClickedOnGuild(MouseEvent event)
    {if(event.isPrimaryButtonDown() && event.getClickCount() == 2) 
        {
            Stage stage = null;
            Parent root = null;
            stage = (Stage) tblGuilds.getScene().getWindow();
            try
            {FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/View/GuildDetails.fxml"));
            
            root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
            } catch (IOException ex)
            {
                Logger.getLogger(VolunteersController.class.getName()).log(Level.SEVERE, null, ex);
            }

           

        }
    }
  public void setSearchComboItem()
    {
        ObservableList<String> comboItems = FXCollections.observableArrayList("First Name", "Last Name", "Guilds");
        cmbSearch.setItems(comboItems);

    }  
    
}
