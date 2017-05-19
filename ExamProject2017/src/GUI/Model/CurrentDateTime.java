/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author EdwinSilva
 */
public class CurrentDateTime {

    Date date = new Date();
    

    public void getCurrentDate() {
        DateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        String outputText = outputFormat.format(date);
           System.out.println (outputText);
    }

}
