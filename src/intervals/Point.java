package intervals;

public class Point {
     private double value; 
	public Point(double value) {
		this.value=value;
	}

	public double getValue() {
		// TODO Auto-generated method stub
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
	
	
}
