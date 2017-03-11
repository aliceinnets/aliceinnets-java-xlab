package aliceinnets.jyplot;

import edu.emory.mathcs.backport.java.util.Arrays;

public class JyPlot {
	
	StringBuffer dataBuffer;
	StringBuffer plotBuffer;
	
	public JyPlot() {
		dataBuffer = new StringBuffer();
		plotBuffer = new StringBuffer();
	}
	
	@Override
	public String toString() {
		return dataBuffer.toString() + "\n" + plotBuffer.toString();
	}
	
	public JyPlot plot(double[] x, double[] y) {
		dataBuffer.append("x = ");
		dataBuffer.append(Arrays.toString(x));
		dataBuffer.append("\n");
		dataBuffer.append("y = ");
		dataBuffer.append(Arrays.toString(y));
		dataBuffer.append("\n");
		plotBuffer.append("plt.plot(x, y)\n");
		return this;
	}
	
	public JyPlot save() {
		System.out.println("saved:\n"+dataBuffer.toString());
		return this;
	}
	
	public JyPlot save(String pathname) {
		return this;
	}
	
	public JyPlot plot() {
		System.out.println("plot:\n"+plotBuffer.toString());
		return this;
	}
	
	public static void main(String[] args) {
		double[] x = new double[] { 1, 2, 3 };
		double[] y = new double[] { Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY };
		JyPlot jyPlot = new JyPlot().plot(x, y).plot().save();
	}
	
	
//	public JyPlot arrow(Object x, Object y, Object dx, Object dy, Object hold, Object... kwargs) {
//
////		new JyPlot(x, y).Grid().Legend("Hoefel", "Udo").FontSie(4).plotAndSave().plot();
//		
//		new JyPlot().axhline(y, xmin, xmax, hold, kwargs)
//		
//		// data python script
//		// plot script
//	}

}
