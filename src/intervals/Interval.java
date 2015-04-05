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
		case LEFT_OPENED:break;
		
		
		
		
		}
		return false;
	}

	public boolean includes(Interval interval) {
		// TODO Auto-generated method stub
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

}
