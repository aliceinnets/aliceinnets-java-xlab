package aliceinnets.xlab.play;

public class PlayWithClassOfClass {
	
	String motherName;
	
	public PlayWithClassOfClass(String name) {
		this.motherName = name;
	}
	
	public PlayWithClassOfClass(AClass a) {
		this.a = a;
	}
	
	AClass a;
	
	private class AClass {
		String name;
		private int pri;
		public AClass(String name) {
			this.name = motherName+"."+name;
		}
		
		public AClass(int pri) {
			this.pri = pri;
		}
		
		
	}
	
	public void print() {
		System.out.println(a.name);
	}
	
	public void print(AClass a) {
		System.out.println(a.pri);
	}
	
	static class AStaticClass {
		public AStaticClass() {
			System.out.println("hello!");
		}
		
	}
	
	public static void main(String[] args) {
		AStaticClass a = new AStaticClass();
		PlayWithClassOfClass mother = new PlayWithClassOfClass("mother");
		AClass b = mother.new AClass("b");
		PlayWithClassOfClass father = new PlayWithClassOfClass(b);
		father.print();
		
		
	}
	

}
