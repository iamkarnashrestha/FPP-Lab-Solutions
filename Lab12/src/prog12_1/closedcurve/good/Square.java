package prog12_1.closedcurve.good;

public final class Square extends ClosedCurve {
	private final double side;
	
	public Square(double side) throws IllegalClosedCurveException{
		if(side<0)
			throw new IllegalClosedCurveException("An IllegalClosedCurveException was thrown in a Square instance");	
		this.side = side;
		
	}
	public double computeArea() {
		return side * side;
	}
	@Override
	public String toString() {
		return "The area of Square is ";
	}
	


}
