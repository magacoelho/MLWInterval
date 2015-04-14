package intervals;

public class IntervalLeftOpened extends Interval{

	public IntervalLeftOpened(Point min, Point max) {
		super(min, max);
		}

	@Override
	public Opening getOpening() {
	    return Opening.LEFT_OPENED;
	}

	public boolean includes(double value) {
		return this.getMin().minorThan(value)&&this.getMax().greaterOrEquals(value);	            
		}

	public boolean includes(Interval interval) {
		
		return interval.includes(this);           

	
	}
	public boolean intersectsWith(Interval interval) {
		if (this.getMin().equalsValues(interval.getMax())) {
				return false;
		}
		if (this.getMax().equalsValues(interval.getMin())) {
			return interval.getOpening() == Opening.RIGHT_OPENED ||
						interval.getOpening() == Opening.UNOPENED;
		}
		return this.includes(interval.getMin().getValue())
				|| this.includes(interval.getMax().getValue());
	}

	public Interval intersection(Interval interval) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
