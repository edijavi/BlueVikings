/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Guild;
import BE.Volunteer;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

    public ArrayList<Guild> getGuild() {
        try (Connection con = CM.getConnection()) {
            String query = "SELECT * FROM [Guild]";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<Guild> Guilds = new ArrayList<>();
            while (rs.next()) {

                String guildString = "";
                guildString += rs.getString("GuildName");
                guildString += rs.getInt("GuildHours");
                guildString += rs.getInt("GuildId");
                guildString += rs.getInt("ManagerId");

                Guilds.add(new Guild(
                        rs.getString("GuildName"),
                        rs.getInt("GuildId"),
                        rs.getInt("GuildHours"),
                        rs.getInt("ManagerId")
                ));

            }
            return Guilds;

        } catch (SQLException sqle) {
            System.err.println(sqle);
            return null;
        }
    }
}
