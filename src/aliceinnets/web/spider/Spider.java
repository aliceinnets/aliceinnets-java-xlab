package aliceinnets.web.spider;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import aliceinnets.util.OneLiners;

/**
 * This class crawls web pages link to link and collects some data, 
 * e.g. connections between pages, from a html document.
 * 
 * @author alice<aliceinnets@gmail.com>
 *
 */
public class Spider {
	
	public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1"; 
	
	/** maximum body size in MB */
	int maxBodySize;
	int timeout;
	
	int numPagesToSearch;
	List<String> pagesToVisit;
	List<String> pagesVisited;
	
	List<String[]> pageLinks;
	
	String[] words;
	List<Integer[]> pageWordCounts;
	
	boolean savePageDocuments;
	List<String> pageDocuments;
	
	boolean savePageHtmlDocuments;
	List<String> pageHtmlDocuments;
	
	/**
	 * 
	 * 
	 * @param url the link to start crawling
	 */
	public Spider(String url) {
		this(url, 100, null);
	}
	
	/**
	 * 
	 * 
	 * @param url the link to start crawling
	 * @param numPagesToSearch the number of pages to search
	 */
	public Spider(String url, int numPagesToSearch) {
		this(url, numPagesToSearch, null);
	}
	
	/**
	 * 
	 * 
	 * @param url the link to start crawling
	 * @param words word to collect
	 */
	public Spider(String url, String[] words) {
		this(url, 100, words);
	}
	
	/**
	 * 
	 * 
	 * @param url the link to start crawling
	 * @param numPagesToSearch the number of pages to search, the default value is 100 
	 * @param words words to collect
	 */
	public Spider(String url, int numPagesToSearch, String[] words) {
		maxBodySize = 0; // Unlimited body size
		timeout = 600000;
		
		this.numPagesToSearch = numPagesToSearch;
		pagesToVisit = new LinkedList<String>();
		pagesToVisit.add(url);
		pagesVisited = new LinkedList<String>();
		
		pageLinks = new LinkedList<String[]>();
		
		this.words = words;
		pageWordCounts = new LinkedList<Integer[]>();
		
		savePageDocuments = false;
		pageDocuments = new LinkedList<String>();
		
		savePageHtmlDocuments = false;
		pageHtmlDocuments = new LinkedList<String>();
		
	}
	
	
	public static List<String> getLinksOnPage(Document document) {
		Elements linksOnPage = document.select("a[href]");
		
		List<String> links = new LinkedList<String>();
		for(Element link : linksOnPage) {
			links.add(link.absUrl("href"));
		}	
		return links;
	}
	
	
	public static Integer[] getWordCounts(Document document, String[] words) {
		String text = document.text();
		Integer[] wordCounts = new Integer[words.length];
		for(int i=0;i<wordCounts.length;++i) {
			wordCounts[i] = OneLiners.countWord(text, words[i]);
		}
		return wordCounts;
	}
	
	
	public void crawl() {
		while(pagesVisited.size() < numPagesToSearch) {
			if(pagesToVisit.isEmpty()) {
				System.out.println("No pages to visit");
				break;
			}
			
			String url = pagesToVisit.remove(0);
			crawl(url);
		}
	}
	
	
	public void crawl(String url) {
		try {
			Document document = Jsoup.connect(url)
//					.header("Accept-Encoding", "gzip, deflate")
					.userAgent(USER_AGENT)
					.maxBodySize(maxBodySize)
					.timeout(timeout)
					.get();
			
//			URLConnection connection = new URL(url).openConnection();
//			URLConnection connection = new URL(url).openConnection(proxy);
//			connection.addRequestProperty("User-Agent", USER_AGENT);
//			connection.setConnectTimeout(timeout);
//			connection.setReadTimeout(timeout);
			
			List<String> links = getLinksOnPage(document);
			for(String link : links) {
				if(!pagesVisited.contains(link) && !pagesToVisit.contains(link)) {
					pagesToVisit.add(link);
				}
			}
			
			pageLinks.add(links.toArray(new String[links.size()]));
			
			if(savePageDocuments) {
				pageDocuments.add(document.text());
			}
			
			if(savePageHtmlDocuments) {
				pageHtmlDocuments.add(document.html());
			}
			
			if(words != null) {
				Integer[] wordCount = getWordCounts(document, words);
				pageWordCounts.add(wordCount);
			}
			
			pagesVisited.add(url);
			System.out.println(String.format("visited page, %s", url));
		} catch (IOException e) {
			e.printStackTrace();
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
	
	
	public void addPagesToVisit(List<String> pagesToVisit) {
		this.pagesToVisit.addAll(pagesToVisit);
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


	public boolean isSavePageDocuments() {
		return savePageDocuments;
	}


	public void setSavePageDocuments(boolean savePageDocuments) {
		this.savePageDocuments = savePageDocuments;
	}


	public List<String> getPageDocuments() {
		return pageDocuments;
	}

	public boolean isSavePageHtmlDocuments() {
		return savePageHtmlDocuments;
	}

	public void setSavePageHtmlDocuments(boolean savePageHtmlDocuments) {
		this.savePageHtmlDocuments = savePageHtmlDocuments;
	}

	public List<String> getPageHtmlDocuments() {
		return pageHtmlDocuments;
	}
	

}
