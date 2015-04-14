package intervals;

public class OpenedRightPoint extends Point{

	public OpenedRightPoint(double value) {
		super(value);
		
	}

	public boolean minorOrEquals(Point p) {
		return this.minorThan(p)||equalsValues(p);
	}

}
