package proj;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;

public class TimeFlow {
	private DateBean date = new DateBean();
	
	JFrame frmTimeControl;

	/**
	 * Launch the application./
	 */
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

	/**
	 * Create the application.
	 */
	public TimeFlow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
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
		
		JButton btnNewButton_3 = new JButton("1 day forward");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

						if(date.getDay() == 28 && date.getMonth() == 2 && date.getYear()%4!=0) {
							date.setMonth(3);
							date.setDay(1);
						}
						else if(date.getDay() == 29 && date.getMonth() == 2) {
							date.setMonth(3);
							date.setDay(1);
						}
						
						else if(date.getDay() == 30 && (date.getMonth() == 4 || date.getMonth() == 6 || date.getMonth() == 9 ||date.getMonth() == 11)) {
							date.setMonth(date.getMonth() + 1);
							date.setDay(1);
						}
						else if(date.getDay() == 31 && (date.getMonth() == 1 || date.getMonth() == 3 || date.getMonth() == 5 || date.getMonth() == 7 || date.getMonth() == 8 || date.getMonth() == 10)) {
							date.setDay(1);
							date.setMonth(date.getMonth() + 1);

						}
						else if(date.getMonth() == 12 && date.getDay() == 31){
							date.setDay(1);
							date.setMonth(1);
							date.setYear(date.getYear() + 1);
						}
						else
							date.setDay(date.getDay() + 1);

					System.out.println(date.toString());
				}
		
		});
		btnNewButton_3.setBounds(10, 11, 130, 39);
		frmTimeControl.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("1 month forward");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(date.getMonth() == 12) {
					date.setMonth(1);
					date.setYear(date.getYear() + 1);
				}
				else {
					date.setMonth(date.getMonth() + 1);
					if((date.getMonth() == 4 || date.getMonth() == 6 || date.getMonth() == 9 || date.getMonth() == 11) && date.getDay() == 31) {
						date.setDay(30);
					}
					else if(date.getMonth() == 2 && date.getDay()>28 && date.getYear()%4!=0) {
						date.setDay(28);
					}
					else if(date.getMonth() == 2 && date.getDay()>29 && date.getYear()%4 == 0) {
						date.setDay(29);
					}
				}
				
				System.out.println(date.toString());
			}
		});
		btnNewButton_5.setBounds(10, 61, 130, 39);
		frmTimeControl.getContentPane().add(btnNewButton_5);
	}
	
	public String getDate() {
		return date.toString();
	}
}
