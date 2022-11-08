package prog4_4.closedcurve.good;

public class Test2 {
	
	public static void main(String[] args) {

		Polygon[] objects = {new Triangle(4,5,6),
								 new Square(3),
								 new Rectangle(3,4),
								
								 };

		//compute areas as output shown in the question
		for(Polygon cc : objects) {
			
				System.out.printf(cc.toString(),cc.getNumberOfSides(),cc.computePerimeter());	
			
		}
    
	}

}