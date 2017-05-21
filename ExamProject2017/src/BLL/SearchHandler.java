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

/**
 *
 * @author boldi
 */
public class SearchHandler {
   public enum SearchType{FIRSTNAME,LASTNAME,GUILD}
   VolunteerManager VM = new VolunteerManager();
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
        }return filtered;
    }
}
