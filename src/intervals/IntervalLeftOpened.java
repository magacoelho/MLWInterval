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
		
		
		switch(interval.getOpening()){
			case BOTH_OPENED:return(this.minorMinOrEquals(interval) && this.greaterMaxOrEquals(interval));
			case LEFT_OPENED: return (this.minorMinOrEquals(interval)&&this.greaterMaxOrEquals(interval));  
	    	case RIGHT_OPENED:return (this.minorMinThan(interval) &&this.greaterMaxOrEquals(interval));
			case UNOPENED: return (this.minorMinThan(interval))||this.equalsMaxValues(interval);
			default: return false;
		}	            

	
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
