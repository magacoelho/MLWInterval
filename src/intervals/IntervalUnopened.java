package intervals;

public class IntervalUnopened extends Interval{

	public IntervalUnopened(Point min, Point max) {
		super(min, max);
		
	}

	@Override
	public Opening getOpening() {
		return Opening.UNOPENED;
	}

	public boolean includes(double value) {
		 return this.minorOrEquals(this.getMin(),value)&& this.greaterOrEquals(getMax(), value);
	}

	public boolean includes(Interval interval) {
		return interval.includes(this);

	}

	public boolean intersectsWith(Interval interval) {
		if (this.equalsValues(this.getMin(),interval.getMax())) {
			return interval.getOpening() == Opening.LEFT_OPENED ||
						interval.getOpening() == Opening.UNOPENED;
		}
		if (this.equalsValues(this.getMax(),interval.getMin())) {
			return interval.getOpening() == Opening.RIGHT_OPENED ||
						interval.getOpening() == Opening.UNOPENED;
		}
		return this.includes(interval.getMin())
				|| this.includes(interval.getMax());
	}

	public Interval intersection(Interval interval) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean includes(IntervalBothOpened interval) {
		return this.greaterThan(this.getMin(), interval.getMin())&&this.minorThan(this.getMax(), interval.getMax());
	}

	@Override
	public boolean includes(IntervalLeftOpened interval) {
		return this.greaterThan(this.getMin(), interval.getMin())&&this.minorOrEquals(this.getMax(), interval.getMax());
	}

	@Override
	public boolean includes(IntervalRightOpened interval) {
		return this.greaterOrEquals(this.getMin(), interval.getMin())&&this.minorThan(this.getMax(), interval.getMax());
	}

	@Override
	public boolean includes(IntervalUnopened interval) {
		return (this.greaterOrEquals(this.getMin(), interval.getMin()) &&this.minorOrEquals(this.getMax(), interval.getMax()));
	}

	

}
