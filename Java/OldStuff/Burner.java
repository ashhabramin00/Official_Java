import java.util.Scanner;

public class Burner
{

	public static void main(String args[])
	{  
		  int i,fact=1;
		  
		  try (Scanner factTo = new Scanner(System.in)) {
			System.out.println("Enter number for factorial");//It is the number to calculate factorial  
			  
			  int number = factTo.nextInt();
			  for(i=1;i<=number;i++){    
			      fact=fact*i;   
			      }    
			  System.out.println("Factorial of "+number+" is: "+fact);
			  }    
		  }  
}  