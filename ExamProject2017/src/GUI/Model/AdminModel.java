/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BE.Adminstrator;
import BE.Guild;
import BE.Volunteer;
import BLL.AdminstratorManager;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author Jesper Enemark
 */
public class AdminModel
{
    
    AdminstratorManager AM = new AdminstratorManager();
    
    public ArrayList<Adminstrator> getAdminstrators()
    {
        return AM.getAdminstrators();
    }
}
