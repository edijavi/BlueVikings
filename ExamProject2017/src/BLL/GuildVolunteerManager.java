/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Volunteer;
import DAL.GuildVolunteerDataManager;
import java.util.ArrayList;

/**
 *
 * @author EdwinSilva
 */
public class GuildVolunteerManager
{

    GuildVolunteerDataManager GVDM = new GuildVolunteerDataManager();

    /**
     * Delete a voluntteer from a guild by the volunteerId
     * @param volunteerId 
     */
    public void deleteVolunteer(int volunteerId)
    {
        GVDM.deleteVolunteerFromGuild(volunteerId);
    }

/**
 * Add a volunteer to  a guild by GuildId and VolunteerId
 * @param GuildId
 * @param VolunteerId 
 */
    public void AddVolunteer(int GuildId, int VolunteerId)
    {
        GVDM.addMemberToGuild(GuildId, VolunteerId);
    }
 /**
  * 
  * @param GuildName
  * @return a list of volunteer based on a guild name 
  */
    public ArrayList<Volunteer> getVolunteerBasedOnGuild(String GuildName)
    {
        return GVDM.getVolunteerBasedOnGuild(GuildName);
    }

}
