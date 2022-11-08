package prog12_2.employeeinfo;

public class OverdrawnAccountException extends Exception{
	
	public OverdrawnAccountException() {
		super();
	}
	
	public OverdrawnAccountException(String msg) {
		super(msg);
	}
	
	public OverdrawnAccountException(Throwable t) {
		super(t);
	}

}
