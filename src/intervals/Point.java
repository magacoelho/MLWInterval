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
	
	public boolean minorOrEquals(double value1, double value2) {
		return this.minorThan( value1, value2)||equalsValues( value1, value2);
	}
}
