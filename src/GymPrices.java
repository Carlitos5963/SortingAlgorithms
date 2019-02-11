
public class GymPrices {

	public static void main(String[] args) {
		int prices[] = {36,66,93,116,135,150,161,176,189,200,214,228};
		pricePerMonth(prices);
	}
	
	public static void pricePerMonth(int[] prices) {
		for(int i = 0; i < prices.length; i++) {
			System.out.println(i+1 + " month: $" + prices[i]/(i+1));
		}
	}
}
