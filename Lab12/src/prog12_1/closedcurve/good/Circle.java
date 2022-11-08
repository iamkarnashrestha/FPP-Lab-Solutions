package prog12_1.closedcurve.good;

public final class Circle extends ClosedCurve {
	private final double radius;
	public Circle(double radius) throws IllegalClosedCurveException{
		if(radius<0)
			throw new IllegalClosedCurveException("An IllegalClosedCurveException was thrown in a Circle instance");
		this.radius = radius;
		
	}
	public double computeArea() {
		return (Math.PI * radius * radius);
	}
	public String toString() {
		return "The area of Circle is:";
	}
}
