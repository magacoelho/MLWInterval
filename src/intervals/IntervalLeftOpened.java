package intervals;

public class IntervalLeftOpened extends Interval{

	public IntervalLeftOpened(double min, double max) {
		super(min, max);
		}

	@Override
	public Opening getOpening() {
	    return Opening.LEFT_OPENED;
	}

	public boolean includes(double value) {
		return this.getMin()<value&&this.getMax()>=value;	            
		}

	public boolean includes(Interval interval) {
		
		return interval.includes(this);           

	
	}
	@Override
	public boolean includes(IntervalBothOpened interval) {
		return this.greaterOrEquals(this.getMin(), interval.getMin())&&this.minorThan(this.getMax(), interval.getMax());
	}

	@Override
	public boolean includes(IntervalLeftOpened interval) {
		return (this.greaterOrEquals(this.getMin(), interval.getMin())&&this.minorOrEquals(this.getMax(), interval.getMax()));
	}

	@Override
	public boolean includes(IntervalRightOpened interval) {
		return (this.greaterOrEquals(this.getMin(), interval.getMin()) &&this.minorThan(this.getMax(), interval.getMax()));
	}

	@Override
	public boolean includes(IntervalUnopened interval) {
		return (this.greaterOrEquals(this.getMin(), interval.getMin()) &&this.minorOrEquals(this.getMax(), interval.getMax()));
	}

	public boolean intersectsWith(Interval interval) {
		if (this.getMin() == interval.getMax()) {
				return false;
		}
		if (this.getMax() == interval.getMin()) {
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

	

	

}
