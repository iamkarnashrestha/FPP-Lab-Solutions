package prog4_5.closedcurve.good;

public interface Polygon {
	public double[] getArrayOfSides();
	
	static double sum(double[] arr) {
		double sum=0;
		for(Double a:arr)
		{
			sum+=a;
		}
		return sum;
	}
	 default double computePerimeter() {
		 double[] arr=getArrayOfSides();
		 return sum(arr);
	 }

}
