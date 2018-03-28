package proj;

import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
