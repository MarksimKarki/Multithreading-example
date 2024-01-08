package Resources;

public class Cake {
	private static int nextId=1;
	private int id;
	
	public Cake(){
		this.id=nextId++;
	}

	public int getId() {
		return id;
	}
	public void increment() {
		nextId++;
	}
}
