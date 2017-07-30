package aliceinnets.xlab.play;

import java.util.Arrays;

import aliceinnets.finance.api.GoogleFinanceGetprices;
import aliceinnets.python.jyplot.JyPlot;

public class PlayWithFinance {
	
	public static void main(String[] args) {
		GoogleFinanceGetprices price = new GoogleFinanceGetprices("INTL");
		System.out.println(Arrays.toString(price.getDataColumns()));
		System.out.println(Arrays.toString(price.getData()));
		
		JyPlot plt = new JyPlot();
		plt.figure();
		plt.plot(price.getData()[0], price.getData()[1]);
		plt.grid();
		plt.show();
		plt.exec();
	}

}
