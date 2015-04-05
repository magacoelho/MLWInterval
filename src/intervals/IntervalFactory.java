package intervals;


public class IntervalFactory {
	private static  IntervalBothOpened intervalBothOpened;
    private static IntervalLeftOpened intervalleftOpened;
    private static IntervalRightOpened intervalRightOpened;
    private static IntervalUnopened intervalUnopened;
    public static Interval interval=null;
	public static Interval getInterval(double min, double max, Opening opening) {
		switch(opening){
		case BOTH_OPENED:if(intervalBothOpened==null)
			                  interval= new IntervalBothOpened(min, max, opening);   
		case LEFT_OPENED:if(intervalleftOpened==null)
                            interval= new IntervalLeftOpened(min, max, opening);;
    	case RIGHT_OPENED: ;
		case UNOPENED: ;   
		default: ;
		
		
		
		}
		
		
		return new Interval(min, max,opening);
	}

}
