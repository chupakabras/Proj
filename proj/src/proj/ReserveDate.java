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
	

	//String strI = Integer.toString(i);
	JTable table;
	public ReserveDate () {
		setLayout(new FlowLayout());
		String[] columnNames = {"Gift Name", "Reserved for" };
			String[][] data = new String[rows.getNumberOfRows()][2];
						for (int i=0; i<rows.getNumberOfRows(); i++) {
				data[i][0] = gift[i].getName();
				data[i][1] = gift[i].getDate().replace("_", " ");
				}		
		
		table = new JTable (data, columnNames);
		table.getColumnModel().getColumn(0).setPreferredWidth(270);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
		
		ListSelectionModel model = table.getSelectionModel();
		model.addListSelectionListener(new ListSelectionListener() {
			

			@Override
			public void valueChanged(ListSelectionEvent e) {
				String[] args = new String[1];
				if (! model.isSelectionEmpty())
				{
					int selectedRow = model.getMinSelectionIndex();
					Application.launch(DatePickerTest.class, args);
					
				}
			}
			
		});
	}
	
}