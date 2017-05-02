/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;


import BE.Volunteer;
import BLL.VolunteerManager;
import java.util.ArrayList;
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
    
private VolunteerModel (){
    
}

public ArrayList<Volunteer> listOfVolunteer(){
 return VM.getVolunteer();
}
public void addVolunteer(Volunteer volunteer){
    listOfVolunteer().add(volunteer);
}
/*
public void deleteVolunteer(Volunteer volunteer{
listOfVolunteer().remove(0).getVolunteerId()
}
*/
    
    

}
