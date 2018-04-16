package proj;

import java.awt.FlowLayout;
import java.io.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javafx.application.Application;

public class ReserveDate extends JFrame {
	
	ReadAndStoreReserved kek = new ReadAndStoreReserved();
	ReservedBean[] gift = kek.store();
	ReadReserved rows = new ReadReserved();
	TimeFlow time = new TimeFlow();
	
	private Scanner x;
	private String date;

	//String strI = Integer.toString(i);
	JTable table;
	public ReserveDate () {
		openFile();
		setLayout(new FlowLayout());
		String[] columnNames = {"Gift Name", "Reserved for", "Bought on"};
			String[][] data = new String[rows.getNumberOfRows()][4];
						for (int i=0; i<rows.getNumberOfRows(); i++) {
				readFile();
				data[i][0] = gift[i].getName();
				data[i][1] = gift[i].getDate().replace("_", " ");
				data[i][2] = date;
				}		
		closeFile();
		table = new JTable (data, columnNames);
		table.getColumnModel().getColumn(0).setPreferredWidth(270);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
		
		ListSelectionModel model = table.getSelectionModel();
		model.addListSelectionListener(new ListSelectionListener() {
			

			public void valueChanged(ListSelectionEvent e) {
				String[] args = new String[1];
				if (! model.isSelectionEmpty())
				{
					if (! e.getValueIsAdjusting()) {
					int selectedRow = model.getMinSelectionIndex();
					//if (gift[selectedRow].getRemaining()>0) {
						DatePicker d = new DatePicker(selectedRow);
						d.main(selectedRow);
					//DatePicker.main(args); 
					//}
				//	else {
				//		JOptionPane.showMessageDialog(null, gift[selectedRow].getName() + " date can't be changed");
					//}
				}
			}
			}
		});
		
	}

	public void openFile() {
		 try{
			 x = new Scanner(new File("ReservedData.txt"));
		 }
		 catch (Exception e) {
			 System.out.println("CurrentDate.txt couldn't be opened");
		 }
	 }
	 
	 public void readFile() {
		 x.next();
		 x.next();
		 date = x.next();
	 }
	 
	 public void closeFile() {
		 x.close();
	 }
	
}