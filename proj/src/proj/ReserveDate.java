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

public class ReserveDate {
	
	ReadAndStoreReserved kek = new ReadAndStoreReserved();
	ReservedBean[] gift = kek.store();
	ReadReserved rows = new ReadReserved();
	
	JTable table;
	public ReserveDate () {
		setLayout(new FlowLayout());
		String[] columnNames = {"Gift Name", "Date"};
			String[][] data = new String[rows.getNumberOfRows()][2];
						for (int i=0; i<rows.getNumberOfRows(); i++) {
				data[i][0] = gift[i].getName();
				data[i][1] = gift[i].getDate();
				}		
		
		table = new JTable (data, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		add (scrollPane);
	
	
	ListSelectionModel model = table.getSelectionModel();
	model.addListSelectionListener(new ListSelectionListener() {
		

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (! model.isSelectionEmpty())
			{
				int selectedRow = model.getMinSelectionIndex();
				JOptionPane.showMessageDialog(null, gift[selectedRow].getName() + " is selected");
				
				//gift[selectedRow].setReserved(gift[selectedRow].getReserved() + 1);
				//gift[selectedRow].setRemaining(gift[selectedRow].getRemaining() - 1);
				//EditGiftData edit = new EditGiftData();
				//edit.writeFile(rows.getNumberOfRows(), gift);
			}
		}
		
	});
}
	private void setLayout(FlowLayout flowLayout) {
		// TODO Auto-generated method stub
	}
	private void add(JScrollPane scrollPane) {
		// TODO Auto-generated method stub
		
	}
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	public void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub
		
	}
	public void setSize(int i, int j) {
		// TODO Auto-generated method stub
		
	}
	public void setTitle(String string) {
		// TODO Auto-generated method stub
		
	}
	
}
