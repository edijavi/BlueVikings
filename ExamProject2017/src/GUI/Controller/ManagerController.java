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

    /**
     * Initializes the controller class.
     */
    private SearchType searchtype;

    ManagerModel mm = new ManagerModel();

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

        colFirstName.setCellValueFactory(new PropertyValueFactory<>("Firstname"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("Lastname"));
        tblManagers.setItems(mm.getManagers());
        setSearchComboItem();
        txtSearch.setDisable(true);

    }

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

    @FXML
    private void search(KeyEvent event)
    {
        if (searchtype != null && (event.getCode().isLetterKey() || event.getCode().isDigitKey() || event.getCode() == KeyCode.BACK_SPACE))
        {
            List<Manager> managers;
            if (searchtype == SearchHandler.SearchType.MANAGERFIRSTNAME)
            {

                managers = mm.getManagers();
                tblManagers.setItems(FXCollections.observableArrayList(mm.doSearch(txtSearch.getText(), managers, searchtype)));

            } else if (searchtype == SearchHandler.SearchType.MANAGERLASTNAME)
            {

                managers = mm.getManagers();
                tblManagers.setItems(FXCollections.observableArrayList(mm.doSearch(txtSearch.getText(), managers, searchtype)));

            }
        }
    }

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

    public void setSearchComboItem()
    {
        ObservableList<String> comboItems = FXCollections.observableArrayList("First Name", "Last Name");
        cmbSearch.setItems(comboItems);

    }

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

    @FXML
    private void deleteManager(ActionEvent event)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
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
