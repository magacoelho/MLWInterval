package intervals;

public class PointOpened extends Point {

	public PointOpened(double value) {
		super(value);
	}

	@Override
	public boolean minorOrEquals(Point p) {
		return p.minorOrEquals(this);
	}

	@Override
	public boolean greaterOrEquals(Point p) {
		return p.greaterOrEquals(this);
	}

	@Override
	public boolean minorOrEquals(PointOpened p) {
			return this.minorOrEquals(p);
	}

	@Override
	public boolean minorOrEquals(PointClosed p) {
		return minorThan(p);
	}

	@Override
	public boolean greaterOrEquals(PointOpened p) {
			return this.greaterOrEquals(p);
	}

	@Override
	public boolean greaterOrEquals(PointClosed p) {
		return this.greaterThan(p);
	}

}
