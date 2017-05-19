/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Guild;
import BE.GuildVolunteerWork;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author EdwinSilva
 */
public class GuildVolunteerWorkDataManager {
    
ConnectionManager CM;


    public ArrayList getGuildWorkHoursBasedOnDate(Date startDate, Date endDate) throws SQLServerException, SQLException{
     try (Connection con = CM.getConnection()) {
            String query = 
                    "SELECT date, Hours FROM [GuildVolunteerWork]"
                    +"WHERE GuildId =?"
                    +"And between Date  =? And =?";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<GuildVolunteerWork> GuildWorkTable = new ArrayList<>();
            while (rs.next()) {

                String WorkString = "";
                WorkString += rs.getDate("Date");
                WorkString += rs.getDouble("Hour");
                WorkString += rs.getInt("GuildId");
                WorkString += rs.getInt("VolunteerId");

                GuildWorkTable.add(new GuildVolunteerWork(
                        rs.getInt("GuildId"),
                        rs.getInt("VolunteerId"), 
                        rs.getDate("Date"),
                        rs.getDouble("Hour")));   
            }
     return GuildWorkTable;
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
