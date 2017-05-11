/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Volunteer;
import GUI.Model.VolunteerModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author boldi
 */
public class VolunteersController implements Initializable
{

    @FXML
    private TextField txtFieldSearch;
    @FXML
    private RadioButton rbtnFirstName;
    @FXML
    private RadioButton rbtnLastName;
    @FXML
    private TableColumn<?, ?> colFirstName;
    @FXML
    private TableColumn<?, ?> colLastName;
    @FXML
    private TableColumn<?, ?> colGuilds;
    @FXML
    private TableColumn<?, ?> colHours;
    @FXML
    private Button btnNewVol;
    @FXML
    private Button btnRemoveVol;
    @FXML
    private Button btnEditVol;
    @FXML
    private Button btnClose;
    
    ObservableList<Volunteer> listOfVolunteers;
    
    private Volunteer volunteer;

    VolunteerModel vm = new VolunteerModel();
    
    VolunteerDetailsController vdc = new VolunteerDetailsController();
    @FXML
    private TableView<Volunteer> allVolTbl;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        showVolunteer();
        listOfVolunteers = FXCollections.observableArrayList(vm.getlistOfVolunteer());
        allVolTbl.setItems(listOfVolunteers);

    }

    public void showVolunteer()
    {
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        
    }

    @FXML
    private void addNewVolunteerBtb(ActionEvent event) throws IOException
    {
        if (event.getSource() == btnNewVol)
        {
            Stage stage = null;
            Parent root = null;
            stage = (Stage) btnNewVol.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/View/VolunteerDetails.fxml"));
            try
            {
                root = fxmlLoader.load();
            } catch (IOException ex)
            {
                Logger.getLogger(VolunteersController.class.getName()).log(Level.SEVERE, null, ex);
            }

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    private void removeVolunteerBtb(ActionEvent event)
    {

        vm.deleteVolunteer(allVolTbl.getSelectionModel().getSelectedItem().getVolunteerId());
        showVolunteer();
        listOfVolunteers = FXCollections.observableArrayList(vm.getlistOfVolunteer());
        allVolTbl.setItems(listOfVolunteers);

    }

    @FXML
    private void ClickedOnVolunteer(MouseEvent event)
    {if(event.isPrimaryButtonDown() && event.getClickCount() == 2) 
        {
            Stage stage = null;
            Parent root = null;
            stage = (Stage) allVolTbl.getScene().getWindow();
            try
            {FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/View/VolunteerDetails.fxml"));
            
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

        public void getVolunteerAddress()
        {
          allVolTbl.getSelectionModel().getSelectedItem().getAddress();     
        }
        public void getVolunteerEmail()
        {
        allVolTbl.getSelectionModel().getSelectedItem().getEmail();
        }
        public void getVolunteerFirstName()
        {
        allVolTbl.getSelectionModel().getSelectedItem().getFirstName();
        }
        public void getVolunteerLastName()
        {
        allVolTbl.getSelectionModel().getSelectedItem().getLastName();
        }

}

