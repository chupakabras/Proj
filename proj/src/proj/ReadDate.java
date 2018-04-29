package proj;

import java.io.*;
import java.util.*;

//Reading date from Date.txt
public class ReadDate {

	private Scanner f;

	public void openFile() {
		try {
			f = new Scanner(new File("Date.txt"));
		} catch (Exception e) {
			System.out.println("An error has occured while trying to read data file.");
		}
	}

	public String readDate() {
		String line = f.nextLine();
		return line;
	}

	public void closeFile() {
		f.close();
	}

}