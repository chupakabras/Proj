package proj;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ReserveDate extends JFrame {

	ReadAndStoreReserved kek = new ReadAndStoreReserved();
	ReservedBean[] gift = kek.store();
	ReadReserved rows = new ReadReserved();
	ReadCurrentDate currentDate = new ReadCurrentDate();
	DateConverter convert = new DateConverter();
	private Scanner x;
	private String date;

	JTable table;

	// Creating JTable to display the contents of ReservedData.txt
	public ReserveDate() {

		openFile();
		setLayout(new FlowLayout());
		String[] columnNames = { "Gift Name", "Available for", "Reserved for", "Bought on", "Expiration" };
		String[][] data = new String[rows.getNumberOfRows()][5];
		for (int i = 0; i < rows.getNumberOfRows(); i++) {
			readFile();
			data[i][0] = gift[i].getName();
			data[i][1] = gift[i].getOrdDate();
			data[i][2] = gift[i].getDate().replace("_", " ");
			data[i][3] = date;

			currentDate.openFile();
			currentDate.readFile();
			currentDate.closeFile();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate firstDate = LocalDate.parse(convert.convertDate(currentDate.getCurrentDate()), formatter);
			LocalDate secDate = LocalDate.parse(convert.convertDate(date), formatter);

			// Calculating the day difference between current date and the date when the
			// gift was bought
			long days = ChronoUnit.DAYS.between(secDate, firstDate); // Chrono unit is a standard set of date periods
																		// units.

			// Checking whether the gift is expired or not
			if (days >= 31) {
				data[i][4] = "Expired";
				gift[i].setState(data[i][4]);
			} else if (days < 0) {
				data[i][4] = "In the future";
				gift[i].setState(data[i][4]);
			} else
				data[i][4] = Long.toString(31 - days) + " days left";
			gift[i].setState(data[i][4]);
		}
		closeFile();
		table = new JTable(data, columnNames);
		table.getColumnModel().getColumn(0).setPreferredWidth(245);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		table.getColumnModel().getColumn(4).setPreferredWidth(60);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(620, 430));
		add(scrollPane);

		// Creating the refresh button
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ReserveDate gui = new ReserveDate();
				gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				gui.setSize(670, 520);
				gui.setVisible(true);
				gui.setTitle("Reserve Date");
				gui.setResizable(false);
			}

		});
		btnRefresh.setBounds(490, 490, 130, 23);
		getContentPane().add(btnRefresh);
		currentDate.openFile();
		currentDate.readFile();
		currentDate.closeFile();

		// Printing current date near the refresh button
		JLabel label1 = new JLabel("Current date " + currentDate.getCurrentDate());
		label1.setBounds(500, 490, 130, 23);
		getContentPane().add(label1);
		label1.setVisible(true);

		ListSelectionModel model = table.getSelectionModel();
		model.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				openFile();
				if (!model.isSelectionEmpty()) {
					if (!e.getValueIsAdjusting()) {
						int selectedRow = model.getMinSelectionIndex();
						if (gift[selectedRow].getState().equals("Expired")) {
							JOptionPane.showMessageDialog(null, gift[selectedRow].getName() + " is expired");
						} else if (gift[selectedRow].getState().equals("In the future")) {
							JOptionPane.showMessageDialog(null,
									gift[selectedRow].getName() + " is bought in the future");
						} else {
							DatePickerReserved d = new DatePickerReserved(selectedRow);
							d.main(selectedRow);
						}

					}
				}
				closeFile();
			}

		});

	}

	public void openFile() {
		try {
			x = new Scanner(new File("ReservedData.txt"));
		} catch (Exception e) {
			System.out.println("CurrentDate.txt couldn't be opened");
		}
	}

	public void readFile() {
		x.next();
		x.next();
		x.next();
		date = x.next();
	}

	public void closeFile() {
		x.close();
	}

}