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
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean includes(double value) {
		// TODO Auto-generated method stub
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
