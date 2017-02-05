package aliceinnets.xlab;

public class FlyingSpaghettiMonster {
	String name;
	int age;
	
	public FlyingSpaghettiMonster() { this("fsm", 100); }
	public FlyingSpaghettiMonster(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void sayWow() {
		System.out.println("Wow!");
	}
	
	public String sayHello() {
		String greeting = "Hello!";
//		System.out.println(greeting);
		return greeting;
	}
	
	public String sayHello(String name) {
		String greeting = "Hello, "+name+"! ";
//		System.out.println(greeting);
		return greeting;
	}
	
	public String sayHelloToTwo(String name1, String name2) {
		return sayHello(name1)+sayHello(name2);
	}
	
	public String sayHelloToAll(String... names) {
		String greeting = "";
		for(String name : names) {
			greeting += sayHello(name);
		}
		return greeting;
	}
	
	public String sayNumberToSomeone(int number, String name) {
		String announcement = name+", "+number+"! ";
//		System.out.println(announcement);
		return announcement;
	}
	
	public String sayNumberToAll(int number, String... names) {
		String announcement = "";
		for(String name : names) {
			announcement += sayNumberToSomeone(number, name);
		}
		return announcement;
	}
	
	public String introduceMeTo(String name) {
		String announcement = "My name is "+this.name+", nice to see you, "+name;
//		System.out.println(announcement);
		return announcement;
	}

}
