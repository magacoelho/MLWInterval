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
		
		boolean equalsMaxs = this.getMax()==interval.getMax();
		boolean equalsMins = this.getMin()==interval.getMin();
		boolean includeMin= this.includes(interval.getMin());
		boolean includeMax = this.includes(interval.getMax());
		
		switch(interval.getOpening()){
			case BOTH_OPENED:return (includeMin &&includeMax);   
			case LEFT_OPENED:return (includeMin &&includeMax);
	    	case RIGHT_OPENED: return(includeMin &&includeMax);
			case UNOPENED: return (includeMin &&includeMax);   
			default: return false;
         }

	}

	public boolean intersectsWith(Interval interval) {
		if (this.getMin() == interval.getMax()) {
			switch (this.getOpening()) {
			case BOTH_OPENED:
			case LEFT_OPENED:
				return false;
			case RIGHT_OPENED:
			case UNOPENED:
				return interval.getOpening() == Opening.LEFT_OPENED ||
						interval.getOpening() == Opening.UNOPENED;
			default:
				assert false;
				return false;
			}
		}
		if (this.getMax() == interval.getMin()) {
			switch (this.getOpening()) {
			case BOTH_OPENED:
			case RIGHT_OPENED:
				return false;
			case LEFT_OPENED:
			case UNOPENED:
				return interval.getOpening() == Opening.RIGHT_OPENED ||
						interval.getOpening() == Opening.UNOPENED;
			default:
				assert false;
				return false;
			}
		}
		return this.includes(interval.getMin())
				|| this.includes(interval.getMax());
	}

	public Interval intersection(Interval interval) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
