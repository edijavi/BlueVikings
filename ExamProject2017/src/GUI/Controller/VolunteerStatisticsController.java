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
 * @authors Boldizsár Koppány, Deividas Tamošiūnas, Edwin Mhoy Silva, Jesper Enemark,
 * Edison J. Lamar Toapanta
 *
 */
public class VolunteerStatisticsController implements Initializable
{

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
    
    VolunteerModel vModel = new VolunteerModel();

    ObservableList<Volunteer> listOfGuilds;
    ObservableList<GuildVolunteerWork> listOfGuildVolunteerWork;
    /**
     * Initializes the controller class.
     */

    

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        DisplayVolunteers();
        setSearchComboItem();
        txtSearch.setDisable(true);
    }
    /**
     * Prepare, contain in an observableArrayList, and load the data in the table view.
     */
    public void DisplayVolunteers()
    {
        listOfGuilds = FXCollections.observableArrayList(vModel.getlistOfVolunteer());
        tblVolunteers.setItems(listOfGuilds);
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    }
    /**
    * This method checks the searchtype if null or not, all the characters in the keyboard and the backspace as well.
    * If the combo box seted to First Name or Last Name the method will reset the items in the table view
    * according what is in the text field.
    * @param event 
    */
    @FXML
    private void search(KeyEvent event)
    {
        if (searchtype != null && (event.getCode().isLetterKey() || event.getCode().isDigitKey() || event.getCode() == KeyCode.BACK_SPACE))
        {
            if (searchtype == SearchHandler.SearchType.FIRSTNAME)
            {
                tblVolunteers.setItems(FXCollections.observableArrayList(vModel.doSearch(txtSearch.getText(), vModel.getlistOfVolunteer(), searchtype)));

            } else if (searchtype == SearchHandler.SearchType.LASTNAME)
            {
                tblVolunteers.setItems(FXCollections.observableArrayList(vModel.doSearch(txtSearch.getText(), vModel.getlistOfVolunteer(), searchtype)));

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
     * Sets the items in the combo box
     */
    public void setSearchComboItem()
    {
        ObservableList<String> comboItems = FXCollections.observableArrayList("First Name", "Last Name");
        cmbSearch.setItems(comboItems);
    }
    /**
     * Prepare and load the data in the table view.
     * @param event
     * @throws SQLException 
     */
    @FXML
    private void getVolunteerStatsOnClick(MouseEvent event) throws SQLException
    {

        colDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        colHours.setCellValueFactory(new PropertyValueFactory<>("Hour"));
        tblDatesnHours.setItems(vModel.getVolunteerWork(tblVolunteers.getSelectionModel().getSelectedItem().getVolunteerId()));
            
        
    }
    /**
     * When you double click on a item in the tabel view this method will opens a new window to modify it. 
     * Sets the selected item equals with a variable in the new window's controller.
     * After you close the window the method will refresh the items in the table view with the override method.
     * @param event 
     */
    @FXML
    private void modifyDate(MouseEvent event)
    {
        if (event.isPrimaryButtonDown() && event.getClickCount() == 2)
        {
            Stage stage = new Stage();
            Stage stage1 = (Stage) tblVolunteers.getScene().getWindow();
            Parent root = null;
            try
            {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/View/ModifyDate.fxml"));
                ModifyDateController.setVolunteer(tblVolunteers.getSelectionModel().getSelectedItem());
                ModifyDateController.setDate(tblDatesnHours.getSelectionModel().getSelectedItem());
                root = fxmlLoader.load();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setOnHiding(new EventHandler<WindowEvent>()
                {
                    @Override
                    public void handle(WindowEvent event)
                    {
                        try{
                        tblDatesnHours.setItems(vModel.getVolunteerWork(tblVolunteers.getSelectionModel().getSelectedItem().getVolunteerId()));
                    
                    }catch (SQLException ex){
                            System.out.println(ex);
                }
                }
                });

                stage.setOnCloseRequest(new EventHandler<WindowEvent>()
                {
                    @Override
                    public void handle(WindowEvent event)
                    {
                        try{
                        tblDatesnHours.setItems(vModel.getVolunteerWork(tblVolunteers.getSelectionModel().getSelectedItem().getVolunteerId()));
                    
                    }catch (SQLException ex){
                            System.out.println(ex);
                }
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
