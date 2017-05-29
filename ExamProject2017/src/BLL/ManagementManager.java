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

    public ArrayList<Manager> getManager()
    {
        return MDM.getManager();
    }
    public void editManager(String Username, String Password, String Firstname, String Lastname, String Email, String Phone, int ManagerId) {
        MDM.editManager(Username, Password, Firstname, Lastname, Email, Phone, ManagerId);
    }
    
     public void deleteManager(int ManagerId) {
         MDM.deleteManager(ManagerId);
     }
     
    public void addManager(String Username, String Password, String Firstname, String Lastname, String Email, String Phone) {
        MDM.addManager(Username, Password, Firstname, Lastname, Email, Phone);
    }
}
