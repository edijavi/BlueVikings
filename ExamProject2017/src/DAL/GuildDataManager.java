
package DAL;

import BE.Guild;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.sql.Date;


/**
 *
 * @authors Boldizsár Koppány, Deividas Tamošiūnas, Edwin Mhoy Silva, Jesper Enemark,
 * Edison J. Lamar Toapanta
 *
 */
public class GuildDataManager {

    ConnectionManager CM;

    private static GuildDataManager GUILDDATAMANAGER = new GuildDataManager();

    public GuildDataManager() {
        CM = new ConnectionManager();
    }

    public ArrayList<Guild> getGuild(){
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
    /**
 * 
 * INSERTs GuildVolunterWork, 4 parameters required
 */
    public void addGuildVolunteerWork(Date date, double Hour, int GuildId, int VolunteerId) {
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
