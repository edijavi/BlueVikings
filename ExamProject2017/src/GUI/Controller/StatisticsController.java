/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Guild;
import BE.GuildVolunteerWork;
import GUI.Model.GuildModel;
import GUI.Model.GuildVolunteerWorkModel;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author boldi
 */
public class StatisticsController implements Initializable
{

    @FXML
    private Button btnDownload;
    @FXML
    private ComboBox<GuildVolunteerWork> cmbStatistics;

    @FXML
    private TableColumn<?, ?> colGuilds;
    @FXML
    private TableView<GuildVolunteerWork> tblStatistics;
    @FXML
    private TableColumn<?, ?> colDate;
    @FXML
    private TableColumn<?, ?> colHours;
    @FXML
    private TableView<Guild> GuildTbl;
    GuildModel GM = new GuildModel();
    GuildVolunteerWorkModel GVWModel = new GuildVolunteerWorkModel();
    ObservableList<Guild> listOfGuilds;
    ObservableList<GuildVolunteerWork> listOfGuildVolunteerWork;
    @FXML
    private DatePicker dpStartDate;
    @FXML
    private DatePicker dpEndDate;

// Fordi den snakker med database? 
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

        try
        {
            ShowGuildInView();
        } catch (IOException ex)
        {
            Logger.getLogger(StatisticsController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void DownloadBtn(ActionEvent event)
    {
    }

    public void ShowGuildInView() throws IOException
    {
        listOfGuilds = FXCollections.observableArrayList(GM.listOfGuilds());
        GuildTbl.setItems(listOfGuilds);
        colGuilds.setCellValueFactory(new PropertyValueFactory<>("GuildName"));

    }

    public void ShowDateAndHours() throws IOException, SQLException
    {

        for (Guild p : GM.listOfGuilds())
        {
          
            if (p.getGuildName().equals(GuildTbl.getSelectionModel().getSelectedItem().getGuildName()))
            {
                String dateStart = dpStartDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String dateEnd = dpEndDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                
                System.out.println(p.getGuildId());
                listOfGuildVolunteerWork = FXCollections.observableArrayList(GVWModel.GetGuildVolunteerWork(dateStart, dateEnd, p.getGuildId()));
                colDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
                colHours.setCellValueFactory(new PropertyValueFactory<>("Hour"));
                tblStatistics.setItems(listOfGuildVolunteerWork);
            }
        }
    }

    @FXML
    private void getGuildStatsOnClick(MouseEvent event) throws IOException, SQLException
    {
        ShowDateAndHours();
        
        System.out.println(listOfGuildVolunteerWork);
        
    }

}
