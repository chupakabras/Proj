package proj;

import java.io.File;
import java.util.Scanner;

//Reading current date from CurrentDate.txt
public class ReadCurrentDate {
	private Scanner x;
	private String date;
	private int year;
	private int month;
	private int day;

	public void openFile() {
		try {
			x = new Scanner(new File("CurrentDate.txt"));
		} catch (Exception e) {
			System.out.println("CurrentDate.txt couldn't be opened");
		}
	}

	public void readFile() {
		date = x.next();
		String[] split = date.split("-");
		year = Integer.parseInt(split[0]);
		month = Integer.parseInt(split[1]);
		day = Integer.parseInt(split[2]);
	}

	public void closeFile() {
		x.close();
	}

	public String getCurrentDate() {
		return date;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}
}