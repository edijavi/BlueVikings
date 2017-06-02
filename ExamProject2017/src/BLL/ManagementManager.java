
package BLL;

import BE.Manager;
import DAL.ManagerDataManager;
import java.util.ArrayList;

/**
 *
 * @authors Boldizsár Koppány, Deividas Tamošiūnas, Edwin Mhoy Silva, Jesper Enemark,
 * Edison J. Lamar Toapanta
 *
 */
public class ManagementManager
{

    ManagerDataManager MDM = new ManagerDataManager();

    /**
     * 
     * @return a list of manager from DB
     */
    public ArrayList<Manager> getManager()
    {
        return MDM.getManager();
    }
    /**
     * Make is possible to change information about the manager
     * @param Username
     * @param Password
     * @param Firstname
     * @param Lastname
     * @param Email
     * @param Phone
     * @param ManagerId 
     */
    public void editManager(String Username, String Password, String Firstname, String Lastname, String Email, String Phone, int ManagerId) {
        MDM.editManager(Username, Password, Firstname, Lastname, Email, Phone, ManagerId);
    }
    /**
     * Delete a manager based on  the id
     * @param ManagerId 
     */
     public void deleteManager(int ManagerId) {
         MDM.deleteManager(ManagerId);
     }
/**
 * Add a maanger to the database
 * @param Username
 * @param Password
 * @param Firstname
 * @param Lastname
 * @param Email
 * @param Phone 
 */
     public void addManager(String Username, String Password, String Firstname, String Lastname, String Email, String Phone) {
        MDM.addManager(Username, Password, Firstname, Lastname, Email, Phone);
    }
}
