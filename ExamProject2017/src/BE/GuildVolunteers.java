/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 *
 * @author EdwinSilva
 */
public class GuildVolunteers {

private int GuildId;
private int VolunteerId;



public GuildVolunteers(int GuildId, int VolunteerId){
this.GuildId = GuildId;
this.VolunteerId = VolunteerId;
    
}

    public int getGuildId() {
        return GuildId;
    }

   

    public int getVolunteerId() {
        return VolunteerId;
    }

    

}
