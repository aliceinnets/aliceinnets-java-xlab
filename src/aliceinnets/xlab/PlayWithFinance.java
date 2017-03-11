package aliceinnets.xlab;

import aliceinnets.finance.api.GoogleFinanceGetprices;
import aliceinnets.util.OneLiners;

public class PlayWithFinance {
	
	public static void main(String[] args) {
		GoogleFinanceGetprices price = new GoogleFinanceGetprices("GOOG");
		OneLiners.println(price.getDataColumns());
		OneLiners.println(price.getData());
	}

}
