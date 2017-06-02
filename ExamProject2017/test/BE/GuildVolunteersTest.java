package BE;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jesper Enemark
 */
public class GuildVolunteersTest
{

    public GuildVolunteersTest()
    {
    }

    /**
     *
     * @authors Boldizsár Koppány, Deividas Tamošiūnas, Edwin Mhoy Silva, Jesper
     * Enemark, Edison J. Lamar Toapanta
     *
     */
    /**
     * Test of getGuildId method, of class GuildVolunteers.
     */
    @Test
    public void testGetGuildId()
    {
        int expResult = 4;
        GuildVolunteers instance = new GuildVolunteers(expResult, 0);

        int result = instance.getGuildId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getVolunteerId method, of class GuildVolunteers.
     */
    @Test
    public void testGetVolunteerId()
    {
        int expResult = 10;
        GuildVolunteers instance = new GuildVolunteers(0, expResult);

        int result = instance.getVolunteerId();

        assertEquals(expResult, result);

    }

}
