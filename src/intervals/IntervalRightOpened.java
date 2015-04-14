package intervals;

public class IntervalRightOpened extends Interval{

	public IntervalRightOpened(Point min, Point max) {
		super(min, max);
		}

	@Override
	public Opening getOpening() {
		return Opening.RIGHT_OPENED;
	}

	public boolean intersectsWith(Interval interval) {
		if (this.getMin().equalsValues(interval.getMax())) {
				return interval.getOpening() == Opening.LEFT_OPENED ||
						interval.getOpening() == Opening.UNOPENED;
		}
		if (this.getMax().equalsValues(interval.getMin())) {
			return false;
		}
		return this.includes(interval.getMin().getValue())
				|| this.includes(interval.getMax().getValue());
	}

	public Interval intersection(Interval interval) {
		// TODO Auto-generated method stub
		return null;
	}

}
