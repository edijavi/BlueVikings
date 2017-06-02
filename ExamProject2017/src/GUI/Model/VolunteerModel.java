/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BE.GuildVolunteerWork;
import BE.Volunteer;
import BLL.SearchHandler;
import BLL.VolunteerManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BLL.SearchHandler.SearchType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @authors Boldizsár Koppány, Deividas Tamošiūnas, Edwin Mhoy Silva, Jesper Enemark,
 * Edison J. Lamar Toapanta
 *
 */
public class VolunteerModel
{
    
   
    
    private SearchHandler searchHandler = new SearchHandler();
    
    VolunteerManager VM = new VolunteerManager();
    ObservableList<Volunteer> listOfVolunteers;
    ObservableList<GuildVolunteerWork> listOFVolunteerWorks;
    public VolunteerModel()
    {
        
    }
    /**
     * 
     * @return a list of volunteer
     */
    public ObservableList<Volunteer> getlistOfVolunteer()
    {
        return listOfVolunteers = FXCollections.observableArrayList(VM.getVolunteer());
    }
/**
     * References to the search handler.
     * @param <T>
     * @param word
     * @param inWhat
     * @param type
     * @return 
     */

    public <T> List<T> doSearch(String word, List<T> inWhat, SearchType type)
    {
        return searchHandler.Search(word, inWhat, type);
    }
    /**
     * delete a volunteer from database based on volunteer id
     * @param volunteerId 
     */
    public void deleteVolunteer(int volunteerId)
    {
        VM.deleteVolunteer(volunteerId);
        
    }
    /**
     * add a volunteer to the DB
     * @param firstName
     * @param lastName
     * @param Email
     * @param phoneNumber
     * @param Address
     * @param additionalInfo 
     */
    public void addVolunteer(String firstName, String lastName, String Email, String phoneNumber, String Address, String additionalInfo)
    {
        VM.AddVolunteer(firstName, lastName, Email, phoneNumber, Address, additionalInfo);
        
    }
    
    
    /**
     * 
     * @param VolunteerId
     * @return the work a volunteer has worked in a guild
     * @throws SQLException 
     */
    public ObservableList<GuildVolunteerWork> getVolunteerWork(int VolunteerId) throws SQLException
    {
        return listOFVolunteerWorks = FXCollections.observableArrayList(VM.getVolunteerWork(VolunteerId));
    }
    /**
     * upadet hte information about the volunteer
     * @param FirstName
     * @param LastName
     * @param Email
     * @param PhoneNumber
     * @param Address
     * @param Additionalinfo
     * @param VolunteerId 
     */
    public void updateVolunteer(String FirstName, String LastName, String Email, String PhoneNumber, String Address, String Additionalinfo, int VolunteerId)
    {
        VM.updateVolunteer(FirstName, LastName, Email, PhoneNumber, Address, Additionalinfo, VolunteerId);
    }
    
}
