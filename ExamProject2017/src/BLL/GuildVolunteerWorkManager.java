
package BLL;

import BE.GuildVolunteerWork;
import DAL.GuildVolunteerWorkDataManager;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @authors Boldizsár Koppány, Deividas Tamošiūnas, Edwin Mhoy Silva, Jesper Enemark,
 * Edison J. Lamar Toapanta
 *
 */
public class GuildVolunteerWorkManager
{

    GuildVolunteerWorkDataManager GVWDM = new GuildVolunteerWorkDataManager();

     /**
     * 
     * @param startDate
     * @param endDate
     * @param GuildId
     * @return Volunteer work based on the start -and  enddate and the guildId
     * @throws IOException
     * @throws SQLException 
     */
    public ArrayList<GuildVolunteerWork> getWorkTable(String startDate, String endDate, int GuildId) throws IOException, SQLException
    {
        return GVWDM.getGuildWorkHoursBasedOnDate(startDate, endDate, GuildId);
    }

    //Add the hour and date a volunteer have worked in af specific guild
    
    public void AddWorkWithDate(Date Date, double Hour, int GuildId, int VolunteerId)
    {
        GVWDM.addVolunteerWork(Date, Hour, GuildId, VolunteerId);
    }

    public void editHourOnWork(double hours, int WorkId)
    {
        GVWDM.editHourOnWork(hours, WorkId);
    }

}
