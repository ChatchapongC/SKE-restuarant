import java.util.Scanner;

/**
 * Main class for SKE Restaurant order taking application. It displays a menu
 * and accepts items to order. When done, it prints a receipt including the
 * order total.
 *
 * @author Chatchapong Chumpada
 */

public class SKErestaurant {
        
	public static Scanner console = new Scanner(System.in);
	static String[] menuItem = { "Steak", "Spaghetti", "Salad", "Juice" };
	static double[] menuPrice = { 299, 150, 100, 25 };
        static int quantity = 0;
	static int[] money = { 1000, 500, 100, 50, 20, 10, 5, 2, 1 };
	static int[] totalQuantity = new int[menuItem.length];
	static int[] prices = new int[menuItem.length];
	
        //print the list of menu and another choice.
	public static void printMenu(){
		System.out.print("--- Welcome to SKE Restaurant ---\n");
		for (int i = 0; i < menuItem.length; i++) {
			System.out.printf("[%d] %s\t\t%.2f Baht\n", i + 1, menuItem[i], menuPrice[i]);
		}
                System.out.printf("[%d] Display order\n[%d] Payment\n[%d] Cancle and Exit\n", 5, 6, 7);
	}
        
        //recieve input(choice) from user. 
        public static void menuSelection(){
		int choice = 0;
		while (true) {
			System.out.print("\nEnter your Choice: ");
			choice = console.nextInt();
			if (choice == 6) {
				System.out.print("\nInput your Cash: ");
				int cash = console.nextInt();
				int change = cash - calculateTotalPrice();
				if (change < 0) {
					System.out.print("Not enough cash.");
					continue;
				} else {
					changeTable(change);
				}
				System.out.print("\n========== Thank you ==========");
				break;
			}
                        else if (choice == 5) {
				makeTable();
                        }
                        else if (choice == 7) {
                                System.out.print("\n========== Thank you ==========");
                                break;
                        } 
                        else if (choice >= 1 && choice<=menuItem.length) {
				System.out.print("Enter quantity: ");
				getPrice(choice);
			}
		}
	}
        
        //calculate the price of each order.
        public static void getPrice(int value) {
		quantity = console.nextInt();
		totalQuantity[value - 1] += quantity;
		prices[value - 1] = (int) (totalQuantity[value - 1] * menuPrice[value - 1]);
	}
        
        //calculate thee total prices of the orders.
        public static int calculateTotalPrice() {
		int totalPrice = 0;
		for (int j = 0; j < menuItem.length; j++) {
			totalPrice += prices[j];
		}
                return totalPrice;
	}
        
        //calculate and print the changes.
        public static void calculateChange(int c) {
		for (int k = 0; k < money.length; k++) {
			if (c / money[k] != 0) {
                            String s = "";
				System.out.printf("| %-4d Baht%12s|%5d |\n", money[k],s, c / money[k]);
			}
			c = c % money[k];
		}
	}
        
        //make a changes table.
        public static void changeTable(int change) {
		System.out.printf("\nYour change is %d Baht.\n", change);
		System.out.print("+----------------------+------+\n");
		System.out.print("|   notes or coins     | Qty  |\n");
		System.out.print("+----------------------+------+\n");
		calculateChange(change);
		System.out.print("+----------------------+------+\n");
	}

        //make the table of user's oder.
        public static void makeTable() {
		System.out.print("+------ Menu ------+-- Qty --+-- Price --+\n");
		for (int i = 0; i < menuItem.length; i++) {
			if (totalQuantity[i] != 0) {
				System.out.printf("| %-17s|%9d|%11d|\n", menuItem[i], totalQuantity[i], prices[i]);
			}
		}
                System.out.print("+------------------+---------+-----------+\n");
		System.out.printf("|%-28s|%11d|\n", " Total", calculateTotalPrice());
		System.out.print("+------------------+---------+-----------+\n");
	}
	
	public static void main(String[] args) {
		printMenu();
		menuSelection();
	}
}