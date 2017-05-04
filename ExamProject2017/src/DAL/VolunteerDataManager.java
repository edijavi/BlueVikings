/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Volunteer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author EdwinSilva
 */
public class VolunteerDataManager {

    ConnectionManager CM;

    private static VolunteerDataManager VOLUNTEERDATAMANAGER = new VolunteerDataManager();

    public static VolunteerDataManager getInstance() {
        return VOLUNTEERDATAMANAGER;
    }

    private Volunteer currentVolunteer;

    public Volunteer getCurrentVolunteer() {
        return currentVolunteer;
    }

    public void setCurrentVolunteer(Volunteer currentVolunteer) {
        this.currentVolunteer = currentVolunteer;
    }

    public VolunteerDataManager() {
        CM = new ConnectionManager();
    }

    public void addVolunteer(String firstName, String lastName, String Email, String PhoneNumber, String Address) {
    
        try (Connection con = CM.getConnection()) {
            
            String sqlCommand
                   
                    = " INSERT INTO Volunteer( FirstName,  LastName, Email, PhoneNumber,Address) VALUES( ?, ?,?,?,?)";
            PreparedStatement pstat = con.prepareStatement(sqlCommand);
            
            pstat.setString(1, firstName);
            pstat.setString(2, lastName);
            pstat.setString(3, Email);
            pstat.setString(4, PhoneNumber);
            pstat.setString(5, Address);
           
            pstat.executeUpdate();
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void deleteVolunteer(String volunteerId) {
      
        try (Connection con = CM.getConnection()) {
            String sqlCommand
                    = "DELETE FROM Volunteer WHERE VolunteerId=?" ; 
             PreparedStatement pstat = con.prepareStatement(sqlCommand);
             pstat.setString(1, volunteerId);
             pstat.executeUpdate();
             
             
           
        } catch (SQLException sqle) {
            System.err.println(sqle);
           
        }
    }

    public ArrayList<Volunteer> getVolunteer() {
        try (Connection con = CM.getConnection()) {
            String query = "SELECT * FROM [Volunteer]";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<Volunteer> volunteers = new ArrayList<>();
            while (rs.next()) {

                String volunteerString = "";
                volunteerString += rs.getString("firstName");
                volunteerString += rs.getString("lastName");
                volunteerString += rs.getInt("VolunteerId");
                volunteerString += rs.getString("Email");
                volunteerString += rs.getString("PhoneNumber");
                volunteerString += rs.getString("Address");
            

                volunteers.add(new Volunteer(
                rs.getString("firstName"),
                rs.getString("lastName"),
                rs.getInt("VolunteerId"),
                rs.getString("Email"),
                rs.getString("PhoneNumber"),
                rs.getString("Address")));
            }
            return volunteers;

        } catch (SQLException sqle) {
            System.err.println(sqle);
            return null;
        }
    }
// Update with task/guild id
//    public void updateVolunteers(String firstName, String lastName, String VolunteerId, String phoneNumber, String Email, String Address) {
//        try (Connection con = CM.getConnection()) {
//            String sqlQuery
//                    = "UPDATE Volunteer SET name=?,email=?,classid=12 WHERE id=?";
//            PreparedStatement pstmt
//                    = con.prepareStatement(sqlQuery);
//
//            pstmt.setString(1, name);
//            pstmt.setString(2, email);
//            pstmt.setInt(3, classid);
//            pstmt.setInt(4, id);
//
//            pstmt.execute();
//
//        } catch (SQLException sqle) {
//            System.err.println(sqle);
//        }

    }

    
    
    
    
    
    
    
    
    
    
    
    

