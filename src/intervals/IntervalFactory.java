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
			                  interval= new IntervalBothOpened(min, max);   
		                   break;
		case LEFT_OPENED:if(intervalleftOpened==null)
                            interval= new IntervalLeftOpened(min, max);
		                   break;
    	case RIGHT_OPENED:if(intervalRightOpened==null)
                             interval= new IntervalRightOpened(min, max); 
    	                  break;
		case UNOPENED: if(intervalUnopened==null)
                          interval= new IntervalUnopened(min, max);
		               break;
		default:  throw new IllegalArgumentException("Incorrect type code value");
			
		}
		
		
		return interval;
	}

}
