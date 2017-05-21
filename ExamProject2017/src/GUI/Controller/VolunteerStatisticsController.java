/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author boldi
 */
public class VolunteerStatisticsController implements Initializable {

    @FXML
    private TextField txtSearch;
    @FXML
    private ComboBox<?> cmbSearch;
    @FXML
    private TableView<?> tblVolunteers;
    @FXML
    private TableColumn<?, ?> colFirstName;
    @FXML
    private TableColumn<?, ?> colLastName;
    @FXML
    private TableView<?> tblDatesnHours;
    @FXML
    private TableColumn<?, ?> colDate;
    @FXML
    private TableColumn<?, ?> colHours;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
