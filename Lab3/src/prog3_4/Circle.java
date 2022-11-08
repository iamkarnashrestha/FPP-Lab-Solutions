package prog3_4;

public final class Circle {
	private final double radius;
	
	Circle(double radius)
	{
		this.radius=radius;
	}
	public double computeArea()
	{
		return Math.PI*Math.pow(radius,2);
	}
	public double getRadius() {
		return radius;
	}
	
}
