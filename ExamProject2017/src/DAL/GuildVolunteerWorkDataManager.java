/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Guild;
import BE.GuildVolunteerWork;
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


public ArrayList<GuildVolunteerWork> getWorkTable() throws IOException {
        try (Connection con = CM.getConnection()) {
            String query = "SELECT * FROM [GuildVolunteerWork]";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<GuildVolunteerWork> WorkTables = new ArrayList<>();
            while (rs.next()) {

                String workString = "";
                workString += rs.getInt("GuildId");
                workString += rs.getInt("VolunteerId");
                workString += rs.getDate("Date");
                workString += rs.getInt("Hours");

                WorkTables.add(new GuildVolunteerWork(
                        rs.getInt("GuildId"),
                        rs.getInt("VolunteerId"), 
                        rs.getDate("Date"),
                        rs.getInt("Hours")
                ));
            }
            return WorkTables;

        } catch (SQLException sqle) {
            System.err.println(sqle);
            return null;
        }
    
    }
    public void AddWorkWithDate(Date date, double Hour) {
        {

        try (Connection con = CM.getConnection())
        {

            String sqlCommand
                    = " INSERT INTO GuildVolunteerWork(Date, Hours) VALUES(?,?)";
            PreparedStatement pstat = con.prepareStatement(sqlCommand);

            pstat.setDate(1, date);
            pstat.setDouble(2, Hour);
            

            pstat.executeUpdate();
        } catch (SQLException sqle)
        {
            System.err.println(sqle);
        }
    }
    }    
 
}
