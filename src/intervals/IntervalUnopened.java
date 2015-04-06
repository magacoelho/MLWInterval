package intervals;

public class IntervalUnopened extends Interval{

	public IntervalUnopened(double min, double max) {
		super(min, max);
		
	}

	@Override
	public Opening getOpening() {
		return Opening.UNOPENED;
	}

	

}
