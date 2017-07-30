package aliceinnets.xlab.play;

public class PlayWithPattern {
	
	public static void main(String[] args) {
		String a = "afsdg[10352]";
		String b = "age2_3[1054265]";
		
		System.out.println(isArray(a));
		System.out.println(isArray(b));
		
	}
	
	
	public static boolean isArray(String name) {
		if(name.matches(".+\\[\\d+\\]")) {
			return true;
		} else {
			return false;
		}
	}

}
