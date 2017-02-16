package aliceinnets.xlab;

import java.lang.reflect.Array;

public class TestCase extends junit.framework.TestCase {
	
	public static void assertArrayEquals(Object expected, Object actual) {
		if(actual.getClass().isArray()) {
			for(int i=0;i<Array.getLength(actual);++i) {
				assertArrayEquals(Array.get(expected, i), Array.get(actual, i));
			}
		} else {
			assertEquals(expected, actual);
		}
	}

}
