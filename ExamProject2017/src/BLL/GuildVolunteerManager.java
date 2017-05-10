/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.GuildVolunteerDataManager;

/**
 *
 * @author EdwinSilva
 */
public class GuildVolunteerManager {
GuildVolunteerDataManager GVDM = new  GuildVolunteerDataManager();

public void deleteVolunteer(int volunteerId){
GVDM.deleteVolunteerFromGuild(volunteerId);
}
public void AddVolunteer(int GuildId, int VolunteerId){
    GVDM.addMemberToGuild(GuildId, VolunteerId);
}





    
}
