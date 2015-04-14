package intervals;

public class IntervalBothOpened extends Interval{

	public IntervalBothOpened(Point  min, Point max) {
		super(min,max);
		}

	@Override
	public Opening getOpening() {
		return Opening.BOTH_OPENED;
	}

	public boolean includes(double value) {
		return this.getMin().minorThan(value)&& this.getMax().greaterThan(value);
	}

	

	public boolean intersectsWith(Interval interval) {
		if (this.getMin().equalsValues(interval.getMax())) {
				return false;
		}
		if (this.getMax().equalsValues(interval.getMin())) {
					return false;
		}
		return this.includes(interval.getMin().getValue())
				|| this.includes(interval.getMax().getValue());
	}

	public Interval intersection(Interval interval) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
