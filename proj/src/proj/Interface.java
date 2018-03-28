package proj;

import javax.swing.JOptionPane;

public class Interface {
	private String userName;
	public void setName() {
	this.userName = JOptionPane.showInputDialog("Enter your name");
	}
	
	public String getName() {
		return userName;
	}
}
//
