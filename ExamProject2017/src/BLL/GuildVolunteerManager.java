
package BLL;

import BE.Volunteer;
import DAL.GuildVolunteerDataManager;
import java.util.ArrayList;

/**
 *
 * @authors Boldizsár Koppány, Deividas Tamošiūnas, Edwin Mhoy Silva, Jesper Enemark,
 * Edison J. Lamar Toapanta
 *
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
