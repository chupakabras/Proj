package proj;
import java.io.*;
import java.util.*;

public class ReadFile {
	
	private Scanner f;
	
	public void openFile() {
		try {
			f = new Scanner(new File("GiftData.txt"));
		}
		catch(Exception e) {
			System.out.println("An error has occured while trying to read data file.");
		}
	}
	
	public void closeFile() {
		f.close();
	}
	
	public int getNumberOfRows() {
		int rows = 0;
		while (f.hasNext()) {
			f.nextLine();
			rows++;
		}
		closeFile();
		openFile();
		return rows;
	}
	
	public String getLine() {
		String line = f.nextLine();
		return line;
	}
	
}