/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BE.Guild;
import BLL.GuildVolunteerWorkManager;
import java.sql.Date;
import java.util.ArrayList;
import BE.GuildVolunteerWork;
import BE.Volunteer;
import java.io.IOException;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;

/**
 *
 * @author EdwinSilva
 */
public class GuildVolunteerWorkModel
{
    
    ObservableList<GuildVolunteerWork> listOfVolunteerWork;
    
    GuildVolunteerWorkManager GVWM = new GuildVolunteerWorkManager();

    public ObservableList<GuildVolunteerWork> GetGuildVolunteerWork(String startDate, String endDate, int GuildId) throws IOException, SQLException
    {
        return listOfVolunteerWork = FXCollections.observableArrayList(GVWM.getWorkTable(startDate, endDate, GuildId));
    }

    public void addWorkWithDate(Date Date, double Hour, int GuildId, int VolunteerId)
    {
        GVWM.AddWorkWithDate(Date, Hour, GuildId, VolunteerId);
    }
    
    
    
    public void editHourOnWork(double hours, int WorkId) {
        GVWM.editHourOnWork(hours, WorkId);
    }
}
