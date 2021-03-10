package shapes;

import java.util.Date;
import java.util.List;

public class Triangle implements Shape
{
    double side1;
    double side2;
    double side3;
    private double xCoordinate;
	private double yCoordinate;
    int x1,x2,x3,y1,y2,y3;
    Point origin;
    Date timestamp;
    List<Double> parameterList;
    int id;
    
    // Constructor for triangle
    public Triangle(Point point, List<Double> list)
    {
        origin = point;
        parameterList = list;
        side1 = parameterList.get(0);
        side2 = parameterList.get(1);
        side3 = parameterList.get(2);
        timestamp = new Date();
		xCoordinate = point.getX();
		yCoordinate = point.getY();
    }
    
    /**
     * Method to find area of triangle
     * @return area
     */
    @Override
    public double getArea() 
    {
        double s, area;
        
        s = ( side1 + side2 + side3 ) / 2;
        area = Math.sqrt( s * (s - side1) * ( s - side2) * (s - side3));
        
        String str = String.format("%1.2f",area);
        return Double.valueOf(str); 
    }
    
    /**
     * Method to find  perimeter of triangle
     * @return perimeter
     */
    @Override
    public double getPerimeter() {
    
        return side1 + side2 + side3;
    }
    
    /**
     * To find origin point of triangle.
     * @return origin of triangle.
     */
    @Override
    public Point getOrigin() 
    {
        return origin;
    }
    
    /**
     * @return shape type of triangle
     */
    @Override
    public ShapeType getShapeType() 
    {
        return ShapeType.TRIANGLE;
    }
    
    /**
     * Method to set time stamp i.e time of creation of triangle
     */
    @Override
    public void setTimestamp(Date timestamp) 
    {
            this.timestamp = timestamp;  
    }

    /**
     * @return time stamp for triangle i.e., time of its creation
     */
    @Override
    public Date getTimestamp() 
    {
        return timestamp;
    }
    
    /**
     * To set shape id
     */
	@Override
	public void setId(int shapeId) {
		
		this.id=shapeId;
		
	}
	
	/**
     * @return shape id
     */
	@Override
	public int getId() {
		
		return id;
	}
	
	/**
	 * Method to check if a point lies inside or outside the triangle
	 * @param point x and y coordinates
     * @return true if point is inside else false
     */
	@Override
	public boolean isPointEnclosed(Point point) {
		double x = point.getX();
		double y = point.getY();

		double x2 = xCoordinate + side1;
		double y2 = yCoordinate + side1;

		double x3 = x2 + side2;
		double y3 = y2 + side2;

		if ( x >= xCoordinate && x <= x3 && y <= y2 && y3 >= y) {
			return true;
		}
		return false;
	}
}