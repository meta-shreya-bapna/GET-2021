package employeeOperations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		ArrayList<Employee> employeeList=new ArrayList<Employee>();
		int choice;
		boolean flag=true;
		while(flag)
		{	
			System.out.println("Enter choice:\n "+"1. to add employee\t"+"2.Natural sort\t\t"+"3.Sort on basis of name\t\t"+"4.Display the list\t"+"5.Exit");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:

				int id;
				String name, add;
				System.out.println("Enter the id of employee");
				id=sc.nextInt();
				sc.nextLine();
				boolean exist=false;
				for(int i=0;i<employeeList.size();i++)
				{
					if (employeeList.get(i).emp_id == id) {
						exist = true;
						break;
					}
				}
				if(exist)
				{
					System.out.println("This id already exists");
				}
				else
				{
					System.out.println("Enter the name of employee");
					name=sc.nextLine();
					System.out.println("Enter the address of employee");
					add=sc.nextLine();
					Employee e=new Employee(id,name,add);
					employeeList.add(e);
				}
				break;
			case 2:
				Collections.sort(employeeList, new NaturalSort());
				break;
			case 3:
				Collections.sort(employeeList, new SortByName());
				break;
			case 4:
				System.out.println("The employee list is as follows Employee List");
				System.out.println("EmpId\tEmployeeName\tAddress");
				for (int i = 0; i < employeeList.size(); i++) {
					System.out.println(employeeList.get(i).emp_id+"\t"+employeeList.get(i).emp_name+"\t\t"+employeeList.get(i).address);
				}
				break;
			case 5:
				flag=false;
				break;
			default:
				System.out.println("Invalid input");
			}
		}
		sc.close();
	}
}
