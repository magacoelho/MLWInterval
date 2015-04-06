package intervals;

public abstract class Interval {
	 private double min;
	 private double max;
	public Interval(double min, double max) {
		this.min=min;
		this.max=max;
		
	}

	public double midPoint() {
	
		return  (this.max+this.min)/2.0;
	}

	public boolean includes(double value) {
		switch(this.getOpening()){
		case BOTH_OPENED:return this.min<value&& this.max>value;
		case LEFT_OPENED: return this.min<value&&this.max>=value;	            
		case RIGHT_OPENED: return this.min<=value&& this.max>value;
		case UNOPENED: return this.min<=value&& this.max>=value;
		}
		return false;
	}

	public boolean includes(Interval interval) {
		
		boolean equalsMaxs = this.getMax()==interval.getMax();
		boolean equalsMins = this.getMin()==interval.getMin();
		boolean includeMin= this.includes(interval.getMin());
		boolean includeMax = this.includes(interval.getMax());
		switch(this.getOpening()){ 
	    case BOTH_OPENED: 
	    				switch(interval.getOpening()){
							case BOTH_OPENED: return ((includeMin||equalsMins) &&(includeMax||equalsMaxs));
							case LEFT_OPENED: return((includeMin||equalsMins)  &&includeMax);  
			             	case RIGHT_OPENED:return (includeMin &&(includeMax||equalsMaxs));
							case UNOPENED: return (includeMin &&includeMax);
							default: return false;
	    				}
			
		case LEFT_OPENED: 
						switch(interval.getOpening()){
							case BOTH_OPENED:return((includeMin||equalsMins) &&includeMax);
							case LEFT_OPENED: return ((includeMin||equalsMins)&&(includeMax||equalsMaxs));  
				        	case RIGHT_OPENED:return (includeMin &&(includeMax||equalsMaxs));
							case UNOPENED: return (includeMin&&includeMax);
							default: return false;
						}	            
		case RIGHT_OPENED: 
						switch(interval.getOpening()){
							case BOTH_OPENED: return ((includeMin) &&((includeMax||equalsMaxs)));
							case LEFT_OPENED:return (includeMin &&(includeMax));   
				        	case RIGHT_OPENED: return(includeMin &&(includeMax)||equalsMaxs);
							case UNOPENED: return (includeMin &&includeMax);   
							default: return false;
					      }
		case UNOPENED:
						switch(interval.getOpening()){
							case BOTH_OPENED:return (includeMin &&includeMax);   
							case LEFT_OPENED:return (includeMin &&includeMax);
					    	case RIGHT_OPENED: return(includeMin &&includeMax);
							case UNOPENED: return (includeMin &&includeMax);   
							default: return false;
                         }
		}
		return false;
	}

	public boolean intersectsWith(Interval interval) {
		if (this.getMin() == interval.getMax()) {
			switch (this.getOpening()) {
			case BOTH_OPENED:
			case LEFT_OPENED:
				return false;
			case RIGHT_OPENED:
			case UNOPENED:
				return interval.getOpening() == Opening.LEFT_OPENED ||
						interval.getOpening() == Opening.UNOPENED;
			default:
				assert false;
				return false;
			}
		}
		if (this.getMax() == interval.getMin()) {
			switch (this.getOpening()) {
			case BOTH_OPENED:
			case RIGHT_OPENED:
				return false;
			case LEFT_OPENED:
			case UNOPENED:
				return interval.getOpening() == Opening.RIGHT_OPENED ||
						interval.getOpening() == Opening.UNOPENED;
			default:
				assert false;
				return false;
			}
		}
		return this.includes(interval.getMin())
				|| this.includes(interval.getMax());
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
		result = prime * result + ((this.getOpening() == null) ? 0 : this.getOpening().hashCode());
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
		if (this.getOpening() != other.getOpening())
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

	public abstract Opening getOpening();

	

	@Override
	public String toString() {
		return "Interval [min=" + min + ", max=" + max + ", opening=" + this.getOpening()
				+ "]";
	}
	
    
}
