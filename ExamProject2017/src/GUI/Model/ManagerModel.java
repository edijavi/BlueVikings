/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BE.Guild;
import BE.Manager;
import BE.Volunteer;
import BLL.ManagementManager;
import BLL.SearchHandler;
import GUI.Controller.LogInController.loginType;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @authors Boldizsár Koppány, Deividas Tamošiūnas, Edwin Mhoy Silva, Jesper Enemark,
 * Edison J. Lamar Toapanta
 *
 */
public class ManagerModel
{
    private static loginType logintype;
    ObservableList<Manager> listOfManagers;
   
    
    public void setLogintype(loginType logintype) {
        this.logintype = logintype;
    }

    
    
    public loginType getLogintype() {
        return logintype;
    }
    ManagementManager MM1 = new ManagementManager();
    private SearchHandler searchHandler = new SearchHandler();
    
    public ObservableList<Manager> getManagers()
    {
        return listOfManagers = FXCollections.observableArrayList(MM1.getManager());
    }
    /**
     * References to the search handler.
     * @param <T>
     * @param word
     * @param inWhat
     * @param type
     * @return 
     */
    public <T> List<T> doSearch(String word, List<T> inWhat, SearchHandler.SearchType type) {
        return searchHandler.Search(word, inWhat, type);
    }
    public void editManager(String Username, String Password, String Firstname, String Lastname, String Email, String Phone, int ManagerId) {
        MM1.editManager(Username, Password, Firstname, Lastname, Email, Phone, ManagerId);
    }
    
    public void deleteManager(int ManagerId) {
         MM1.deleteManager(ManagerId);
    }
    
    public void addManager(String Username, String Password, String Firstname, String Lastname, String Email, String Phone) {
        MM1.addManager(Username, Password, Firstname, Lastname, Email, Phone);
    }
}
