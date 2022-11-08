package prog4_4.closedcurve.good;

public class Rectangle extends ClosedCurve implements Polygon{
		private double length,width;
		
		public Rectangle(int i, int j) {
			this.length=i;
			this.width=j;
		}

		public double computeArea()
		{
			return length*width;
		}
		public String toString() {
			return "For this Rectangle \n  Number of sides = %d \n  Perimeter= %.1f\n";
		}

		@Override
		public int getNumberOfSides() {
			// TODO Auto-generated method stub
			return 4;
			
		}

		@Override
		public double computePerimeter() {
			// TODO Auto-generated method stub
			return 2*(length+width);
		}
}
