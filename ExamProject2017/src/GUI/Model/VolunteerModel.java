/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;


import BE.Volunteer;
import BLL.VolunteerManager;
import java.util.ArrayList;
import java.util.List;
import sun.security.jca.GetInstance;


/**
 *
 * @author EdwinSilva
 */
public class VolunteerModel {

private static VolunteerModel  VOLUNTEERMODEL = new VolunteerModel();

VolunteerManager VM = VolunteerManager.getInstance();

public static VolunteerModel getInstance(){
    return VOLUNTEERMODEL;


}    
    
public VolunteerModel (){
    
}

public List<Volunteer> getlistOfVolunteer(){
 return VM.getVolunteer();
}



public void deleteVolunteer(int volunteerId){
VM.deleteVolunteer(volunteerId);

    
}

public void addVolunteer(String firstName, String lastName, String Email, String phoneNumber, String Address){
VM.AddVolunteer(firstName, lastName, Email, phoneNumber, Address);
    
}

public ArrayList<Volunteer> getVolunteersBasedOnGuild(String GuildName) {
    return VM.getVolunteerBasedOnGuild(GuildName);
}
/*
public void deleteVolunteer(Volunteer volunteer{
listOfVolunteer().remove(0).getVolunteerId()
}
*/
    
    

}
