/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Guild;
import DAL.GuildDataManager;
import java.io.IOException;
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

}
