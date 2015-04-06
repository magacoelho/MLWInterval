package intervals;

public class IntervalRightOpened extends Interval{

	public IntervalRightOpened(double min, double max) {
		super(min, max);
		}

	@Override
	public Opening getOpening() {
		return Opening.RIGHT_OPENED;
	}

	public boolean includes(double value) {
	  return this.getMin()<=value&& this.getMax()>value;
		
	}

	public boolean includes(Interval interval) {
		
		
		switch(interval.getOpening()){
			case BOTH_OPENED: return ((this.minorMinThan(interval)||this.equalsMinsValues(interval)) &&((this.greaterMaxThan(interval)||this.equalsMaxValues(interval))));
			case LEFT_OPENED:return ((this.minorMinThan(interval)||this.equalsMinsValues(interval)) &&(this.greaterMaxThan(interval)));   
        	case RIGHT_OPENED: return((this.minorMinThan(interval)||this.equalsMinsValues(interval)) &&(this.greaterMaxThan(interval)||this.equalsMaxValues(interval)));
			case UNOPENED: return ((this.minorMinThan(interval)||this.equalsMinsValues(interval) )&&this.greaterMaxThan(interval));   
			default: return false;
		}
		
	}

	public boolean intersectsWith(Interval interval) {
		if (this.getMin() == interval.getMax()) {
				return interval.getOpening() == Opening.LEFT_OPENED ||
						interval.getOpening() == Opening.UNOPENED;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean includes(IntervalLeftOpened interval) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean includes(IntervalRightOpened interval) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean includes(IntervalUnopened interval) {
		// TODO Auto-generated method stub
		return false;
	}

}
