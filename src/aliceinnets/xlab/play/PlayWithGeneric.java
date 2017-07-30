package aliceinnets.xlab.play;

public class PlayWithGeneric {
	
	public static void main(String[] args) {
		int a = 1;
		double b = cast(a);
		System.out.println(b);
	}
	
	public final static <T> int cast(T obj) {
		return (int) obj;
	}
	
	public final static <T> T cast(Object obj, Class<?> type) {
		if(type.equals(double.class)) {
//			return (T) Double.parseDouble(obj.toString());
		}
		return null;
	}

}
