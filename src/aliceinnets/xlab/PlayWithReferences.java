package aliceinnets.xlab;

import java.util.Arrays;

public class PlayWithReferences {
	
	public static void main(String[] args) {
		double[] a = new double[] { 1.0, 2.0, 3.0 };
		DoubleArray b = new DoubleArray();
		b.setArray(a);
		
		System.out.println(Arrays.toString(a));
	}
	
	public static class DoubleArray {
		double[] array;
		int[] index = new int[] { 2, 1, 0 };
		
		public DoubleArray() { }
		
		public void setArray(double[] a) {
			a = a.clone();
			order(a, index);
			array = a;
		}
		
		
	}
	
	public static final void order(double[] a, int[] ia) {
        double[] ac = a.clone();
        for(int i = 0;i < a.length; ++i) {
            a[i] = ac[ia[i]];
        }
    }

}
