package intervals;


public class IntervalFactory {

	public static Interval getInterval(double min, double max, Opening opening) {
		return new Interval(min, max,opening);
	}

}
