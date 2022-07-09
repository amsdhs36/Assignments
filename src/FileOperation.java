import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
public class FileOperation
{
public static void directoryifnotexist(String folderName)
{
		File file = new File(folderName);

		// If directory not exist, create the Main folder
		if (!file.exists()) {
			file.mkdirs();
					}
		}
  public static void displayOption()
  {
	  FileOperation.directoryifnotexist("Main");
	  String fileMenu ="Please enter the operations to be performed:"
	              + "\n1. Add/Write 2.Delete 3. Read 4.Append 5.Exit";
	  System.out.println(fileMenu);
  }
  public static void UserChoiceOperation()
  {
	  Scanner sc=new Scanner(System.in);
	  boolean running = true;
	  do {
		try {
	 	  FileOperation.displayOption();
	  int choice=sc.nextInt();
	  switch(choice)
	  {
	  	  case 1:
			System.out.println("Enter the name of the file to be added to the Main folder");
			String fileToAdd = sc.next();
			FileOperation.addFile(fileToAdd,sc);
			break;	
		case 2: 
			System.out.println("Enter the name of the file to be deleted");
			String fileToDel=sc.next();
			FileOperation.deleteFile(fileToDel);
			break;
		case 3:
			System.out.println("Enter the file to be read");  
		    String fileToread=sc.next();
			FileOperation.ReadFile(fileToread); 
		   	    
		    break;
		case 4:
			System.out.println("Enter the file to be append");
			String fileToAppend=sc.next();
			FileOperation.AppendFile(fileToAppend,sc);
			break;
		case 5:
			System.out.println("Program exited successfully.");
			running = false;
			sc.close();
			System.exit(0);
			break;
		default:
			System.out.println("Please enter valid choice from the menu");
		      }
			}  catch (Exception e) {
			System.out.println(e.getClass().getName());		} 
	  
	  } while (running == true);
  }
  public static void main(String[] args)
  {
	  System.out.println("File Operation");
	  FileOperation.UserChoiceOperation();
}
	  
	  
	  //Create a file
     public static void addFile(String fileToAdd, Scanner sc) {
    	 FileOperation.directoryifnotexist("Main");
 		Path pathToFile = Paths.get("./main/" + fileToAdd);
 		try {
 			Files.createDirectories(pathToFile.getParent());
 			Files.createFile(pathToFile);
 			System.out.println(fileToAdd + " created successfully");

 			System.out.println("Would you like to add some content to the file? (Y/N)");
 			String choice = sc.next().toLowerCase();

 			sc.nextLine();
 			if (choice.equals("y")) {
 				System.out.println("\n\nInput content and press enter\n");
 				String content = sc.nextLine();
 				Files.write(pathToFile, content.getBytes());
 				System.out.println("\nContent written to file " + fileToAdd);
 				System.out.println("Content can be read using Notepad or Notepad++");
 			}

 		} catch (IOException e) {
 			System.out.println("Failed to create file " + fileToAdd);
 			System.out.println(e.getClass().getName());
 		}
     }
   

//Deletes the file
	public static void deleteFile(String fileToDel)
	{
	   FileOperation.directoryifnotexist("Main");
	   Path Filepath=Paths.get("./Main/"+fileToDel);
	   try
	   {  
	     Files.delete(Filepath);
	     System.out.println(fileToDel+" deleted successfully");
	   }
	   catch (IOException e)
	   {
		   System.out.println("Failed, filed not deleted"+ fileToDel);
		   System.out.println(e.getClass().getName());
		   
	   }
	}
	//Reads the file
	public static void ReadFile(String filetoRead) 
	{try {
	      File myObj = new File("./Main/"+filetoRead);
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        System.out.println(data);
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		  
	}

	//Append to the file
	public static void AppendFile(String fileToAppend, Scanner sc)
	{
		try {
			Path path = Paths.get("C:\\Users\\lenovo\\eclipse-workspace\\AssignmentNo1\\Main\\"+fileToAppend);
			System.out.println("Please confirm? (Y/N)");
 			String choice = sc.next().toLowerCase();
 			sc.nextLine();
 			if (choice.equals("y")) {
 			System.out.println("Enter the data:");
			String appenddata=sc.nextLine();
			Files.write(path, appenddata.getBytes(StandardCharsets.UTF_8),
	                StandardOpenOption.CREATE,
	                StandardOpenOption.APPEND);
			System.out.println("Successfully appended");
 			}
	      } catch(IOException e){
	    	 System.out.println("Failed to create file " + fileToAppend);
	 		System.out.println(e.getClass().getName());
	      }
        }
}      
	

