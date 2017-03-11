package aliceinnets.util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class OneLiners {
	
	
	public final static String getAbsoluteDir(Class<?> clazz) {
		return clazz.getResource(clazz.getName()+".java").getPath().replace(clazz.getSimpleName()+".java", "");
	}
	
	
	public final static void println(Object object) {
		if(object.getClass().isArray()) {
			System.out.println(Arrays.toString((Object[]) object));
		} else {
			System.out.println(object);
		}
	}
	
	
	public final static String read(String pathname) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(pathname));
		scanner.useDelimiter("\\Z");
		
		String s = scanner.next();
		scanner.close();
		
		return s;
	}
	
	
	public final static void write(String s, String pathname) throws FileNotFoundException {
		PrintWriter out = new PrintWriter(new File(pathname));
		out.write(s);
		out.close();
	}
	
	public final static double[] linspace(double x0, double x1, int n){
		if(n == 1) return new double[]{ (x0+x1)/2 };
        double f[] = new double[n];
        double dx = (x1 - x0)/(double)(n - 1.0);
        for(int i=0; i<n; i++)
            f[i] = x0 + i*dx;
        return f;
	}
	
	public final static int countWordUsingScanner(String document, String word) {
		return countWordUsingScanner(document, word, false, false, false);
	}
	
	
	public final static int countWordUsingScanner(String document, String word, boolean caseSensitive) {
		return countWordUsingScanner(document, word, caseSensitive, false, false);
	}
	
	
	public final static int countWordUsingScanner(String document, String word, boolean caseSensitive, boolean wholeWord) {
		return countWordUsingScanner(document, word, caseSensitive, wholeWord, false);
	}
	
	/**
	 * Counting the word in the document string using scanner. It is slower than {@link #countWord} method.
	 * 
	 * @param document
	 * @param word
	 * @param caseSensitive
	 * @param wholeWord
	 * @param excludeNonWordChars
	 * @return number of occurrences of the word in the document
	 */
	public final static int countWordUsingScanner(String document, String word, boolean caseSensitive, boolean wholeWord, boolean excludeNonWordChars) {
		int count = 0;
		
		if(!caseSensitive) document = document.toLowerCase();
		if(excludeNonWordChars) word = word.replaceAll("\\W", "");
		
		Scanner scanner = new Scanner(document);
		if(wholeWord) {
			if(excludeNonWordChars) {
				while(scanner.hasNext()) if(scanner.next().equals(word)) ++count;
			} else {
				while(scanner.hasNext()) if(scanner.next().replaceAll("\\W", "").equals(word)) ++count;
			}
		} else {
			if(excludeNonWordChars) {
				while(scanner.hasNext()) if(scanner.next().contains(word)) ++count;
			} else {
				while(scanner.hasNext()) if(scanner.next().replaceAll("\\W", "").contains(word)) ++count;
			}
			
		}
		scanner.close();
		
		return count;
	}
	
	
	public final static int[] countWords(String document, String[] words) {
		return countWords(document, words, false, false, false);
	}
	
	
	public final static int[] countWords(String document, String[] words, boolean caseSensitive) {
		return countWords(document, words, caseSensitive, false, false);
	}
	
	
	public final static int[] countWords(String document, String[] words, boolean caseSensitive, boolean wholeWord) {
		return countWords(document, words, caseSensitive, wholeWord, false);
	}
	
	
	public final static int[] countWords(String document, String[] words, boolean caseSensitive, boolean wholeWord, boolean excludeNonWordChars) {
		int[] wordCounts = new int[words.length];
		for(int i=0;i<wordCounts.length;++i) {
			wordCounts[i] = countWord(document, words[i], caseSensitive, wholeWord, excludeNonWordChars);
		}
		return wordCounts;
	}
	
	
	public final static int countWord(String document, String word) {
		return countWord(document, word, false, false, false);
	}
	
	
	public final static int countWord(String document, String word, boolean caseSensitive) {
		return countWord(document, word, caseSensitive, false, false);
	}
	
	
	public final static int countWord(String document, String word, boolean caseSensitive, boolean wholeWord) {
		return countWord(document, word, caseSensitive, wholeWord, false);
	}
	
	/**
	 * Counting the word in the document string.
	 * 
	 * @param document
	 * @param word
	 * @param caseSensitive
	 * @param wholeWord
	 * @param excludeNonWordChars
	 * @return number of occurrences of the word in the document
	 */
	public final static int countWord(String document, String word, boolean caseSensitive, boolean wholeWord, boolean excludeNonWordChars) {
		int count = 0;
		
		if(!caseSensitive) document = document.toLowerCase();
		if(excludeNonWordChars) word = word.replaceAll("\\W", "");
		
		String[] words = document.split("\\s+");
		if(wholeWord) {
			if(excludeNonWordChars) {
				for(int i=0;i<words.length;++i) if(words[i].equals(word)) ++count;
			} else {
				for(int i=0;i<words.length;++i) if(words[i].replaceAll("\\W", "").equals(word)) ++count;
			}
		} else {
			if(excludeNonWordChars) {
				for(int i=0;i<words.length;++i) if(words[i].contains(word)) ++count;
			} else {
				for(int i=0;i<words.length;++i) if(words[i].replaceAll("\\W", "").contains(word)) ++count;
			}
			
		}
		
		return count;
	}

}
