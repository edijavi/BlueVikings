/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Volunteer;
import BLL.SearchHandler.SearchType;
import GUI.Model.VolunteerModel;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
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
public class VolunteersController implements Initializable
{

    @FXML
    private TableColumn<?, ?> colFirstName;
    @FXML
    private TableColumn<?, ?> colLastName;
    @FXML
    private Button btnNewVol;
    @FXML
    private Button btnRemoveVol;
    @FXML
    private Button btnEditVol;
    
    
    
    private Volunteer volunteer;

    VolunteerModel vm = new VolunteerModel();
    
    VolunteerDetailsController vdc = new VolunteerDetailsController();
    @FXML
    private TableView<Volunteer> allVolTbl;
    @FXML
    private ComboBox<String> cmbSearch;
    
    private SearchType searchtype;
    @FXML
    private TextField txtSearch;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        showVolunteer();
        
        allVolTbl.setItems(vm.getlistOfVolunteer());
        setSearchComboItem();
        txtSearch.setDisable(true);

    }


    public void showVolunteer()
    {
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        
    }
    @FXML
    private void search(KeyEvent event)
    {
        if(searchtype != null && (event.getCode().isLetterKey() || event.getCode().isDigitKey() || event.getCode() == KeyCode.BACK_SPACE)) {
            List<Volunteer> volunteers;
            if(searchtype == SearchType.FIRSTNAME) {
                
                    volunteers = vm.getlistOfVolunteer();  
                    allVolTbl.setItems(FXCollections.observableArrayList(vm.doSearch(txtSearch.getText(),volunteers, searchtype)));
               
            }else if(searchtype == SearchType.LASTNAME) {
                
                    volunteers = vm.getlistOfVolunteer();
                    allVolTbl.setItems(FXCollections.observableArrayList(vm.doSearch(txtSearch.getText(),volunteers, searchtype)));
            
            }
    }
    }
    @FXML
    private void setSearchType(ActionEvent event)
    {
    if("First Name".equals(cmbSearch.getSelectionModel().getSelectedItem()))
        {
            this.searchtype = SearchType.FIRSTNAME;
            txtSearch.setDisable(false);
        }
    if("Last Name".equals(cmbSearch.getSelectionModel().getSelectedItem()))
        {
            this.searchtype = SearchType.LASTNAME;
            txtSearch.setDisable(false);
        }
    }


    @FXML
    private void addNewVolunteerBtb(ActionEvent event) throws IOException
    {
        if (event.getSource() == btnNewVol)
        {
            
            Parent root = null;
            Stage stage = new Stage();
            Stage stage1 = (Stage) allVolTbl.getScene().getWindow();
            try
            {FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/View/NewVolunteer.fxml"));
            root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setOnHiding(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                allVolTbl.setItems(FXCollections.observableArrayList(vm.getlistOfVolunteer()));   
                }
            });
            
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                allVolTbl.setItems(FXCollections.observableArrayList(vm.getlistOfVolunteer()));    
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

    @FXML
    private void removeVolunteerBtb(ActionEvent event)
    {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmation");
        alert.setContentText("Are you sure you want to remove " + allVolTbl.getSelectionModel().getSelectedItem().getFirstName()+ " " + allVolTbl.getSelectionModel().getSelectedItem().getLastName() +" from the system" );
        Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                vm.deleteVolunteer(allVolTbl.getSelectionModel().getSelectedItem().getVolunteerId());
                showVolunteer();
                
                allVolTbl.setItems(vm.getlistOfVolunteer());
            }else{alert.close();}
    }

    @FXML
    private void ClickedOnVolunteer(MouseEvent event)
    {if(event.isPrimaryButtonDown() && event.getClickCount() == 2) 
        {
            
            Parent root = null;
            Stage stage = new Stage();
            Stage stage1 = (Stage) allVolTbl.getScene().getWindow();
            try
            {FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/View/VolunteerDetails.fxml"));
            VolunteerDetailsController.setVolunteer(allVolTbl.getSelectionModel().getSelectedItem());
            VolunteerDetailsController controller = fxmlLoader.getController();
           // controller.setCurrentVolunteer(allVolTbl.getSelectionModel().getSelectedItem());
            root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setOnHiding(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                allVolTbl.setItems(FXCollections.observableArrayList(vm.getlistOfVolunteer()));   
                }
            });
            
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                allVolTbl.setItems(FXCollections.observableArrayList(vm.getlistOfVolunteer()));    
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
      public void setSearchComboItem()
    {
        ObservableList<String> comboItems = FXCollections.observableArrayList("First Name", "Last Name");
        cmbSearch.setItems(comboItems);

    }

        

}

