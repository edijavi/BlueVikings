/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Guild;
import BE.GuildVolunteerWork;
import BE.Volunteer;
import BLL.SearchHandler;
import BLL.SearchHandler.SearchType;
import GUI.Model.GuildModel;
import GUI.Model.GuildVolunteerWorkModel;
import java.io.FileOutputStream;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

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
    @FXML
    private TextField txtSearch;
    private SearchType searchtype;
    GuildModel gm = new GuildModel();

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
    private void DownloadBtn(ActionEvent event) throws IOException
    {
        HSSFWorkbook workbook = new HSSFWorkbook();

        HSSFSheet spreadsheet = workbook.createSheet("GuildWork");

        HSSFRow row = null;

        int i = 1;
        for (GuildVolunteerWork item : tblStatistics.getItems())
        {
            row = spreadsheet.createRow(i);
            row.createCell(1).setCellValue(item.getGuildId());
            //.... add other column data as well
            i++;
        }

        try
        {
            //Write the workbook in file system
            String PathTillProject = System.getProperty("user.dir");
            FileOutputStream out = new FileOutputStream(PathTillProject + "/src/Guild.xls");

            workbook.write(out);
            out.close();
            System.out.println("CountriesDetails.xlsx has been created successfully");
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            workbook.close();
        }
    }

    public void ShowGuildInView() throws IOException
    {
        listOfGuilds = FXCollections.observableArrayList(GM.listOfGuilds());
        GuildTbl.setItems(listOfGuilds);
        colGuilds.setCellValueFactory(new PropertyValueFactory<>("GuildName"));

    }

    @FXML
    private void search(KeyEvent event)
    {
        if ((event.getCode().isLetterKey() || event.getCode().isDigitKey() || event.getCode() == KeyCode.BACK_SPACE))
        {
            List<Guild> guilds;
            this.searchtype = SearchHandler.SearchType.GUILD;
            try
            {
                guilds = gm.listOfGuilds();
                GuildTbl.setItems(FXCollections.observableArrayList(gm.doSearch(txtSearch.getText(), guilds, searchtype)));
            } catch (IOException ex)
            {
                Logger.getLogger(GuildController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void ShowDateAndHours() throws IOException, SQLException
    {
        if(dpStartDate.getValue() == null || dpEndDate.getValue() == null) {
        for (Guild p : GM.listOfGuilds())
        {
            if (p.getGuildName().equals(GuildTbl.getSelectionModel().getSelectedItem().getGuildName()))
            {
                listOfGuildVolunteerWork = FXCollections.observableArrayList(GVWModel.GetGuildVolunteerWork("2016-05-22", "2030-05-22", p.getGuildId()));
                colDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
                colHours.setCellValueFactory(new PropertyValueFactory<>("Hour"));
                tblStatistics.setItems(listOfGuildVolunteerWork);

            }
        }
        }
        else {
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
    }


@FXML
        private void getGuildStatsOnClick(MouseEvent event) throws IOException, SQLException
    {
        ShowDateAndHours();

        System.out.println(listOfGuildVolunteerWork);

    }

}
