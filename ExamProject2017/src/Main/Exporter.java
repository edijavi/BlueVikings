package Main;

import BE.Volunteer;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Exporter {

    private SQLServerDataSource ds
            = new SQLServerDataSource();

    public Exporter() {
        setupDataSouce();
    }

    public Connection getConnection() throws SQLServerException {
        return ds.getConnection();
    }

    private void setupDataSouce() {
        ds.setDatabaseName("BlueVikings");
        ds.setUser("CS2016B_9");
        ds.setPassword("CS2016B_9");
        ds.setPortNumber(1433);
        ds.setServerName("10.176.111.31");
    }

    public ArrayList<Object[]> getTableDataForGuild() throws SQLServerException {
        ArrayList<Object[]> tableDataList = null;
        Connection con = getConnection();
        if (con != null) {
            try {
                PreparedStatement ps = con.prepareStatement("SELECT GuildId, GuildName, GuildHours From Guild");
                ResultSet result = ps.executeQuery();
                tableDataList = new ArrayList<Object[]>();
                while (result.next()) {
                    Object[] objArray = new Object[3];
                    objArray[0] = result.getInt(1);
                    objArray[1] = result.getString(2);
                    objArray[2] = result.getInt(3);

                    tableDataList.add(objArray);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Unable to create PreparedStatement");
            }
        }
        return tableDataList;
    }

    public void doExportGuildInfo(ArrayList<Object[]> dataList) {
        if (dataList != null && !dataList.isEmpty()) {
            HSSFWorkbook workBook = new HSSFWorkbook();
            HSSFSheet sheet = workBook.createSheet();
            HSSFRow headingRow = sheet.createRow(0);
            headingRow.createCell((short) 0).setCellValue("GuildId");
            headingRow.createCell((short) 1).setCellValue("GuildName");
            headingRow.createCell((short) 2).setCellValue("GuildHours");
            ;
            short rowNo = 1;
            for (Object[] objects : dataList) {
                HSSFRow row = sheet.createRow(rowNo);
                row.createCell((short) 0).setCellValue(objects[0].toString());
                row.createCell((short) 1).setCellValue(objects[1].toString());
                row.createCell((short) 2).setCellValue(objects[2].toString());

                rowNo++;
            }

            String file = "/Users/EdwinSilva/Desktop/GithubProjects/BlueVikings/ExamProject2017/MyFirstExcel.xls";
            try {
                FileOutputStream fos = new FileOutputStream(file);
                workBook.write(fos);
                fos.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Invalid directory or file not found");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error occurred while writting excel file to directory");
            }
        }
    }

    public ArrayList<Object[]> getVolunteerBasedOnGuild() {

         ArrayList<Object[]> tableDataList = null;

        try (Connection con = getConnection()) {
            {
                String query
                        = " SELECT v.VolunteerId, v.FirstName, g.GuildName "
                        + " FROM [Volunteer] v"
                        
                        + " INNER JOIN [GuildVolunteers] gv ON v.VolunteerId = gv.VolunteerId "
                        + " INNER JOIN [Guild] g ON gv.GuildId = g.GuildId "
                        +"where g.GuildId = gv.GuildId "
                        +"ORDER BY g.GuildName"
                  ;
                PreparedStatement pstmt = con.prepareStatement(query);

        
                ResultSet rs = pstmt.executeQuery();
                tableDataList = new ArrayList<Object[]>();
                while (rs.next()) {
                    Object[] objArray = new Object[3];
                    objArray[0] = rs.getInt(1);
                    
                    objArray[1] = rs.getString(2);
                    objArray[2] = rs.getString(3);
//                    objArray[3] = rs.getString(4);
//                    objArray[4] = rs.getString(5);
//                    objArray[5] = rs.getString(6);
//                    objArray[6] = rs.getFloat(7);
//                     objArray[7] = rs.getInt(8);

                    tableDataList.add(objArray);

                   


                }
            }

            return tableDataList;

        } catch (SQLException sqle) {
            System.err.println(sqle);
            return null;

        }

    }
    public void doExportGuildVolunteerInfo(ArrayList<Object[]> dataList) {
        if (dataList != null && !dataList.isEmpty()) {
            HSSFWorkbook workBook = new HSSFWorkbook();
            HSSFSheet sheet = workBook.createSheet("Volunteer");
            HSSFRow headingRow = sheet.createRow(0);
           
            headingRow.createCell((short) 0).setCellValue("VolunteerId");
            headingRow.createCell((short) 1).setCellValue("FirstName");
//            headingRow.createCell((short) 2).setCellValue("LastName");
//            headingRow.createCell((short) 3).setCellValue("Email");
//            headingRow.createCell((short) 4).setCellValue("PhoneNumber");
//             headingRow.createCell((short) 5).setCellValue("Address");
//              headingRow.createCell((short) 6).setCellValue("VolunteerHours");
               headingRow.createCell((short) 2).setCellValue("GuildName");
            ;
            short rowNo = 1;
            for (Object[] objects : dataList) {
                HSSFRow row = sheet.createRow(rowNo);
                row.createCell((short) 0).setCellValue(objects[0].toString());
                row.createCell((short) 1).setCellValue(objects[1].toString());
                row.createCell((short) 2).setCellValue(objects[2].toString());
//                 row.createCell((short) 3).setCellValue(objects[3].toString());
//                row.createCell((short) 4).setCellValue(objects[4].toString());
//                row.createCell((short) 5).setCellValue(objects[5].toString());
//                row.createCell((short) 6).setCellValue(objects[6].toString());
//                 row.createCell((short) 7).setCellValue(objects[7].toString());

                rowNo++;
            }
            String file = "/Users/EdwinSilva/Desktop/GithubProjects/BlueVikings/ExamProject2017/MyFirstExcel.xls";
            try {
                FileOutputStream fos = new FileOutputStream(file);
                workBook.write(fos);
                fos.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Invalid directory or file not found");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error occurred while writting excel file to directory");
            }
        }
        }
    

    public static void main(String[] args) throws SQLServerException {
        Exporter exporter = new Exporter();
        //ArrayList<Object[]> dataList = exporter.getTableDataForGuild();
       ArrayList<Object[]> dataList = exporter.getVolunteerBasedOnGuild();
        if (dataList != null && dataList.size() > 0) {
            exporter.doExportGuildVolunteerInfo(dataList);
        } else {
            System.out.println("There is no data available in the table to export");
        }
    }

}

