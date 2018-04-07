package proj;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class DatePicker {

	private JFrame frmSelectDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatePicker window = new DatePicker();
					window.frmSelectDate.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DatePicker() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSelectDate = new JFrame();
		frmSelectDate.setTitle("Select date");
		frmSelectDate.setBounds(100, 100, 257, 84);
		frmSelectDate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSelectDate.getContentPane().setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateChooser.setBounds(10, 11, 130, 20);
		frmSelectDate.getContentPane().add(dateChooser);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(142, 11, 89, 23);
		frmSelectDate.getContentPane().add(btnConfirm);
	}
}
