
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

<<<<<<< Upstream, based on origin/master
    

   /**
    * 
    * @return The Guild Id
    */
=======
>>>>>>> f037fba Added test class and javaDoc implemented - Jesper
    public int getGuildId()
    {
        return GuildId;
    }

<<<<<<< Upstream, based on origin/master
  
    /**
     * 
     * @return return the volunteerId 
     */
=======
>>>>>>> f037fba Added test class and javaDoc implemented - Jesper
    public int getVolunteerId()
    {
        return VolunteerId;
    }

<<<<<<< Upstream, based on origin/master
   /**
    * 
    * @return return the date for work days 
    */
=======
>>>>>>> f037fba Added test class and javaDoc implemented - Jesper
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
