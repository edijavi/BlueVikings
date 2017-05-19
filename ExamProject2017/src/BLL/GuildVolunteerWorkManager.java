/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Guild;
import BE.GuildVolunteerWork;
import DAL.GuildDataManager;
import DAL.GuildVolunteerWorkDataManager;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author EdwinSilva
 */
public class GuildVolunteerWorkManager {
 
GuildVolunteerWorkDataManager GVWDM = new GuildVolunteerWorkDataManager();

    public ArrayList<GuildVolunteerWork> getWorkTable() throws IOException
    {
        return GVWDM.getWorkTable();
    }

 
    
    public void AddWorkWithDate(Date date, double Hour) {
        GVWDM.AddWorkWithDate(date, Hour);
    }

    
}
