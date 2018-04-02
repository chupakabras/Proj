package proj;

import java.awt.EventQueue;

import javax.swing.JFrame;
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
		frame.setBounds(100, 100, 223, 87);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnReserve = new JButton("Reserve");
		btnReserve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0) {
				
				ReserveDate s = new ReserveDate();
				s.setVisible(true);	
				
				ReserveDate gui = new ReserveDate();
				gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gui.setSize(500, 500);
				gui.setVisible(true);
				gui.setTitle("Reserve Date");
				
			}
		});
		btnReserve.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnReserve);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Selection s = new Selection();
				s.setVisible(true);	
				
				Selection gui = new Selection();
				gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gui.setSize(500, 500);
				gui.setVisible(true);
				gui.setTitle("Gift list");
				
			}
		});
		btnBuy.setBounds(109, 11, 89, 23);
		frame.getContentPane().add(btnBuy);
	}
}
