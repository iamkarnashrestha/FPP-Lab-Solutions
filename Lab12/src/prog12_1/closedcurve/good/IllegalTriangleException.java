package prog12_1.closedcurve.good;

public class IllegalTriangleException extends IllegalClosedCurveException {

	public IllegalTriangleException() {
		super();
	}
	public IllegalTriangleException(String msg) {
		super(msg);
	}
	public IllegalTriangleException(Throwable t) {
		super(t);
	}
}
