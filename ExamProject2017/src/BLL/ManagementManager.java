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
}
