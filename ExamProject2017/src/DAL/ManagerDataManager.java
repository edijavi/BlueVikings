/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Manager;
import java.sql.Connection;
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
                
            

                Manager.add(new Manager(
                rs.getString("Username"),
                rs.getString("Password")));
            }
            return Manager;

        } catch (SQLException sqle) {
            System.err.println(sqle);
            return null;
        }
    }
}
