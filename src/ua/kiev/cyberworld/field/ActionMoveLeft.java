package ua.kiev.cyberworld.field;

import java.awt.Point;

public class ActionMoveLeft implements Action {

	@Override
	public void perform(Field field, Object src, Object args) {
		Point targetPoint = field.getPoint(src);
		if (targetPoint == null) {
			throw new IllegalArgumentException("Source object is not on the field!");
		}
		targetPoint.x = targetPoint.x + 1;
		
		Unit u;
		if (field.getObjects(targetPoint) != null) {
		for(Object o : field.getObjects(targetPoint)) {
			if (o instanceof Unit) {
				u = (Unit)o;
				o = u.getProperty("IsWall");
				if (o != null && o.equals(true)) {
					return;
				}
			}
		}
		}
		field.removeObject(src);
		field.setObject(src, targetPoint);
	}

}
