package aliceinnets.xlab.play;

import aliceinnets.python.jyplot.JyPlot;
import aliceinnets.util.OneLiners;
import cern.jet.random.Poisson;
import cern.jet.random.engine.MersenneTwister;
import cern.jet.random.engine.RandomEngine;

public class PlayWithColt {
	
	public static void main(String[] args) {
		RandomEngine engine = new MersenneTwister();
		Poisson poisson = new Poisson(10, engine);
		
		int numSamples = 1000;
		int[] sample = new int[numSamples];
		for (int i = 0; i < sample.length; i++) {
			sample[i] = poisson.nextInt();
		}
		
		int[] sample2 = new int[numSamples];
		for (int i = 0; i < sample2.length; i++) {
			sample2[i] = poisson.nextInt(0);
		}
		
		int[] sample4 = new int[numSamples];
		for (int i = 0; i < sample4.length; i++) {
			sample4[i] = poisson.nextInt(20);
		}
		
		
		JyPlot plt = new JyPlot();
		plt.figure();
		plt.subplot(3,1,1);
		plt.hist(sample, OneLiners.linspaceInt(0,30,1));
		plt.grid();
		plt.subplot(3,1,2);
		plt.hist(sample2, OneLiners.linspaceInt(0,30,1));
		plt.grid();
		plt.subplot(3,1,3);
		plt.hist(sample4, OneLiners.linspaceInt(0,30,1));
		plt.grid();
		plt.show();
		plt.exec();
	}

}
