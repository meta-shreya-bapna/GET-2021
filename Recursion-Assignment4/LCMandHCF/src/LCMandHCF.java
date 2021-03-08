import java.util.Scanner;

public class LCMandHCF {
	private static int i=2;  
	
	/**
	 * LCM of 2 numbers
	 * @param num1: First input number
	 * @param num2: Second input number
	 * @param tempMax: contains max value's copy to reserve the max value
	 * @param max: contains largest value among both the numbers 
	 * @return lcm
	 */
	int lcm(int num1,int num2,int tempMax,int max) 
	{
	  if(max%num2!=0 || max%num1!=0)
		{
		max=tempMax*i;
		i=i+1;
		return lcm(num1,num2,tempMax,max);
		}
	  return max;
 	 }
	
	/**
	 * HCF of 2 numbers
	 * @param num1: First input number
	 * @param num2: Second input number 
	 * @return hcf
	 */
	int hcf(int num1,int num2)
	{
	    if (num1 == 0)
	        return num2;
	    else
	        return hcf(num2%num1,num1);
	}
	
	public static void main(String[] args)
	{
		int number1,number2,max,tempMax,num1,num2;
 	    Scanner sc=new Scanner(System.in);
 	    System.out.println("For LCM:");
 	    System.out.println("enter number 1");
        number1=sc.nextInt();
        System.out.println("enter number 2");
        number2=sc.nextInt();
        
        LCMandHCF l=new LCMandHCF();
        //to check maximum number among both
        if(number1>number2) 
    	   max=number1;
        else
    	   max=number2;
        
        tempMax=max;
        
        //to check numbers should not be 0
        if(number1==0 ||number2==0)
        {
     	   System.out.println("Numbers should not be 0");
        }
        else
        {System.out.println("LCM of 2 numbers is :"+l.lcm(number1,number2,tempMax,max));}
        
        //hcf
        System.out.println("\nFor HCF:");
 	    System.out.println("enter number 1");
        num1=sc.nextInt();
        System.out.println("enter number 2");
        num2=sc.nextInt();
        System.out.println("HCF of 2 numbers is :"+l.hcf(num1,num2));
	}
	
}
