/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import java.sql.Date;

/**
 *
 * @author Jesper Enemark
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

    public int getWorkId()
    {
        return WorkId;
    }

    public void setWorkId(int WorkId)
    {
        this.WorkId = WorkId;
    }

   
    public int getGuildId()
    {
        return GuildId;
    }

    public void setGuildId(int GuildId)
    {
        this.GuildId = GuildId;
    }

    public int getVolunteerId()
    {
        return VolunteerId;
    }

    public void setVolunteerId(int VolunteerId)
    {
        this.VolunteerId = VolunteerId;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public double getHour()
    {
        return Hour;
    }

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
