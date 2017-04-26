/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 *
 * @author DaveTamo
 */
public class tasks {
    public int id;
    String name;
    private tasks guilds;
    int addTask;
    int removeTask;
    int editTask;
    int listOfGuilds;
    
public tasks (int id, String name){
    this.id = id;
    this.name = name;
}
public void name(String name) {
    this.name = name;
    
}
public int getId(){
    return id;
}
public String getName() {
        return name;
}
public tasks guilds() {
    return guilds;
}
}


