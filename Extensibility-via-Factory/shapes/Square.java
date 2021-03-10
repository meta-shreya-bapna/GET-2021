package shapes;

import java.util.Date;
import java.util.List;

public class Square implements Shape{
	double side;
    Point origin;
    Date timestamp;
    List<Double> parameterList;
    int id;
   
    // Constructor for shape Square
    public Square(Point point, List<Double> list)
    {
        origin = point;
        parameterList = list;
        side = parameterList.get(0); 
        timestamp = new Date();
    }
    
    /**
     * Method to find area of square
     * @return area
     */
	@Override
	public double getArea() {
		
		return side * side;
	}
	
	/**
     * Method to find  perimeter of square
     * @return perimeter
     */
	@Override
	public double getPerimeter() {
		
		return 4*side;
	}
	
	/**
     * To find origin point of square
     * @return origin of square
     */
	@Override
	public Point getOrigin() {
		
		return origin;
	}
	
	/**
     * @return shape type of square
     */
	@Override
	public ShapeType getShapeType() {
		
		return ShapeType.SQUARE;
	}
	
	/**
     * @return time stamp for square i.e., time of its creation
     */
	@Override
	public Date getTimestamp() {
		
		return timestamp;
	}
	
	/**
     * Method to set time stamp i.e time of creation of square
     */
	@Override
	public void setTimestamp(Date timestamp) {
		
		this.timestamp=timestamp;
		
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
	 * Method to check if a point lies inside or outside the square
	 * @param point x and y coordinates
     * @return true if point is inside else false
     */
	@Override
	public boolean isPointEnclosed(Point point) {
		if(point.getX()>point.getX() &&
				point.getX()<point.getX()+side &&
				point.getY()>point.getY() &&
				point.getY()<point.getY()+side)
				return true;
			return false;
	}

}
