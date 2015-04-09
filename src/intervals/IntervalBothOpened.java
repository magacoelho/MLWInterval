package intervals;

public class IntervalBothOpened extends Interval{

	public IntervalBothOpened(Point  min, Point max) {
		super(min,max);
		}

	@Override
	public Opening getOpening() {
		return Opening.BOTH_OPENED;
	}

	public boolean includes(double value) {
		return this.getMin().minorThan(value)&& this.getMax().greaterThan(value);
	}

	public boolean includes(Interval interval) {
		return interval.includes(this);
	}

	public boolean intersectsWith(Interval interval) {
		if (this.getMin().equalsValues(interval.getMax())) {
				return false;
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
		//return (this.greaterMinOrEquals(interval) &&this.minorMaxOrEquals(interval));
		//return this.greaterOrEquals(this.getMin(), interval.getMin())&&this.minorOrEquals(this.getMax(), interval.getMax());
		return this.getMin().greaterOrEquals(interval.getMin())&& this.getMax().minorOrEquals(interval.getMax());
	}

	@Override
	public boolean includes(IntervalLeftOpened interval) {
		return(this.getMin().greaterOrEquals(interval.getMin())  &&this.getMax().minorOrEquals(interval.getMax())); 
	}

	@Override
	public boolean includes(IntervalRightOpened interval) {
		return (this.getMin().greaterOrEquals(interval.getMin()) &&this.getMax().minorOrEquals(interval.getMax()));
	}

	@Override
	public boolean includes(IntervalUnopened interval) {
		return (this.getMin().greaterOrEquals(interval.getMin()) &&this.getMax().minorOrEquals(interval.getMax()));
	}

	

	

}
