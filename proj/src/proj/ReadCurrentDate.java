package proj;

import java.io.File;
import java.util.Scanner;

public class ReadCurrentDate {
	 private Scanner x;
	 private String date;
	 
	 public void openFile() {
		 try{
			 x = new Scanner(new File("CurrentDate.txt"));
		 }
		 catch (Exception e) {
			 System.out.println("CurrentDate.txt couldn't be opened");
		 }
	 }
	 
	 public void readFile() {
		 date = x.next();
	 }
	 
	 public void closeFile() {
		 x.close();
	 }
	 
	 public String getCurrentDate() {
		 return date;
	 }
}