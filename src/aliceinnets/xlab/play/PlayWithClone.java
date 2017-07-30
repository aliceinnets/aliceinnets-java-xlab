package aliceinnets.xlab.play;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PlayWithClone {
	
	public static void main(String[] args) {
		Object obj = "object";
		Object[] obj1 = new Object[] { 1.0, "array", 3 };
		Object[][] obj2 = new Object[][] { { 1.0 }, { "array", 2.0 }, { 3L } };
		Object[][][] obj3 = new Object[][][] { { { "4", 4L } } };
		double[][] obj4 = new double[][] { {1.0, 2.0}, { 3.0, 4.0} };
		
//		Object clone = obj;
//		Object clone1 = obj1.clone();
//		Object clone2 = obj2.clone();
		Object clone = cloneNonClassObject(obj);
		Object clone1 = cloneNonClassObject(obj1);
		Object clone2 = cloneNonClassObject(obj2);
		double[][] clone4 = (double[][]) cloneNonClassObject(obj4);
		System.out.println(obj);
		System.out.println(clone);
		System.out.println(Arrays.toString(obj1));
		System.out.println(Arrays.toString((Object[]) clone1));
		System.out.println(obj2[1][0]);
		System.out.println(((Object[][]) clone2)[1][0]);
		System.out.println(obj4[1][0]);
		System.out.println(clone4[1][0]);
		System.out.println();
		
		obj = null;
		obj1[0] = null;
		obj2[1][0] = null;
		System.out.println("Cloned!");
		System.out.println(obj);
		System.out.println(clone);
		System.out.println(Arrays.toString(obj1));
		System.out.println(Arrays.toString((Object[]) clone1));
		System.out.println(obj2[1][0]);
		System.out.println(((Object[][]) clone2)[1][0]);
		System.out.println();
		System.out.println(obj4[1][0]);
		System.out.println(clone4[1][0]);
		
		
	}
	
	/**
	 * Clone the non-class object, so handles primitives, 
	 * object type primitives (e.g. Long), Strings, and arbitrary multidimensional arrays of those types. 
	 * 
	 * @param object non-class object
	 * @return clone
	 */
	public static Object cloneNonClassObject(Object object) {
		if(!object.getClass().isArray()) {
			return object;
		} else {
			Object ret = Array.newInstance(object.getClass().getComponentType(), Array.getLength(object));
			for(int i=0;i<Array.getLength(object);++i) {
				Array.set(ret, i, cloneNonClassObject(Array.get(object, i)));
			}
			return ret;
		}
	}
	

}
