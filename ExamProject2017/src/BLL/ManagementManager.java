/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Manager;
import DAL.ManagerDataManager;
import java.util.ArrayList;

/**
 *
 * @author Jesper Enemark
 */
public class ManagementManager
{

    ManagerDataManager MDM = new ManagerDataManager();
// Get a list of Manager from DB
    public ArrayList<Manager> getManager()
    {
        return MDM.getManager();
    }
    //Makes it possible to change information about a Manager
    public void editManager(String Username, String Password, String Firstname, String Lastname, String Email, String Phone, int ManagerId) {
        MDM.editManager(Username, Password, Firstname, Lastname, Email, Phone, ManagerId);
    }
    // deletes a manager from database based on managerId
     public void deleteManager(int ManagerId) {
         MDM.deleteManager(ManagerId);
     }
    // Add a Manager to the database
    public void addManager(String Username, String Password, String Firstname, String Lastname, String Email, String Phone) {
        MDM.addManager(Username, Password, Firstname, Lastname, Email, Phone);
    }
}
