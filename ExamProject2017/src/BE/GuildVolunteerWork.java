
package BE;

import java.sql.Date;

/**
 *
 * @authors Boldizsár Koppány, Deividas Tamošiūnas, Edwin Mhoy Silva, Jesper Enemark,
 * Edison J. Lamar Toapanta
 *
 */
public class GuildVolunteerWork
{

    private int GuildId;
    private int VolunteerId;
    private Date date;
    private double Hour;
    private int WorkId;

    public GuildVolunteerWork(int GuildId, int VolunteerId, Date date, double Hour, int WorkId)
    {
        this.GuildId = GuildId;
        this.VolunteerId = VolunteerId;
        this.date = date;
        this.Hour = Hour;
        this.WorkId = WorkId;

    }
    /**
     * 
     * @return The id of work each work done
     */
    public int getWorkId()
    {
        return WorkId;
    }


    

   /**
    * 
    * @return The Guild Id
    */

    public int getGuildId()
    {
        return GuildId;
    }


  
    /**
     * 
     * @return return the volunteerId 
     */

    public int getVolunteerId()
    {
        return VolunteerId;
    }


   /**
    * 
    * @return return the date for work days 
    */

    public Date getDate()
    {
        return date;
    }
 /**
  * Set the date for work
  * @param date 
  */
    public void setDate(Date date)
    {
        this.date = date;
    }
    /**
     * 
     * @return hours worked for each volunteer 
     */
    public double getHour()
    {
        return Hour;
    }
    /**
     * set the hours worked in a guild
     * @param Hour 
     */
    public void setHour(double Hour)
    {
        this.Hour = Hour;
    }

    @Override
    public String toString()
    {
        return "GuildVolunteerWork{" + "GuildId=" + GuildId + ", VolunteerId=" + VolunteerId + ", date=" + date + ", Hour=" + Hour + '}';
    }

}
