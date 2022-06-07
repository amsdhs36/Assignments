package Calculator;

public class Operation {
		private long num1,num2;
		//this keyword usage
	public	void setNumber1(int n1)
		{
			this.num1=n1;
			
		}
		int getNumber1()
		{

			return (int) num1;
			
		}
		void setNumber2(int n2)
		{
			this.num2=n2;
			
		}
		int getNumber2()
		{
			
			return (int) num2;
			
		}
		public float SwitchChoice(int choice,float num1,float num2)
		{
			float ans = 0;
			switch(choice)
			{
			case 1:
				 ans=num1+num2;
				 
				 break;
				
			case 2:
				 ans=num1-num2;
				 
				 break;
			case 3: 
				ans=num1*num2;
				
				break;
				
			case 4:
			    ans=num1/num2;
			    
			    break;
			    default:
			    	System.out.println("Please enter the correct choice");
			    	return ans;
				
			}
			return ans;
			
		}
		
	}


