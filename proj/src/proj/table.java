package proj;

import javax.swing.*;
import java.awt.*;

public class table extends JFrame{
	JTable table;
	ReadAndStore kek = new ReadAndStore();
	GiftBean[] gift = kek.store();
	ReadFile rows = new ReadFile();
	public table() {
		setLayout(new FlowLayout());
		String[] columnNames = {"Gift Name", "When can be ordered", "Order info"};
			String[][] data = new String[rows.getNumberOfRows()][3];
			for (int i=0; i<rows.getNumberOfRows(); i++) {
				data[i][0] = gift[i].getName();
				data[i][1] = gift[i].getDate();
				data[i][2] = gift[i].getOwner();
				}		
		};
		
		
		//lalala
		table = new JTable (data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500, 50));
		table.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
	}

}

