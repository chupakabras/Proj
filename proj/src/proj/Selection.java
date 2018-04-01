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
	
	public static void main(String[] args) {
		
	Selection s = new Selection();
	s.setVisible(true);	
	
	Selection gui = new Selection();
	gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	gui.setSize(1000, 600);
	gui.setVisible(true);
	gui.setTitle("Gift list");
	
	}
	//String strI = Integer.toString(i);
	JTable table;
	public Selection () {
		setLayout(new FlowLayout());
		String[] columnNames = {"Gift Name", "When can be ordered", "Order info"};
			String[][] data = new String[rows.getNumberOfRows()][4];
						for (int i=0; i<rows.getNumberOfRows(); i++) {
				data[i][0] = gift[i].getName();
				data[i][1] = gift[i].getDate();
				data[i][2] = Integer.toString(gift[i].getRemaining());
				data[i][3] = Integer.toString(gift[i].getReserved());
				}		
		
		table = new JTable (data, columnNames);
		
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
		
		ListSelectionModel model = table.getSelectionModel();
		model.addListSelectionListener(new ListSelectionListener() {
			

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (! model.isSelectionEmpty())
				{
					int selectedRow = model.getMinSelectionIndex();
					JOptionPane.showMessageDialog(null, "Selected Row "+selectedRow);
					
					//Kodas, kad irasytu pasirinktos eilutes duomenis i faila
				}
			}
			
		});
	}
	
}