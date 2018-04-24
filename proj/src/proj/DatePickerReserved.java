package proj;
//
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DatePickerReserved {

	private String year;
	private String month;
	private String day;
	private String date;
	private int row;
	private int selectedRow;
	
	ReadAndStoreReserved kek = new ReadAndStoreReserved();
	ReservedBean[] check = kek.store();

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public void main(int selectedRow) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatePickerReserved window = new DatePickerReserved(selectedRow);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public DatePickerReserved(int selectedRow) {
	
		initialize(selectedRow);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int selectedRow) {
		frame = new JFrame();
		frame.setBounds(100, 100, 292, 146);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JComboBox comboBox = new JComboBox();
		JComboBox comboBox2 = new JComboBox();
		JComboBox comboBox3 = new JComboBox();

		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Year", "2018", "2019", "2020" }));
		comboBox.setToolTipText("Year");
		comboBox.setBounds(10, 38, 77, 22);
		frame.getContentPane().add(comboBox);

		JLabel lblSelectDate = new JLabel("Select date");
		lblSelectDate.setBounds(105, 11, 119, 22);
		frame.getContentPane().add(lblSelectDate);

		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED)
					setYear((String) comboBox.getSelectedItem());

				comboBox2.setModel(new DefaultComboBoxModel(new String[] {"Month", "1", "2", "3", "4",
						"5", "6", "7", "8", "9", "10", "11", "12" }));
				comboBox2.setToolTipText("Month");
				comboBox2.setBounds(100, 38, 90, 22);
				frame.getContentPane().add(comboBox2);

				comboBox2.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent event) {
						if (event.getStateChange() == ItemEvent.SELECTED) {
							
							
							setMonth((String) comboBox2.getSelectedItem());
							
							if (getMonth().equals("1") || getMonth().equals("3") || getMonth().equals("5")
									|| getMonth().equals("8") || getMonth().equals("10")
									|| getMonth().equals("12") || getMonth().equals("7")) {
								comboBox3.setModel(new DefaultComboBoxModel(new String[] {"Day", "1", "2", "3", "4", "5", "6",
										"7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
										"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
								comboBox3.setToolTipText("Day");
								comboBox3.setBounds(210, 38, 50, 22);
								frame.getContentPane().add(comboBox3);
								if (event.getStateChange() == ItemEvent.SELECTED)
									setDay((String) comboBox3.getSelectedItem());

								JButton btnSelectThisDate = new JButton("Select this date");
								btnSelectThisDate.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										setDay((String) comboBox3.getSelectedItem());
										setDate();
										boolean bounds = false;
										if (getYear() == "Year" && getMonth() == "Month" && getDay() == "Day") {
											JOptionPane.showMessageDialog(null, "Please select year, month and day");
											return;
										}
										else if (getYear() == "Year" && getMonth() == "Month") {
											JOptionPane.showMessageDialog(null, "Please select year and month");
											return;
										}
										else if (getYear() == "Year" && getDay() == "Day") {
											JOptionPane.showMessageDialog(null, "Please select year and day");
											return;
										}
										else if (getMonth() == "Month" && getDay() == "Day") {
											JOptionPane.showMessageDialog(null, "Please select month and day");
											return;
										}
										else if (getYear()== "Year") {
											JOptionPane.showMessageDialog(null, "Please select year");
											return;
										}
										else if (getMonth() == "Month") {
											JOptionPane.showMessageDialog(null, "Please select month");
											return;
										}
										else if (getDay() == "Day") {
											JOptionPane.showMessageDialog(null, "Please select day");
											return;
										}
										
										for(int k=1; k<=12; k++) {
											if(Integer.parseInt(getMonth()) == k && check[selectedRow].getFrom() <= k && check[selectedRow].getTo() >= k) {
												 bounds = true;
											}
										}
										if(bounds == false) {
											JOptionPane.showMessageDialog(null, check[selectedRow].getName() + " is not avalaible for "+ getMonth());
										return;
										}
										
										ReadAndStoreReserved kek = new ReadAndStoreReserved();
										ReservedBean[] gift = kek.store();
										ReadReserved rows = new ReadReserved();
										gift[selectedRow].setDate(getDate());
										EditReservedData reformat = new EditReservedData();
										reformat.writeFile(rows.getNumberOfRows(), gift);
										frame.setVisible(false);


									}
								});
								btnSelectThisDate.setBounds(77, 71, 130, 23);
								frame.getContentPane().add(btnSelectThisDate);
								frame.repaint();

							} else if (getMonth().equals("4") || getMonth().equals("6")
									|| getMonth().equals("9") || getMonth().equals("11")) {
								comboBox3.setModel(new DefaultComboBoxModel(new String[] {"Day", "1", "2", "3", "4", "5", "6",
										"7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
										"21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
								comboBox3.setToolTipText("Day");
								comboBox3.setBounds(210, 38, 50, 22);
								frame.getContentPane().add(comboBox3);
								if (event.getStateChange() == ItemEvent.SELECTED)
									setDay((String) comboBox3.getSelectedItem());

								JButton btnSelectThisDate = new JButton("Select this date");
								btnSelectThisDate.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										setDay((String) comboBox3.getSelectedItem());
										setDate();
										boolean bounds = false;
										if (getYear() == "Year" && getMonth() == "Month" && getDay() == "Day") {
											JOptionPane.showMessageDialog(null, "Please select year, month and day");
											return;
										}
										else if (getYear() == "Year" && getMonth() == "Month") {
											JOptionPane.showMessageDialog(null, "Please select year and month");
											return;
										}
										else if (getYear() == "Year" && getDay() == "Day") {
											JOptionPane.showMessageDialog(null, "Please select year and day");
											return;
										}
										else if (getMonth() == "Month" && getDay() == "Day") {
											JOptionPane.showMessageDialog(null, "Please select month and day");
											return;
										}
										else if (getYear()== "Year") {
											JOptionPane.showMessageDialog(null, "Please select year");
											return;
										}
										else if (getMonth() == "Month") {
											JOptionPane.showMessageDialog(null, "Please select month");
											return;
										}
										else if (getDay() == "Day") {
											JOptionPane.showMessageDialog(null, "Please select day");
											return;
										}

										for(int k=1; k<=12; k++) {
											if(Integer.parseInt(getMonth()) == k && check[selectedRow].getFrom() <= k && check[selectedRow].getTo() >= k) {
												 bounds = true;
											}
										}
										if(bounds == false) {
											JOptionPane.showMessageDialog(null, check[selectedRow].getName() + " is not avalaible for "+ getMonth());
										return;
										}

										ReadAndStoreReserved kek = new ReadAndStoreReserved();
										ReservedBean[] gift = kek.store();
										ReadReserved rows = new ReadReserved();
										gift[selectedRow].setDate(getDate());
										EditReservedData reformat = new EditReservedData();
										reformat.writeFile(rows.getNumberOfRows(), gift);
										frame.setVisible(false);

									}
								});
								btnSelectThisDate.setBounds(77, 71, 130, 23);
								frame.getContentPane().add(btnSelectThisDate);
								frame.repaint();

							} else if (getMonth().equals("2")) {
								comboBox3.setModel(new DefaultComboBoxModel(new String[] {"Day", "1", "2", "3", "4", "5", "6",
										"7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
										"21", "22", "23", "24", "25", "26", "27", "28" }));
								comboBox3.setToolTipText("Day");
								comboBox3.setBounds(210, 38, 50, 22);
								frame.getContentPane().add(comboBox3);
								if (event.getStateChange() == ItemEvent.SELECTED) {
									setDay((String) comboBox3.getSelectedItem());

									JButton btnSelectThisDate = new JButton("Select this date");
									btnSelectThisDate.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
											setDay((String) comboBox3.getSelectedItem());
											setDate();
											boolean bounds = false;
											if (getYear() == "Year" && getMonth() == "Month" && getDay() == "Day") {
												JOptionPane.showMessageDialog(null, "Please select year, month and day");
												return;
											}
											else if (getYear() == "Year" && getMonth() == "Month") {
												JOptionPane.showMessageDialog(null, "Please select year and month");
												return;
											}
											else if (getYear() == "Year" && getDay() == "Day") {
												JOptionPane.showMessageDialog(null, "Please select year and day");
												return;
											}
											else if (getMonth() == "Month" && getDay() == "Day") {
												JOptionPane.showMessageDialog(null, "Please select month and day");
												return;
											}
											else if (getYear()== "Year") {
												JOptionPane.showMessageDialog(null, "Please select year");
												return;
											}
											else if (getMonth() == "Month") {
												JOptionPane.showMessageDialog(null, "Please select month");
												return;
											}
											else if (getDay() == "Day") {
												JOptionPane.showMessageDialog(null, "Please select day");
												return;
											}
											
											for(int k=1; k<=12; k++) {
												if(Integer.parseInt(getMonth()) == k && check[selectedRow].getFrom() <= k && check[selectedRow].getTo() >= k) {
													 bounds = true;
												}
											}
											if(bounds == false) {
												JOptionPane.showMessageDialog(null, check[selectedRow].getName() + " is not avalaible for "+ getMonth());
											return;
											}
											
											ReadAndStoreReserved kek = new ReadAndStoreReserved();
											ReservedBean[] gift = kek.store();
											ReadReserved rows = new ReadReserved();
											gift[selectedRow].setDate(getDate());
											EditReservedData reformat = new EditReservedData();
											reformat.writeFile(rows.getNumberOfRows(), gift);
											frame.setVisible(false);

										}
									});
									btnSelectThisDate.setBounds(77, 71, 130, 23);
									frame.getContentPane().add(btnSelectThisDate);
									frame.repaint();

								}
							}
						}
					}
				});

			}
		});
	}

	private void setYear(String year) {
		this.year = year;
	}

	private String getYear() {
		return year;
	}

	private void setMonth(String month) {
		this.month = month;
	}

	private String getMonth() {
		return month;
	}

	private void setDay(String day) {
		this.day = day;
	}

	private String getDay() {
		return day;
	}
	private void setDate() {
		date = year + "-" + month + "-" + day;
	}

	private String getDate() {
		return date;
	}

	public void setRow(int row) {
		this.row = row;
	}

}
