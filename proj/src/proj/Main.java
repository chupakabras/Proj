package proj;

public class Main {
	public static void main(String[] args) {
		
		ReadFile r = new ReadFile();
		r.openFile();
		r.readFile();
		r.closeFile();
	}
}
