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
public class GuildVolunteerWorkDataManager
{

  
    ConnectionManager CM;

    public GuildVolunteerWorkDataManager()
    {
        CM = new ConnectionManager();
    }

    public ArrayList<GuildVolunteerWork> getGuildWorkHoursBasedOnDate(String startDate, String endDate, int GuildId) throws SQLServerException, SQLException
    {
        try (Connection con = CM.getConnection())
        {
            String query = "SELECT * FROM GuildVolunteerWork WHERE GuildId ="+ GuildId +" AND Date between '" + startDate + "' AND '" + endDate + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<GuildVolunteerWork> GuildWorkTable = new ArrayList<>();
            while (rs.next())
            {

                String WorkString = "";
                WorkString += rs.getInt("GuildId");
                WorkString += rs.getInt("VolunteerId");
                WorkString += rs.getDate("Date");
                WorkString += rs.getDouble("Hours");

                GuildWorkTable.add(new GuildVolunteerWork(
                        rs.getInt("GuildId"),
                        rs.getInt("VolunteerId"),
                        rs.getDate("Date"),
                        rs.getDouble("Hours")));
            }
            return GuildWorkTable;
        
        } catch (SQLException sqle)
        {
            System.err.println(sqle);
            return null;
        }

    }

    // +"And between Date" + startDate +  "AND" + endDate + "";
    public void addVolunteerWork(Date Date, double Hour, int GuildId, int VolunteerId)
    {
        {

            try (Connection con = CM.getConnection())
            {

                String sqlCommand
                        = " INSERT INTO GuildVolunteerWork(Date, Hours, GuildId, VolunteerId) VALUES(?,?,?,?)";
                PreparedStatement pstat = con.prepareStatement(sqlCommand);

                pstat.setDate(1, Date);
                pstat.setDouble(2, Hour);
                pstat.setDouble(3, GuildId);
                pstat.setInt(4, VolunteerId);

                pstat.executeUpdate();
            } catch (SQLException sqle)
            {
                System.err.println(sqle);
            }
        }
    }

}
