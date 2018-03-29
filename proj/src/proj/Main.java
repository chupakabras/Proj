package proj;

import javax.swing.JFrame;
import java.awt.*;

public class Main {

	public static void main(String[] args) {

		ReadAndStore kek = new ReadAndStore();
		GiftBean[] gift = kek.store();
		// kek.printAll(gift);
		table gui = new table();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(1000, 600);
		gui.setVisible(true);
		gui.setTitle("Gift list"); 

		//System.out.println(gift[1].toString());
		//new Interface();
	//	pick.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	pick.setSize(300,200);
	//	pick.setVisible(true);
		// Interface usr = new Interface();
		// usr.setName();
		// System.out.println(usr.getName());
		///
	}
}
