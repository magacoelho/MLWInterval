package intervals;


public class IntervalFactory {
    public static Interval interval=null;
	public static Interval getInterval(double min, double max, Opening opening) {
		switch(opening){
		case BOTH_OPENED:
		                 interval= new IntervalBothOpened(new PointOpened(min), new PointOpened(max)); 
		                  break;
		case LEFT_OPENED:
                         interval= new IntervalLeftOpened(new PointOpened(min),new PointClosed(max));
		                 break;
    	case RIGHT_OPENED:
                         interval= new IntervalRightOpened(new PointClosed(min), new PointOpened(max));
    	                  break;
		case UNOPENED: 
                         interval= new IntervalUnopened(new PointClosed(min), new PointClosed(max));
		               break;
		default:  throw new IllegalArgumentException("Incorrect type code value");
			
		}
		return interval;
	}

}
