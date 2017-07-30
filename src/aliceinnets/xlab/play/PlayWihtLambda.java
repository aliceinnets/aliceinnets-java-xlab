package aliceinnets.xlab.play;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import edu.emory.mathcs.backport.java.util.Arrays;

public class PlayWihtLambda {

	public static void main(String[] args) {
		tryFunctionalInterfaces();
//		tryListForEach();
//		tryLambdaExpressions();
//		sortList();
	}

	public static void eval(List<Integer> list, Predicate<Integer> predicate) {
		for(Integer n: list) {

			if(predicate.test(n)) {
				System.out.println(n + " ");
			}
		}
	}
	
	interface IntPredicate {
		boolean test(int n);
	}

	public static void tryFunctionalInterfaces() {
		List<Integer> list = Arrays.asList(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9});

		// Predicate<Integer> predicate = n -> true
		// n is passed as parameter to test method of Predicate interface
		// test method will always return true no matter what value n has.

		System.out.println("Print all numbers:");

		//pass n as parameter
		eval(list, n->true);

		// Predicate<Integer> predicate1 = n -> n%2 == 0
		// n is passed as parameter to test method of Predicate interface
		// test method will return true if n%2 comes to be zero

		System.out.println("Print even numbers:");
		eval(list, n-> n%2 == 0 );

		// Predicate<Integer> predicate2 = n -> n > 3
		// n is passed as parameter to test method of Predicate interface
		// test method will return true if n is greater than 3.

		System.out.println("Print numbers greater than 3:");
		eval(list, n-> n > 3 );
		
		IntPredicate intPredicate = n -> n % 3 == 0;
		System.out.println("Print numbers multiple of 3:");
		eval(list, intPredicate::test);
	}

	public static void tryListForEach() {
		List<String> names = new ArrayList<String>();

		names.add("Mahesh");
		names.add("Suresh");
		names.add("Ramesh");
		names.add("Naresh");
		names.add("Kalpesh");

		names.forEach(System.out::println);

		GreetingService greetService1 = message -> System.out.println("Hello " + message);
		names.forEach(greetService1::sayMessage);

		GreetingService1 greetingService1 = new GreetingService1("Hello, ");
		names.forEach(greetingService1::sayMessage);

		greetingService1.setSalutation("Hi there, ");
		names.forEach(greetingService1::sayMessage);
	}

	static class GreetingService1 implements GreetingService {

		String salutation;

		public GreetingService1(String salutation) {
			this.salutation = salutation;
		}

		public void setSalutation(String salutation) {
			this.salutation = salutation;
		}

		@Override
		public void sayMessage(String message) {
			System.out.println(salutation + message);
		}

	}

	interface MathOperation {
		int operation(int a, int b);
	}

	interface GreetingService {
		void sayMessage(String message);
	}

	private static int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}

	public static void tryLambdaExpressions() {
		MathOperation addition = (int a, int b) -> a + b;
		MathOperation subtraction = (a, b) -> a - b;
		MathOperation multiplication = (int a, int b) -> { return a * b; };
		MathOperation division = (int a, int b) -> a / b;

		System.out.println("10 + 5 = " + operate(10, 5, addition));
		System.out.println("10 - 5 = " + operate(10, 5, subtraction));
		System.out.println("10 x 5 = " + operate(10, 5, multiplication));
		System.out.println("10 / 5 = " + operate(10, 5, division));

		//with parenthesis
		GreetingService greetService1 = message -> System.out.println("Hello " + message);

		//without parenthesis
		GreetingService greetService2 = (message) -> System.out.println("Hello " + message);

		greetService1.sayMessage("Mahesh");
		greetService2.sayMessage("Suresh");

	}

	public static void sortList() {
		String[] array = new String[] { "Maven", "Python", "Gradle", "Java" };
		List<String> list = Arrays.asList(array);
		System.out.println(list);

		list.stream().sorted((e1, e2) -> e1.compareTo(e2));

		list.sort((element2, element1) -> element1.compareTo(element2));
		System.out.println(list);

		Collections.sort(list);
		System.out.println(list);
	}

}
