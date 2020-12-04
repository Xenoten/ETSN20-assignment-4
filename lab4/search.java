package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Search {
	private ArrayList<String> content = new ArrayList<String>();
	private ArrayList<String> filteredContent = new ArrayList<String>();
	
	
	public static void main(String[] args) {
		Search search = new Search();
		
		String pattern = args[0];
		String filename = args[1];
		
		search.readFile(filename);
		search.filter(pattern);
		search.printAllRows();
		
	}
	

	
	
	private void readFile(String filename) {
		
		File file = new File(filename);
		try {
			Scanner reader = new Scanner(file);
			while (reader.hasNextLine()) {
				String row = reader.nextLine();
				content.add(row);
				
			}
			reader.close();
			
		} catch (FileNotFoundException e) {
			System.out.print("File not found");
		}
	}
	
	private void filter(String pattern) {
		
		for(String row : content) {
			if (row.toLowerCase().contains(pattern)) {
				filteredContent.add(row);
			}
		}
	}
	
	private void printAllRows() {
		for (String row : filteredContent) {
			System.out.println(row);
		}
	}
	
}
