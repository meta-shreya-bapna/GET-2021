import java.util.Scanner;
import java.util.*;

public class Marksheet {
	
	/*
	 * Average of all grades
	 * @param grades : grade array input 
	 * @param n : size of array
	 * @return average
	 */
	public float average(float[] grades,int n)throws ArithmeticException
	{
		int i;
		float sum=0;
		for(i=0;i<n;i++)
		{
			sum+=grades[i];
		}
		return(sum/n);
	}
	
	/*
	 * Maximum among all grades
	 * @param grades : grade array input 
	 * @param n : size of array
	 * @return maximum
	 */
	public float maximum(float[] grades,int n)
	{
		int i;
		float max=0.0f;
		for(i=0;i<n;i++)
		{
			if(grades[i]>max)
			max=grades[i];
		}
		return(max);
	}
	
	/*
	 * Minimum among all grades
	 * @param grades : grade array input 
	 * @param n : size of array
	 * @return minimum
	 */
	public float minimum(float[] grades,int n)
	{
		int i;
		float min=grades[0];
		for(i=1;i<n;i++)
		{
			if(grades[i]<min)
			min=grades[i];
		}
		return(min);
	}
	
	/*
	 * Passing percentage of students scoring grades more than or equal to 40
	 * @param grades : grade array input 
	 * @param n : size of array
	 * @return percentage
	 */
	public float percentage(float[] grades,int n)throws ArithmeticException
	{
		int i,count=0;
		for(i=0;i<n;i++)
		{
			if(grades[i]>=40)
			{
				count+=1;
			}
		}
		float result=(count*100)/n;
		return(result);
	}
	
	
	public static void main(String[] args) {
		
		int num,choice;
		boolean flag=true;
		Scanner sc = new Scanner(System.in);
		Marksheet mark = new Marksheet();
		System.out.println("Enter the total no of students");
		num = sc.nextInt();
		float [] grades = new float[num];
		
		System.out.println("enter the grades of students \n");
		for(int i = 0;i<num;i++){
			grades[i] = sc.nextFloat();
		}
		
		try{
        	while(flag)
        	{
        	System.out.println("To Find: \n"+"1. average \n"+"2. maximum \n"+"3. minimum \n"+ "4. passing percentage \n"+"5. exit");
        	choice = sc.nextInt();
        	switch(choice){
        	case 1:{
        		System.out.println(mark.average(grades,num));
        		break;
        	}
        	case 2:{
        		System.out.println(mark.maximum(grades, num));
        		break;
        	}
        	case 3:{
        		System.out.println(mark.minimum(grades, num));
        		break;
        	}
        	case 4:{
        		System.out.println(mark.percentage(grades, num) + "%");
        		break;
        	}
		case 5:{
			flag=false;
			break;
		}

        	default: 
			System.out.println("Invalid choice");
        	}
        }
		}
        	catch(ArithmeticException e)
    		{
    			System.out.println("Sorry!, Number of Students cannot be Zero");
    		}
        }
	}


