package proj;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TimeFlow {
	private DateBean date = new DateBean();
	
	private JFrame frmTimeControl;

	/**
	 * Launch the application.
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
		frmTimeControl.setBounds(100, 100, 297, 196);
		frmTimeControl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTimeControl.getContentPane().setLayout(null);
		
		ReadAndStoreDate kek = new ReadAndStoreDate();
		DateBean date = kek.store();
		this.date = date;
		
		JButton btnNewButton = new JButton("1 day back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println(date.toString());
				
			}
		});
		btnNewButton.setBounds(10, 11, 101, 34);
		frmTimeControl.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("1 month back");
		btnNewButton_1.setBounds(10, 56, 101, 39);
		frmTimeControl.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("1 year back");
		btnNewButton_2.setBounds(10, 106, 101, 39);
		frmTimeControl.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("1 day forward");
		btnNewButton_3.setBounds(157, 11, 113, 34);
		frmTimeControl.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("1 month forward");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(157, 56, 113, 39);
		frmTimeControl.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("1 year forward");
		btnNewButton_5.setBounds(157, 106, 113, 39);
		frmTimeControl.getContentPane().add(btnNewButton_5);
	}
}
