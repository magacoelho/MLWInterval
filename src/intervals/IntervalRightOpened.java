package intervals;

public class IntervalRightOpened extends Interval{

	public IntervalRightOpened(Point min, Point max) {
		super(min, max);
		}

	@Override
	public Opening getOpening() {
		return Opening.RIGHT_OPENED;
	}

	public boolean includes(double value) {
	  return this.getMin().minorOrEquals(value)&&this.getMax().greaterThan(value);
		
	}

	public boolean includes(Interval interval) {
		return interval.includes(this);
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

	@Override
	public boolean includes(IntervalBothOpened interval) {
		
	    return this.getMin().greaterOrEquals( interval.getMin())&&this.getMax().minorOrEquals(interval.getMax());
	}

	@Override
	public boolean includes(IntervalLeftOpened interval) {
		
		return this.getMin().greaterOrEquals(interval.getMin())&&this.getMax().minorOrEquals(interval.getMax());
	}

	@Override
	public boolean includes(IntervalRightOpened interval) {
		
		return this.getMin().greaterOrEquals(interval.getMin())&&this.getMax().minorOrEquals(interval.getMax()) ;
	}

	@Override
	public boolean includes(IntervalUnopened interval) {
		return (this.getMin().greaterOrEquals(interval.getMin()) &&this.getMax().minorOrEquals(interval.getMax()));
	}

}
