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

    public String getGuildName() {
        return GuildName;
    }

    public void setGuildName(String GuildName) {
        this.GuildName = GuildName;
    }

    public int getGuildId() {
        return GuildId;
    }

    public void setGuildId(int GuildId) {
        this.GuildId = GuildId;
    }

    public double getGuildHours() {
        return GuildHours;
    }

    public void setGuildHours(double GuildHours) {
        this.GuildHours = GuildHours;
    }

    public int getManagerId() {
        return ManagerId;
    }

    public void setManagerId(int ManagerId) {
        this.ManagerId = ManagerId;
    }


    @Override
    public String toString() {
        return " \n " +" \n " +"GuildName:" + GuildName + " \n " +"GuildId:" + GuildId +" \n " + "GuildHours:" + GuildHours +" \n " +  "ManagerId:" + ManagerId;
    }





}