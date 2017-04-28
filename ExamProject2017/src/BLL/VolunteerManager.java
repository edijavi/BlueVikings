/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Volunteer;
import DAL.VolunteerDataManager;
import java.util.ArrayList;

/**
 *
 * @author EdwinSilva
 */
public class VolunteerManager {

VolunteerDataManager VDM = new VolunteerDataManager();

private static VolunteerManager VOLUNTEERMANAGER = new VolunteerManager();

public static VolunteerManager getInstance(){
    return VOLUNTEERMANAGER;
}

public VolunteerManager(){
    
}

public ArrayList<Volunteer> getVolunteer(){
return VDM.getVolunteer();
}
    
    
    
    
}
