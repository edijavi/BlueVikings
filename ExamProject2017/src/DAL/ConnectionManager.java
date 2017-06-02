package DAL;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;

/**
 *
 * @authors Boldizsár Koppány, Deividas Tamošiūnas, Edwin Mhoy Silva, Jesper
 * Enemark, Edison J. Lamar Toapanta
 *
 */
public class ConnectionManager
{

    private SQLServerDataSource ds
            = new SQLServerDataSource();

    public ConnectionManager()
    {
        setupDataSouce();
    }
    /**
     * 
     * @return
     * @throws SQLServerException 
     */
    public Connection getConnection() throws SQLServerException
    {
        return ds.getConnection();
    }

    private void setupDataSouce()
    {
        ds.setDatabaseName("BlueVikings");
        ds.setUser("CS2016B_9");
        ds.setPassword("CS2016B_9");
        ds.setPortNumber(1433);
        ds.setServerName("10.176.111.31");
    }

}
