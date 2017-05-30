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
 * @author EdwinSilva
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
    
    public ObservableList<Volunteer> getlistOfVolunteer()
    {
        return listOfVolunteers = FXCollections.observableArrayList(VM.getVolunteer());
    }

    public <T> List<T> doSearch(String word, List<T> inWhat, SearchType type)
    {
        return searchHandler.Search(word, inWhat, type);
    }
    
    public void deleteVolunteer(int volunteerId)
    {
        VM.deleteVolunteer(volunteerId);
        
    }
    
    public void addVolunteer(String firstName, String lastName, String Email, String phoneNumber, String Address, String additionalInfo)
    {
        VM.AddVolunteer(firstName, lastName, Email, phoneNumber, Address, additionalInfo);
        
    }
    
    
    
    public ObservableList<GuildVolunteerWork> getVolunteerWork(int VolunteerId) throws SQLException
    {
        return listOFVolunteerWorks = FXCollections.observableArrayList(VM.getVolunteerWork(VolunteerId));
    }
    
    public void updateVolunteer(String FirstName, String LastName, String Email, String PhoneNumber, String Address, String Additionalinfo, int VolunteerId)
    {
        VM.updateVolunteer(FirstName, LastName, Email, PhoneNumber, Address, Additionalinfo, VolunteerId);
    }
    
}
