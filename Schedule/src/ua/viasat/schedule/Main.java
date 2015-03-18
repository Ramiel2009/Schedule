package ua.viasat.schedule;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static String[] sss = {"","","","","","","","","","","","","","","","","","","","","","","","","",""};
	
	public static void main(String[] args) throws FileNotFoundException, IOException {		
		try(BufferedReader br = new BufferedReader (new FileReader ("e:/MGM_s.sgi"))){
		
			StringBuffer sb = new StringBuffer();
			String line = br.readLine();
			
			byte text[] = line.getBytes("utf-8");
			String value = new String (text, "utf-8");
			
		
			System.out.println(value);
			

			while (line != null){
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
				
				String[] params = line.split("~");
				
				sss[0] = params[0];
				System.out.println("key: " + sss[0]);
				sss[1] = params [1];
				System.out.println("date: " + sss[1]);
				sss[2] = params [2];
				System.out.println("time: " + sss[2]);
				sss[3] = params [3];
				System.out.println("duration: " + sss[3]);
				sss[4] = params [4];
				System.out.println("name: " + sss[4]);
				sss[5] = params [5];
				System.out.println("synopsis: " + sss[5]);
				sss[6]=params[6];
				MysqlPreparedStetementInsert.sq(sss[0], sss[1], sss[2], sss[3], sss[4], sss[5], sss[6]);
			}
		}
	}
}