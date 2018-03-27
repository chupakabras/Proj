package proj;

public class Main {
	
	public static void main(String[] args) {
		
		ReadAndStore kek = new ReadAndStore();
		GiftBean[] gift = kek.store();
		kek.printAll(gift);
	}
}

