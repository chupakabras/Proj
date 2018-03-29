package proj;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Interface extends JFrame {
	private String userName;
	//private JComboBox box;
	

	private static String[] time = { "2017", "2018", "2019" };
	private static String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	
	JComboBox box = new JComboBox(time);
	JComboBox box2 = new JComboBox(month);
	JButton button = new JButton("Check");
	JLabel label = new JLabel();
	
	public void setName() {
		this.userName = JOptionPane.showInputDialog("Enter your name");
	}

	public String getName() {
		return userName;
	}
	
	public void frame() {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(220,85);
		f.setVisible(true);
		
		JPanel p = new JPanel();
		p.add(box);
		p.add(box2);
		p.add(button);
		
		f.add(p);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println(box.getSelectedItem().toString());
				System.out.println(box2.getSelectedItem().toString());
			}
		}
				);
	}
	public Interface() {

		frame();
		
	}

}
