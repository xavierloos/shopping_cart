import java.util.Scanner;

public class Supermarket extends Products {
	public static String productId;  
	static Scanner sc = new Scanner(System.in);
	static Checkout ck = new Checkout();
	
	public static void main(String[] args) { 
		System.out.println("WELCOME TO THE SUPERMARKET");
		while(true) {  
			printMenu(); 
		}   
	}
	
	public static void printMenu(){ 
		int choice;
		do {
			System.out.println("-----------------------------");
			System.out.printf("What would you like to do?\n");
			System.out.println("-----------------------------");
			System.out.println("1 - See products available");
			System.out.println("2 - Add product to basket");
			System.out.println("3 - Delete product from basket");
			System.out.println("4 - See basket");
			System.out.println("5 - Checkout");  
			System.out.println("6 - Exit"); 
			System.out.println("-----------------------------");
			System.out.print("Enter choice: ");
			choice = sc.nextInt(); 
			if(choice<1||choice>6) {
				System.out.println("Invalid choice, please choose 1 to 6");
			}
		}while(choice<1||choice>6);
		userInput(choice); 
	}
	
	private static void userInput(int choice) { 
		String pCode;
		switch(choice) {
		case 1:
			System.out.println("-----------------------------");
			System.out.println("          PRODUCTS          ");
			System.out.println("-----------------------------");
			getAllProducts();
			 
			break;
		case 2:  
			System.out.print("ADD - Enter ID:"); 
			sc.nextLine(); 
			 pCode = sc.nextLine(); 
			if(ck.addToBasket(pCode)) {
				System.out.print("(✓) Added to the basket\n");
			}else {
				System.out.printf("(x) %s not available\n",pCode);
			}
			break;
		case 3:
			if(ck.basket.size()>0) {
				System.out.print("DELETE - Enter ID (or * all):"); 
				sc.nextLine(); 
				pCode = sc.nextLine();
				if(pCode.equals("*")) {
					ck.basket.removeAll(ck.basket);
					System.out.println("(✓) Basket cleared");
					break;
				}else {
					if(ck.basket.contains(pCode)){
						ck.deleteFromBasket(pCode); 
						System.out.print("(✓) Deleted from the basket\n");
						break;
					}else {
						System.out.printf("(x) %s not found\n",pCode);
					}
				}
			}else {
				System.out.println("⚠ BASKET EMPTY (Nothing to delete)");
			}
			break;
		case 4:
			ck.seeBasket(); 
			break;
		case 5:
			ck.checkout(); 
			break;
		case 6: 
			System.out.println("Thanks for shopping with us");
			System.exit(0);
			break;
		}
	}

}
