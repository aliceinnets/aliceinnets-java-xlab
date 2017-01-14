package util;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides time differences between any two time points in nanos, mircos, millis and second 
 * using system time. When a new instance is created (calling its constructor) 
 * the current system nano-time is automatically stored. When any of toc methods is called,
 * it returns the time differences between the previous and current time point.  
 * 
 * @author alice
 *
 */
public class Stopwatch {
	
	List<Long> nanoTimes;
	
	/**
	 * Initiating stopwatch, tic! The current system nano-time is automatically stored.
	 * 
	 */
	public Stopwatch() {
		nanoTimes = new ArrayList<Long>();
		nanoTimes.add(System.nanoTime());
	}
	
	
	/**
	 * Clear the nano-time list and initiate stopwatch again, tic!
	 * 
	 */
	public void tic() {
		nanoTimes.clear();
		nanoTimes.add(System.nanoTime());
	}
	
	public long tocNano() {
		nanoTimes.add(System.nanoTime());
		return nanoTimes.get(nanoTimes.size()-1)-nanoTimes.get(nanoTimes.size()-2);
	}
	
	public long tocMirco() {
		return tocNano()/1000;
	}
	
	/**
	 * Toc! Return the time differences between the previous and current time point in millisecond.
	 * 
	 * @return the time differences in millisecond
	 */
	public long toc() {
		return tocNano()/1000000;
	}
	
	public long tocSecond() {
		return tocNano()/1000000000;
	}
	
	public long tocNano(String print) {
		long toc = tocNano();
		System.out.println(String.format("%s time: %s [ns]", print, toc));
		return toc;
	}
	
	public long tocMirco(String print) {
		long toc = tocNano()/1000;
		System.out.println(String.format("%s time: %s [us]", print, toc));
		return toc;
	}
	
	/**
	 * Toc! Print and return the time differences between the previous and current time point in millisecond.
	 * 
	 * @param print name of the current time point, e.g. if it is "test", it prints "test time: 4.57 [ms]"
	 * @return the time difference in millisecond
	 */
	public long toc(String print) {
		long toc = tocNano()/1000000;
		System.out.println(String.format("%s time: %s [ms]", print, toc));
		return toc;
	}
	
	public long tocSecond(String print) {
		long toc = tocNano()/1000000000;
		System.out.println(String.format("%s time: %s [ns]", print, toc));
		return toc;
	}
	
	public List<Long> getNanoTimes() {
		return nanoTimes;
	}

}
