/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BE.Manager;
import BLL.ManagementManager;
import java.util.ArrayList;

/**
 *
 * @author Jesper Enemark
 */
public class ManagerModel
{
    ManagementManager MM1 = new ManagementManager();
    
    public ArrayList<Manager> getManager()
    {
        return MM1.getManager();
    }
}
