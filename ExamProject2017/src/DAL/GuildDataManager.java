/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Guild;
import BE.Volunteer;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.sql.Date;
import org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig;


/**
 *
 * @author EdwinSilva
 */
public class GuildDataManager {

    ConnectionManager CM;

    private static GuildDataManager GUILDDATAMANAGER = new GuildDataManager();

    public GuildDataManager() {
        CM = new ConnectionManager();
    }

    public ArrayList<Guild> getGuild() throws IOException {
        try (Connection con = CM.getConnection()) {
            String query = "SELECT * FROM [Guild]";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<Guild> Guilds = new ArrayList<>();
            while (rs.next()) {

                String guildString = "";
                guildString += rs.getString("GuildName");
                guildString += rs.getFloat("GuildHours");
                guildString += rs.getInt("GuildId");
                guildString += rs.getInt("ManagerId");

                Guilds.add(new Guild(
                        rs.getString("GuildName"),
                        rs.getInt("GuildId"), 
                        rs.getFloat("GuildHours"),
                        rs.getInt("ManagerId")
                ));
//        XSSFWorkbook workbook = new XSSFWorkbook();
//        XSSFSheet spreadsheet = workbook
//                .createSheet("Guild db");
//        XSSFRow row = spreadsheet.createRow(1);
//        XSSFCell cell;
//        cell = row.createCell(1);
//        cell.setCellValue(" Guild Name");
//        cell = row.createCell(2);
//        cell.setCellValue("Guild Id");
//        cell = row.createCell(3);
//        cell.setCellValue("Guild Hours");
//        int i=2;
//      while(rs.next())
//      {
//         row=spreadsheet.createRow(i);
//         cell=row.createCell(1);
//         cell.setCellValue(rs.getString("GuildName"));
//         cell=row.createCell(2);
//         cell.setCellValue(rs.getInt("GuildId"));
//         cell=row.createCell(3);
//         cell.setCellValue(rs.getFloat("GuildHours"));
//        
//         i++;
//      }
//        FileOutputStream out = new FileOutputStream(
//      new File("exceldatabase.xlsx"));
//      workbook.write(out);
//      out.close();
//      System.out.println(
//      "exceldatabase.xlsx written successfully");
            }
            return Guilds;

        } catch (SQLException sqle) {
            System.err.println(sqle);
            return null;
        }
    }
    
    public void updateGuildHours(double GuildHours, int GuildId) {
        try (Connection con = CM.getConnection()) {
            String sqlQuery
                    = "UPDATE Guild SET GuildHours=? WHERE GuildId=?";
            PreparedStatement pstmt
                    = con.prepareStatement(sqlQuery);

            pstmt.setDouble(1, GuildHours);
            pstmt.setInt(2, GuildId);
            

            pstmt.execute();

        } catch (SQLException sqle) {
            System.err.println(sqle);
        }

    }
    
    public void addVolunteerWork(Date date, double Hour, int GuildId, int VolunteerId) {
        {

        try (Connection con = CM.getConnection())
        {

            String sqlCommand
                    = " INSERT INTO GuildVolunteerWork(Date, Hours, GuildId, VolunteerId) VALUES(?,?,?,?)";
            PreparedStatement pstat = con.prepareStatement(sqlCommand);

            pstat.setDate(1, date);
            pstat.setDouble(2, Hour);
            pstat.setInt(3, GuildId);
            pstat.setInt(4, VolunteerId);

            pstat.executeUpdate();
        } catch (SQLException sqle)
        {
            System.err.println(sqle);
        }
    }
    }
    
    
        
}
