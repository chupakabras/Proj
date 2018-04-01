/*package proj;

import javax.swing.*;
import java.awt.*;

public class Table extends JFrame {
	JTable table;
	ReadAndStore kek = new ReadAndStore();
	GiftBean[] gift = kek.store();
	ReadFile rows = new ReadFile();
	
	public Table() {
		setLayout(new FlowLayout());
		String[] columnNames = {"Gift Name", "When can be ordered", "Remaining", "Reserved"};
			String[][] data = new String[rows.getNumberOfRows()][4];
			for (int i=0; i<rows.getNumberOfRows(); i++) {
				data[i][0] = gift[i].getName();
				data[i][1] = gift[i].getDate();
				data[i][2] = Integer.toString(gift[i].getRemaining());
				data[i][3] = Integer.toString(gift[i].getReserved());
				}		
		
		table = new JTable (data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(700, 300));
		table.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
		};
	}

*/

