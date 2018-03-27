package proj;

public class Main {
	public static void main(String[] args) {
		
		Main kek = new Main();
		GiftBean[] gift = kek.store();
	}
	
	public GiftBean[] store() {
		
		ReadFile r = new ReadFile();
		r.openFile();
		int rows = r.getNumberOfRows();
		String[] temp = new String[rows];
		String[] wordsplit = new String[3];
		
		GiftBean[] gift = new GiftBean[rows];
		
		for(int i=0; i<rows; i++) {
			gift[i] = new GiftBean();
			temp[i] = r.getLine();
			wordsplit = temp[i].split(" ");
			gift[i].setName(wordsplit[0]);
			gift[i].setDate(wordsplit[1]);
			gift[i].setOwner(wordsplit[2]);
		}
		return gift;
	}
}
