package properties;

import Resources.Cake;
import Resources.CakeShop;

public class Kitchen extends Thread {
	CakeShop cakeShop;
	
	public Kitchen(CakeShop cakeShop) {
		this.cakeShop = cakeShop;
	}

	@Override
	public void run() {
		while (true) {
			if (cakeShop.getTraySize() >= cakeShop.getMaxCakes()) {
				cakeShop.threadWait();
			}
			Cake cake = new Cake();
			cakeShop.addCake(cake);
			System.out.println("Producing a cake with id" + cake.getId());

			try {
				Thread.sleep(cakeShop.getTimeToProduce());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			if (cakeShop.getTraySize() > cakeShop.getMinThreshold()) {
				cakeShop.threadNotify();
			}
		}
	}

}
