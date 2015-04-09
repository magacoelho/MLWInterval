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
	
}
