/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.util.ArrayList;
import java.util.List;
import BE.Volunteer;
import BE.Guild;
import BE.Manager;
import DAL.ManagerDataManager;

/**
 *
 * @author boldi
 */
public class SearchHandler {
   public enum SearchType{FIRSTNAME,LASTNAME,GUILD,MANAGERFIRSTNAME,MANAGERLASTNAME,FIRSTNAMBASEDONGUILD,LASTNAMEBASEDONGUILD}
   VolunteerManager VM = new VolunteerManager();
   ManagerDataManager MDM = new ManagerDataManager();
   public <T> List <T> Search(String word, List<T> inWhat, SearchType type)
   {
       List <T> filtered = new ArrayList<>();
       
       if(type == SearchType.FIRSTNAME) {
           for (T t : inWhat) {
               if (t instanceof Volunteer)
                   if(((Volunteer) t).getFirstName().toLowerCase().contains(word.toLowerCase())){
                   filtered.add(t);
                   }
           }
       }else
        if(type == SearchType.LASTNAME) {
           for (T t : inWhat) {
               if (t instanceof Volunteer)
                   if(((Volunteer) t).getLastName().toLowerCase().contains(word.toLowerCase())){
                   filtered.add(t);
                   }
           }
        }else
           if(type == SearchType.GUILD) {
           for (T t : inWhat) {
               if (t instanceof Guild)
                   if(((Guild) t).getGuildName().toLowerCase().contains(word.toLowerCase())){
                   filtered.add(t);
                   }
           }
        }else
           if(type == SearchType.MANAGERFIRSTNAME) {
           for (T t : inWhat) {
               if (t instanceof Manager)
                   if(((Manager) t).getFirstname().toLowerCase().contains(word.toLowerCase())){
                   filtered.add(t);
                   }
           }
        }else
           if(type == SearchType.MANAGERLASTNAME) {
           for (T t : inWhat) {
               if (t instanceof Manager)
                   if(((Manager) t).getLastname().toLowerCase().contains(word.toLowerCase())){
                   filtered.add(t);
                   }
           }
        }return filtered;
    }
}
