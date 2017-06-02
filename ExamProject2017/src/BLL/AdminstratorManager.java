
package BLL;

import BE.Adminstrator;
import DAL.AdminManager;
import java.util.ArrayList;

/**
 *
 * @authors Boldizsár Koppány, Deividas Tamošiūnas, Edwin Mhoy Silva, Jesper Enemark,
 * Edison J. Lamar Toapanta
 *
 */
public class AdminstratorManager
{

    AdminManager AM = new AdminManager();

    /** 
    @return List of Adminstrators from DB
    */
   
   public ArrayList<Adminstrator> getAdminstrators()
    {
        return AM.getAdminstrators();

    }
}
