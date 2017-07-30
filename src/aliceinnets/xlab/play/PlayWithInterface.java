package aliceinnets.xlab.play;

public class PlayWithInterface {
	
	public interface FunctionND {
		public double evalND(double[] x);
	}
	
	public interface Function2D {
		public double eval2D(double x, double y);
	}
	
	public static class Function implements FunctionND {
		
		double a;
		
		public Function(double a) {
			this.a = a;
		}
		
		public double eval2D(double x, double y) {
			return x + y + a;
		}
		
		@Override
		public double evalND(double[] x) {
			double ret = 0;
			for (int i = 0; i < x.length; i++) {
				ret += x[i];
			}
			ret += a;
			return ret;
		}
		
	}
	
	public static void main(String[] args) {
		Function func = new Function(3.0);
		Function2D func2D = (Function2D) func;
		
		System.out.println(func.evalND(new double[] { 1.0, 2.0 }));
		System.out.println(func2D.eval2D(1.0, 2.0));
	}

}
