import java.util.*;

public class Area {

	private double area;
	
	/*
	 * Area of Triangle
	 * @param width :Width of a Triangle
	 * @param height:Height of a Triangle
	 * @return Area of Triangle
	 */
	public double areaTriangle(double width, double height)throws ArithmeticException
	{
		return((width*height)/2);
	}
	
	/*
	 * Area of Rectangle
	 * @param width :Width of a Rectangle
	 * @param height:Height of a Rectangle
	 * @return Area of Rectangle
	 */
	public double areaRectangle(double width, double height)throws ArithmeticException
	{
		return (width*height);
	}
	
	/*
	 * Area of Square
	 * @param width :Width of a Square
	 * @return Area of Square
	 */
	public double areaSquare(double width)throws ArithmeticException
	{
		return (width*width);
	}
	
	/*
	 * Area of Circle
	 * @param radius :radius of a Circle
	 * @return Area of Circle
	 */
	public double areaCircle(double radius)throws ArithmeticException
	{
		return (3.14*radius*radius);
	}
	
	public static void main(String[] args)
	{
		int choice;
		boolean flag=true;
		Scanner sc= new Scanner(System.in);
		Area area=new Area();
		
		while(flag)
		{
			System.out.println("Enter your choice to calculate area of:\n"+"1.Triangle\n"+"2.Rectangle\n"+"3.Square\n"+"4.Circle\n"+"5.Exit");
			choice=sc.nextInt();
			sc.nextLine();
			
			try
			{
			switch(choice)
			{
			case 1:
				double width,height;
				System.out.println("enter the width and height of triangle");
				width = sc.nextDouble();
				height = sc.nextDouble();
				System.out.println("Area: "+area.areaTriangle(width, height));
				break;
    	
			case 2:
				double recWidth,recHeight;
				System.out.println("enter the widht and height of rectangle");
				recWidth = sc.nextDouble();
				recHeight = sc.nextDouble();
				System.out.println("Area: "+area.areaRectangle(recWidth, recHeight));
				break;
    	
			case 3:
				double sqWidth;
				System.out.println("enter the width of square ");
				sqWidth = sc.nextDouble();
				System.out.println("Area: "+area.areaSquare(sqWidth));
    				break;
    	
			case 4:
				double radius;
				System.out.println("enter the radius of circle");
				radius = sc.nextDouble();
				System.out.println("Area: "+area.areaCircle(radius));
				break;
    		
			case 5:
				flag=false;
				break;
				
			default:
				System.out.println("Invalid input! Try again");
			}
		}
			catch(ArithmeticException e)
    		{
    			System.out.println("Sorry!,value cannot be Zero");
    		}
		}
		sc.close();
	}

}
