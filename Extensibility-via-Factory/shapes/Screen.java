package shapes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Screen {
	int X_MIN = 0;
	int Y_MIN = 0;
	int X_MAX = 100;
	int Y_MAX = 100;
	static int shapeId = 0;
	static ShapeFactory shapeFactory = new ShapeFactory();
	static List<Shape> shapes = new ArrayList<>();
	static List<Double> list = new ArrayList<>();
	
	static Scanner sc = new Scanner(System.in);
	
	/**
    * To add a shape on the screen, requires that shape must be either SQUARE, RECTANGLE, CIRCLE, TRIANGLE
    */
	static void addShape(){
		System.out.println("Enter shape name :");
		String shapeType = sc.next().toUpperCase();
		System.out.println("Enter "+shapeType+" coordinate x");
		double xCord = sc.nextInt();
		System.out.println("Enter "+shapeType+" coordinate y");
		double yCord = sc.nextInt();
		Point point = new Point(xCord,yCord);
		getParameter(shapeType);
		Shape shape = ShapeFactory.createShape(shapeType, point, list);
		if(shape==null){
			System.out.println("This shape is not supported");
			return;
		}
		shape.setId(shapeId++);
		shapes.add(shape);
		list.clear();
	}
	
	/**
	 * Method to take parameter values of a particular shape
	 *@param shapeType which indicates the type of shape
	*/
	private static void getParameter(String shapeType) {
		if(shapeType.equalsIgnoreCase("circle")){
			System.out.println("Enter radius");
			list.add(sc.nextDouble());
			
		}
		else if(shapeType.equalsIgnoreCase("triangle")){
			System.out.println("Enter side1");
			list.add(sc.nextDouble());
			System.out.println("Enter side2");
			list.add(sc.nextDouble());
			System.out.println("Enter side3");
			list.add(sc.nextDouble());
		}
		else if(shapeType.equalsIgnoreCase("rectangle")){
			System.out.println("Enter width");
			list.add(sc.nextDouble());
			System.out.println("Enter height");
			list.add(sc.nextDouble());
		}
		else{
			System.out.println("Enter square side");
			list.add(sc.nextDouble());
		}
		
	}
	
	//main method
	public static void main(String [] args){
		boolean flag=true;
		
		while(flag){
			System.out.println("1.Add shape");
			System.out.println("2.Remove shape");
			System.out.println("3.Display shapes");
			System.out.println("4.Check weather given point is enclosed or not");
			System.out.println("5.Sort acc. to timestamp latest to old");
			System.out.println("6.Sort acc. to area in ascending order");
			System.out.println("7.Exit");
			int option = sc.nextInt();
			
			switch(option){
			case 1:
				addShape();
				break;
				
			case 2:
				removeShape();
				break;
				
			case 3:
				displayShapes();
				break;
				
			case 4:
				isEnclosed();
				break;
				
			case 5:
				sortAndDisplay();
				break;
				
			case 6:
				getSortedListOfShapesByArea();
				break;
				
			case 7:
				flag=false;
				break;
			
			default:
				System.out.println("Invalid input!");
			}
			
			
		}
	}
	
	 /**
     * Sort and display shapes according to time stamp from latest to oldest
     */
	private static void sortAndDisplay() {
		for(int index=shapes.size()-1;index>=0;index--){
			System.out.println(shapes.get(index).getId()+"\t"+shapes.get(index).getClass().getSimpleName()+
					"\t ("+shapes.get(index).getOrigin().getX()+","+shapes.get(index).getOrigin().getY()+") \t"+shapes.get(index).getTimestamp());
		}
		
	}
	
	/**
     * Sort and display shapes according to area in ascending order
     */
	public static void getSortedListOfShapesByArea() {
		List<Shape> listOfShapes = new ArrayList<Shape>();
		if (shapes.isEmpty()) {
			System.out.println("List is empty!");
		}
		for (int value=0;value<shapes.size();value++) {
			listOfShapes.add(shapes.get(value));
		}

		for (int i = 0; i < listOfShapes.size(); i++) {
			for (int j = 0; j < (listOfShapes.size() - 1 - i); j++) {
				double area1 = listOfShapes.get(j).getArea();
				double area2 = listOfShapes.get(j + 1).getArea();
				if (area1 > area2) {
					Shape temp1 = listOfShapes.get(j);
					Shape temp2 = listOfShapes.get(j + 1);
					listOfShapes.set(j, temp2);
					listOfShapes.set(j + 1, temp1);
				}
			}
		}
		
		for(Shape value : listOfShapes){
			System.out.println(value.getId()+"\t"+value.getClass().getSimpleName()+
					"\t ("+value.getOrigin().getX()+","+value.getOrigin().getY()+") \t"+value.getArea()+"\t"+value.getTimestamp());
		}
	}
	
	/**
     * To get list of all the shapes enclosing a given point
     */
	private static void isEnclosed() {
		System.out.println("Enter x Coordinate");
		int x = sc.nextInt();
		System.out.println("Enter Y coordinate");
		int y = sc.nextInt();
		int tempCount=0;
		Point point = new Point(x,y);
		System.out.println("Given point is enclosed in follwing shapes :");
		for(Shape shape:shapes){
			if(shape.isPointEnclosed(point)){
				System.out.println(shape.getClass().getSimpleName()+"\t"+"\t\t ("+shape.getOrigin().getX()+","+shape.getOrigin().getY()+")");
			tempCount++;
			}
		}
		System.out.println("\n");
		if(tempCount==0)
		{
			System.out.println("Sorry! No shapes enclosing the points\n");
		}
		
	}

	 /**
     * Method to delete shape from the screen
     * Deletes a single shape based on id or deletes all shapes of a particular shape type from screen
     */
	private static void removeShape() {
		System.out.println("1.Remove a shape from screen");
		System.out.println("2.Remove all shape from screen of a specific type");
		int choice  = sc.nextInt();
		switch(choice){
		case 1:
			System.out.println("Enter shape Id");
			int id = sc.nextInt();
			for(int index = 0;index<shapes.size();index++){
				if(shapes.get(index).getId()==id){
					shapes.remove(index);
					break;
				}
			}
			break;
		case 2:
			System.out.println("Enter shape Type");
			String shapeType = sc.next();
			ArrayList<Shape> objectsToBeRemove = new ArrayList<>();
			for(Shape shape:shapes){
				if(shapeType.equalsIgnoreCase(shape.getClass().getSimpleName())){
					objectsToBeRemove.add(shape);
				}
			}
			for(Shape shape:objectsToBeRemove){
				shapes.remove(shape);
				
			}
			break;
		}		
		
	}
	
	 /**
     * Method to display shapes present on the screen
     */
	private static void displayShapes() {
		if(shapes.size()==0){
			System.out.println("Screen is Empty");
		}
		else{
			System.out.println("id\tshape\t\tscreen Coordinate\t\t\ttimestamp\t\t\tarea\tperimeter");
			for(Shape shape:shapes){
				System.out.println(shape.getId()+"\t"+shape.getClass().getSimpleName()+
				"\t\t ("+shape.getOrigin().getX()+","+shape.getOrigin().getY()+")\t\t\t"+shape.getTimestamp()+"\t"+shape.getArea()+"\t"+shape.getPerimeter());
			}
		}
		
	}

}