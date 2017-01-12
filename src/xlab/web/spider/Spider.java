package xlab.web.spider;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Spider {
	private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1"; 
	
	public static List<String> crawl(String url) {
		try {
			Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
			if(connection.response().contentType().contains("text/html")) {
				Document document = connection.get();
				Elements linksOnPage = document.select("a[href]");
				
				List<String> links = new LinkedList<String>();
				for(Element link : linksOnPage) {
					links.add(link.absUrl("href"));
				}
				
				return links;
			} else {
				return null;
			}
		} catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public static int countWord(String document, String word) {
		int count = 0;
		
		String[] wordsInDocument = document.toLowerCase().split("\\s+");
		for(int i=0;i<wordsInDocument.length;++i) {
			wordsInDocument[i] = wordsInDocument[i].replaceAll("[^\\w]", "");
			if(wordsInDocument[i].equals(word)) ++count;
		}
		
		return count;
	}
	
	

}
