import java.io.IOException;

import org.jsoup.Jsoup;

public class OneLiners {
	
	public static String getHtmlBodyText(String url) {
		try {
			return Jsoup.connect(url).get().text();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
