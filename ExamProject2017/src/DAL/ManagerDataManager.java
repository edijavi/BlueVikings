/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author EdwinSilva
 */
public class ManagerDataManager {
    ConnectionManager CM = new ConnectionManager();
    
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
                
            

                Manager.add(new Manager(
                rs.getString("Username"),
                rs.getString("Password"),
                rs.getString("Firstname"),
                rs.getString("Lastname"),
                rs.getString("Email")));
            }
            return Manager;

        } catch (SQLException sqle) {
            System.err.println(sqle);
            return null;
        }
    }
    public void addManager(String Username, String Password, String Firstname, String Lastname, String Email)
    {

        try (Connection con = CM.getConnection())
        {

            String sqlCommand
                    = " INSERT INTO Management(Username, Password, Firstname, Lastname, Email) VALUES(?,?,?,?,?)";
            PreparedStatement pstat = con.prepareStatement(sqlCommand);

            pstat.setString(1, Username);
            pstat.setString(2, Password);
            pstat.setString(3, Firstname);
            pstat.setString(4, Lastname);
            pstat.setString(5, Email);
            

            pstat.executeUpdate();
        } catch (SQLException sqle)
        {
            System.err.println(sqle);
        }
    }
}
