/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Adminstrator;
import DAL.AdminManager;
import java.util.ArrayList;

/**
 *
 * @author Jesper Enemark
 */
public class AdminstratorManager
{

    AdminManager AM = new AdminManager();

    // Get a list of Administrators  from DB
    public ArrayList<Adminstrator> getAdminstrators()
    {
        return AM.getAdminstrators();

    }
}
