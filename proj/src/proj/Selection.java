package proj;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Selection extends JFrame {
	
	public static void main(String[] args) {		 
		 
		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				Selection s = new Selection();
				s.setVisible(true);	
				*/
				
				Selection gui = new Selection();
				gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				gui.setResizable(false);
				gui.setSize(500, 500);
				gui.setVisible(true);
				gui.setTitle("Gift list");
				
			}
		});
		btnBuy.setBounds(109, 11, 89, 23);
		//frame.getContentPane().add(btnBuy);
	

	}	
	
	ReadAndStore kek = new ReadAndStore();
	GiftBean[] gift = kek.store();
	ReadFile rows = new ReadFile();
	private int i = 0;
	
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
				DatePicker d = new DatePicker();
				String[] args = new String[1];
				if (! model.isSelectionEmpty())
				{
					int selectedRow = model.getMinSelectionIndex();
					if (i%2==0) {
					
					d.main(args);

					//DatePicker.main(args);
					}
					i++;
					if (gift[selectedRow].getRemaining()>0){
					//JOptionPane.showMessageDialog(null, gift[selectedRow].getName() + " is selected");
					gift[selectedRow].setReserved(gift[selectedRow].getReserved() + 1);
					gift[selectedRow].setRemaining(gift[selectedRow].getRemaining() - 1);
					EditGiftData edit = new EditGiftData();
					edit.writeFile(rows.getNumberOfRows(), gift);
					EditReservedData rowadd = new EditReservedData();
					rowadd.addRow(selectedRow, gift, d.getDate());
					}
				else {
					JOptionPane.showMessageDialog(null, gift[selectedRow].getName() + " is not available");
					i=0;
					}
				}
			}

		});
	}
}