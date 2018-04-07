package proj; 

import java.io.*;
import java.lang.*;
import java.util.*;

public class EditReservedData {
	private Writer x;
	/*public static void main(String[] args) {
		EditGiftData edit = new EditGiftData();
		ReadAndStore kek = new ReadAndStore();
		GiftBean[] gift = kek.store();
		ReadFile rows = new ReadFile();
		int row = rows.getNumberOfRows();
		edit.writeFile(row, gift);
	
	}*/
	
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
	
	public void addRow(int row, GiftBean[] gift) {
		try(FileWriter fw = new FileWriter("ReservedData.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
				out.println(gift[row].getName().replace(' ', '_') + " ");
				
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}		
	}
}
