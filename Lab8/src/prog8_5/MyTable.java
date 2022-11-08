package prog8_5;

public class MyTable {
	private static final int START_IDX = 97;
	private Entry[] entries = new Entry[26];

	// returns the String that is matched with char c in the table
	public String get(char c) {
		// implement
		int idx = (int) c % START_IDX;
		return entries[idx] == null ? "null" : entries[idx].toString();
	}

	// adds to the table a pair (c, s) so that s can be looked up using c
	public void add(char c, String s) {
		// implement
		int idx = (int) c % START_IDX;
		entries[idx] = new Entry(s, c);
	}

	// returns a String consisting of nicely formatted display
	// of the contents of the table
	public String toString() {
		String out = "";
		for(Entry e : entries) {
			if(e != null)
				out += String.format("%s %n",e.toString());
		}
		return out;
	}

	private class Entry {

		String str;
		char ch;
		
		Entry(String str, char ch) {
			// implement
			this.str = str;
			this.ch = ch;
		}

		// returns a String of the form "ch->str"
		public String toString() {
			// implement
			String out = "";
			out += String.format("%c-> %s", ch, str);
			return out;
		}
	}

	public static void main(String[] args) {
		MyTable t = new MyTable();
		t.add('a', "Andrew");
		t.add('b', "Billy");
		t.add('w', "Willie");
		System.out.println(t);
	}
}