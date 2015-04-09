package intervals;

public class Point {
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
	
	public boolean minorOrEquals(Point p) {
		return this.minorThan(p)||equalsValues(p);
	}
	public boolean equalsValues(Point p) {
		return this.getValue()==p.getValue();
	}

	public boolean minorThan(Point p) {
				return this.getValue()<p.getValue();
	}
	public boolean greaterThan(Point p){
		 return this.getValue()>p.getValue();
	}
	
	public boolean greaterOrEquals(Point p) {
		return this.greaterThan(p)||this.equalsValues(p);
	}

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
