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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author EdwinSilva
 */
public class GuildVolunteerDataManager
{

    ConnectionManager CM;
    Volunteer volunteer = new Volunteer();
    Guild guild = new Guild();

    public GuildVolunteerDataManager()
    {
        CM = new ConnectionManager();
    }

    public void addMemberToGuild(int VolunteerId, int GuildId)
    {
        try (Connection con = CM.getConnection())
        {

            String sqlCommand
                    = "INSERT INTO GuildVolunteers ( GuildId, VolunteerId) VALUES( ?, ?)";

            PreparedStatement pstat = con.prepareStatement(sqlCommand);

            pstat.setInt(1, GuildId);
            pstat.setInt(2, VolunteerId);
            pstat.executeUpdate();
        } catch (SQLException sqle)
        {
            System.err.println(sqle);
        }
    }
    
    public ArrayList<Volunteer> getVolunteerBasedOnGuild(String GuildName)
    {

        ArrayList<Volunteer> volunteers = new ArrayList<>();

        try (Connection con = CM.getConnection())
        {
            {
                String query
                        = " SELECT * "
                        + " FROM [Volunteer] v "
                        + " INNER JOIN [GuildVolunteers] gv ON v.VolunteerId = gv.VolunteerId "
                        + " INNER JOIN [Guild] g ON gv.GuildId = g.GuildId "
                        + " WHERE g.GuildName = ? ";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, GuildName);
                ResultSet rs = pstmt.executeQuery();

                while (rs.next())
                {

                    volunteers.add(new Volunteer(
                            rs.getString("firstName"),
                            rs.getString("lastName"),
                            rs.getInt("VolunteerId"),
                            rs.getString("Email"),
                            rs.getString("PhoneNumber"),
                            rs.getString("additionalInfo"),
                            rs.getString("Address"),
                            rs.getString("Image")));

                }
            }

            return volunteers;

        } catch (SQLException sqle)
        {
            System.err.println(sqle);
            return null;

        }

    }

    public void deleteVolunteerFromGuild(int volunteerId)
    {

        try (Connection con = CM.getConnection())
        {
            String sqlCommand
                    = "DELETE FROM GuildVolunteers WHERE VolunteerId=?";
            PreparedStatement pstat = con.prepareStatement(sqlCommand);
            pstat.setInt(1, volunteerId);
            pstat.executeUpdate();

        } catch (SQLException sqle)
        {
            System.err.println(sqle);

        }

    }

}
