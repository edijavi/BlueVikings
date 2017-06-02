
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
 *
 * @authors Boldizsár Koppány, Deividas Tamošiūnas, Edwin Mhoy Silva, Jesper Enemark,
 * Edison J. Lamar Toapanta
 *
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
    @FXML
    private ComboBox<String> cmbSearch;
    @FXML
    private TextField txtSearch; 
    
    int GuildId;
    int VolunteerId;
      
    VolunteerModel vm = new VolunteerModel();
    GuildModel gm = new GuildModel();
    
    private SearchHandler.SearchType searchtype;
    

    
    
    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    ShowInView();
    tblVolunteers.setItems(vm.getlistOfVolunteer());
    tblGuilds.setItems(gm.getListOfGuilds());
    setSearchComboItem();
    txtSearch.setDisable(true);
    
    }  

/**
 * If you click on the Add to guild button this method opens a confirmation popup where
 * you can see two options OK or CANCEL after click one of them "IF" method will runs
 * which add the selected member to the selected guild or else close the popup 
 * @param event 
 */

    @FXML
    private void AddMemberToGuiild(ActionEvent event)                                  
    {                                                                                   
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);                                   
        alert.setHeaderText(null);                                                                         
        Stage Iconstage = (Stage) alert.getDialogPane().getScene().getWindow();
        Iconstage.getIcons().add(new Image("CSS/icon.png"));
        alert.setTitle("Confirmation");
        alert.setContentText("Are you sure you want to add " + tblVolunteers.getSelectionModel().getSelectedItem().getFirstName() + " " + tblVolunteers.getSelectionModel().getSelectedItem().getLastName() +" to "+ tblGuilds.getSelectionModel().getSelectedItem().getGuildName());   
        Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK)
            {
                GuildVolunteerModel GVmodel = new GuildVolunteerModel(); 
                getSelectedValues();
                GVmodel.addMemebertoGuild(VolunteerId,GuildId );
                    System.out.println("GuildId"+GuildId);
                    System.out.println("VolunteerId"+VolunteerId);
    
            }else{
                alert.close();}
    }
    /**
     * This method checks the searchtype if null or not, all the characters in the keyboard and the backspace as well.
     * If the combo box i set to First Name, Last Name or Guild the method will reset the items in the right table view
     * according what is in the text field.
     * @param event 
     */
    @FXML
    private void search(KeyEvent event)
    {
        if(searchtype != null && (event.getCode().isLetterKey() || event.getCode().isDigitKey() || event.getCode() == KeyCode.BACK_SPACE)) {

            if(searchtype == SearchHandler.SearchType.FIRSTNAME) { 
                
                    tblVolunteers.setItems(FXCollections.observableArrayList(vm.doSearch(txtSearch.getText(),vm.getlistOfVolunteer(), searchtype)));
                }else if(searchtype == SearchHandler.SearchType.LASTNAME) {

                    tblVolunteers.setItems(FXCollections.observableArrayList(vm.doSearch(txtSearch.getText(),vm.getlistOfVolunteer(), searchtype)));
                }else if(searchtype == SearchHandler.SearchType.GUILD) {

                    tblGuilds.setItems(FXCollections.observableArrayList(gm.doSearch(txtSearch.getText(),gm.getListOfGuilds(), searchtype)));
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
     * This Method prepare the data to load it in the table view
     */
    public void ShowInView()
    {
    
        GuildNameClm.setCellValueFactory(new PropertyValueFactory<>("GuildName"));
        colHours.setCellValueFactory(new PropertyValueFactory<>("GuildHours"));
        FirstNameClm.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        LastNameClm.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    
    }
    /**
     * This method gets the id of the selected value from the tabelview of Volunteer and guild,
     * and saves the in two global varibles.
     */
    public void getSelectedValues()
    {
        VolunteerId  = tblVolunteers.getSelectionModel().getSelectedItem().getVolunteerId();
        GuildId = tblGuilds.getSelectionModel().getSelectedItem().getGuildId();
    }
    /**
     * This Action event method runs when you double click on a guild in the guilds table view.
     * It will load a new window which is the Guild Details FXML and sets the selected item
     * equals with a variable in the new window's controller.
     * @param event 
     */
    @FXML
    private void ClickedOnGuild(MouseEvent event)
    {if(event.isPrimaryButtonDown() && event.getClickCount() == 2) 
        {           
            Parent root = null;
            Stage stage = new Stage();
            Stage stage1 = (Stage) tblGuilds.getScene().getWindow();
            try
            {FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/View/GuildDetails.fxml"));
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
            
            } catch (IOException ex){
                Logger.getLogger(VolunteersController.class.getName()).log(Level.SEVERE, null, ex);
                } 
        }
    }
    /**
     * This method sets the items in the combobox, where you can choose the search options.
     */
  public void setSearchComboItem()
    {
        ObservableList<String> comboItems = FXCollections.observableArrayList("First Name", "Last Name", "Guilds");
        cmbSearch.setItems(comboItems);

    }  
    
}
