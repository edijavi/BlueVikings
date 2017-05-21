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
import sun.security.jca.GetInstance;
import BLL.SearchHandler.SearchType;

/**
 *
 * @author EdwinSilva
 */
public class VolunteerModel {

private static VolunteerModel  VOLUNTEERMODEL = new VolunteerModel();

 private SearchHandler searchHandler = new SearchHandler();

VolunteerManager VM = VolunteerManager.getInstance();

public static VolunteerModel getInstance(){
    return VOLUNTEERMODEL;


}    
    
public VolunteerModel (){
    
}

public List<Volunteer> getlistOfVolunteer(){
 return VM.getVolunteer();
}
public <T> List<T> doSearch(String word, List<T> inWhat, SearchType type) {
        return searchHandler.Search(word, inWhat, type);
    }


public void deleteVolunteer(int volunteerId){
VM.deleteVolunteer(volunteerId);

    
}

public void addVolunteer(String firstName, String lastName, String Email, String phoneNumber, String Address, String additionalInfo){
VM.AddVolunteer(firstName, lastName, Email, phoneNumber, Address, additionalInfo);
    
}

public ArrayList<Volunteer> getVolunteersBasedOnGuild(String GuildName) {
    return VM.getVolunteerBasedOnGuild(GuildName);
}

public ArrayList<GuildVolunteerWork> getVolunteerWork(int VolunteerId) throws SQLException {
    return VM.getVolunteerWork(VolunteerId);
}

/*
public void deleteVolunteer(Volunteer volunteer{
listOfVolunteer().remove(0).getVolunteerId()
}
*/
    
    

}
