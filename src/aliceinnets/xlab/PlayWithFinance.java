package aliceinnets.xlab;

import java.util.Arrays;

import aliceinnets.finance.api.GoogleFinanceGetprices;

public class PlayWithFinance {
	
	public static void main(String[] args) {
		GoogleFinanceGetprices price = new GoogleFinanceGetprices("GOOG");
		System.out.println(Arrays.toString(price.getDataColumns()));
		System.out.println(Arrays.toString(price.getData()));
	}

}
