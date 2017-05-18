/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Guild;
import DAL.GuildDataManager;
<<<<<<< Upstream, based on origin/master
import java.io.IOException;
=======
import java.sql.Date;
>>>>>>> c35b622 GuildVolunteerWork added
import java.util.ArrayList;

/**
 *
 * @author EdwinSilva
 */
public class GuildManager
{

    private static GuildManager GUILDMANAGER = new GuildManager();

    public GuildManager getInstance()
    {
        return GUILDMANAGER;

    }
    GuildDataManager GDM = new GuildDataManager();

    public ArrayList<Guild> getGuild() throws IOException
    {
        return GDM.getGuild();
    }

    public void setGuildHours(double GuildHours, int GuildId)
    {
        GDM.updateGuildHours(GuildHours, GuildId);
    }
    
    public void addVolunteerWork(Date date, double Hour) {
        GDM.addVolunteerWork(date, Hour);
    }
}
