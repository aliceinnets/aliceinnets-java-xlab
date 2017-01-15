package web.spider;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

public class TestSpider extends TestCase {
	
	public void testSpider() {
		String url = "https://github.com/aliceinnets";
		int numPagesToSearch = 20;
		String[] words = new String[] { "alice", "github" };
		
		Spider spider = new Spider(url, numPagesToSearch, words);
		spider.crawl();
		
		System.out.println(spider.getPagesToVisit());
		System.out.println(spider.getPagesVisited());
		
		List<String> pageVisited = spider.getPagesVisited();
		List<String[]> pageLinks = spider.getPageLinks();
		List<Integer[]> pageWordCounts = spider.getPageWordCounts();
		
		for(int i=0;i<pageVisited.size();++i) {
			System.out.println(pageVisited.get(i));
			System.out.println(Arrays.toString(pageLinks.get(i)));
			System.out.println(Arrays.toString(words));
			System.out.println(Arrays.toString(pageWordCounts.get(i)));
		}
		
	}

}
