/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Guild;
import BE.GuildVolunteerWork;
import BLL.SearchHandler;
import BLL.SearchHandler.SearchType;
import GUI.Model.GuildModel;
import GUI.Model.GuildVolunteerWorkModel;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * FXML Controller class
 * @authors Boldizsár Koppány, Deividas Tamošiūnas, Edwin Mhoy Silva, Jesper Enemark,
 * Edison J. Lamar Toapanta
 *
 */
public class StatisticsController implements Initializable
{

    @FXML
    private Button btnDownload;

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
    @FXML
    private DatePicker dpStartDate;
    @FXML
    private DatePicker dpEndDate;
    @FXML
    private TextField txtSearch;
    
    GuildModel GM = new GuildModel();
    GuildVolunteerWorkModel GVWModel = new GuildVolunteerWorkModel();

    ObservableList<Guild> listOfGuilds;
    ObservableList<GuildVolunteerWork> listOfGuildVolunteerWork;

    private SearchType searchtype;

   
    
 


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
    /**
     * This event will runs if you click on the downolad button. It will opens an information alert
     * which says that the download was successfully.
     * Edwin
     * @param event
     * @throws IOException 
     */

    @FXML
    private void DownloadBtn(ActionEvent event) throws IOException
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("CSS/icon.png"));
        alert.setTitle("Downloaded");
        alert.setContentText("The statistic has been donwloaded for " + GuildTbl.getSelectionModel().getSelectedItem().getGuildName());
        alert.show();  
        printToExcel();
    }
    /**
     * Prepares and loads the data to the table view.
     * @throws IOException 
     */
    public void ShowGuildInView() throws IOException
    {        
        GuildTbl.setItems(GM.getListOfGuilds());
        colGuilds.setCellValueFactory(new PropertyValueFactory<>("GuildName"));
    }

     /**
     * This method checks the searchtype if null or not, all the characters in the keyboard and the backspace as well.
     * It will reset the items in the right table view according what is in the text field.
     * @param event 
     */
    @FXML
    private void search(KeyEvent event)
    {
        if ((event.getCode().isLetterKey() || event.getCode().isDigitKey() || event.getCode() == KeyCode.BACK_SPACE))
        {
            this.searchtype = SearchHandler.SearchType.GUILD;
            GuildTbl.setItems(FXCollections.observableArrayList(GM.doSearch(txtSearch.getText(), GM.getListOfGuilds(), searchtype)));
        }
    }
/**
 * If the datepickers are empty it goes through list of guilds and picks the object that is equal to what is selected
 * Then it is displaying the work from before the program was made a 13 years into the future based on the guildId
 * @throws IOException
 * @throws SQLException 
 */
    public void ShowDateAndHours() throws IOException, SQLException
    {
        if(dpStartDate.getValue() == null || dpEndDate.getValue() == null) {
        for (Guild p : GM.getListOfGuilds())
        {
            if (p.getGuildName().equals(GuildTbl.getSelectionModel().getSelectedItem().getGuildName()))
            {
                
                colDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
                colHours.setCellValueFactory(new PropertyValueFactory<>("Hour"));
                tblStatistics.setItems(GVWModel.GetGuildVolunteerWork("2016-05-22", "2030-05-22", p.getGuildId()));

            }
        }
        }
        else {
        for (Guild p : GM.getListOfGuilds())
        {
            if (p.getGuildName().equals(GuildTbl.getSelectionModel().getSelectedItem().getGuildName()))
            {
                String dateStart = dpStartDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String dateEnd = dpEndDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                System.out.println(p.getGuildId());
                
                colDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
                colHours.setCellValueFactory(new PropertyValueFactory<>("Hour"));
                tblStatistics.setItems(GVWModel.GetGuildVolunteerWork(dateStart, dateEnd, p.getGuildId()));
                
            }
        }
    }
    }
/**
 * 
 * @param event
 * @throws IOException
 * @throws SQLException 
 * Initializes ShowDateAndHours
 */
    @FXML
    private void getGuildStatsOnClick(MouseEvent event) throws IOException, SQLException
    {           
        ShowDateAndHours();
        
        
    }
    /**
     * Edwin
     * @throws IOException 
     */
    public void printToExcel() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();

        HSSFSheet spreadsheet = workbook.createSheet("GuildWork");

        HSSFRow row = null;

        int i = 1;
        for (GuildVolunteerWork item : tblStatistics.getItems()) {

            HSSFRow headingRow = spreadsheet.createRow(0);
            headingRow.createCell((short) 0).setCellValue("Date");
            headingRow.createCell((short) 1).setCellValue("GuildId");
            headingRow.createCell((short) 2).setCellValue("VolunteerId");
            headingRow.createCell((short) 3).setCellValue("Hours");
            ;

            row = spreadsheet.createRow(i);
            row.createCell((short) 0).setCellValue(item.getDate().toString());
            row.createCell((short) 1).setCellValue(item.getGuildId());
            row.createCell((short) 2).setCellValue(item.getVolunteerId());
            row.createCell((short) 3).setCellValue(item.getHour());

            //.... add other column data as well
            i++;
        }

        try {
            //Write the workbook in file system
            String PathTillProject = System.getProperty("user.dir");
            try (FileOutputStream out = new FileOutputStream(PathTillProject + "/src/"+GuildTbl.getSelectionModel().getSelectedItem().getGuildName()+".xls")) {
                workbook.write(out);
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            workbook.close();
        }
    }
}
