package proj;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartUP {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartUP window = new StartUP();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
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
	public StartUP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 282, 83);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		JButton btnReserve = new JButton("Your Reservations");
		btnReserve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0) {
				/*
				ReserveDate s = new ReserveDate();
				s.setVisible(true);	
				*/
				ReserveDate gui = new ReserveDate();
				gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				gui.setSize(600, 500);
				gui.setVisible(true);
				gui.setTitle("Reserve Date");
				gui.setResizable(false);
				
			}
		});
		btnReserve.setBounds(10, 11, 147, 23);
		frame.getContentPane().add(btnReserve);
		
		JButton btnBuy = new JButton("Gift Shop");
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
		btnBuy.setBounds(167, 11, 89, 23);
		frame.getContentPane().add(btnBuy);
	}
}
