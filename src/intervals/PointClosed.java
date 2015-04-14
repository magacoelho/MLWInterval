package intervals;

public class PointClosed extends Point{

	public PointClosed(double value) {
		super(value);
	}

	@Override
	public boolean minorOrEquals(Point p) {
		return this.minorThan(p)||equalsValues(p);
	}

	@Override
	public boolean greaterOrEquals(Point p) {
		return this.greaterThan(p)||this.equalsValues(p);
	}

}
