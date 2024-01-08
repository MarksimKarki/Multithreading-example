package Resources;

import java.util.LinkedList;
import java.util.Queue;

public class CakeShop {
	private static int cakeCount = 0;
	private Queue<Cake> tray;
	private int maxCakes = 5;
	private int minThreshold = 2;
	private int timeToProduce = 10;

	public CakeShop(int maxCakes, int minThreshold, int timeToProduce) {
		this.maxCakes = maxCakes;
		this.minThreshold = minThreshold;
		this.timeToProduce = timeToProduce;
		tray = new LinkedList<>();
	}
	
	public synchronized void threadWait() {
		try {
			wait();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	public synchronized void threadNotify() {
			notifyAll();
	}

	public void removeCake() {
		tray.remove();
	}

	public Queue<Cake> getTray() {
		return tray;
	}

	public void setTray(Queue<Cake> tray) {
		this.tray = tray;
	}

	public void addCake(Cake cake) {
		tray.add(cake);
	}

	public int getTraySize() {
		return tray.size();
	}

	public int getMaxCakes() {
		return maxCakes;
	}

	public void setMaxCakes(int maxCakes) {
		this.maxCakes = maxCakes;
	}

	public int getMinThreshold() {
		return minThreshold;
	}

	public void setMinThreshold(int minThreshold) {
		this.minThreshold = minThreshold;
	}

	public int getTimeToProduce() {
		return timeToProduce;
	}

	public void setTimeToProduce(int timeToProduce) {
		this.timeToProduce = timeToProduce;
	}

	public static void setCakeCount(int cakeCount) {
		CakeShop.cakeCount = cakeCount;
	}

	public static int getCakeCount() {
		return cakeCount;
	}

	public static void produceCake() {
		cakeCount++;
		System.out.println("Producing a cake. Total cakes: " + cakeCount);
	}

	public static void sellCake(int quantity) {
		if (cakeCount >= quantity) {
			cakeCount -= quantity;
			System.out.println("Selling " + quantity + " cakes. Remaining cakes: " + cakeCount);
		} else {
			System.out.println("Not enough cakes in the shop.");
		}
	}
}
