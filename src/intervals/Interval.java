package intervals;

public abstract class Interval {
	 private Point min;
	 private Point max;
	public Interval(Point min, Point max) {
		super();
		this.min = min;
		this.max = max;
	}


	public Point getMin() {
		return min;
	}


	public void setMin(Point min) {
		this.min = min;
	}


	public Point getMax() {
		return max;
	}


	public void setMax(Point max) {
		this.max = max;
	}


	public double midPoint() {
	
		return  (this.getMax().getValue()+this.getMin().getValue())/2.0;
	}

	

//	public double getMin() {
//		return min.getValue();
//	}
//
//	public void setMin(double min) {
//		this.min.setValue(min);
//	} 
//
//	public double getMax() {
//		return max.getValue();
//	}
//
//	public void setMax(double max) {
//		this.max.setValue(max);
//	}

	public abstract Opening getOpening();

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((max == null) ? 0 : max.hashCode());
		result = prime * result + ((min == null) ? 0 : min.hashCode());
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
		if (max == null) {
			if (other.max != null)
				return false;
		} else if (!max.equals(other.max))
			return false;
		if (min == null) {
			if (other.min != null)
				return false;
		} else if (!min.equals(other.min))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Interval [min=" + this.getMin() + ", max=" + this.getMax() + ", opening=" + this.getOpening()
				+ "]";
	}

	public abstract boolean includes(double value) ;

	public abstract boolean intersectsWith(Interval interval) ;
	public abstract Interval intersection(Interval interval);

	
	
	public boolean minorOrEquals(double value1, double value2) {
		return this.minorThan( value1, value2)||equalsValues( value1, value2);
	}
	
	public boolean equalsValues(double value1, double value2) {
		return value1==value2;
	}

	public boolean minorThan(double value1, double value2) {
				return value1<value2;
	}
    
	public boolean greaterThan(double value1, double value2){
		 return value1>value2;
	}
	
	public boolean greaterOrEquals(double value1, double value2) {
		return this.greaterThan(value1, value2)||this.equalsValues(value1, value2);
	}

	public boolean includes(Interval interval){
		
		return this.getMin().greaterOrEquals(interval.getMin())&& this.getMax().minorOrEquals(interval.getMax());
	}

	
	
//	public boolean equalsMaxValues(Interval interval) {
//		return this.getMax()==interval.getMax(); 
//	}
//    
//	public boolean greaterMaxThan(Interval interval) {
//		return this.getMax()>interval.getMax();
//	}
//	public boolean greaterMaxOrEquals(Interval interval) {
//		return this.greaterMaxThan(interval)||this.equalsMaxValues(interval);
//	}
//
//	public boolean equalsMinsValues(Interval interval) {
//		return this.getMin()==interval.getMin();
//	}
//	public boolean minorMinThan(Interval interval) {
//			return this.getMin()< interval.getMin();
//	}
//
//	public boolean minorMinOrEquals(Interval interval) {
//		return this.minorMinThan(interval)||equalsMinsValues(interval);
//	}
//
//
//	
///////
//	public boolean greaterMinThan(Interval interval) {
//		
//		return this.getMin()>interval.getMin();
//	}
//
//	public boolean greaterMinOrEquals(Interval interval) {
//		return this.greaterMinThan(interval)||this.equalsMinsValues(interval);
//	}
//	public boolean minorMaxThan(Interval interval) {
//	
//		return this.getMax()< interval.getMax();
//	}
//
//	public boolean minorMaxOrEquals(Interval interval) {
//		return this.minorMaxThan(interval)||equalsMaxValues(interval);
//	}
//    
}
