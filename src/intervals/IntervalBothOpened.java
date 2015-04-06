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
		
		boolean equalsMaxs = equalsMaxValues(interval);
		boolean equalsMins = this.getMin()==interval.getMin();
		boolean menorMin= this.getMin()< interval.getMin();
		boolean mayorMax = this.getMax()>interval.getMax();
	
		switch(interval.getOpening()){
			case BOTH_OPENED: return ((menorMin||equalsMins) &&(mayorMax||this.equalsMaxValues(interval)));
			case LEFT_OPENED: return((menorMin||equalsMins)  &&mayorMax);  
         	case RIGHT_OPENED:return (menorMin &&(mayorMax||this.equalsMaxValues(interval)));
			case UNOPENED: return (menorMin &&mayorMax);
			default: return false;
		}
	}

	public boolean equalsMaxValues(Interval interval) {
		return this.getMax()==interval.getMax();
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
