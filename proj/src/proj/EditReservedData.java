package proj;

import java.io.*;

public class EditReservedData {
	ReadCurrentDate currentDate = new ReadCurrentDate();

	public void writeFile(int row, ReservedBean[] gift) {

		// Creating objects for ReservedData.txt reformatting
		try (FileWriter fw = new FileWriter("ReservedData.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			PrintWriter writer = new PrintWriter("ReservedData.txt");

			// closing the writer so it overwrites the existing file
			writer.close();
			currentDate.openFile();
			currentDate.readFile();
			currentDate.closeFile();
			for (int i = 0; i < row; i++) {
				out.println(gift[i].getName().replace(' ', '_') + " " + gift[i].getOrdDate() + " " + gift[i].getDate()
						+ " " + gift[i].getBDate());

			}
		} catch (IOException e) {
			System.out.println("An error has occured while trying to reformat ReservedDate.txt");
		}
	}

	public void addRow(int row, GiftBean[] gift, String date) {
		try (FileWriter fw = new FileWriter("ReservedData.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			currentDate.openFile();
			currentDate.readFile();
			currentDate.closeFile();
			out.println(gift[row].getName().replace(' ', '_') + " " + gift[row].getFrom() + "/" + gift[row].getTo()
					+ " " + date + " " + currentDate.getCurrentDate());

		} catch (IOException e) {
			System.out.println("An error has occured while trying to add row to ReservedDate.txt");
		}
	}
}
