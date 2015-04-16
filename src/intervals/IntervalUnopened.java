package intervals;

public class IntervalUnopened extends Interval{

	public IntervalUnopened(Point min, Point max) {
		super(min, max);
		
	}

	@Override
	public Opening getOpening() {
		return Opening.UNOPENED;
	}

	public boolean intersectsWith(Interval interval) {
		if (this.getMin().equalsValues(interval.getMax())) {
		return interval.getOpening() == Opening.LEFT_OPENED ||
						interval.getOpening() == Opening.UNOPENED;
		}
		if (this.getMax().equalsValues(interval.getMin())) {
			return interval.getOpening() == Opening.RIGHT_OPENED ||
						interval.getOpening() == Opening.UNOPENED;
		}
		return this.includes(interval.getMin().getValue())
			|| this.includes(interval.getMax().getValue());

	}

	public Interval intersection(Interval interval) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
