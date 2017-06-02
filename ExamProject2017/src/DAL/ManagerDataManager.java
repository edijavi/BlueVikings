
package DAL;

import BE.Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @authors Boldizsár Koppány, Deividas Tamošiūnas, Edwin Mhoy Silva, Jesper Enemark,
 * Edison J. Lamar Toapanta
 *
 */

public class ManagerDataManager {
    ConnectionManager CM = new ConnectionManager();
    
    /**
     * 
     * @return list of Managers
     */
    public ArrayList<Manager> getManager() {
        try (Connection con = CM.getConnection()) {
            String query = "SELECT * FROM [Management]";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<Manager> Manager = new ArrayList<>();
            while (rs.next()) {

                String ManagerString = "";
                ManagerString += rs.getString("Username");
                ManagerString += rs.getString("Password");
                ManagerString += rs.getString("Firstname");
                ManagerString += rs.getString("Lastname");
                ManagerString += rs.getString("Email");
                ManagerString += rs.getString("Phone");
                ManagerString += rs.getInt("ManagerId");
                
            

                Manager.add(new Manager(
                rs.getString("Username"),
                rs.getString("Password"),
                rs.getString("Firstname"),
                rs.getString("Lastname"),
                rs.getString("Phone"),
                rs.getString("Email"),
                rs.getInt("ManagerId")));
            }
            return Manager;

        } catch (SQLException sqle) {
            System.err.println(sqle);
            return null;
        }
    }
    
    /**
     * Adds a manager based on all the parameters
     * @param Username
     * @param Password
     * @param Firstname
     * @param Lastname
     * @param Email
     * @param Phone 
     */
    public void addManager(String Username, String Password, String Firstname, String Lastname, String Email, String Phone)
    {

        try (Connection con = CM.getConnection())
        {

            String sqlCommand
                    = " INSERT INTO Management(Username, Password, Firstname, Lastname, Email, Phone) VALUES(?,?,?,?,?,?)";
            PreparedStatement pstat = con.prepareStatement(sqlCommand);

            pstat.setString(1, Username);
            pstat.setString(2, Password);
            pstat.setString(3, Firstname);
            pstat.setString(4, Lastname);
            pstat.setString(5, Email);
            pstat.setString(6, Phone);
            
            

            pstat.executeUpdate();
        } catch (SQLException sqle)
        {
            System.err.println(sqle);
        }
    }
    /**
     * Updates Manager based on ManagerId
     * @param Username
     * @param Password
     * @param Firstname
     * @param Lastname
     * @param Email
     * @param Phone
     * @param ManagerId 
     */
    public void editManager(String Username, String Password, String Firstname, String Lastname, String Email, String Phone, int ManagerId) {
        try(Connection con = CM.getConnection()) 
        {
            String sqlQuery = "UPDATE Management SET Username=?, Password=?, Firstname=?, Lastname=?, Email=?, Phone=? WHERE ManagerId=?";
            PreparedStatement pstat = con.prepareStatement(sqlQuery);
            
            pstat.setString(1, Username);
            pstat.setString(2, Password);
            pstat.setString(3, Firstname);
            pstat.setString(4, Lastname);
            pstat.setString(5, Email);
            pstat.setString(6, Phone);
            pstat.setInt(7, ManagerId);
            pstat.execute();
        } catch (SQLException sqle)
        {
          
            System.err.println(sqle);
        }
    }
    
    /**
     * Delete a manager based on ManagerId
     * @param ManagerId 
     */
    public void deleteManager(int ManagerId)
    {

        try (Connection con = CM.getConnection())
        {
            String sqlCommand
                    = "DELETE FROM Management WHERE ManagerId=?";
            PreparedStatement pstat = con.prepareStatement(sqlCommand);
            pstat.setInt(1, ManagerId);
            pstat.executeUpdate();

        } catch (SQLException sqle)
        {
            System.err.println(sqle);

        }
    }
    
    
    
    
}
