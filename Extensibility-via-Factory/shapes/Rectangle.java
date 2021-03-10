package shapes;

import java.util.Date;
import java.util.List;

public class Rectangle implements Shape{
	double length;
	double breadth;
    Point origin;
    Date timestamp;
    List<Double> parameterList;
    int id;
   
 // Constructor for shape rectangle    
    public Rectangle(Point point, List<Double> list) {
		
    	origin = point;
        parameterList = list;
        length = parameterList.get(0); 
        breadth = parameterList.get(1); 
        timestamp = new Date();
	}

    /**
     * Method to find  area of rectangle
     * @return area
     */
    @Override
    public double getArea()
    {
        return length * breadth;
    }

    /**
     * Method to find  perimeter of rectangle
     * @return perimeter
     */
    @Override
    public double getPerimeter() 
    {
        return 2 * (length + breadth);
    }
        
    /**
     * To find origin point of rectangle
     * @return origin of rectangle
     */
    @Override
    public Point getOrigin()
    {
        return origin; 
    }

    /**
     * @return shape type of rectangle
     */
    @Override
    public ShapeType getShapeType() 
    {
        return ShapeType.RECTANGLE;
    }
    
    /**
     * To get time stamp i.e time of creation of rectangle
     */
    @Override
    public Date getTimestamp() 
    {
        return timestamp;
    }
    
    /**
     * To set time stamp for rectangle
     */
    @Override
    public void setTimestamp(Date timestamp) 
    {
            this.timestamp = timestamp;  
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
	 * Method to check if a point lies inside or outside the rectangle
	 * @param point x and y coordinates
     * @return true if point is inside else false
     */
	@Override
	public boolean isPointEnclosed(Point point) {
		if(point.getX()>origin.getX() &&
			point.getX()<origin.getX()+length &&
			point.getY()>origin.getY() &&
			point.getY()<origin.getY()+breadth)
			return true;
		return false;
	}

}