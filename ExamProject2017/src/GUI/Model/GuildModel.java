/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BE.Guild;
import BE.Volunteer;
import BLL.GuildManager;
import BLL.SearchHandler;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author EdwinSilva
 */
public class GuildModel
{

    ObservableList<Guild> listOfGuilds;
    ObservableList<Volunteer> listOfVolunteer;
    
    GuildManager GM = new GuildManager();
    private SearchHandler searchHandler = new SearchHandler();

    public ObservableList<Guild> getListOfGuilds() 
    {
        return listOfGuilds = FXCollections.observableArrayList(GM.getGuild());

    }

    public <T> List<T> doSearch(String word, List<T> inWhat, SearchHandler.SearchType type)
    {
        return searchHandler.Search(word, inWhat, type);
    }

    public GuildModel()
    {
        
    }

    
    
    public void setGuildHours(double GuildHours, int GuildId)
    {
        GM.setGuildHours(GuildHours, GuildId);
    }

    public void addVolunteerWork(Date date, double Hour, int GuildId, int VolunteerId)
    {
        GM.addVolunteerWork(date, Hour, GuildId, VolunteerId);
    }

}
