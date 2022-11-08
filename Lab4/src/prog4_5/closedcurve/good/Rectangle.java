package prog4_5.closedcurve.good;

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
			return "For this Rectangle\n  Perimeter= %.1f\n";
		}

		@Override
		public double[] getArrayOfSides() {
			// TODO Auto-generated method stub
			double[] arrayOfSide= {length,width,length,width};
			return arrayOfSide;
			
			
		}

}
