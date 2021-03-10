package shapes;

public class Point {
	double xCoordinate;
	double yCoordinate;
	
	// Default constructor for point class
	public Point()
	{
		xCoordinate=0;
		yCoordinate=0;
	}
	
	// Parameterized constructor for point class
	public Point(double xCord, double yCord)
	{
		this.xCoordinate=xCord;
		this.yCoordinate=yCord;
	}

	public double getX() {
		return xCoordinate;
	}
	
	public double getY() {
		return yCoordinate;
	}

}
