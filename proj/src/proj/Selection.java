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

public class Selection extends JFrame {
	
	ReadAndStore kek = new ReadAndStore();
	GiftBean[] gift = kek.store();
	ReadFile rows = new ReadFile();
	

	//String strI = Integer.toString(i);
	JTable table;
	public Selection () {
		setLayout(new FlowLayout());
		String[] columnNames = {"Gift Name", "When can be ordered", "Left","Reserved" };
			String[][] data = new String[rows.getNumberOfRows()][4];
						for (int i=0; i<rows.getNumberOfRows(); i++) {
				data[i][0] = gift[i].getName();
				data[i][1] = gift[i].getDate();
				data[i][2] = Integer.toString(gift[i].getRemaining());
				data[i][3] = Integer.toString(gift[i].getReserved());
				}		
		
		table = new JTable (data, columnNames);
		table.getColumnModel().getColumn(0).setPreferredWidth(270);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
		
		ListSelectionModel model = table.getSelectionModel();
		model.addListSelectionListener(new ListSelectionListener() {
			

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (! model.isSelectionEmpty())
				{
					int selectedRow = model.getMinSelectionIndex();
					
				if (gift[selectedRow].getRemaining()>0){
					JOptionPane.showMessageDialog(null, gift[selectedRow].getName() + " is selected");
					gift[selectedRow].setReserved(gift[selectedRow].getReserved() + 1);
					gift[selectedRow].setRemaining(gift[selectedRow].getRemaining() - 1);
					EditGiftData edit = new EditGiftData();
					edit.writeFile(rows.getNumberOfRows(), gift);
					EditReservedData rowadd = new EditReservedData();
					rowadd.addRow(selectedRow, gift);
					}
				else {
					JOptionPane.showMessageDialog(null, gift[selectedRow].getName() + " is not available");
					}
				}
			}
			
		});
	}
	
}