/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BE.Volunteer;
import BLL.GuildVolunteerManager;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author EdwinSilva
 */
public class GuildVolunteerModel
{

    GuildVolunteerManager GVM = new GuildVolunteerManager();
    ObservableList<Volunteer> listOfVolunteerOnGuild;
    public GuildVolunteerModel()
    {
    }

    public void addMemebertoGuild(int GuildId, int VolunteerId)
    {
        GVM.AddVolunteer(GuildId, VolunteerId);
    }

    public void deleteMemberFromGuild(int VolunteerId)
    {
        GVM.deleteVolunteer(VolunteerId);

    }
    public ObservableList<Volunteer> getVolunteersBasedOnGuild(String GuildName)
    {
        return listOfVolunteerOnGuild = FXCollections.observableArrayList(GVM.getVolunteerBasedOnGuild(GuildName));
    }

}
