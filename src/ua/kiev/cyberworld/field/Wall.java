package ua.kiev.cyberworld.field;

public class Wall implements Unit {

	@Override
	public Object getProperty(String property) {
		if (property.toUpperCase() == "ISWALL") return true;
		return null;
	}

}
