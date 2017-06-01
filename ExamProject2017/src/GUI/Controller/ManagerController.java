/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Manager;
import BE.Volunteer;
import BLL.SearchHandler;
import BLL.SearchHandler.SearchType;
import GUI.Model.ManagerModel;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
public class ManagerController implements Initializable
{

    @FXML
    private Button btnAddManager;
    @FXML
    private Button btnRemove;
    @FXML
    private Button btnEdit;
    @FXML
    private TextField txtSearch;
    @FXML
    private ComboBox<String> cmbSearch;
    @FXML
    private TableView<Manager> tblManagers;
    @FXML
    private TableColumn<?, ?> colFirstName;
    @FXML
    private TableColumn<?, ?> colLastName;

    private SearchType searchtype;

    ManagerModel mm = new ManagerModel();
/**
 * Disable the search text field.
 * @param url
 * @param rb 
 */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        showManagers();
        setSearchComboItem();
        txtSearch.setDisable(true);

    }
/**
 * This Action event runs if you click on the new manager button in the main view.
 * It opens a new window where you can add the information of the new manager.
 * When you click on the save button it will reset the items in the table view to show the new manager.
 * @param event
 * @throws IOException 
 */
    @FXML
    private void addNewManagerBtb(ActionEvent event) throws IOException
    {
        if (event.getSource() == btnAddManager)
        {
            Parent root = null;
            Stage stage = new Stage();
            Stage stage1 = (Stage) tblManagers.getScene().getWindow();
            try
            {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/View/NewManager.fxml"));
                root = fxmlLoader.load();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setOnHiding(new EventHandler<WindowEvent>()
                {
                    @Override
                    public void handle(WindowEvent event)
                    {
                        tblManagers.setItems(mm.getManagers());
                    }
                });

                stage.setOnCloseRequest(new EventHandler<WindowEvent>()
                {
                    @Override
                    public void handle(WindowEvent event)
                    {
                        tblManagers.setItems(mm.getManagers());
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
    /**
     * This method prepare and upload the data to the table view.
     */
    private void showManagers()
    {
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("Firstname"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("Lastname"));
        tblManagers.setItems(mm.getManagers());

    }
     /**
     * This method checks the searchtype if null or not, all the characters in the keyboard and the backspace as well.
     * If the combo box seted to First Name or Last Name the method will reset the items in the right table view
     * according what is in the text field.
     * @param event 
     */
    @FXML
    private void search(KeyEvent event)
    {
        if (searchtype != null && (event.getCode().isLetterKey() || event.getCode().isDigitKey() || event.getCode() == KeyCode.BACK_SPACE))
        {

            if (searchtype == SearchHandler.SearchType.MANAGERFIRSTNAME)
            {
                tblManagers.setItems(FXCollections.observableArrayList(mm.doSearch(txtSearch.getText(), mm.getManagers(), searchtype)));

            } else if (searchtype == SearchHandler.SearchType.MANAGERLASTNAME)
            {
                tblManagers.setItems(FXCollections.observableArrayList(mm.doSearch(txtSearch.getText(), mm.getManagers(), searchtype)));

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
            this.searchtype = SearchHandler.SearchType.MANAGERFIRSTNAME;
            txtSearch.setDisable(false);
        }
        if ("Last Name".equals(cmbSearch.getSelectionModel().getSelectedItem()))
        {
            this.searchtype = SearchHandler.SearchType.MANAGERLASTNAME;
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
    /**
     * When you double click on a item in the tabel view this method will opens a new window to edit it. 
     * Sets the selected item equals with a variable in the new window's controller.
     * After you close the window the method will refresh the items in the table view with the override method.
     * @param event 
     */
    @FXML
    private void ClickedOnManager(MouseEvent event)
    {
        if (event.isPrimaryButtonDown() && event.getClickCount() == 2)
        {
            {

                Parent root = null;
                Stage stage = new Stage();
                Stage stage1 = (Stage) tblManagers.getScene().getWindow();
                try
                {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/View/ManagerDetails.fxml"));
                    ManagerDetailsController controller = fxmlLoader.getController();
                    ManagerDetailsController.setManager(tblManagers.getSelectionModel().getSelectedItem());
                    root = fxmlLoader.load();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setOnHiding(new EventHandler<WindowEvent>()
                    {
                        @Override
                        public void handle(WindowEvent event)
                        {
                            tblManagers.setItems(mm.getManagers());
                        }
                    });

                    stage.setOnCloseRequest(new EventHandler<WindowEvent>()
                    {
                        @Override
                        public void handle(WindowEvent event)
                        {
                            tblManagers.setItems(mm.getManagers());
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
    /**
     * Jesper
     * @param event 
     */
    @FXML
    private void deleteManager(ActionEvent event)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        Stage Iconstage = (Stage) alert.getDialogPane().getScene().getWindow();
        Iconstage.getIcons().add(new Image("CSS/icon.png"));
        alert.setTitle("Confirmation");
        alert.setContentText("Are you sure you want to remove " + tblManagers.getSelectionModel().getSelectedItem().getFirstname() + " " + tblManagers.getSelectionModel().getSelectedItem().getLastname() + " from the system?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
            mm.deleteManager(tblManagers.getSelectionModel().getSelectedItem().getManagerId());

            colFirstName.setCellValueFactory(new PropertyValueFactory<>("Firstname"));
            colLastName.setCellValueFactory(new PropertyValueFactory<>("Lastname"));

        } else
        {
            alert.close();
        }

        tblManagers.setItems(mm.getManagers());

    }
}
