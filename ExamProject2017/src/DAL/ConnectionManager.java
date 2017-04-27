/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;

/**
 *
 * @author EdwinSilva
 */
public class ConnectionManager
{
    private SQLServerDataSource ds =
        new SQLServerDataSource();

    public ConnectionManager()
    {
        setupDataSouce();
    }
    
    public Connection getConnection() throws SQLServerException
    {
        return ds.getConnection();
    }
    
    private  void setupDataSouce(){
     ds.setDatabaseName("BlueVikigns");
     ds.setUser("CS2016B_9");
     ds.setPassword("CS2016B_9");
     ds.setPortNumber(1433);
     ds.setServerName("10.176.111.31");
        }
}
