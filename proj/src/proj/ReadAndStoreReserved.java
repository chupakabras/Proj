package proj;

public class ReadAndStoreReserved{
	private int rows;
	public ReservedBean[] store() {
		
		ReadReserved r = new ReadReserved();
		r.openFile();
		int rows = r.getNumberOfRows();
		this.rows = rows+1;
		String[] temp = new String[rows];
		String[] wordsplit = new String[5];
		
		ReservedBean[] gift = new ReservedBean[rows];
		
		for(int i=0; i<rows; i++) {
			gift[i] = new ReservedBean();
			temp[i] = r.getLine();
			wordsplit = temp[i].split(" ");
			wordsplit[0] = wordsplit[0].replace("_", " ");
			gift[i].setName(wordsplit[0]);
			gift[i].setDate(wordsplit[1]);
			gift[i].setBDate(wordsplit[2]);
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
