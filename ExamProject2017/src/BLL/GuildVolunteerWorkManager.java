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
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.control.DatePicker;

/**
 *
 * @author EdwinSilva
 */
public class GuildVolunteerWorkManager {
 
GuildVolunteerWorkDataManager GVWDM = new GuildVolunteerWorkDataManager();
    // Get the data of who have worked in a specifik guild, from the GuildVolunteerWork table, based on startdate, enddate and guild.
    public ArrayList<GuildVolunteerWork> getWorkTable(String startDate, String endDate, int GuildId) throws IOException, SQLException
    {
        return GVWDM.getGuildWorkHoursBasedOnDate(startDate, endDate, GuildId);
    }

 
    //Add the hour and date a volunteer have worked in af specific guild
    public void AddWorkWithDate(Date Date, double Hour, int GuildId, int VolunteerId) {
        GVWDM.addVolunteerWork(Date, Hour, GuildId, VolunteerId);
    }

    
}
