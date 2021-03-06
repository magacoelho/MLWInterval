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

	public abstract boolean intersectsWith(Interval interval) ;
	public abstract Interval intersection(Interval interval);

	
	public boolean includes(Interval interval){
		return this.getMin().minorOrEquals(interval.getMin())&& this.getMax().greaterOrEquals(interval.getMax());
	}


	public boolean includes(double value) {
		Point p = new PointClosed(value);
		return this.getMin().minorOrEquals(p)&&this.getMax().greaterOrEquals(p);
	}
}
