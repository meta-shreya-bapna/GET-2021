package shapes;

import java.util.Date;
import java.util.List;

public class Circle implements Shape{
	double radius;
    Point origin;
    final double PI=3.14;
    Date timestamp;
    List<Double> parameterList;
    int id;
   
    // Constructor for shape Circle
    public Circle(Point point, List<Double> list)
    {
        origin = point;
        parameterList = list;
        radius = parameterList.get(0); 
        timestamp = new Date();
    }
    
    /**
     * Method to find area of circle
     * @return area
     */
	@Override
	public double getArea() {
		
		double area= PI*radius*radius;
		String str = String.format("%1.2f",area);
        return Double.valueOf(str); 
	}
	
	/**
     * Method to find  perimeter or circumference of circle
     * @return perimeter
     */
	@Override
	public double getPerimeter() {
		
		return 2*PI*radius;
	}
	
	/**
     * To find origin point of circle
     * @return origin of circle
     */
	@Override
	public Point getOrigin() {
		
		return origin;
	}
	
	/**
     * @return shape type of circle
     */
	@Override
	public ShapeType getShapeType() {
		
		return ShapeType.CIRCLE;
	}
	
	/**
     * @return time stamp for circle i.e., time of its creation
     */
	@Override
	public Date getTimestamp() {
		
		return timestamp;
	}

	/**
     * Method to set time stamp i.e time of creation of circle
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
	 * Method to check if a point lies inside or outside the circle
	 * @param point x and y coordinates
     * @return true if point is inside else false
     */
	@Override
	public boolean isPointEnclosed(Point point) {
		if(point.getX()<origin.getX()+radius && 
				point.getX()>origin.getX()-radius &&
				point.getY()<origin.getY()+radius &&
				point.getY()>origin.getY()-radius)
			return true;
		return false;
	}

}