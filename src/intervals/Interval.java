package intervals;

public class Interval {
	 private double min;
	 private double max;
	 private Opening opening;

	public Interval(double min, double max, Opening opening) {
		this.min=min;
		this.max=max;
		this.opening=opening;
	}

	public double midPoint() {
	
		return  (this.max+this.min)/2.0;
	}

	public boolean includes(double value) {
		switch(this.opening){
		case BOTH_OPENED:return this.min<value&& this.max>value;
		case LEFT_OPENED: return this.min<value&&this.max>=value;	            
		case RIGHT_OPENED: return this.min<=value&& this.max>value;
		case UNOPENED: return this.min<=value&& this.max>=value;
		}
		return false;
	}

	public boolean includes(Interval interval) {
		switch(this.opening){
	    case BOTH_OPENED: 
	    				switch(this.opening){
						case BOTH_OPENED: if  (this.includes(interval.getMin()))
							                 {if(this.includes(interval.getMax())||this.getMax()==interval.getMax())
							                	    return true;}
						                    if  (this.includes(interval.getMin())){}
						case LEFT_OPENED: break;	            
						case RIGHT_OPENED:break;
						case UNOPENED: break;
	    				}
			
			
			              return this.min<value&& this.max>value;
		case LEFT_OPENED: return this.min<value&&this.max>=value;	            
		case RIGHT_OPENED: return this.min<=value&& this.max>value;
		case UNOPENED: return this.min<=value&& this.max>=value;
		}
		return false;
	}

	public boolean intersectsWith(Interval interval) {
		// TODO Auto-generated method stub
		return false;
	}

	public Interval intersection(Interval interval) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(max);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(min);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((opening == null) ? 0 : opening.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Interval other = (Interval) obj;
		if (Double.doubleToLongBits(max) != Double.doubleToLongBits(other.max))
			return false;
		if (Double.doubleToLongBits(min) != Double.doubleToLongBits(other.min))
			return false;
		if (opening != other.opening)
			return false;
		return true;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public Opening getOpening() {
		return opening;
	}

	public void setOpening(Opening opening) {
		this.opening = opening;
	}

	@Override
	public String toString() {
		return "Interval [min=" + min + ", max=" + max + ", opening=" + opening
				+ "]";
	}
	
    
}