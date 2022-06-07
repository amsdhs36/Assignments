package Calculator;

import java.util.Scanner;

public class Operator {
public static void main (String argvs[])
{
	Operation obj=new Operation();
	try (Scanner sc = new Scanner(System.in)) 
		{
			char todomore;
			System.out.println(START);
			do
			{
		    
	    	System.out.println("Please enter the number 1:");
		    int n1=sc.nextInt();
	    	obj.setNumber1(n1);
	    	System.out.println("Please enter the number 2:");
	    	int n2=sc.nextInt();
	    	obj.setNumber2(n2);
	    	printAns();
	    	System.out.println("Number1:"+obj.getNumber1());
	     	System.out.println("Number2:"+obj.getNumber2());
	    	int ch=sc.nextInt();
	     	float result=obj.SwitchChoice(ch, n1, n2);
	     	System.out.println("Result:"+result);
	     	//Type Casting
	     	long result1=(long) result;
	     	int result2=(int) result1;
	    	System.out.println("Result after type casting="+result2);
	    	System.out.println("Do you want to continue(Y/N)");
	    	todomore=sc.next().charAt(0);
	    	}while(todomore=='y'|| todomore=='Y');
			System.out.println("Program exited succesfully");
		
	}
	
}
private static void printAns() {
	//Static method
	System.out.println("Please enter the operation  to be performed ");
	System.out.println("1.Addition 2. Subtraction 3. Multiplication 4. Division");
}
//Static final keyword
public static final String  START="Welcome to Calculator operations";
	
}