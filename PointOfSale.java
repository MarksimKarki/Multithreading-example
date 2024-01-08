package properties;

import java.util.ArrayList;
import java.util.List;

import Resources.CakeShop;

public class PointOfSale extends Thread {
	CakeShop cakeShop;
	public static List<Integer> listoforders = new ArrayList<>();

	public PointOfSale(CakeShop cakeShop) {
		this.cakeShop = cakeShop;
	}

	public void run() {

		while (true) {
			try {
				Thread.sleep(1000);
				if (!listoforders.isEmpty()) {
					sellCakes();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void sellCakes() throws InterruptedException {
		if (!listoforders.isEmpty()) {
			if (listoforders.get(0) == 0) {
				listoforders.remove(0);
				System.out.println("1 Order Over..... ");
			}

			else if (listoforders.get(0) > 0) {
				if (cakeShop.getTraySize() == 0) {
					System.out.println("Tray is empty please Wait...");
					cakeShop.threadWait();
				}
				System.out.println("Cake sellling id:" + cakeShop.getTray().peek().getId());
				cakeShop.removeCake();
				listoforders.set(0, listoforders.get(0) - 1);
				Thread.sleep(100);
				if (cakeShop.getTraySize() <= cakeShop.getMinThreshold()) {
					cakeShop.threadNotify();
				}
			}
		}
	}

}
