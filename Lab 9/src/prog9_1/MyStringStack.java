package prog9_1;

public class MyStringStack {
	private MyStringLinkedList list;
	public MyStringStack() {
		list = new MyStringLinkedList();
	}
	
	public String pop() {
		String ret = peek();
		if (peek() == null)
			return "Stack is Empty";
		else {
			list.remove(0);
			return ret;
		}
	}
	public String peek() {
		if(list.get(0)!=null)
			return list.get(0);
		else
			return null;
	}
	
	public void push(String s) {
		if(s == null)
			return;
		else
			list.addFirst(s);
	}
	
	
	
	public static void main(String[]args){
		MyStringStack stack = new MyStringStack();
		stack.push("Bob");
		stack.push("Harry");
		stack.push("Alice");
		System.out.println(stack.list.toString());
		System.out.println("Popping…"+stack.pop());
		System.out.println("Peeking…."+stack.peek());
		System.out.println("Popping…"+stack.pop());
		System.out.println(stack.list.toString());
		
	}
}
