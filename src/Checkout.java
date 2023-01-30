import java.util.ArrayList;
import java.util.Collections;

public class Checkout {
	public  ArrayList<String> basket  = new ArrayList<String>();
	Products p = new Products();
	
	public void checkout() {
		if(basket.size()>0) {
			int countFR1=Collections.frequency(basket, "FR1"); 
			int countSR1=Collections.frequency(basket, "SR1"); 
			int countCF1=Collections.frequency(basket, "CF1");
			double subtotal = 0.0;
			double discount = 0.0;
			double total = 0.0;
			
			if(countFR1>0) { 
				subtotal += Double.parseDouble(p.getProduct("FR1")[2]) * countFR1;
				discount +=promo(countFR1, "FR1"); 
			}
			if(countSR1>=3) {
				//13.50 FOR 3 
				subtotal += Double.parseDouble(p.getProduct("SR1")[2]) * countSR1;
				discount += promo(countSR1, "SR1");  
			}else { 
				subtotal+=Double.parseDouble(p.getProduct("SR1")[2]) * countSR1; 
			}
			if(countCF1>0) {
				subtotal +=Double.parseDouble(p.getProduct("CF1")[2]) * countCF1; 
			}
			total = subtotal - discount;
			printReceipt(subtotal,discount,total);  
		}else {
			System.out.println("⚠ BASKET EMPTY ");
		}
	} 
	
	private void printReceipt(Double subtotal, Double discount, Double total) { 
			System.out.println("-----------------------------");
			System.out.println("           RECEIPT           ");
			System.out.println("-----------------------------");
			for (int i = 0; i < basket.size(); i++) {
				String[] currentProduct = p.getProduct(basket.get(i));
				System.out.printf("%s | £%s | %s\n", currentProduct[0], currentProduct[2],currentProduct[1]);
			}
			System.out.println("-----------------------------");
			System.out.printf("Items:                     %s\n",basket.size());
			System.out.printf("Subtotal:              £%.2f\n",subtotal);
			System.out.printf("Discount:             -£%.2f\n",discount);
			System.out.println("-----------------------------");
			System.out.printf("Total:                 £%.2f\n",total);
			System.out.println("-----------------------------");
			System.out.println("Thanks for shopping with us!");
			System.out.println("-----------------------------");
			System.exit(0);  
	}
	
	private  Double promo(int pCounter, String pCode) {
		switch (pCode) {
		case "FR1": { 
			return (pCounter/2) * Double.parseDouble(p.getProduct(pCode)[2]);  
		}
		case "SR1": { 
			return  pCounter*0.5;  
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + pCode);
		} 
	}
	
	public Boolean addToBasket(String pCode) { 
		if(p.getProduct(pCode) != null) {
			if(pCode.equalsIgnoreCase("FR1")) {
				basket.add(p.getProduct(pCode)[0]);
				basket.add(p.getProduct(pCode)[0]);
				return true;
			}else {
				basket.add(p.getProduct(pCode)[0]);
				return true;
			}
		}
		return false;
	}

	public boolean deleteFromBasket(String pCode) {
		for (int i = 0; i < basket.size(); i++) {
			if(pCode.equalsIgnoreCase(basket.get(i))) { //Check if the product exist in the basket
				if(pCode.equalsIgnoreCase("FR1")) {
					basket.remove(pCode);
					basket.remove(pCode); //Remove the free one
					break;
				}else {
					basket.remove(pCode);
					break;
				}
			}
		} 
		return false; 
	}

	public void seeBasket() {
		if(basket.size()>0) {
			System.out.println("-----------------------------");
			System.out.printf("       BASKET (%s Items)      \n", basket.size()); 
			System.out.println("-----------------------------");
			for (int i = 0; i <basket.size(); i++) {
				String[] currentPro =  p.getProduct(basket.get(i));
				System.out.printf("%s | £%s | %s\n", currentPro[0], currentPro[2], currentPro[1]);
			}
			System.out.println("-----------------------------");
		}else {
			System.out.println("⚠ BASKET EMPTY ");
		}
	} 
}
