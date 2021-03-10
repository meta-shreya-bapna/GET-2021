package shapes;

import java.util.Date;

public interface Shape {
	
	// Enum specifying allowed shape types on screen 
	public enum ShapeType {
		RECTANGLE, CIRCLE, SQUARE, TRIANGLE;
	}
	
	double getArea();
	double getPerimeter();
	Point getOrigin();
	ShapeType getShapeType();
	Date getTimestamp();
	void setTimestamp(Date timestamp);
	void setId(int shapeId);
	int getId();
	boolean isPointEnclosed(Point point);
	
}
