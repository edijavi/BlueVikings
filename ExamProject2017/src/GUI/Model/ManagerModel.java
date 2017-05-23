/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BE.Manager;
import BLL.ManagementManager;
import BLL.SearchHandler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesper Enemark
 */
public class ManagerModel
{
    ManagementManager MM1 = new ManagementManager();
    private SearchHandler searchHandler = new SearchHandler();
    
    public ArrayList<Manager> getManager()
    {
        return MM1.getManager();
    }
    public <T> List<T> doSearch(String word, List<T> inWhat, SearchHandler.SearchType type) {
        return searchHandler.Search(word, inWhat, type);
    }
}
