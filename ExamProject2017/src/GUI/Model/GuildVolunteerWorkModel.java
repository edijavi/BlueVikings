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
import javafx.scene.control.DatePicker;

/**
 *
 * @author EdwinSilva
 */
public class GuildVolunteerWorkModel {

GuildVolunteerWorkManager GVWM = new GuildVolunteerWorkManager();


public ArrayList<GuildVolunteerWork> GetGuildVolunteerWork (Date Date, double Hour, int GuildId, int VolunteerId) throws IOException, SQLException {
return GVWM.getWorkTable(Date,  Hour, GuildId,  VolunteerId);
}



public void addWorkWithDate(Date Date, double Hour, int GuildId, int VolunteerId){
     GVWM.AddWorkWithDate(Date, Hour, GuildId, VolunteerId);
}

    
}
