package prog5_1;



public class MySingleton {
	private static MySingleton instance;
	public static int count = 0;
	private MySingleton()
	{
		count++;	
	}
	public static MySingleton getInstance() {
		if(instance == null) {
			instance = new MySingleton();
		}
		return instance;
	}

	public static void main(String[] args) {
		MySingleton a=MySingleton.getInstance();
		MySingleton b= MySingleton.getInstance();
		System.out.println(count);
		System.out.println(count);
		
	}
	
	//here I  tried to create two instance of class MySingleton 
	//later checked the count variable but the count is still 1, which shows that the two instances refers to the same instances
	
}
