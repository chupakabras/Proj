package proj;

import java.io.*;
import java.lang.*;
import java.util.*;

public class EditGiftData {
	private Writer x;
	
	public void writeFile(int row, GiftBean[] gift) {
		try(FileWriter fw = new FileWriter("GiftData.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			PrintWriter writer = new PrintWriter("GiftData.txt");
			writer.close();
			for(int i=0; i<row; i++) {
				out.println(gift[i].getName().replace(' ', '_') + " " + gift[i].getDate() + " " + gift[i].getRemaining() + " " + gift[i].getReserved());

			}
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}		
	}
}
