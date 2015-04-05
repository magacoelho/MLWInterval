package intervals;


public class IntervalFactory {
	private static  IntervalBothOpened intervalBothOpened;
    private static IntervalLeftOpened intervalleftOpened;
    private static IntervalRightOpened intervalRightOpened;
    private static IntervalUnopened intervalUnopened;
	public static Interval getInterval(double min, double max, Opening opening) {
		return new Interval(min, max,opening);
	}

}
