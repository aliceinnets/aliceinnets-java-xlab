package web.spider;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import util.OneLiners;

public class Spider {
	
	public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1"; 
	
	List<String> pagesToVisit;
	int numPagesToSearch;
	String[] words;
	
	List<String> pagesVisited;
	List<String[]> pageLinks;
	List<Integer[]> pageWordCounts;
	
	
	public Spider(String url, int numPagesToSearch, String[] words) {
		pagesToVisit = new LinkedList<String>();
		pagesToVisit.add(url);
		
		this.numPagesToSearch = numPagesToSearch;
		this.words = words;
		
		pagesVisited = new LinkedList<String>();
		pageLinks = new LinkedList<String[]>();
		pageWordCounts = new LinkedList<Integer[]>();
		
	}
	
	
	public static List<String> getLinksOnPage(Document document) {
		Elements linksOnPage = document.select("a[href]");
		
		List<String> links = new LinkedList<String>();
		for(Element link : linksOnPage) {
			links.add(link.absUrl("href"));
		}	
		return links;
	}
	
	
	public void crawl() {
		while(pagesVisited.size() < numPagesToSearch) {
			if(pagesToVisit.isEmpty()) {
				System.out.println("No pages to visit");
				break;
			}
			
			try {
				String url = pagesToVisit.remove(0);
				Document document = Jsoup.connect(url).userAgent(USER_AGENT).get();
				
				digestPage(document);
				pagesVisited.add(url);
				System.out.println(String.format("visited page, %s", url));
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void digestPage(Document document) {
		List<String> links = getLinksOnPage(document);
		for(String link : links) {
			if(!pagesVisited.contains(link) && !pagesToVisit.contains(link)) {
				pagesToVisit.add(link);
			}
		}
		pageLinks.add(links.toArray(new String[links.size()]));
		
		String text = document.text();
		if(words != null) {
			Integer[] wordCount = new Integer[words.length];
			for(int i=0;i<wordCount.length;++i) {
				wordCount[i] = OneLiners.countWord(text, words[i]);
			}
			pageWordCounts.add(wordCount);
		}
		
	}


	public int getNumPagesToSearch() {
		return numPagesToSearch;
	}


	public void setNumPagesToSearch(int numPagesToSearch) {
		this.numPagesToSearch = numPagesToSearch;
	}


	public List<String> getPagesToVisit() {
		return pagesToVisit;
	}


	public void setPagesToVisit(List<String> pagesToVisit) {
		this.pagesToVisit = pagesToVisit;
	}


	public String[] getWords() {
		return words;
	}


	public void setWords(String[] words) {
		this.words = words;
		pageWordCounts.clear();
	}


	public List<String> getPagesVisited() {
		return pagesVisited;
	}


	public List<String[]> getPageLinks() {
		return pageLinks;
	}


	public List<Integer[]> getPageWordCounts() {
		return pageWordCounts;
	}
	

}
