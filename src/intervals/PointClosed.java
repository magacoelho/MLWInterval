package intervals;

public class PointClosed extends Point{

	public PointClosed(double value) {
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
	
		return p.getValue()<this.getValue();
	}

	@Override
	public boolean minorOrEquals(PointClosed p) {
		return p.getValue()<= this.getValue();
	}

	@Override
	public boolean greaterOrEquals(PointOpened p) {
		return p.getValue()>this.getValue();
	}

	@Override
	public boolean greaterOrEquals(PointClosed p) {
		return p.getValue()>=this.getValue();
	}

}
