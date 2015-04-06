package intervals;

public abstract class Interval {
	 private double min;
	 private double max;
	public Interval(double min, double max) {
		this.min=min;
		this.max=max;
		
	}

	public double midPoint() {
	
		return  (this.getMax()+this.getMin())/2.0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(this.getMax());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.getMin());
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
		if (Double.doubleToLongBits(this.getMax()) != Double.doubleToLongBits(other.getMax()))
			return false;
		if (Double.doubleToLongBits(this.getMin()) != Double.doubleToLongBits(other.getMin()))
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
		return "Interval [min=" + this.getMin() + ", max=" + this.getMax() + ", opening=" + this.getOpening()
				+ "]";
	}

	public abstract boolean includes(Interval interval);
	public abstract boolean includes(IntervalBothOpened interval);
	public abstract boolean includes(IntervalLeftOpened interval);
	public abstract boolean includes(IntervalRightOpened interval);
	public abstract boolean includes(IntervalUnopened interval);
	public abstract boolean includes(double value) ;

	public abstract boolean intersectsWith(Interval interval) ;
	public abstract Interval intersection(Interval interval);
    
}
