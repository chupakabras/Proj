package proj;

public class Main {
	
	public static void main(String[] args) {
		
		ReadAndStore kek = new ReadAndStore();
		GiftBean[] gift = kek.store();
	//	kek.printAll(gift);
		
		System.out.println(gift[1].toString());
		
	//	Interface usr = new Interface();
	//	usr.setName();
	//	System.out.println(usr.getName());
		///
	}
}

