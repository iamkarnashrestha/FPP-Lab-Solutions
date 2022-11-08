package prog9_2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class SymbolBalancer {
	String ODD_DELIMITER = ""+(char)0;
	String filename;
	String text;
	char[] left;
	char[] right;
	Stack<Character> symbols;
	public SymbolBalancer(String filename) {
		this.filename = filename;
		readFile();
	}
	public void setText(String text) {
		this.text = text;
	}
	
	boolean symbolsBalanced(String delimiters){
		symbols = new Stack<Character>();
		
		for(int i=0; i< text.length(); ++i) {
			char ch = text.charAt(i);
			if(delimiters.indexOf(ch) % 2 == 0){
				symbols.push(ch);
			}
			if(delimiters.indexOf(ch) % 2 == 1) {
				if(symbols.isEmpty())
					return false;
				
				char top = symbols.pop();
				if(top=='[' && ch==']' || top=='{' && ch=='}' || top=='<' && ch=='>' || top=='(' && ch==')') 
					continue;
				else
					return false;
			}
		}
		return symbols.isEmpty();
	}

	public static void main(String[] args) {
		SymbolBalancer sb = new SymbolBalancer("\\Employee.java");
		System.out.println(sb.symbolsBalanced("[]{}<>()"));
	}
	void readFile() {
		String prefix = System.getProperty("user.dir") + "\\src\\";
		try {
			Scanner sc = new Scanner(new File(prefix + filename));
			sc.useDelimiter(ODD_DELIMITER);
			text = sc.next();
			//System.out.println(text);
			sc.close();
		}
		catch(FileNotFoundException ex) {
			System.err.println("File Not Found Exception " + ex.getMessage());
		}
	}
	
}



