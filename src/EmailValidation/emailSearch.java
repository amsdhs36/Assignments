package EmailValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class emailSearch {
	public class searchString
	{
		//String eID;
		public static boolean search(List<String> emailID,String eID)
		{
			boolean ans=emailID.contains(eID);
			if(ans)
			{
				System.out.println("Already Exist");
			}
			else
			{
				System.out.println("Does not exist");
			}
			return ans;
		}	
					
	}
	
	public static void main(String[] args) {
	 List<String> emailID=new ArrayList<String>();
	 
	 emailID.add("amrutasinghpatil@gmail.com");
	 emailID.add("amscat@gmail.com");
	 emailID.add("amsdhs@gmail.com");
	 
	 System.out.println("Enter the email id to be search:");
		 try (Scanner sc = new Scanner(System.in)) {
		 
		String userInput=sc.next();
		System.out.println("Email ID entered by user:"+userInput);
		boolean result=searchString.search(emailID,userInput);  
		if(result==false)
		{
			System.out.println("Do you want to add the emailID(Y/N):");
			char choice=sc.next().charAt(0);
			if(choice=='Y'|| choice=='y')
			{
				emailID.add(userInput);
				System.out.println("EmailID is added to the list");

			}
			else 
			{
				System.out.println("Program Exited");
			}}
			System.out.println("Email List:");
	      for(String email:emailID)
	      {

		   System.out.println(email);

		}	
			
         }
	}
}
	