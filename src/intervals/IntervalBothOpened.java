package intervals;

public class IntervalBothOpened extends Interval{

	public IntervalBothOpened(double min, double max) {
		super(min, max);
		}

	@Override
	public Opening getOpening() {
		return Opening.BOTH_OPENED;
	}

	public boolean includes(double value) {
		return this.getMin()<value&& this.getMax()>value;
	}

	public boolean includes(Interval interval) {
		 
		return interval.includes(this);
	}

	public boolean intersectsWith(Interval interval) {
		if (this.getMin() == interval.getMax()) {
				return false;
		}
		if (this.getMax() == interval.getMin()) {
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
		return (this.greaterMinOrEquals(interval) &&this.minorMaxOrEquals(interval));
	}

	@Override
	public boolean includes(IntervalLeftOpened interval) {
		return(this.greaterMinOrEquals(interval)  &&this.minorMinThan(interval)); 
	}

	@Override
	public boolean includes(IntervalRightOpened interval) {
		return (this.minorMinThan(interval) &&this.greaterMaxOrEquals(interval));
	}

	@Override
	public boolean includes(IntervalUnopened interval) {
		return (this.minorMinThan(interval) &&this.greaterMaxThan(interval));
	}

	

	

}
