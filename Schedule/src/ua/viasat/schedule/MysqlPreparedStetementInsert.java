package ua.viasat.schedule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MysqlPreparedStetementInsert {
	
		 
		  public static void sq(String key, String date, String time, String duration,
				  String name, String synopsis, String tag){		
		    try
		    {
		      // create a mysql database connection
		      String myUrl = "jdbc:mysql://10.0.1.126/schedule";
		      Class.forName("com.mysql.jdbc.Driver");
		      System.out.println("Connection..");
		      Connection conn = DriverManager.getConnection(myUrl, "schedule", "");
		     
		     /* // the mysql insert statement		      
		      String query = "INSERT into schedule (date, time, lang, name, synopsis, genre, tag) " +
		      		"VALUES (?, ?, ?, ?, ?, ?, ?)";
		 
		      // create the mysql insert preparedstatement
		      
		     PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setString (1, "090909");
		      preparedStmt.setString (2, "Rubble");
		      preparedStmt.setString (3, "rus");
		      System.out.println(s);
		      preparedStmt.setString (4, "просто текст");
		      preparedStmt.setString (5, "TeletuBIE");
		      preparedStmt.setString (6, "kids");
		      preparedStmt.setString (7, "kk");*/
		      
		      
		      
		   // the mysql insert statement		      
		      String query = "INSERT into schedule (key, date, time, duration, name, synopsis, tag) " +
		      		"VALUES (?, ?, ?, ?, ?, ?, ?);";
		 
		      // create the mysql insert preparedstatement	      
		  
		     PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setString (1, key);
		      preparedStmt.setString (2, date);
		      preparedStmt.setString (3, time);
		      preparedStmt.setString (4, duration);
		      preparedStmt.setString (5, name);
		      preparedStmt.setString (6, synopsis);
		      preparedStmt.setString (7, tag);
		 
		      // execute the preparedstatement
		      preparedStmt.execute();
		      conn.close();
		      System.out.println("Inserted");
		    }
		    catch (Exception e)
		    {
		      System.err.println("Exception:");
		      System.err.println(e.getMessage());
		      e.printStackTrace();
		    }
		  }

}
