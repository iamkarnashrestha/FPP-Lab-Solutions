package prog3_4;

public final class Triangle {
	private final double height;
	private final double base;
	
	Triangle(double height,double base)
	{
		this.height=height;
		this.base=base;
	}
	
	Triangle(double side1,double side2,double side3)
	{
		base=findBase(side1,side2,side3);
		height = findHeight(side1,side2,side3);
//		height=0.5 * Math.sqrt((side1 + side2 + side3) * (-side1 + side2 + side3) * (side1 - side2 + side3) * (side1 + side2 - side3)) / base;
	}
	public double computeArea()
	{
		return 0.5*height*base;
	}
	
	double findBase(double s1,double s2,double s3)
	{
		if(s1>s2 && s1>s3)
			return s1;
		else if(s2>s1 && s2>s3)
			return s2;
		else 
			return s3;
	}
	
	double findHeight(double s1,double s2,double s3)
	{
		return 0.5 * Math.sqrt((s1 + s2 + s3) * (-s1 + s2 + s3) * (s1 - s2 + s3) * (s1 + s2 - s3)) / base;
		
	}

	public double getHeight() {
		return height;
	}

	public double getBase() {
		return base;
	}
	

 
}
