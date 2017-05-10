/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.GuildVolunteerManager;

/**
 *
 * @author EdwinSilva
 */
public class GuildVolunteerModel {

GuildVolunteerManager GVM = new GuildVolunteerManager();



    public GuildVolunteerModel() {
    }
public void addMemebertoGuild(int GuildId, int VolunteerId){
GVM.AddVolunteer(GuildId, VolunteerId);
}

public void deleteMemberFromGuild(int VolunteerId){
GVM.deleteVolunteer(VolunteerId);
    
}


    
}
