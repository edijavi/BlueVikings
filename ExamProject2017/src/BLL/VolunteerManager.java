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
/**
 * 
 * @return a list of volunteer from the database
 */
    public ArrayList<Volunteer> getVolunteer()
    {
        return VDM.getVolunteer();
    }

    
/**
 * Delete a volunteer from the database based on vollunteer Id
 * @param volunteerId 
 */
    public void deleteVolunteer(int volunteerId)
    {
        VDM.deleteVolunteer(volunteerId);
    }
    /**
     * Update information about the volunteer in the DB
     * @param FirstName
     * @param LastName
     * @param Email
     * @param PhoneNumber
     * @param Address
     * @param Additionalinfo
     * @param VolunteerId 
     */
    public void updateVolunteer(String FirstName, String LastName, String Email, String PhoneNumber, String Address, String Additionalinfo, int VolunteerId) {
        VDM.updateVolunteer(FirstName, LastName, Email, PhoneNumber, Address, Additionalinfo, VolunteerId);
    }
/**
 * Add a volunteer to the database, with indformation
 * @param firstName
 * @param lastName
 * @param Email
 * @param phoneNumber
 * @param Address
 * @param additionalInfo 
 */
    public void AddVolunteer(String firstName, String lastName, String Email, String phoneNumber, String Address, String additionalInfo)
    {
        VDM.addVolunteer(firstName, lastName, Email, phoneNumber, Address, additionalInfo);
    }
/**
 * 
 * @param VolunteerId
 * @return a list of volunteer from the database
 * @throws SQLException 
 */
    public ArrayList<GuildVolunteerWork> getVolunteerWork(int VolunteerId) throws SQLException {
        return VDM.getVolunteerWork(VolunteerId);
    }
}
