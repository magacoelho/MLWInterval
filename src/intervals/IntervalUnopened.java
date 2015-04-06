package intervals;

public class IntervalUnopened extends Interval{

	public IntervalUnopened(double min, double max) {
		super(min, max);
		
	}

	@Override
	public Opening getOpening() {
		return Opening.UNOPENED;
	}

	public boolean includes(double value) {
		 return this.getMin()<=value&& this.getMax()>=value;
	}

	public boolean includes(Interval interval) {
		/*	
		switch(interval.getOpening()){
			case BOTH_OPENED:   
			case LEFT_OPENED:
	    	case RIGHT_OPENED: 
			case UNOPENED: return this.minorMinOrEquals(interval)&&this.greaterMaxOrEquals(interval); 
			default: return false;
         }*/
		return interval.includes(this);

	}

	public boolean intersectsWith(Interval interval) {
		if (this.getMin() == interval.getMax()) {
			return interval.getOpening() == Opening.LEFT_OPENED ||
						interval.getOpening() == Opening.UNOPENED;
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

	@Override
	public boolean includes(IntervalBothOpened interval) {
		return this.minorMinOrEquals(interval)&&this.greaterMaxOrEquals(interval);
	}

	@Override
	public boolean includes(IntervalLeftOpened interval) {
		return this.minorMinOrEquals(interval)&&this.greaterMaxOrEquals(interval);
	}

	@Override
	public boolean includes(IntervalRightOpened interval) {
		return this.minorMinOrEquals(interval)&&this.greaterMaxOrEquals(interval);
	}

	@Override
	public boolean includes(IntervalUnopened interval) {
		return this.minorMinOrEquals(interval)&&this.greaterMaxOrEquals(interval);
	}

	

}
