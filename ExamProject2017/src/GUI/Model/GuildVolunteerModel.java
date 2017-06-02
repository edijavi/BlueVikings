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
 * @authors Boldizsár Koppány, Deividas Tamošiūnas, Edwin Mhoy Silva, Jesper Enemark,
 * Edison J. Lamar Toapanta
 *
 */
public class GuildVolunteerModel
{

    GuildVolunteerManager GVM = new GuildVolunteerManager();
    ObservableList<Volunteer> listOfVolunteerOnGuild;
    public GuildVolunteerModel()
    {
    }
/**
 * add a memeber to a guild
 * @param GuildId
 * @param VolunteerId 
 */
    public void addMemebertoGuild(int GuildId, int VolunteerId)
    {
        GVM.AddVolunteer(GuildId, VolunteerId);
    }
    /**
     * delete a Member from a guild
     * @param VolunteerId 
     */
    public void deleteMemberFromGuild(int VolunteerId)
    {
        GVM.deleteVolunteer(VolunteerId);

    }
    /**
     * 
     * @param GuildName
     * @return volunteers in a guild
     */
    public ObservableList<Volunteer> getVolunteersBasedOnGuild(String GuildName)
    {
        return listOfVolunteerOnGuild = FXCollections.observableArrayList(GVM.getVolunteerBasedOnGuild(GuildName));
    }

}
