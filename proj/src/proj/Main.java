package proj;

public class Main {
	private int rows;
	
	public static void main(String[] args) {
		
		Main kek = new Main();
		GiftBean[] gift = kek.store();
		kek.printAll(gift);
	}
	
	public GiftBean[] store() {
		
		ReadFile r = new ReadFile();
		r.openFile();
		int rows = r.getNumberOfRows();
		this.rows = rows;
		String[] temp = new String[rows];
		String[] wordsplit = new String[3];
		
		GiftBean[] gift = new GiftBean[rows];
		
		for(int i=0; i<rows; i++) {
			gift[i] = new GiftBean();
			temp[i] = r.getLine();
			wordsplit = temp[i].split(" ");
			wordsplit[0] = wordsplit[0].replace("_", " ");
			gift[i].setName(wordsplit[0]);
			gift[i].setDate(wordsplit[1]);
			gift[i].setOwner(wordsplit[2]);
		}
		r.closeFile();
		
		return gift;
	}
	
	public void printAll(GiftBean[] gift) {
		for(int i=0; i<rows; i++) {
			System.out.println(gift[i].toString());
		}
	}
}
