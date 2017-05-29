/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;


import BE.GuildVolunteerWork;
import BE.Volunteer;
import BLL.SearchHandler;
import BLL.SearchHandler.SearchType;
import GUI.Model.VolunteerModel;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author boldi
 */
public class VolunteerStatisticsController implements Initializable {

    @FXML
    private TextField txtSearch;
    @FXML
    private ComboBox<String> cmbSearch;
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
    private SearchType searchtype;
    VolunteerModel vm = new VolunteerModel();

    ObservableList<Volunteer> listOfGuilds;
    ObservableList<GuildVolunteerWork> listOfGuildVolunteerWork;
    /**
     * Initializes the controller class.
     */
    
    VolunteerModel VM = new VolunteerModel();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DisplayVolunteers();
        setSearchComboItem();
        txtSearch.setDisable(true);
    }    
    
    
    public void DisplayVolunteers() {
        listOfGuilds = FXCollections.observableArrayList(VM.getlistOfVolunteer());
        tblVolunteers.setItems(listOfGuilds);
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        
        
    }
    
     @FXML
    private void search(KeyEvent event)
    {
        if(searchtype != null && (event.getCode().isLetterKey() || event.getCode().isDigitKey() || event.getCode() == KeyCode.BACK_SPACE)) {
            List<Volunteer> volunteers;
            if(searchtype == SearchHandler.SearchType.FIRSTNAME) {
                
                    volunteers = vm.getlistOfVolunteer();  
                    tblVolunteers.setItems(FXCollections.observableArrayList(vm.doSearch(txtSearch.getText(),volunteers, searchtype)));
               
            }else if(searchtype == SearchHandler.SearchType.LASTNAME) {
                
                    volunteers = vm.getlistOfVolunteer();
                    tblVolunteers.setItems(FXCollections.observableArrayList(vm.doSearch(txtSearch.getText(),volunteers, searchtype)));
            
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
    }
    public void setSearchComboItem()
    {
        ObservableList<String> comboItems = FXCollections.observableArrayList("First Name", "Last Name");
        cmbSearch.setItems(comboItems);

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
    @FXML
    private void modifyDate(MouseEvent event)
    {
        if(event.isPrimaryButtonDown() && event.getClickCount() == 2)
        {
            Stage stage = new Stage();
            Stage stage1 = (Stage) tblVolunteers.getScene().getWindow();
            Parent root = null;
            try
            {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/View/ModifyDate.fxml"));
                ModifyDateController controller = fxmlLoader.getController();
                controller.setVolunteer(tblVolunteers.getSelectionModel().getSelectedItem());
                ModifyDateController.setDate(tblDatesnHours.getSelectionModel().getSelectedItem());
                root = fxmlLoader.load();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setOnHiding(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                tblDatesnHours.setItems(FXCollections.observableArrayList(listOfGuildVolunteerWork));   
                        }
                    });
            
                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                tblDatesnHours.setItems(FXCollections.observableArrayList(listOfGuildVolunteerWork));    
                }
                });

                stage.getIcons().add(new Image("CSS/icon.png"));
                stage.setResizable(false);
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(stage1);
                stage.show();
           
            
            } catch (IOException ex)
            {
                Logger.getLogger(VolunteersController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
    
}
