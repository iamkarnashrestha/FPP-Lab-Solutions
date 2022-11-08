package prog7_1;

public class Exponential {
	
	
	public double pow(double x,int n) {
		if(n==0)
			return 1;
		else
			return x*pow(x,n-1);
	}
	
	public static void main(String[] args) {
		Exponential e=new Exponential();
		System.out.println("Result="+e.pow(2, 2));
	}

}
