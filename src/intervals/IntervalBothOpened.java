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
		
		switch(interval.getOpening()){
			case BOTH_OPENED: return ((this.minorMinThan(interval)||equalsMinsValues(interval)) &&(this.greaterMaxThan(interval)||this.equalsMaxValues(interval)));
			case LEFT_OPENED: return((this.minorMinThan(interval)||equalsMinsValues(interval))  &&this.greaterMaxThan(interval));  
         	case RIGHT_OPENED:return (this.minorMinThan(interval) &&(this.greaterMaxThan(interval)||this.equalsMaxValues(interval)));
			case UNOPENED: return (this.minorMinThan(interval) &&this.greaterMaxThan(interval));
			default: return false;
		}
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

	

	

}
