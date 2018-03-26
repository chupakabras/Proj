package proj;
import java.io.*;
import java.util.*;

public class ReadFile {
	
	private Scanner f;
	private int rows = 0;
	
	public void openFile() {
		try {
			f = new Scanner(new File("GiftData.txt"));
		}
		catch(Exception e) {
			System.out.println("An error has occured while trying to read data file.");
		}
	}
	public void readFile() {
		while (f.hasNext()) {
			System.out.print(f.nextLine()+"\n");
		}
	}
	
	public void closeFile() {
		f.close();
	}
}
