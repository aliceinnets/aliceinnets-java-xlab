package aliceinnets.xlab;

public class PlayWithAssignable {
	
	public static void main(String[] args) {
		double a = 2;
		Double A = a;
		double a1 = A;
		Object obj = A;
		Double A1 = (Double) obj;
		System.out.println(Double.class.isAssignableFrom(double.class));
		System.out.println(double.class.isAssignableFrom(Double.class));
		System.out.println(Object.class.isAssignableFrom(Double.class));
		System.out.println(Double.class.isAssignableFrom(Object.class));
		System.out.println(Object.class.isAssignableFrom(double.class));
		System.out.println(double.class.isAssignableFrom(Object.class));
		System.out.println(double.class.isAssignableFrom(int.class));
		System.out.println(int.class.isAssignableFrom(double.class));
		System.out.println(long.class.isAssignableFrom(int.class));
		System.out.println(int.class.isAssignableFrom(long.class));
		long l = 123L;
		Long L = new Long(12334034834L);
		byte b = 112;
	}

}
