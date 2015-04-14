package intervals;

public class PointOpened extends Point {

	public PointOpened(double value) {
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

	@Override
	public boolean minorOrEquals(PointOpened p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean minorOrEquals(PointClosed p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean greaterOrEquals(PointOpened p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean greaterOrEquals(PointClosed p) {
		// TODO Auto-generated method stub
		return false;
	}

}
