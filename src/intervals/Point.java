package intervals;

public abstract class Point {
     private double value; 
	public Point(double value) {
		this.value=value;
	}

	public double getValue() {
	
		return this.value;
	}

	public void setValue(double value) {
		this.value=value;
	}
	
	public abstract boolean minorOrEquals(Point p);
	public abstract boolean minorOrEquals(PointOpened p);
	public abstract boolean minorOrEquals(PointClosed p);
	
	public boolean equalsValues(Point p) {
		return this.getValue()==p.getValue();
	}

	public abstract boolean greaterOrEquals(Point p);
	public abstract boolean greaterOrEquals(PointOpened p);
	public abstract boolean greaterOrEquals(PointClosed p);
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Point other = (Point) obj;
		if (Double.doubleToLongBits(value) != Double
				.doubleToLongBits(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Point [value=" + value + "]";
	}

	

	
	
}
