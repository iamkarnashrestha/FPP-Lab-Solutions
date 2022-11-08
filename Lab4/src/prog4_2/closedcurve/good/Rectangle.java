package prog4_2.closedcurve.good;

public class Rectangle extends ClosedCurve{
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
			return "The area of Rectangle is ";
		}
}
