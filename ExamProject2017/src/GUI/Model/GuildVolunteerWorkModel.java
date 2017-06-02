/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.GuildVolunteerWorkManager;
import java.sql.Date;
import BE.GuildVolunteerWork;
import java.io.IOException;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @authors Boldizsár Koppány, Deividas Tamošiūnas, Edwin Mhoy Silva, Jesper Enemark,
 * Edison J. Lamar Toapanta
 *
 */
public class GuildVolunteerWorkModel
{
    
    ObservableList<GuildVolunteerWork> listOfVolunteerWork;
    
    GuildVolunteerWorkManager GVWM = new GuildVolunteerWorkManager();
    
/**
 * 
 * @param startDate
 * @param endDate
 * @param GuildId
 * @return list of volunteer work from DB.
 * @throws IOException
 * @throws SQLException 
 */
    public ObservableList<GuildVolunteerWork> GetGuildVolunteerWork(String startDate, String endDate, int GuildId) throws IOException, SQLException
    {
        return listOfVolunteerWork = FXCollections.observableArrayList(GVWM.getWorkTable(startDate, endDate, GuildId));
    }
    /**
     * adds volunteer work to the db
     * @param Date
     * @param Hour
     * @param GuildId
     * @param VolunteerId 
     */
    public void addWorkWithDate(Date Date, double Hour, int GuildId, int VolunteerId)
    {
        GVWM.AddWorkWithDate(Date, Hour, GuildId, VolunteerId);
    }
    
    
    /**
     * edit the volunteer hours
     * @param hours
     * @param WorkId 
     */
    public void editHourOnWork(double hours, int WorkId) {
        GVWM.editHourOnWork(hours, WorkId);
    }
}
