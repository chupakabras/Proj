package proj; 

import java.io.*;
import java.lang.*;
import java.util.*;

public class EditReservedData {
	ReadCurrentDate currentDate = new ReadCurrentDate();
	
	public void writeFile(int row, ReservedBean[] gift) {
		try(FileWriter fw = new FileWriter("ReservedData.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			PrintWriter writer = new PrintWriter("ReservedData.txt");
			writer.close();
			currentDate.openFile();
			currentDate.readFile();
			currentDate.closeFile();
			for(int i=0; i<row; i++) {
				out.println(gift[i].getName().replace(' ', '_') + " " + gift[i].getDate() + " " + gift[i].getBDate());

			}
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}		
	}
	
	public void addRow(int row, GiftBean[] gift, String date) {
		try(FileWriter fw = new FileWriter("ReservedData.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
				currentDate.openFile();
				currentDate.readFile();
				currentDate.closeFile();
				out.println(gift[row].getName().replace(' ', '_') + " " + date + " " + currentDate.getCurrentDate() + " Valid" );
				
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}		
	}
}
