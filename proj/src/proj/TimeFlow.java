package proj;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Formatter;
import java.awt.event.ActionEvent;

public class TimeFlow {
	private DateBean date = new DateBean();
	private Formatter x;

	JFrame frmTimeControl;

	// Invoking the time control window
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimeFlow window = new TimeFlow();
					window.frmTimeControl.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TimeFlow() {
		initialize();
	}

	private void initialize() {
		frmTimeControl = new JFrame();
		frmTimeControl.setTitle("Time control");
		frmTimeControl.setBounds(100, 100, 164, 145);
		frmTimeControl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTimeControl.getContentPane().setLayout(null);
		frmTimeControl.setResizable(false);

		ReadAndStoreDate kek = new ReadAndStoreDate();
		DateBean date = kek.store();
		this.date = date;
		openFile();
		addDate();
		closeFile();

		// Button for adding one day to the date
		JButton btnNewButton_3 = new JButton("1 day forward");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Date logic implementation
				if (date.getDay() == 28 && date.getMonth() == 2 && date.getYear() % 4 != 0) {
					date.setMonth(3);
					date.setDay(1);
				} else if (date.getDay() == 29 && date.getMonth() == 2) {
					date.setMonth(3);
					date.setDay(1);
				}

				else if (date.getDay() == 30 && (date.getMonth() == 4 || date.getMonth() == 6 || date.getMonth() == 9
						|| date.getMonth() == 11)) {
					date.setMonth(date.getMonth() + 1);
					date.setDay(1);
				} else if (date.getDay() == 31 && (date.getMonth() == 1 || date.getMonth() == 3 || date.getMonth() == 5
						|| date.getMonth() == 7 || date.getMonth() == 8 || date.getMonth() == 10)) {
					date.setDay(1);
					date.setMonth(date.getMonth() + 1);

				} else if (date.getMonth() == 12 && date.getDay() == 31) {
					date.setDay(1);
					date.setMonth(1);
					date.setYear(date.getYear() + 1);
				} else
					date.setDay(date.getDay() + 1);

				openFile();
				addDate();
				closeFile();
				// System.out.println(date.toString()); //print current date to the console

			}

		});
		btnNewButton_3.setBounds(10, 11, 130, 39);
		frmTimeControl.getContentPane().add(btnNewButton_3);

		// Button for adding one month to the date
		JButton btnNewButton_5 = new JButton("1 month forward");
		btnNewButton_5.addActionListener(new ActionListener() {

			// Date logic implementation
			public void actionPerformed(ActionEvent e) {
				if (date.getMonth() == 12) {
					date.setMonth(1);
					date.setYear(date.getYear() + 1);
				} else {
					date.setMonth(date.getMonth() + 1);
					if ((date.getMonth() == 4 || date.getMonth() == 6 || date.getMonth() == 9 || date.getMonth() == 11)
							&& date.getDay() == 31) {
						date.setDay(30);
					} else if (date.getMonth() == 2 && date.getDay() > 28 && date.getYear() % 4 != 0) {
						date.setDay(28);
					} else if (date.getMonth() == 2 && date.getDay() > 29 && date.getYear() % 4 == 0) {
						date.setDay(29);
					}
				}
				openFile();
				addDate();
				closeFile();
				// System.out.println(date.toString()); //print current date to the console
			}
		});
		btnNewButton_5.setBounds(10, 61, 130, 39);
		frmTimeControl.getContentPane().add(btnNewButton_5);
	}

	public String getDate() {
		return date.toString();
	}

	public void openFile() {
		try {
			x = new Formatter(new File("CurrentDate.txt"));
		} catch (Exception e) {
			System.out.println("An error has occured while trying to read data file.");
		}
	}

	public void closeFile() {
		x.close();
	}

	public void addDate() {
		x.format("%s", getDate());
	}
}
