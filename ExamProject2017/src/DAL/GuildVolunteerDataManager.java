/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Guild;
import BE.Volunteer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author EdwinSilva
 */
public class GuildVolunteerDataManager {

    ConnectionManager CM;
    Volunteer volunteer = new Volunteer();
    Guild guild = new Guild();

    public GuildVolunteerDataManager() {
        CM = new ConnectionManager();
    }

    public void addMemberToGuild(int VolunteerId, int GuildId) {
        try (Connection con = CM.getConnection()) {

            String sqlCommand
 = "INSERT INTO GuildVolunteers ( GuildId, VolunteerId) VALUES( ?, ?)";

            PreparedStatement pstat = con.prepareStatement(sqlCommand);
            
            pstat.setInt(1, GuildId);
            pstat.setInt(2, VolunteerId);
            pstat.executeUpdate();
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }
    public void deleteVolunteerFromGuild(int volunteerId) {
      
        try (Connection con = CM.getConnection()) {
            String sqlCommand
                    = "DELETE FROM GuildVolunteers WHERE VolunteerId=?" ; 
             PreparedStatement pstat = con.prepareStatement(sqlCommand);
             pstat.setInt(1, volunteerId);
             pstat.executeUpdate();
             
             
           
        } catch (SQLException sqle) {
            System.err.println(sqle);
           
        }
        
  
}
    
}


    
    