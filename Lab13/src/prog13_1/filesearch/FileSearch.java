package prog13_1.filesearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * //PSEUDO-CODE boolean searchForFile(Object file, Object startDir) { Object[]
 * fileSystemObjects = startDir.getContents(); for(Object o: fileSystemObjects)
 * { //base case if(isFile(o) && isSameFile(o,f)) { return true; }
 * 
 * if(isDirectory(o)) { searchForFile(file, o); } } //file not found in startDir
 * return false; }
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileSearch {
	static boolean found = false;
	// Store the text that is found in the
	// file that is found in this String variable
	static String discoveredText = null;

	public static void readContents(File fileName) {
		Scanner sc = null;
		try {
			sc = new Scanner(fileName);
			String line = null;
			while (sc.hasNextLine()) {
				line = sc.nextLine();
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

	public static boolean searchForFile(String filename, String startDir) {
		File f = new File(startDir);
		ArrayList<File> files = new ArrayList<File>(Arrays.asList(f.listFiles()));
		for (File file : files) {
			if (file.isFile() && file.getName().equals(filename)) {
				System.out.println(filename + " found in : " + file + "\nContents :");
				readContents(file);
				found = true;
			}
			
			if (file.isDirectory()) {
				searchForFile(filename, file.getAbsolutePath());
			} 
		}
		return found;
	}

	public static void main(String[] args) {
		String filename = "InsideTemp.txt";
		String startDir = "C:\\Users\\caran\\Desktop\\FPP\\Lab13\\src\\prog13_1\\filesearch\\";

		if(!searchForFile(filename, startDir)) {
			System.out.println("404 !! File not found !!");
		}

	}

}
