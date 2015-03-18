package ua.viasat.schedule;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public class Encode {
	
	static File fl;
	public static void main(String[] args) throws IOException {
		Pathb(); //get current directory
		String ffolder = fl.toString().replaceAll("encoder.jar", "");

		File folder = new File(ffolder);
		File[] listOfFiles = folder.listFiles();
		
		//deleting restricted files
		for (int i = 0; i < listOfFiles.length; i++) {
			System.out.println("--------------------------");
				   if (listOfFiles[i].getName().equalsIgnoreCase("BBC_World.sgi")
					 ||listOfFiles[i].getName().equalsIgnoreCase("Bloomberg_TV_Europe.sgi")
					 ||listOfFiles[i].getName().equalsIgnoreCase("5_Channel.sgi")
					 ||listOfFiles[i].getName().equalsIgnoreCase("M2.sgi")
					 ||listOfFiles[i].getName().equalsIgnoreCase("Shopping_TV.sgi")
					 ||listOfFiles[i].getName().equalsIgnoreCase("France_24.sgi")
					 ||listOfFiles[i].getName().equalsIgnoreCase("UBR.sgi")
					 ||listOfFiles[i].getName().equalsIgnoreCase("Eurosport2.sgi")){
				File removeFile = new File (ffolder+"/"+ listOfFiles[i].getName());
				removeFile.delete();
				System.out.println("File "+listOfFiles[i].getName()+ "\nDeleted");
			}
				   
			else if (listOfFiles[i].isFile()) {
				String filename = ffolder + "/" + listOfFiles[i].getName();
				String ext = FilenameUtils.getExtension(listOfFiles[i].getName());
				
				//checking files extension
				if (ext.equalsIgnoreCase("sgi")) {
					System.out.println("Sgi founded: "+ listOfFiles[i].getName());
					File file1 = new File(filename);
					String content = FileUtils.readFileToString(file1, "ISO8859_5");
					content.replaceAll("Viasat_NatHist_HD", "Nature_HD");
					FileUtils.write(file1, content, "UTF-8");
					System.out.println("Done with " + listOfFiles[i].getName());
					
					//processing Nature/History
					if (listOfFiles[i].getName().equals("Viasat_NatHist_HD.sgi")) {
						System.out.println("Nature_History founded!");
						File renameToNature = new File(ffolder + "/" + "Viasat_Nature_HD_s.sgi");
						listOfFiles[i].renameTo(renameToNature);
						System.out.println("Renamed to Nature HD");
						File copyNatHist = new File(ffolder + "/" + "Viasat_History_HD_s.sgi");
						FileUtils.copyFile(renameToNature, copyNatHist);
						System.out.println("Copied to History HD");
						//setReplacer(renameToNature, renameToNature, "History HD");
					};

					File siteName = new File(ffolder+ "/"
					+FilenameUtils.removeExtension(listOfFiles[i].getName())+"_s.sgi");
					
					listOfFiles[i].renameTo(siteName);
					
					/*if ((Week.getDate()).equals("Friday")){
						System.out.println("GG");
						
					}*/
				} 
				
				//skipping non-sgi files
				else{
					System.out.println("File " + listOfFiles[i].getName() + " skiped");
				}
				
				//skipping directories
			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory \" " + listOfFiles[i].getName()
						+ "\" skiped");
			}
		}
	}
	
	public static File setReplacer (File in, File out, String name){
		try{
			String input = "";
			BufferedReader br = new BufferedReader (new FileReader(in));
			PrintWriter outp = new PrintWriter(out);
			while ((input = br.readLine())!=null){
				if (input.contains("Viasat NatHist HD")){
					input.replace("Viasat NatHist HD", name);
					outp.println(input);
					br.close();
					outp.close();
				}
			}
		}
		
		catch (IOException e){
			e.printStackTrace();
		}
		
		return null;
	}

	
	public static File Pathb() {
		try {
			fl = new File(Encode.class.getProtectionDomain().getCodeSource()
					.getLocation().toURI().getPath());
			return fl;
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void cutter(File filee) throws IOException{
		
		System.out.println("Reader");
		BufferedReader br = new BufferedReader (new FileReader 
				(filee));
		try{
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while(line!=null){
				sb.append(line);
				sb.append(System.lineSeparator());
				line=br.readLine();
			}
			String text = sb.toString();
			System.out.println(text);
		}finally{
			br.close();
		}
	}
}