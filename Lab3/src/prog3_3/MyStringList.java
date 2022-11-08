package prog3_3;

import java.util.Arrays;

public class MyStringList {
	private final int INITIAL_LENGTH = 2;
	private String[] strArray; 
	private int size;
	
	public MyStringList() {
		strArray = new String[INITIAL_LENGTH];
		size = 0;
	}
	
	public void add(String s){
		//implement
		if(size>=strArray.length)
		{
			resize();
		}
		strArray[size]=s;
		size++;
	}
	
	public String get(int i){
		//implement
		return strArray[i];
	}
	
	public boolean find(String s){
		for(int i=0;i<strArray.length;i++)
		{
			if(strArray[i].equals(s))
				return true;
		}
		return false;
	}
	
	public void insert(String s, int pos){
		//implement
		
	}
	
	public boolean remove(String s){
		//implement
		if(find(s))
		{	 size--;
			
			for(int i=0;i<strArray.length;i++)
			{	 
				if(s.equals(strArray[i]))
				{	
					System.arraycopy(strArray,i+1, strArray, i, strArray.length-i-1);
					break;
					
				}	
			}
			return true;
		}
		else
			return false;
	}
	
	
	private void resize(){
		System.out.println("Resizing....");
		String[]temp=new String[size*2];
		System.arraycopy(strArray, 0, temp, 0, size());
		strArray=temp;
	}
	
	
	public String toString(){
		//System.out.println(Arrays.toString(this.strArray));
		String myString="[";
		for(int i=0;i<size;i++)
		{
//			if(strArray[i]!=null)
//			{
				if(i==size-1)
				{
					myString+=strArray[i];
					
				}
				else
					myString+=strArray[i]+",";
						
		//	}
				
		}
		return myString+"]";
	}
	public int size() {
		return size;
	}

	public static void main(String[] args){
		MyStringList l = new MyStringList();
		l.add("Bob");
		System.out.println("The list of size " + l.size() + " is " + l.toString());
		l.add("Steve");
		System.out.println("The list of size " + l.size() + " is " + l.toString());
		l.add("Susan");
		System.out.println("The list of size " + l.size() + " is " + l.toString());
		l.add("Mark");
		System.out.println("The list of size " + l.size() + " is " + l.toString());
		l.add("Dave");
		System.out.println("The list of size " + l.size() + " is " + l.toString());
		l.remove("Mark");
		System.out.println("The list of size " + l.size() + " is " + l.toString());
		l.remove("Bob");
		System.out.println("The list of size " + l.size() + " is " + l.toString());
	}

}
