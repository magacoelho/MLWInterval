package intervals;

public class ClosedRightPoint extends Point{

	public ClosedRightPoint(double value) {
		super(value);
		// TODO Auto-generated constructor stub
	}

	public boolean minorOrEquals(Point p) {
		return this.minorThan(p)||equalsValues(p);
	}

}
