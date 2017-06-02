
package DAL;

import BE.GuildVolunteerWork;
import BE.Volunteer;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @authors Boldizsár Koppány, Deividas Tamošiūnas, Edwin Mhoy Silva, Jesper Enemark,
 * Edison J. Lamar Toapanta
 *
 */
public class VolunteerDataManager
{

    ConnectionManager CM;

    
  
   

    public VolunteerDataManager()
    {
        CM = new ConnectionManager();
    }
    /**
     * Add volunteer based on all the paramters
     * @param firstName
     * @param lastName
     * @param Email
     * @param PhoneNumber
     * @param Address
     * @param additionalInfo 
     */
    public void addVolunteer(String firstName, String lastName, String Email, String PhoneNumber, String Address, String additionalInfo)
    {

        try (Connection con = CM.getConnection())
        {

            String sqlCommand
                    = " INSERT INTO Volunteer(FirstName ,LastName ,Email ,PhoneNumber ,Address ,Additionalinfo) VALUES(?,?,?,?,?,?)";
            PreparedStatement pstat = con.prepareStatement(sqlCommand);

            pstat.setString(1, firstName);
            pstat.setString(2, lastName);
            pstat.setString(3, Email);
            pstat.setString(4, PhoneNumber);
            pstat.setString(5, Address);
            pstat.setString(6, additionalInfo);
            pstat.executeUpdate();
        } catch (SQLException sqle)
        {
            System.err.println(sqle);
        }
    }
    
   
    
    
    
    
    /**
     * Updates volunteer based on parameters
     * @param FirstName
     * @param LastName
     * @param Email
     * @param PhoneNumber
     * @param Address
     * @param Additionalinfo
     * @param VolunteerId 
     */
    public void updateVolunteer(String FirstName, String LastName, String Email, String PhoneNumber, String Address, String Additionalinfo, int VolunteerId)
    {
        try (Connection con = CM.getConnection())
        {
            String sqlQuery
                    = "UPDATE Volunteer SET FirstName=?, LastName=?, Email=?, PhoneNumber=?, Address=?, Additionalinfo=? WHERE VolunteerId=?";
            PreparedStatement pstmt
                    = con.prepareStatement(sqlQuery);

            pstmt.setString(1, FirstName);
            pstmt.setString(2, LastName);
            pstmt.setString(3, Email);
            pstmt.setString(4, PhoneNumber);
            pstmt.setString(5, Address);
            pstmt.setString(6, Additionalinfo);
            pstmt.setInt(7, VolunteerId);
            pstmt.execute();
        } catch (SQLException ex)
        {
            Logger.getLogger(VolunteerDataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Deletes volunteer based on VolunteerId
     * @param volunteerId 
     */
    public void deleteVolunteer(int volunteerId)
    {

        try (Connection con = CM.getConnection())
        {
            String sqlCommand
                    = "DELETE FROM Volunteer WHERE VolunteerId=?";
            PreparedStatement pstat = con.prepareStatement(sqlCommand);
            pstat.setInt(1, volunteerId);
            pstat.executeUpdate();

        } catch (SQLException sqle)
        {
            System.err.println(sqle);

        }
    }
    /**
     * 
     * @return list of Volunteers
     */
    public ArrayList<Volunteer> getVolunteer()
    {
        try (Connection con = CM.getConnection())
        {
            String query = "SELECT * FROM [Volunteer]";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<Volunteer> volunteers = new ArrayList<>();
            while (rs.next())
            {

                String volunteerString = "";
                volunteerString += rs.getString("firstName");
                volunteerString += rs.getString("lastName");
                volunteerString += rs.getInt("VolunteerId");
                volunteerString += rs.getString("Email");
                volunteerString += rs.getString("PhoneNumber");
                volunteerString += rs.getString("Address");
                volunteerString += rs.getString("Additionalinfo");
                volunteerString += rs.getString("Image");

                volunteers.add(new Volunteer(
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getInt("VolunteerId"),
                        rs.getString("Email"),
                        rs.getString("PhoneNumber"),
                        rs.getString("Address"),
                        rs.getString("additionalInfo"),
                        rs.getString("Image")));
                        
            }
            return volunteers;

        } catch (SQLException sqle)
        {
            System.err.println(sqle);
            return null;
        }
    }

    
    /**
     * Gets VolunteerWork based on VolunteerId
     * @param VolunteerId
     * @return
     * @throws SQLServerException
     * @throws SQLException 
     */
    public ArrayList<GuildVolunteerWork> getVolunteerWork(int VolunteerId) throws SQLServerException, SQLException
    {
        try (Connection con = CM.getConnection())
        {
            String query = "SELECT * FROM GuildVolunteerWork WHERE VolunteerId=" + VolunteerId + "";
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
                        rs.getDouble("Hours"),
                        rs.getInt("WorkId")
                ));
            }
            return GuildWorkTable;

        } catch (SQLException sqle)
        {
            System.err.println(sqle);
            return null;
        }

    }

}
