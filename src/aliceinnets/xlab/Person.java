package aliceinnets.xlab;

public class Person implements Comparable<Person>{
	public String name;
	public int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		
	}

	@Override
	public int compareTo(Person other) {
		// TODO Auto-generated method stub
		int lengthNameThis = name.length();
		int lengthNameOther = other.name.length();
		if(lengthNameThis > lengthNameOther) return -1;
		if(lengthNameThis == lengthNameOther) return 0;
		return +1;
		//return name.compareTo(other.name);
	}

}
