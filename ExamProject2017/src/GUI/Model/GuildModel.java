/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BE.Guild;
import BLL.GuildManager;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author EdwinSilva
 */
public class GuildModel
{

    GuildManager GM = new GuildManager();

    public List<Guild> listOfGuilds() throws IOException
    {
        return GM.getGuild();
        
    }

    public GuildModel()
    {
        
    }    
    
    public void setGuildHours(double GuildHours, int GuildId)
    {
        GM.setGuildHours(GuildHours, GuildId);
    }
}
