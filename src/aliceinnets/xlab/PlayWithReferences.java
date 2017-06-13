package aliceinnets.xlab;

import java.util.Arrays;

import aliceinnets.util.OneLiners;

public class PlayWithReferences {
	
	public static void main(String[] args) {
		double[] a = new double[] { 1.0, 2.0, 3.0 };
		DoubleArray b = new DoubleArray();
		b.setArray(a);
		
		OneLiners.println(a);
		
		changeElement(a, 2.0);
		OneLiners.println(a);
		changeElement(a, 3.0);
		OneLiners.println(a);
		changeElement(a, 4.0);
		OneLiners.println(a);
		
		Double c = new Double(0.0);
		changeObject(c, 1.0);
		System.out.println(c);
	}
	
	public static void changeElement(double[] a, double b) {
		if(a.length > 0) {
			a[0] = b;
		}
	}
	
	public static void changeDouble(Double a, double b) {
		a = b;
	}
	
	public static void changeObject(Object a, Object b) {
		a = b;
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
