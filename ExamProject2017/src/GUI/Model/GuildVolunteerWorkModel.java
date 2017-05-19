/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.GuildVolunteerWorkManager;
import java.sql.Date;
import java.util.ArrayList;
import BE.GuildVolunteerWork;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author EdwinSilva
 */
public class GuildVolunteerWorkModel {

GuildVolunteerWorkManager GVWM = new GuildVolunteerWorkManager();


public ArrayList<GuildVolunteerWork> GetGuildVolunteerWork (Date startDate, Date endDate) throws IOException, SQLException {
return GVWM.getWorkTable(startDate, endDate);
}



public void addWorkWithDate(Date date, double Hour, int GuildId, int VolunteerId){
GVWM.AddWorkWithDate(date, Hour, GuildId, VolunteerId);
}

    
}
