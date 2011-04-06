package ua.kiev.cyberworld.field;

import java.awt.Point;
import java.util.List;

public interface Field {
	public List<Object> getObjects(Point point);
	public Point getPoint(Object obj);
	public void removeObject(Object obj);
	public void setObject(Object obj, Point point);
}
