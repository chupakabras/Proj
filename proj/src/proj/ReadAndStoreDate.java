package proj;

public class ReadAndStoreDate{
	private int rows;
	public DateBean store() {
		
		ReadDate r = new ReadDate();
		r.openFile();
		String temp;
		String[] wordsplit = new String[4];
		
		DateBean date = new DateBean();
		
			temp = r.readDate();
			wordsplit = temp.split("-");

			date.setYear(Integer.parseInt(wordsplit[0]));
			date.setMonth(Integer.parseInt(wordsplit[1]));
			date.setDay(Integer.parseInt(wordsplit[2]));

		r.closeFile();
		
		return date;
	}
	
	public void printAll(GiftBean[] gift) {
		for(int i=0; i<rows; i++) {
			System.out.println(gift[i].toString());
		}
	}
}
