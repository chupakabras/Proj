package proj;
import java.io.*;
import java.util.*;

public class ReadFile {
	private Scanner file;
	
	public void openFile() {
		try {
			file = new Scanner(new File("GiftData.txt"));
		}
		catch(Exception e) {
			System.out.println("An error has occured while trying to read data file.");
		}
	}
	String wow;
	public void readFile() {
		while (file.hasNext()) {
			wow = file.next();
			System.out.println(wow);
		}
	}
	
	public void closeFile() {
		file.close();
	}
}
