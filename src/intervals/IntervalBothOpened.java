package intervals;

public class IntervalBothOpened extends Interval{

	public IntervalBothOpened(double min, double max) {
		super();
		this.min= new UnExactPoint(min);
		this.max= new UnExactPoint(max);
		}

	@Override
	public Opening getOpening() {
		return Opening.BOTH_OPENED;
	}

	public boolean includes(double value) {
		return this.minorThan(this.getMin(),value)&& this.greaterThan(this.getMax(),value);
	}

	public boolean includes(Interval interval) {
		return interval.includes(this);
	}

	public boolean intersectsWith(Interval interval) {
		if (this.equalsValues(this.getMin(), interval.getMax())) {
				return false;
		}
		if (this.equalsValues(this.getMax(),interval.getMin())) {
					return false;
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
		//return (this.greaterMinOrEquals(interval) &&this.minorMaxOrEquals(interval));
		return this.greaterOrEquals(this.getMin(), interval.getMin())&&this.minorOrEquals(this.getMax(), interval.getMax());
	}

	@Override
	public boolean includes(IntervalLeftOpened interval) {
		return(this.greaterOrEquals(this.getMin(), interval.getMin())  &&this.minorOrEquals(this.getMax(), interval.getMax())); 
	}

	@Override
	public boolean includes(IntervalRightOpened interval) {
		return (this.greaterOrEquals(this.getMin(), interval.getMin()) &&this.minorOrEquals(this.getMax(), interval.getMax()));
	}

	@Override
	public boolean includes(IntervalUnopened interval) {
		return (this.greaterOrEquals(this.getMin(), interval.getMin()) &&this.minorOrEquals(this.getMax(), interval.getMax()));
	}

	

	

}
