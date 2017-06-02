
package BLL;

import BE.Guild;
import DAL.GuildDataManager;

import java.io.IOException;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @authors Boldizsár Koppány, Deividas Tamošiūnas, Edwin Mhoy Silva, Jesper Enemark,
 * Edison J. Lamar Toapanta
 *
 */
public class GuildManager
{

    private static GuildManager GUILDMANAGER = new GuildManager();

    public GuildManager getInstance()
    {
        return GUILDMANAGER;

    }
    GuildDataManager GDM = new GuildDataManager();

    public ArrayList<Guild> getGuild()
    {
        return GDM.getGuild();
    }

    public void setGuildHours(double GuildHours, int GuildId)
    {
        GDM.updateGuildHours(GuildHours, GuildId);
    }
    
    public void addGuildVolunteerWork(Date date, double Hour, int GuildId, int VolunteerId) {
        GDM.addGuildVolunteerWork(date, Hour, GuildId, VolunteerId);
    }
    
    
}
