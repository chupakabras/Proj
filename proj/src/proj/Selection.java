package proj;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	ReadCurrentDate currentDate = new ReadCurrentDate();
	JTable table;

	// Creating JTable to display the contents of GiftData.txt
	public Selection() {
		setLayout(new FlowLayout());
		String[] columnNames = { "Gift Name", "Available for", "Left", "Reserved" };
		String[][] data = new String[rows.getNumberOfRows()][4];
		for (int i = 0; i < rows.getNumberOfRows(); i++) {
			data[i][0] = gift[i].getName();
			data[i][1] = gift[i].getDate();
			data[i][2] = Integer.toString(gift[i].getRemaining());
			data[i][3] = Integer.toString(gift[i].getReserved());
		}

		table = new JTable(data, columnNames);
		table.getColumnModel().getColumn(0).setPreferredWidth(300);
		table.getColumnModel().getColumn(1).setPreferredWidth(85);
		table.getColumnModel().getColumn(2).setPreferredWidth(35);

		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);

		// Creating the refresh button
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Selection gui = new Selection();
				gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				gui.setResizable(false);
				gui.setSize(500, 500);
				gui.setVisible(true);
				gui.setTitle("Gift list");
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

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!model.isSelectionEmpty()) {
					if (!e.getValueIsAdjusting()) {

						int selectedRow = model.getMinSelectionIndex();
						if (gift[selectedRow].getRemaining() > 0) {
							DatePicker d = new DatePicker(selectedRow);
							d.main(selectedRow);
						} else {
							JOptionPane.showMessageDialog(null, gift[selectedRow].getName() + " is not avalaible");
						}
					}
				}
			}
		});
	}

}