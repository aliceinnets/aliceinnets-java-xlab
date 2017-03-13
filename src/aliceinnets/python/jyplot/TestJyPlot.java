package aliceinnets.python.jyplot;

import java.io.IOException;

import aliceinnets.python.PythonScript;
import aliceinnets.util.OneLiners;

public class TestJyPlot {
	
	public static void main(String[] args) throws InterruptedException {
		double[] x = new double[] { 1, 2, 3 };
		double[] y = new double[] { Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY };
//		try {
//			new JyPlot().plot(x, y).exec();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		x = OneLiners.linspace(0, 10, 100);
		y = new double[x.length];
		for (int i = 0; i < y.length; i++) {
			y[i] = Math.sin(x[i]);
		}
		double[] z = new double[x.length];
		for (int i = 0; i < y.length; i++) {
			z[i] = Math.cos(x[i]);
		}
		try {
//			new JyPlot().figure(null, null, null, null, null, null, null, null).acorr(x, null, null, null).grid().exec();
//			new JyPlot()
//			.ion()
//			.figure(null, null, null, null, null, null, null, null)
//			.plot(new Object[] { x, y, "\"-o\""}, null)
//			.plot(new Object[] { x, z, "\"-x\""}, null)
//			.grid()
//			.ylim(new Double[] { -2.0, 2.0 }, null)
//			.legend(new String[] {"\"a\"", "\"b\""}, new Object[] {"loc=\"lower left\""})
//			.savefig(new Object[] {"\""+PythonModule.DEFAULT_PATH+System.nanoTime()+".pdf\""}, null)
//			.show(null, null)
//			.ioff()
//			.exec();
			
//			Thread.sleep(1000);
			
			double[][] grid = OneLiners.meshGrid(x, x);
//			System.out.println(Arrays.toString(grid[0]));
			double[][] f = new double[x.length][x.length];
			for (int i = 0; i < f.length; i++) {
				for (int j = 0; j < f[0].length; j++) {
					f[i][j] = Math.sin(x[i])+Math.sin(x[j]);
				}
			}
			
			System.out.println(OneLiners.getElementType(new Object[] { x, y, f}.getClass()));
			System.out.println(new Object[] {f, x, y}.getClass().getComponentType());
			System.out.println(f.getClass().getComponentType() instanceof Object);
			
			
			new JyPlot()
			.write("from matplotlib import cm\n")
			.figure(null, null, null, null, null, null, null, null)
			.plot(new Object[] { x, y}, null)
			.plot(new Object[] { x, z, "\"-x\""}, null)
			.grid()
			.xlabel("\"$f$\"", null, null)
			.ylabel("\"$f$\"", null, null)
			.ylim(new Double[] { -2.0, 2.0 }, null)
			.legend(new String[] {"\"a\"", "\"b\""}, new Object[] {"loc=\"lower left\""})
			.savefig(new Object[] {"\""+PythonScript.DEFAULT_PATH+System.nanoTime()+".pdf\""}, null)
			.figure(null, null, null, null, null, null, null, null)
			.contourf(f, new Object[] {"cmap = cm.jet"})
//			.contourf(new Object[] {x,x,f, 50}, new Object[] {"cmap = cm.jet"})
			.colorbar(null, null, null, null)
//			.plot(new Object[] { x, z, "\"-x\""}, null)
			.grid()
			.xlabel("\"$T_e$ [keV]\"", null, null)
			.ylabel("\"$n_e$ [$10^{19} m^{-3}$]\"", null, null)
//			.ylim(new Double[] { -2.0, 2.0 }, null)
//			.legend(new String[] {"\"a\"", "\"b\""}, new Object[] {"loc=\"lower left\""})
			.savefig(new Object[] {"\""+PythonScript.DEFAULT_PATH+System.nanoTime()+".pdf\""}, null)
			.tight_layout(null, null, null, null)
			.show(null, null)
			.exec();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
