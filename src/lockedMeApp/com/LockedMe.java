package lockedMeApp.com;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Scanner;

public class LockedMe {
		public static void main(String[] args) throws ClassNotFoundException, IOException{
			
			int loc = 0;
			LockedMe lockedMe = new LockedMe();
			Scanner scanner  = new Scanner(System.in);
			System.out.println("LockedMe App");
			System.out.println("..........");
			System.out.println("by fikru cheklie");
			System.out.println("..........");
			System.out.println("Select one of the following options");
			System.out.println("..........");
			char ch;
			
			do{
				System.out.println("select one option");
				System.out.println("1. list file names");
				System.out.println("2. add file");
				System.out.println("3. delete");
				System.out.println("4. search");
				System.out.println("5. exit");
			loc = scanner.nextInt();
			
			switch(loc) {
			case 1: System.out.println("1: Displaying file names from directory in ascending order");
			lockedMe.FileNamesInAscendingOrder();
			break;
			case 2: System.out.println("2: adding files in the directory");
			lockedMe.addFileToTheDirectory();
			break;
			case 3: System.out.println("3: deleting files");
			lockedMe.delete_File();
			break;
			case 4: System.out.println("4: searching files");
			lockedMe.Searchilng_File();
			break;
			case 5: System.out.println("5: exit");
			lockedMe.exit();
			break;
			}
			System.out.println("Do you want to continue (Type y or n)");
			ch = scanner.next().charAt(0);
			}while(ch =='Y' || ch == 'y');
		}
		public String FileNamesInAscendingOrder() {
			File allFile = new File("C:\\LockedMe");
			String[] fileList = allFile.list();
			
			for(String fileName:fileList) {
				System.out.println("File : "+fileName);
				}
			return "success";
		}

		public void addFileToTheDirectory() {
			 File fileRepo = new File("C:\\LockedMe\\lockedMeFile.txt");
				
				if(fileRepo.exists())
				{
					System.out.println("file already exist");
					
					try
					{
				    //creating file writter object
					FileWriter fileWriter = new FileWriter("C:\\LockedMe\\lockedMeFile.txt");
					fileWriter.write("file successfully added");
					fileWriter.close();
					System.out.println("New file content successfully added");
					}
					catch(Exception e)
					{
						System.out.println("error opening the file");
					}
						
				}else
					try {
						//creating new file
						fileRepo.createNewFile();
						System.out.println("new file created");
					}
						catch(Exception e)
						{
							System.out.println("error creating a new file");
						}
		}
		
		public void delete_File() {
			System.out.println("Do you want to delete the file? Type yes or no");
			File fileDel = new File("C:\\LockedMe\\lockedMeDelete.txt");
			Scanner inputScanner = new Scanner(System.in);
			String input = inputScanner.nextLine();
			if(input.equalsIgnoreCase("yes")) {
				fileDel.delete();
				System.out.println("file deleted");
			}else {
				System.out.println("File not deleted");		
				}
			}

		
		public void Searchilng_File() {
			File fileSearch = new File("C:\\LockedMe\\lockedMeRepo.txt");	
			if(fileSearch.exists())
			    {
				System.out.println("File exist in the directory");
				try {
					//creating scanner object for reading content of file
					Scanner scannerSearch = new Scanner(fileSearch);
					while(scannerSearch.hasNextLine()) {
						String data = scannerSearch.nextLine();
						System.out.println(data);
					}
					System.out.println("file information");
					System.out.println("Name : "+fileSearch.getName());
					System.out.println("path : "+fileSearch.getAbsolutePath());
					System.out.println("parent : "+fileSearch.getParent());
					System.out.println("writable : "+fileSearch.canWrite());
					System.out.println("Readable : "+fileSearch.canRead());
					System.out.println("Executable : "+fileSearch.canExecute());
					System.out.println("length : "+fileSearch.length());
				} catch (FileNotFoundException e) {
					System.out.println(e);
				}
				
				}else {
					System.out.println("FileNotFound");
				}
			
			}
			
			public void exit() {
				System.out.println("Do you want to exit? Type yes or no");
				Scanner exitScanner = new Scanner(System.in);
					String exitInput = exitScanner.nextLine();
					if(exitInput.equalsIgnoreCase("yes")) {
						System.exit(0);
						System.out.println("appplication closed");
					}else {
						System.out.println("applocation is running");
						
					}
				
			
	}

}
