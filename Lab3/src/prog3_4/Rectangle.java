package prog3_4;

public final class Rectangle {
	private final double length;
	private final double width;
	
	Rectangle(double length,double width)
	{
		this.length=length;
		this.width=width;
	}
	
	public double computeArea()
	{
		return length*width;
	}

	public double getLength() {
		return length;
	}

	public double getWidth() {
		return width;
	}
}
