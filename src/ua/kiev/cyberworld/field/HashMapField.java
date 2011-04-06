package ua.kiev.cyberworld.field;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMapField implements Field {
	private HashMap<Point, List<Object>> objects  = new HashMap<Point, List<Object>>();
	private HashMap<Object, Point> points = new HashMap<Object, Point>();

	@Override
	public List<Object> getObjects(Point point) {
		return objects.get(point);
	}

	@Override
	public Point getPoint(Object obj) {
		return points.get(obj);
	}

	@Override
	public void removeObject(Object obj) {
		Point p = points.get(obj);
		points.remove(p);
		objects.get(p).remove(obj);
	}

	@Override
	public void setObject(Object obj, Point point) {
		List<Object> o = objects.get(point);
		if (o == null) {
			o = new ArrayList<Object>();
		}
		o.add(obj);
		objects.put(point, o);
		points.put(obj, point);
	}

}
