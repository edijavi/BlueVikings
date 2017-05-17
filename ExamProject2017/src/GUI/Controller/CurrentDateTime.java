/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author EdwinSilva
 */


public class CurrentDateTime {
	public static void main(String[] args) throws ParseException {
		//get current date time using java.util.Date class
		Date date = new Date();
		
                DateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		
		String outputText = outputFormat.format(date);
		System.out.println(outputText);
	}
}    

