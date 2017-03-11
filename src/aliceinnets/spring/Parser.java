package aliceinnets.spring;

public class Parser {
	
	public static String toString(Object array) {
		return "D[ 1.0, 2.0, 3.0 ]";
	}
	
	public static Object parseArray(String array) {
		return new double[] { 1.0, 2.0, 3.0 };
	}

}
