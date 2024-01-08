package application;
import properties.Kitchen;
import properties.PointOfSale;


import Resources.Cake;
import Resources.CakeShop;
import Resources.InputClass;

public class CakeShopSimulation extends Thread {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Enter the maximum number of cakes:");
		int maxCakes = InputClass.input.nextInt();

		System.out.print("Enter the minimum threshold to produce the cakes :");
		int minThreshold = InputClass.input.nextInt();

		System.out.print("Enter the minimum of amount of time the consumer waits:(give in milli seconds)");
		int timeToProduce = InputClass.input.nextInt();

		CakeShop cakeShop = new CakeShop(maxCakes, minThreshold, timeToProduce);

		Kitchen kitchen = new Kitchen(cakeShop);
		PointOfSale pointOfSale = new PointOfSale(cakeShop);

		Thread kitchenThread = new Thread(kitchen);
		Thread pointOfSaleThread = new Thread(pointOfSale);

		kitchenThread.start();
		pointOfSaleThread.start();
		while (true) {
			System.out.println("1. SELL CAKES : ");
			System.out.println("2. VIEW NUMBER OF CAKES : ");
			System.out.println("3. EXIT ");
			int choice = InputClass.input.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the needed cakes: ");
				int neededCakes = InputClass.input.nextInt();
				PointOfSale.listoforders.add(neededCakes);
				break;
			case 2:
				System.out.println("Total Cakes" + cakeShop.getTraySize());
				for (Cake cake : cakeShop.getTray()) {
					System.out.println(String.valueOf(cake.getId()));
				}
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Inavlid Input:Please enter the above specified options alone.");
				break;
			}
		}

	}
}
