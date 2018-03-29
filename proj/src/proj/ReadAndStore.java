package proj;

public class ReadAndStore{
	private int rows;
	public GiftBean[] store() {
		
		ReadFile r = new ReadFile();
		r.openFile();
		int rows = r.getNumberOfRows();
		this.rows = rows;
		String[] temp = new String[rows];
		String[] wordsplit = new String[4];
		
		GiftBean[] gift = new GiftBean[rows];
		
		for(int i=0; i<rows; i++) {
			gift[i] = new GiftBean();
			temp[i] = r.getLine();
			wordsplit = temp[i].split(" ");
			wordsplit[0] = wordsplit[0].replace("_", " ");
			gift[i].setName(wordsplit[0]);
			gift[i].setDate(wordsplit[1]);
			gift[i].setRemaining(Integer.parseInt(wordsplit[2]));
			gift[i].setReserved(Integer.parseInt(wordsplit[3]));
			
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
