public class Products {
	private static  String[] productIds = {"FR1","SR1","CF1"};
	private static String[] productNames = {"Tea","StraWberries","Coffee"};
	private static String[] productPrices = {"3.11" ,"5.00" , "11.2"};
	
	public String[] getProductIds() {
		return productIds;
	}
	public void setProductIds(String[] productIds) {
		Products.productIds = productIds;
	}
	public void  getProductNames() {
		for (int i = 0; i < productNames.length; i++) {
			System.out.println(productNames[i]);
		}
	}
	public void setProductNames(String[] productNames) {
		Products.productNames = productNames;
	}
	public String[] getProductPrices() {
		return productPrices;
	}
	public void setProductPrices(String[] productPrices) {
		Products.productPrices = productPrices;
	}
	
	public String[] getProduct(String productId) {
		String productIndex = null; 
		for (int i = 0; i < productIds.length; i++) {
			if(productId.equalsIgnoreCase(productIds[i])) {
				productIndex= Integer.toString(i);
				break;
			}
		}
		if(productIndex!= null) {
			int ind = Integer.valueOf(productIndex);
			String[] product = {productIds[ind], productNames[ind], productPrices[ind]};
			return product;
		}
		return null;
	}
	public static void getAllProducts() {
		// TODO Auto-generated method stub 
		for (int i = 0; i < productIds.length; i++) {
			System.out.printf("%s | £%s | %s\n", productIds[i],productPrices[i],productNames[i]);
		}
	}
	
}
