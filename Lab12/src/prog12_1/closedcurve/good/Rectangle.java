package prog12_1.closedcurve.good;

public class Rectangle extends ClosedCurve{
		private double length,width;
		
		public Rectangle(int i, int j) throws IllegalClosedCurveException {
			if(i<=0 && j<=0)
				throw new IllegalClosedCurveException("An IllegalClosedCurveException was thrown in a Rectangle instance");
			this.length=i;
			this.width=j;
		}

		public double computeArea()
		{
			return length*width;
		}
		public String toString() {
			return "The area of Rectangle is ";
		}
}
