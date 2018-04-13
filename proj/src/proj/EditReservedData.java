package proj; 

import java.io.*;
import java.lang.*;
import java.util.*;

public class EditReservedData {
	private Writer x;
	TimeFlow time = new TimeFlow();
	
	public void writeFile(int row, ReservedBean[] gift) {
		try(FileWriter fw = new FileWriter("ReservedData.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			PrintWriter writer = new PrintWriter("ReservedData.txt");
			writer.close();
			for(int i=0; i<row; i++) {
				out.println(gift[i].getName().replace(' ', '_') + " " + gift[i].getDate());

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
			
				out.println(gift[row].getName().replace(' ', '_') + " " + date + " " + time.getDate());
				
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}		
	}
}
