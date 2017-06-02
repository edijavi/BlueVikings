package BE;

public class Guild {
private String GuildName;
private int GuildId;
private double GuildHours;
private int ManagerId;

public Guild(String GuildName, int GuildId, double GuildHours, int ManagerId )  {
        this.GuildName = GuildName;
        this.GuildId = GuildId;
        this.GuildHours =  GuildHours;
        this.ManagerId = ManagerId;
    }
public Guild(){
    
}
/**
 * 
 * @return Guild Name 
 */
    public String getGuildName() {
        return GuildName;
    }
 /**
  * Set the guild name
  * @param GuildName 
  */
    public void setGuildName(String GuildName) {
        this.GuildName = GuildName;
    }
/**
 * 
 * @return The guild id
 */
    public int getGuildId() {
        return GuildId;
    }
/**
 * Set the guild id
 * @param GuildId 
 */
    public void setGuildId(int GuildId) {
        this.GuildId = GuildId;
    }
/**
 * 
 * @return Hours worked in a guild
 */
    public double getGuildHours() {
        return GuildHours;
    }
/**
 * set the number of hours worked in a guild
 * @param GuildHours 
 */
    public void setGuildHours(double GuildHours) {
        this.GuildHours = GuildHours;
    }
/**
 * 
 * @return Id of the manager
 */
    public int getManagerId() {
        return ManagerId;
    }
    /**
     * Set the id of the Manger
     * @param ManagerId 
     */
    public void setManagerId(int ManagerId) {
        this.ManagerId = ManagerId;
    }


    @Override
    public String toString() {
        return " \n " +" \n " +"GuildName:" + GuildName + " \n " +"GuildId:" + GuildId +" \n " + "GuildHours:" + GuildHours +" \n " +  "ManagerId:" + ManagerId;
    }





}