package proj;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
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

import javafx.application.Application;

public class ReserveDate extends JFrame {
	
	ReadAndStoreReserved kek = new ReadAndStoreReserved();
	ReservedBean[] gift = kek.store();
	ReadReserved rows = new ReadReserved();
	ReadCurrentDate currentDate = new ReadCurrentDate();
	private Scanner x;
	private String date;

	//String strI = Integer.toString(i);
	JTable table;
	public ReserveDate () {

		openFile();
		setLayout(new FlowLayout());
		String[] columnNames = {"Gift Name", "Reserved for", "Bought on", "Expiration"};
			String[][] data = new String[rows.getNumberOfRows()][4];
						for (int i=0; i<rows.getNumberOfRows(); i++) {
				readFile();
				data[i][0] = gift[i].getName();
				data[i][1] = gift[i].getDate().replace("_", " ");
				data[i][2] = date;
				data[i][3] = null;
				}		
		closeFile();
		table = new JTable (data, columnNames);
		table.getColumnModel().getColumn(0).setPreferredWidth(245);
		//table.getColumnModel().getColumn(3).setPreferredWidth(150);
		//table.setPreferredSize(new Dimension(600,500));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(550,430));
		add(scrollPane);
		
		
		JButton btnSelectThisDate = new JButton("Refresh");
		btnSelectThisDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				//setVisible(false);
				ReserveDate gui = new ReserveDate();
				gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				gui.setSize(600, 500);
				gui.setVisible(true);
				gui.setTitle("Reserve Date");
				gui.setResizable(false);
			}

		});
		btnSelectThisDate.setBounds(490, 490, 130, 23);
		getContentPane().add(btnSelectThisDate); 
		currentDate.openFile();
		currentDate.readFile();
		currentDate.closeFile();
		JLabel label1 = new JLabel("Current date "  + currentDate.getCurrentDate());
		label1.setBounds(500, 490, 130, 23);
		getContentPane().add(label1);
		label1.setVisible(true);
		
		ListSelectionModel model = table.getSelectionModel();
		model.addListSelectionListener(new ListSelectionListener() {
			

			public void valueChanged(ListSelectionEvent e) {
				openFile();
				String[] args = new String[1];
				if (! model.isSelectionEmpty())
				{
					if (! e.getValueIsAdjusting()) {
					int selectedRow = model.getMinSelectionIndex();
					//if (gift[selectedRow].getRemaining()>0) {
						DatePickerReserved d = new DatePickerReserved(selectedRow);
						d.main(selectedRow);
					//DatePicker.main(args); 
					//}
				//	else {
				//		JOptionPane.showMessageDialog(null, gift[selectedRow].getName() + " date can't be changed");
					//}
				}
			}
				closeFile();
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