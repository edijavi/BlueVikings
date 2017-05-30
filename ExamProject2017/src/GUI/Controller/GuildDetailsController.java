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
import static GUI.Controller.LogInController.loginType.ADMIN;
import static GUI.Controller.LogInController.loginType.MANAGER;
import GUI.Model.GuildVolunteerModel;
import GUI.Model.ManagerModel;
import GUI.Model.VolunteerModel;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
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

    private static Guild guild;

    VolunteerModel vm = new VolunteerModel();

    ManagerModel MM = new ManagerModel();

    GuildVolunteerModel GVM = new GuildVolunteerModel();

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

    ObservableList<Volunteer> listOfVolunteersBasedOnGuild;

    @FXML
    private ComboBox<String> cmbSearch;
    @FXML
    private TextField txtSearch;

    private SearchType searchtype;
    @FXML
    private Label lblGuildName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        setGuildMembers();
        setSearchComboItem();
        txtSearch.setDisable(true);
        
        
        
        
      
    }

    @FXML
    private void closeAction(ActionEvent event)
    {
        Stage closeStage = (Stage) btnClose.getScene().getWindow();
        closeStage.close();
    }

    public static void setGuild(Guild guildd)
    {
        guild = guildd;
    }

    public void setGuildMembers()
    {

        colFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        tblMembers.setItems(GVM.getVolunteersBasedOnGuild(guild.getGuildName()));
    }

    @FXML
    private void search(KeyEvent event)
    {
        if (searchtype != null && (event.getCode().isLetterKey() || event.getCode().isDigitKey() || event.getCode() == KeyCode.BACK_SPACE))
        {
            List<Volunteer> volunteers;
            if (searchtype == SearchHandler.SearchType.FIRSTNAME)
            {

                volunteers = GVM.getVolunteersBasedOnGuild(guild.getGuildName());
                tblMembers.setItems(FXCollections.observableArrayList(vm.doSearch(txtSearch.getText(), volunteers, searchtype)));

            } else if (searchtype == SearchHandler.SearchType.LASTNAME)
            {

                volunteers = GVM.getVolunteersBasedOnGuild(guild.getGuildName());
                tblMembers.setItems(FXCollections.observableArrayList(vm.doSearch(txtSearch.getText(), volunteers, searchtype)));

            }
        }
    }

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

    public void setSearchComboItem()
    {
        ObservableList<String> comboItems = FXCollections.observableArrayList("First Name", "Last Name");
        cmbSearch.setItems(comboItems);

    }

}
