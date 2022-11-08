package prog12_1.closedcurve.good;

public class Test {
	
	public static void main(String[] args) {
		 Triangle t=null;
		 Square s=null;
		 Circle c=null;
		try {
			t = new Triangle(4,5,6);
				s=new Square(3);
				c=new Circle(-1);
			}
		catch(IllegalClosedCurveException e) {
			System.out.println(e.getMessage());
		}
		ClosedCurve[] objects = {t,s,c };
		//compute areas as output shown in the question
		for(ClosedCurve cc : objects) {
			
				System.out.println(cc.toString()+cc.computeArea());	
			
		}
    
	}

}