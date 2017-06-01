/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Guild;
import BE.Volunteer;
import BLL.SearchHandler;
import BLL.SearchHandler.SearchType;
import GUI.Model.GuildVolunteerModel;
import GUI.Model.ManagerModel;
import GUI.Model.VolunteerModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jesper Enemark
 */
public class GuildDetailsController implements Initializable
{

    
    @FXML
    private Button btnClose;
    @FXML
    private TableView<Volunteer> tblMembers;
    @FXML
    private TableColumn<?, ?> colFirstName;
    @FXML
    private TableColumn<?, ?> colLastName;
    @FXML
    private Label lblAllHours;
    @FXML
    private Label lblAllMembers;
    @FXML
    private ComboBox<String> cmbSearch;
    @FXML
    private TextField txtSearch;
    @FXML
    private Label lblGuildName;
    
    ObservableList<Volunteer> listOfVolunteersBasedOnGuild;

    private SearchType searchtype;

    private static Guild guild;

    VolunteerModel vm = new VolunteerModel();

    ManagerModel MM = new ManagerModel();

    GuildVolunteerModel GVM = new GuildVolunteerModel();

    /**
     * Set the items in the table view, and the details of the selected guild. 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        setGuildMembers();
        setSearchComboItem();
        txtSearch.setDisable(true);
        lblGuildName.setText(guild.getGuildName());
        String guildhour = String.valueOf(guild.getGuildHours());
        lblAllHours.setText(guildhour);
        String guildMembers = String.valueOf(GVM.getVolunteersBasedOnGuild(guild.getGuildName()).size());
        lblAllMembers.setText(guildMembers);
    }
    /**
     * Close the program 
     * @param event 
     */
    @FXML
    private void closeAction(ActionEvent event)
    {
        Stage closeStage = (Stage) btnClose.getScene().getWindow();
        closeStage.close();
    }
    /**
     * We use this method to get the information from the Guild view and load it here.  
     * @param guildd 
     */
    public static void setGuild(Guild guildd)
    {
        guild = guildd;
    }
    /**
     * Prepare the data to load it in the view
     */
    public void setGuildMembers()
    {
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        tblMembers.setItems(GVM.getVolunteersBasedOnGuild(guild.getGuildName()));
    }
    /**
     * This method checks the searchtype if null or not, all the characters in the keyboard and the backspace as well.
     * If the combo box seted to First Name or Last Name the method will enable the text field,
     * and reset the items in the right table view according what is in the text field.
     * @param event 
     */
    @FXML
    private void search(KeyEvent event)
    {
        if (searchtype != null && (event.getCode().isLetterKey() || event.getCode().isDigitKey() || event.getCode() == KeyCode.BACK_SPACE))
        {
            if (searchtype == SearchHandler.SearchType.FIRSTNAME)
            {
                tblMembers.setItems(FXCollections.observableArrayList(vm.doSearch(txtSearch.getText(), GVM.getVolunteersBasedOnGuild(guild.getGuildName()), searchtype)));

            } else if (searchtype == SearchHandler.SearchType.LASTNAME)
            {
                tblMembers.setItems(FXCollections.observableArrayList(vm.doSearch(txtSearch.getText(), GVM.getVolunteersBasedOnGuild(guild.getGuildName()), searchtype)));

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
        if ("First Name".equals(cmbSearch.getSelectionModel().getSelectedItem()))
        {
            this.searchtype = SearchHandler.SearchType.FIRSTNAME;
            txtSearch.setDisable(false);
        }
        if ("Last Name".equals(cmbSearch.getSelectionModel().getSelectedItem()))
        {
            this.searchtype = SearchHandler.SearchType.LASTNAME;
            txtSearch.setDisable(false);
        }
    }
    /**
    * This method sets the items in the combobox, where you can choose the search options.
    */
    public void setSearchComboItem()
    {
        ObservableList<String> comboItems = FXCollections.observableArrayList("First Name", "Last Name");
        cmbSearch.setItems(comboItems);

    }

}
