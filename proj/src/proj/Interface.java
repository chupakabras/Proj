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
	
	JComboBox box = new JComboBox(time);
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
		f.setSize(300,200);
		f.setVisible(true);
		
		JPanel p = new JPanel();
		p.add(box);
		p.add(button);
		
		f.add(p);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String d = box.getSelectedItem().toString();
				System.out.println(d);
			}
		}
				);
	}
	public Interface() {

		frame();
		
	}

}
