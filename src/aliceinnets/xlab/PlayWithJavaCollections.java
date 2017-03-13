package aliceinnets.xlab;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PlayWithJavaCollections {
	public static void main(String[] args) {
		example();
		exampleList();
		example1Set();
		example2Set();
	}
	
	private static void example() {
		String bodyText = "**Test** A sentence, a String; many words? many many-type!";
		String[] texts = bodyText.toLowerCase().split("\\s+");
		int count = 0;
		for(int i=0;i<texts.length;++i) {
			texts[i] = texts[i].replaceAll("[^\\w]", "");
			if(texts[i].equals("a")) ++count; 
			System.out.println(texts[i]);
		}
		System.out.println(count);
	}

	private static void exampleList() {
		List<String> cart1 = new ArrayList<String>();
		cart1.add("Shirt");
		cart1.add("Shoes");
		cart1.add("Pants");
		cart1.add("Socks");
		cart1.addAll(cart1);
		cart1.set(2, "Socks");
		
		List<String> cart2 = new ArrayList<String>();
		cart2.add("Shirt");
		cart2.add("Skirt");
		
		System.out.println(cart1);
		System.out.println(cart1.contains(cart2.get(1)));
		System.out.println(cart1.remove("Socks"));
		System.out.println(cart1);
	}

	private static void example2Set() {
		Set<CountableObject> set = new TreeSet<CountableObject>();
		
		CountableObject a = new CountableObject("alice", 17);
		CountableObject b = new CountableObject("bob", 24);
		CountableObject c = new CountableObject("charlie", 20);
		set.add(a);
		//a.name = "bob";
		set.add(c);
		set.add(b);
		
		//System.out.println("Bob is there?"+set.contains("bob"));
		for(Iterator<CountableObject> iterator=set.iterator();iterator.hasNext();) {
			CountableObject person = iterator.next();
			System.out.println(person.getObject());
		}
	}

	/**
	 * Java collections framework
	 * 	Interface: Set, no duplicates,
	 * 	Implementation: HashSet, TreeSet, LinkedHashSet
	 * 
	 * 	TreeSet: iterator list is ordered by Comparator (compareTo)
	 * 	HashSet: no predictable order
	 * 	LinkedHashSet: order in which they are added 
	 */
	private static void example1Set() {
		Set<String> set = new HashSet<String>();
		set.add("bobby");
		set.add("alice");
		set.add("charlie");
		
		System.out.println("Bob is there?"+set.contains("bob"));
		for(Iterator<String> iterator=set.iterator();iterator.hasNext();) {
			String name = iterator.next();
			System.out.println(name);
		}
	}

}
