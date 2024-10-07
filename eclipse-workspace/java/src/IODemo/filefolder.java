package IODemo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class filefolder {

	public static void main(String[] args) throws IOException {

//		CREATE A FOLDER & SUBFOLDER
//		  File file=new File("//home//sasi-670-test//Raja//Rani//Manthiri");
//		  boolean present=file.exists(); 
//		  System.out.println("folder present: "+present);
//		  if(present==false)
//		  file.mkdirs();
//		  present=file.exists();
//		  System.out.println("folder present :"+ present);

//		File file=new File("//home//sasi-670-test//Raja//sk.txt");	
//		file.createNewFile();	

		
//		CREATE A FILE
//		  File file = new File("//home//sasi-670-test//Raja//test.txt"); 
//		  boolean present = file.exists(); 
//		  if (present == false)
//		   { 
//		   try
//		    { boolean created =file.createNewFile(); 
//		  System.out.println("File Created:" + created); 
//		  }
//		   catch
//		  (IOException e) 
//		  { catch block e.printStackTrace(); 
//		  }
//		  }

		
//		DELETE A FILE
//		  File file=new File("//home//sasi-670-test//Raja//test.txt"); file.delete();
//		  boolean present=file.exists(); System.out.println("file present:" +present);
//		 

//		RENAME A FILE
//		  File file=new File("//home//sasi-670-test//Raja//test.txt");
//		  file.createNewFile(); File newName=new
//		  File("//home//sasi-670-test//Raja//hakunamatata.txt"); boolean
//		  rename=file.renameTo(newName); System.out.println("Rename success"+rename);
//		  System.out.println("File Name"+newName.getName());

		
//		LIST OF ALL FOLDERS
//		  File file = new File("//home//sasi-670-test"); String[] listOfFilesFolders =
//		  file.list(); for (int i = 0; i < listOfFilesFolders.length; i++)
//		  System.out.println(listOfFilesFolders[i]); for(String s:listOfFilesFolders)
		  
		

		
//		WRITE A FILE
//		FileWriter file=new FileWriter("/home/sasi-670-test/Raja/sk.txt");
//		file.write("Hey Good to see you");
//		file.close();
		
		
//		
//		String path="/home/sasi-670-test/Raja/hakunamatata.txt";
//		BufferedWriter writer=new BufferedWriter(new FileWriter(path));
//		String content="Hey Hi Good to see you";
//		writer.write(content);
//		writer.close();
		
//		READ A FILE
		
//		try {
//            File Obj = new File("/home/sasi-670-test/Raja/hakunamatata.txt");
//            Scanner Reader = new Scanner(Obj);
//            while (Reader.hasNextLine()) {
//                String data = Reader.nextLine();
//                System.out.println(data);
//            }
//            Reader.close();
//        }
//        catch (FileNotFoundException e) {
//            System.out.println("An error has occurred.");
//            e.printStackTrace();
//        }
		
		
		
	}
}
