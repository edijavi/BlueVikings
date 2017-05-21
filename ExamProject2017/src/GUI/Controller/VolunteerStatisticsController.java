/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;


import BE.GuildVolunteerWork;
import BE.Volunteer;
import GUI.Model.VolunteerModel;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author boldi
 */
public class VolunteerStatisticsController implements Initializable {

    @FXML
    private TextField txtSearch;
    @FXML
    private ComboBox<?> cmbSearch;
    @FXML
    private TableView<Volunteer> tblVolunteers;
    @FXML
    private TableColumn<?, ?> colFirstName;
    @FXML
    private TableColumn<?, ?> colLastName;
    @FXML
    private TableView<GuildVolunteerWork> tblDatesnHours;
    @FXML
    private TableColumn<?, ?> colDate;
    @FXML
    private TableColumn<?, ?> colHours;

    ObservableList<Volunteer> listOfGuilds;
    ObservableList<GuildVolunteerWork> listOfGuildVolunteerWork;
    /**
     * Initializes the controller class.
     */
    
    VolunteerModel VM = new VolunteerModel();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DisplayVolunteers();
    }    
    
    
    public void DisplayVolunteers() {
        listOfGuilds = FXCollections.observableArrayList(VM.getlistOfVolunteer());
        tblVolunteers.setItems(listOfGuilds);
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        
        
    }
    
 

    @FXML
    private void getVolunteerStatsOnClick(MouseEvent event) throws SQLException
    {
        for (Volunteer V : VM.getlistOfVolunteer())
        {
          
            if (V.getFirstName().equals(tblVolunteers.getSelectionModel().getSelectedItem().getFirstName()))
            {
                
                
                listOfGuildVolunteerWork = FXCollections.observableArrayList(VM.getVolunteerWork(V.getVolunteerId()));
                colDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
                colHours.setCellValueFactory(new PropertyValueFactory<>("Hour"));
                tblDatesnHours.setItems(listOfGuildVolunteerWork);
            }
        }
    }
    
    
}
