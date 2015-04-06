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
		
		boolean equalsMaxs = this.getMax()==interval.getMax();
		boolean equalsMins = this.getMin()==interval.getMin();
		boolean menorMin= this.getMin()< interval.getMin();
		boolean mayorMax = this.getMax()>interval.getMax();
		switch(interval.getOpening()){
			case BOTH_OPENED:return((menorMin||equalsMins) &&(mayorMax||equalsMaxs));
			case LEFT_OPENED: return ((menorMin||equalsMins)&&(mayorMax||equalsMaxs));  
	    	case RIGHT_OPENED:return (menorMin &&(mayorMax||equalsMaxs));
			case UNOPENED: return (menorMin&&(mayorMax||equalsMaxs));
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
