package aliceinnets.util;

import java.lang.reflect.Array;

import junit.framework.TestCase;

public class TestCaseUtil {
	
	public static void assertArrayEquals(Object expected, Object actual) {
		if(actual.getClass().isArray()) {
			for(int i=0;i<Array.getLength(actual);++i) {
				assertArrayEquals(Array.get(expected, i), Array.get(actual, i));
			}
		} else {
			TestCase.assertEquals(expected, actual);
		}
	}

}
