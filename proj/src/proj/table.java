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
		
			for (int i=0; i<rows.getNumberOfRows(); i++) {
				String[][] data = {gift[i].getName(), gift[i].getDate(), gift[i].getOwner()};
				
		};
		
		
		
		table = new JTable (data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500, 50));
		table.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
	}

}

