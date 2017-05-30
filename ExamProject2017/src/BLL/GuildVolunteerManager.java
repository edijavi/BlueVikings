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
// Delete a volunteer from DB, with a specific volunteerId

    public void deleteVolunteer(int volunteerId)
    {
        GVDM.deleteVolunteerFromGuild(volunteerId);
    }
// Add a volunteer based on a volunteerID to a guild based on the chosen guildId

    public void AddVolunteer(int GuildId, int VolunteerId)
    {
        GVDM.addMemberToGuild(GuildId, VolunteerId);
    }

    public ArrayList<Volunteer> getVolunteerBasedOnGuild(String GuildName)
    {
        return GVDM.getVolunteerBasedOnGuild(GuildName);
    }

}
