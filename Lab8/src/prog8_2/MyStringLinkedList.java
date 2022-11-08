package prog8_2;

import prog8_2.MyStringLinkedList.Node;

public class MyStringLinkedList {
	Node header;
	MyStringLinkedList(){
		header = new Node(null);
	}
	//adds to the front of the list
	public void addFirst(String item){
		Node n = new Node(item);
		//place new node after header and 
		//establish links from new node to 
		//surrounding nodes
		n.next = header.next;
		n.previous = header;
		
		//establish links from surrounding 
		//nodes to the new node
		if(header.next != null){
			header.next.previous = n;
		}		
		header.next = n;	
	}
	
	//adds to the end of the list
	public void addLast(String item) {
		Node n = new Node(item);
		//find last node
		Node last = header;
		while(last.next != null) {
			last = last.next;
		}
		//now last.next == null
        last.next = n;
        n.previous = last;
	}
	
	//removes node in last position
	public void removeLast( ) {
		//if list is empty, return
		if(header.next == null) return;
		
		Node current = header;
		//traverse the list until current.next is 
		//null - then remove current
		while(current.next != null) {
			current = current.next;
		}
		//now current.next == null, so remove current
		Node previous = current.previous; 
		//previous is not null since current is not header
		previous.next = null;
		current.previous = null;
	}
	
	//determines whether the input string is in the list
	public boolean search(String s) {
		Node next = header.next;
		while(next != null && !next.value.equals(s)) {
			next = next.next;
		}
		//either next == null or next.value is s
		if(next == null) return false;
		else {//next.value.equals(s) 
			return true;
		}
	}
	public String toString() { 
		var sb = new StringBuffer();
		Node next = header.next;
		while(next != null) {
			sb.append(next.toString() + ", ");
			next = next.next;
		}
		var result = sb.toString().trim();
		if(result.length() == 0) return "<empty list>";
		if(result.charAt(result.length()-1) == ',') {
			return result.substring(0,result.length()-1);
		}
		return result;			
	}
	class Node {
		String value;
		Node next=null;
		Node previous;
		Node(String value){
			this.value = value;
		}
		
		public String toString() {
			return value == null ? "null" : value;
		}
	}

	public static void main(String[] args){
		var list = new MyStringLinkedList();
		list.addLast("big");
		list.addLast("small");
		list.addLast("tall");
		list.addLast("short");
		list.addLast("round");
		list.addLast("square");
		list.addLast("enormous");
		list.addLast("tiny");
		list.addLast("gargantuan");
		list.addLast("numberless");
		list.addLast("none");
		list.addLast("vast");
		list.addLast("miniscule");
		System.out.println(list);
		list.minsort();
		System.out.println(list);
	}
	
	
	void insert(String data, int pos)
	{	
		if(pos<0 || pos>size())
			throw new IllegalArgumentException("Illegal position for new node");
		else if(pos==0)
			addFirst(data);
		else if(pos==size())
			addLast(data);
		else
		{
			Node n=new Node(data);
			Node current= header;
			for(int i=0;i<pos;i++)
			{
				current=current.next;
				
			}
			Node next=current.next;
			current.next=n;
			n.previous=current;
			n.next=next;
			next.previous=n;
		}
	}
	
	
	
	/** size = the number of non-null nodes */

	int size()
	{
		Node current=header;
		int size=0;
		while(current.next!=null)
		{
			current=current.next;
			size++;
		}
		return size;
	}
	
	
	boolean remove(String data) {
	if(data == null) return false;
	Node current = header;
	//if next == null, s cannot be removed
	while(current.next != null)
	{
		current=current.next;
		
		if(data.equals(current.value)&&current.next!=null )
		{
			Node previous=current.previous;
			previous.next=current.next;
			return true;
		}
	}
	return false;
	
}
	
	
	
	public void minsort()
	{	
		if(header.next==null) return;
		Node current=header.next;
		if(header.next==null) return;
		while(current.next!=null) {
			Node nextMinPos=minpos(current);		
			swap(current,nextMinPos);
			current=current.next;
		}
	}
	// Swaps values arr[i], arr[j]
	void swap(Node n1, Node n2) {
		String temp = n1.value;
		n1.value=n2.value;
		n2.value= temp;
	}

	// Returns pos of min value from
	// positions i to j
	Node minpos(Node n) {
		
		Node min = n;
		Node current = n;
		while (current.next != null) {
			if (min.value.compareTo(current.next.value) > 0) {
				min = current.next;
			}
			current = current.next;
		}
		return min;
	}
	
	
	
}
