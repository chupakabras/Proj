package proj;

import java.io.*;

public class EditGiftData {

	public void writeFile(int row, GiftBean[] gift) {

		// Creating objects for GiftData.txt reformatting
		try (FileWriter fw = new FileWriter("GiftData.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			PrintWriter writer = new PrintWriter("GiftData.txt");

			// closing the writer so it overwrites the existing file
			writer.close();
			for (int i = 0; i < row; i++) {
				out.println(gift[i].getName().replace(' ', '_') + " " + gift[i].getDate() + " " + gift[i].getRemaining()
						+ " " + gift[i].getReserved());

			}
		} catch (IOException e) {
			System.out.println("An error has occured while trying to edit GiftData.txt");
		}
	}
}
