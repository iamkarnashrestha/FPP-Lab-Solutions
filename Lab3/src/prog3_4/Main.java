package prog3_4;

public class Main {

	public static void main(String[] args) {
		Triangle triangle=new Triangle(4,6);
		Rectangle rectangle=new Rectangle(5,6);
		Circle circle= new Circle(3);
		
		System.out.printf("Area of Triangle:%.2f\n",triangle.computeArea());
		System.out.printf("Area of Rectangle:%.2f\n",rectangle.computeArea());
		System.out.printf("Area of Circle: %.2f\n",circle.computeArea());

		
		Triangle triangle1=new Triangle(15,12,20);
		System.out.printf("Area of Triangle:%.2f\n",triangle1.computeArea());
		
	}

}
