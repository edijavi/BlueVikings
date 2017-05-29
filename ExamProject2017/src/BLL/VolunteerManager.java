/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.GuildVolunteerWork;
import BE.Volunteer;
import DAL.VolunteerDataManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author EdwinSilva
 */
public class VolunteerManager
{

    VolunteerDataManager VDM = new VolunteerDataManager();



 

    public VolunteerManager()
    {

    }

    public ArrayList<Volunteer> getVolunteer()
    {
        return VDM.getVolunteer();
    }

    public ArrayList<Volunteer> getVolunteerBasedOnGuild(String GuildName)
    {
        return VDM.getVolunteerBasedOnGuild(GuildName);
    }

    public void deleteVolunteer(int volunteerId)
    {
        VDM.deleteVolunteer(volunteerId);
    }
    // Update the  information about a volunteer in the DB
    public void updateVolunteer(String FirstName, String LastName, String Email, String PhoneNumber, String Address, String Additionalinfo, int VolunteerId) {
        VDM.updateVolunteer(FirstName, LastName, Email, PhoneNumber, Address, Additionalinfo, VolunteerId);
    }
    // Add a Volunteer to the DB
    public void AddVolunteer(String firstName, String lastName, String Email, String phoneNumber, String Address, String additionalInfo)
    {
        VDM.addVolunteer(firstName, lastName, Email, phoneNumber, Address, additionalInfo);
    }
    //Get the work a volunteer has registeret by volunteerID
    public ArrayList<GuildVolunteerWork> getVolunteerWork(int VolunteerId) throws SQLException {
        return VDM.getVolunteerWork(VolunteerId);
    }
}
