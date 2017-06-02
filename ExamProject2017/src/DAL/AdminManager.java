
package DAL;

import BE.Adminstrator;

import java.sql.Connection;
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
public class AdminManager
{

    ConnectionManager CM;

    public AdminManager()
    {
        CM = new ConnectionManager();
    }
/**
 * 
 * @returns Adminstrators from the Adminstrator table from database, retrieving username and password
 */
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
