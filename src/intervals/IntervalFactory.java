package intervals;


public class IntervalFactory {
	private static  IntervalBothOpened intervalBothOpened;
    private static IntervalLeftOpened intervalleftOpened;
    private static IntervalRightOpened intervalRightOpened;
    private static IntervalUnopened intervalUnopened;
    public static Interval interval=null;
	public static Interval getInterval(double min, double max, Opening opening) {
		switch(opening){
		case BOTH_OPENED:
			                  interval= new IntervalBothOpened(min, max); 
			                  
		                   break;
		case LEFT_OPENED:
                            interval= new IntervalLeftOpened(min, max);
		                   break;
    	case RIGHT_OPENED:
                             interval= new IntervalRightOpened(min, max); 
    	                  break;
		case UNOPENED: 
                          interval= new IntervalUnopened(min, max);
		               break;
		default:  throw new IllegalArgumentException("Incorrect type code value");
			
		}
		
		interval.setOpening(opening);
		return interval;
	}

}
