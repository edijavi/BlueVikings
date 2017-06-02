/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 *
 * @authors Boldizsár Koppány, Deividas Tamošiūnas, Edwin Mhoy Silva, Jesper Enemark,
 * Edison J. Lamar Toapanta
 *
 */
public class GuildVolunteers {

private int GuildId;
private int VolunteerId;



public GuildVolunteers(int GuildId, int VolunteerId){
this.GuildId = GuildId;
this.VolunteerId = VolunteerId;
    
}
    /**
     * 
     * @return the guild id
     */
    public int getGuildId() {
        return GuildId;
    }

   
    /**
     * 
     * @return The volunteer Id
     */
    public int getVolunteerId() {
        return VolunteerId;
    }

    

}
