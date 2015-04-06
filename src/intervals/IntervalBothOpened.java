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
		
		boolean equalsMaxs = this.getMax()==interval.getMax();
		boolean equalsMins = this.getMin()==interval.getMin();
		boolean includeMin= this.getMin()< interval.getMin();
		boolean includeMax = this.getMax()>interval.getMax();
	
		switch(interval.getOpening()){
			case BOTH_OPENED: return ((includeMin||equalsMins) &&(includeMax||equalsMaxs));
			case LEFT_OPENED: return((includeMin||equalsMins)  &&includeMax);  
         	case RIGHT_OPENED:return (includeMin &&(includeMax||equalsMaxs));
			case UNOPENED: return (includeMin &&includeMax);
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
