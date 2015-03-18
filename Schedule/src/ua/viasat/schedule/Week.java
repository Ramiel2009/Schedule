package ua.viasat.schedule;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Week {
	public static String getDate(){
	
	DateFormat dateFormat = new SimpleDateFormat("EEEE");
	Date date = new Date();
	System.out.println(dateFormat.format(date));
	return dateFormat.format(date);
}
}
