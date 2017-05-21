/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.util.List;

/**
 *
 * @author EdwinSilva
 */
public class VolunteerDataManager
{

    ConnectionManager CM;

    private static VolunteerDataManager VOLUNTEERDATAMANAGER = new VolunteerDataManager();

    public static VolunteerDataManager getInstance()
    {
        return VOLUNTEERDATAMANAGER;
    }

    private Volunteer currentVolunteer;

    public Volunteer getCurrentVolunteer()
    {
        return currentVolunteer;
    }

    public void setCurrentVolunteer(Volunteer currentVolunteer)
    {
        this.currentVolunteer = currentVolunteer;
    }

    public VolunteerDataManager()
    {
        CM = new ConnectionManager();
    }

    public void addVolunteer(String firstName, String lastName, String Email, String PhoneNumber, String Address, String additionalInfo)
    {

        try (Connection con = CM.getConnection())
        {

            String sqlCommand
                    = " INSERT INTO Volunteer( FirstName,  LastName, Email, PhoneNumber, Address, Additionalinfo) VALUES(?,?,?,?,?,?)";
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

                volunteers.add(new Volunteer(
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getInt("VolunteerId"),
                        rs.getString("Email"),
                        rs.getString("PhoneNumber"),
                        rs.getString("Address"),
                        rs.getString("additionalInfo")));
            }
            return volunteers;

        } catch (SQLException sqle)
        {
            System.err.println(sqle);
            return null;
        }
    }

    public ArrayList<Volunteer> getVolunteerBasedOnGuild(String GuildName) 
    {

        ArrayList<Volunteer> volunteers = new ArrayList<>();

        try (Connection con = CM.getConnection())
        {
        {
            String query = 
                       " SELECT * "
                    
                    +  " FROM [Volunteer] v "
                    
                   +  " INNER JOIN [GuildVolunteers] gv ON v.VolunteerId = gv.VolunteerId "
                    
                    +  " INNER JOIN [Guild] g ON gv.GuildId = g.GuildId "
                    
                    +  " WHERE g.GuildName = ? ";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, GuildName);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
            

                volunteers.add(new Volunteer(
                        rs.getString(  "firstName"  ),
                        rs.getString(  "lastName"  ),
                        rs.getInt(  "VolunteerId"  ),
                        rs.getString(  "Email"  ),
                        rs.getString(  "PhoneNumber"  ),
                        rs.getString( "additionalInfo" ),
                        rs.getString(  "Address"  )));
//                
          
        }}
        
        return volunteers;
           
        
        } 
                catch (SQLException sqle)
                {           
                        System.err.println(sqle);
                        return null;

                }

        }
    
    
        public ArrayList<GuildVolunteerWork> getVolunteerWork(int VolunteerId) throws SQLServerException, SQLException
    {
        try (Connection con = CM.getConnection())
        {
            String query = "SELECT * FROM GuildVolunteerWork WHERE VolunteerId="+ VolunteerId +"";
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
    }
