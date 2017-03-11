package aliceinnets.web.spider;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import aliceinnets.web.spider.condition.CollectingAll;
import aliceinnets.web.spider.condition.CollectingCondition;
import aliceinnets.web.spider.condition.CrawlingCondition;
import aliceinnets.web.spider.condition.CrawlingOnce;

/**
 * This class crawls web pages link to link and collects some data, 
 * e.g. connections between pages, from a html document.
 * 
 * @author alice<aliceinnets@gmail.com>
 *
 */
public class Spider {
	
	/** agent which spider will crawl with */  
	String userAgent;
	/** maximum body size of pages in MB */
	int maxBodySize;
	/** connection time out in millisecond */
	int timeout;
	
	List<String> pagesToVisit = new LinkedList<String>();
	List<String> pagesVisited = new LinkedList<String>();
	List<String> pagesCollected = new LinkedList<String>();
	List<String> pagesFailedToVisit = new LinkedList<String>();
	
	CrawlingCondition crawlingCondition;
	CollectingCondition collectingCondition;
	
	
	public Spider() {
		this(null);
	}
	
	/**
	 * 
	 * 
	 * @param url the link to start crawling
	 */
	public Spider(String url) {
		userAgent = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
		maxBodySize = 0; // Unlimited body size
		timeout = 60000;
		
		if(url != null && !url.equals("")) {
			pagesToVisit.add(url);
		}
		
		crawlingCondition = new CrawlingOnce(this);
		collectingCondition = new CollectingAll();
		
	}
	
	
	public void crawl(int numPagesToVisit) {
		int numPagesVisited = 0;
		while(numPagesVisited < numPagesToVisit) {
			if(pagesToVisit.isEmpty()) {
				System.out.println("No pages to visit");
				break;
			}
			
			crawl();
			++numPagesVisited;
		}
	}
	
	
	public String crawl() {
		return crawl(pagesToVisit.remove(0));
	}
	
	
	public String crawl(String url) {
		try {
			Document document = Jsoup.connect(url)
//					.header("Accept-Encoding", "gzip, deflate")
					.userAgent(userAgent)
					.maxBodySize(maxBodySize)
					.timeout(timeout)
					.get();
			
			Elements linksOnPage = document.select("a[href]");
			List<String> links = new LinkedList<String>();
			for(Element link : linksOnPage) {
				links.add(link.absUrl("href"));
			}
			
			for(String link : links) {
				if(crawlingCondition.shouldCrawl(link)) {
					pagesToVisit.add(link);
				}
			}
			
			if(collectingCondition.shouldCollect(document)) {
				pagesCollected.add(url);
				
				pagesVisited.add(url);
				System.out.println(String.format("visited page, %s", url));
				return url;
			} else {
				pagesVisited.add(url);
				System.out.println(String.format("visited page, %s", url));
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
			pagesFailedToVisit.add(url);
			System.out.println(String.format("failed to visit page, %s", url));
			return null;
		}
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


	public List<String> getPagesVisited() {
		return pagesVisited;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public int getMaxBodySize() {
		return maxBodySize;
	}

	public void setMaxBodySize(int maxBodySize) {
		this.maxBodySize = maxBodySize;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public List<String> getPagesCollected() {
		return pagesCollected;
	}

	public void setPagesCollected(List<String> pages) {
		this.pagesCollected = pages;
	}

	public CrawlingCondition getCrawlingCondition() {
		return crawlingCondition;
	}

	public void setCrawlingCondition(CrawlingCondition crawlingCondition) {
		this.crawlingCondition = crawlingCondition;
	}

	public CollectingCondition getCollectingCondition() {
		return collectingCondition;
	}

	public void setCollectingCondition(CollectingCondition collectingCondition) {
		this.collectingCondition = collectingCondition;
	}

	public void setPagesVisited(List<String> pagesVisited) {
		this.pagesVisited = pagesVisited;
	}

	public List<String> getPagesFailedToVisit() {
		return pagesFailedToVisit;
	}

	public void setPagesFailedToVisit(List<String> pagesFailedToVisit) {
		this.pagesFailedToVisit = pagesFailedToVisit;
	}
	

}
