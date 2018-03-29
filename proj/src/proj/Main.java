package proj;

import javax.swing.JFrame;
import java.awt.*;

public class Main {

	public static void main(String[] args) {

		ReadAndStore kek = new ReadAndStore();
		GiftBean[] gift = kek.store();
		// kek.printAll(gift);
		Table gui = new Table();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(1000, 600);
		gui.setVisible(true);
		gui.setTitle("Gift list"); 

		//System.out.println(gift[1].toString());
		Interface usr = new Interface();
		usr.setName();
		System.out.println(usr.getName());

	}
}
