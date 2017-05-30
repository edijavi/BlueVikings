/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Adminstrator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Jesper Enemark
 */
public class AdminManager
{

    ConnectionManager CM;

    public AdminManager()
    {
        CM = new ConnectionManager();
    }

    public ArrayList<Adminstrator> getAdminstrators()
    {
        try (Connection con = CM.getConnection())
        {
            String query = "SELECT * FROM [Adminstrator]";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<Adminstrator> admin = new ArrayList<>();
            while (rs.next())
            {

                String ManagerString = "";
                ManagerString += rs.getString("Username");
                ManagerString += rs.getString("Password");

                admin.add(new Adminstrator(
                        rs.getString("Username"),
                        rs.getString("Password")));
            }
            return admin;

        } catch (SQLException sqle)
        {
            System.err.println(sqle);
            return null;
        }
    }
}
