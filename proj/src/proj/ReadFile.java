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
			f.nextLine();
			rows++;
		}
		GiftBean[] gift = new GiftBean[rows];
		String[] local = new String[rows];
		closeFile();
		openFile();
		
		for(int i=0; i<rows; i++) {
			gift[i] = new GiftBean();
			local[i] = f.nextLine();
		}
		
		for(int i=0; i<rows; i++) {
			String wordarr[] = local[i].split(" ");
			gift[i].setName(wordarr[0]);
			gift[i].setDate(wordarr[1]);
			gift[i].setOwner(wordarr[2]);
			System.out.print(gift[i].getName() + " " + gift[i].getDate() + " " + gift[i].getOwner() + "\n");
		}
	}

	public void closeFile() {
		f.close();
	}
}
