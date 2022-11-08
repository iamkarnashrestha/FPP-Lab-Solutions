package prog4_5.closedcurve.good;

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
		return "For this Square\n  Perimeter= %.1f\n";
	}
	@Override
	public double[] getArrayOfSides() {
		// TODO Auto-generated method stub
		double[] arrayOfSide= {side,side,side,side};
		return arrayOfSide;
		
		
	}
	


}
