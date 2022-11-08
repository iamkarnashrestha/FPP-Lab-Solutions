package prog4_4.closedcurve.good;

public final class Square extends ClosedCurve implements Polygon {
	private final double side;
	
	public Square(double side){
		this.side = side;
		
	}
	public double computeArea() {
		return side * side;
	}
	@Override
	public String toString() {
		return "For this Square \n  Number of sides = %d \n  Perimeter= %.1f\n";
	}
	@Override
	public int getNumberOfSides() {
		// TODO Auto-generated method stub
		return 4;
	}
	@Override
	public double computePerimeter() {
		// TODO Auto-generated method stub
		return 4*side;
	}
	


}
