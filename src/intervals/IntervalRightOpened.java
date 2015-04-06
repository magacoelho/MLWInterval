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
		
		boolean equalsMaxs = this.getMax()==interval.getMax();
		boolean equalsMins = this.getMin()==interval.getMin();
		boolean menorMin= this.getMin()< interval.getMin();
		boolean mayorMax = this.getMax()>interval.getMax();
		
		switch(interval.getOpening()){
			case BOTH_OPENED: return ((menorMin||equalsMins) &&((mayorMax||equalsMaxs)));
			case LEFT_OPENED:return ((menorMin||equalsMins) &&(mayorMax));   
        	case RIGHT_OPENED: return((menorMin||equalsMins) &&(mayorMax||equalsMaxs));
			case UNOPENED: return ((menorMin||equalsMins )&&mayorMax);   
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

}
