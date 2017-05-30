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
import BLL.SearchHandler;
import GUI.Model.GuildModel;
import GUI.Model.VolunteerModel;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
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
    private TableView<Volunteer> tblVolunteers;
    @FXML
    private TableColumn<?,? > GuildNameClm;
    @FXML
    private TableColumn<?, ?> FirstNameClm;
    @FXML
    private TableColumn<?, ?> LastNameClm;
    
    
    
    GuildVolunteerModel GVmodel = new GuildVolunteerModel();
    
    GuildModel GModel = new GuildModel();
    
    VolunteerModel VModel = new VolunteerModel();
    
    int GuildId;
    
    int VolunteerId;
    
    @FXML
    private ComboBox<String> cmbSearch;
    
    @FXML
    private TextField txtSearch;
   
    private SearchHandler.SearchType searchtype;
    
    VolunteerModel vm = new VolunteerModel();
    
    GuildModel gm = new GuildModel();
    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    ShowInView();
    
    
        
    tblVolunteers.setItems(VModel.getlistOfVolunteer());
    tblGuilds.setItems(gm.getListOfGuilds());
    setSearchComboItem();
    txtSearch.setDisable(true);
    
    }  


    @FXML
    private void AddMemberToGuiild(ActionEvent event) {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setHeaderText(null);
    alert.setTitle("Confirmation");
    alert.setContentText("Are you sure you want to add " + tblVolunteers.getSelectionModel().getSelectedItem().getFirstName() + " " + tblVolunteers.getSelectionModel().getSelectedItem().getLastName() +" to "+ tblGuilds.getSelectionModel().getSelectedItem().getGuildName());   
    Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
    GuildVolunteerModel GVmodel = new GuildVolunteerModel(); 
    getSelectedValues();
    GVmodel.addMemebertoGuild(VolunteerId,GuildId );
        System.out.println("GuildId"+GuildId);
        System.out.println("VolunteerId"+VolunteerId);
    
    }else{alert.close();}
    }
    @FXML
    private void search(KeyEvent event)
    {
        if(searchtype != null && (event.getCode().isLetterKey() || event.getCode().isDigitKey() || event.getCode() == KeyCode.BACK_SPACE)) {
            List<Volunteer> volunteers;
            List<Guild> guilds;
            if(searchtype == SearchHandler.SearchType.FIRSTNAME) {
                    volunteers = vm.getlistOfVolunteer();  
                    tblVolunteers.setItems(FXCollections.observableArrayList(vm.doSearch(txtSearch.getText(),volunteers, searchtype)));
                }else if(searchtype == SearchHandler.SearchType.LASTNAME) {
                    volunteers = vm.getlistOfVolunteer();
                    tblVolunteers.setItems(FXCollections.observableArrayList(vm.doSearch(txtSearch.getText(),volunteers, searchtype)));
                }else if(searchtype == SearchHandler.SearchType.GUILD) {
                    guilds = gm.getListOfGuilds();
                    tblGuilds.setItems(FXCollections.observableArrayList(gm.doSearch(txtSearch.getText(),guilds, searchtype)));
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
    public void ShowInView()
    {
    
    GuildNameClm.setCellValueFactory(new PropertyValueFactory<>("GuildName"));
    colHours.setCellValueFactory(new PropertyValueFactory<>("GuildHours"));
    FirstNameClm.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    LastNameClm.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    
    }
    public void getSelectedValues(){
    VolunteerId  = tblVolunteers.getSelectionModel().getSelectedItem().getVolunteerId();
    GuildId = tblGuilds.getSelectionModel().getSelectedItem().getGuildId();
    }
    
    @FXML
    private void ClickedOnGuild(MouseEvent event)
    {if(event.isPrimaryButtonDown() && event.getClickCount() == 2) 
        {
            
            Parent root = null;
            Stage stage = new Stage();
            Stage stage1 = (Stage) tblGuilds.getScene().getWindow();
            try
            {FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/View/GuildDetails.fxml"));
            GuildDetailsController controller = fxmlLoader.getController();
            GuildDetailsController.setGuild(tblGuilds.getSelectionModel().getSelectedItem());
            
            root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.getIcons().add(new Image("CSS/icon.png"));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(stage1);
            stage.show();
            stage.setResizable(false);
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
