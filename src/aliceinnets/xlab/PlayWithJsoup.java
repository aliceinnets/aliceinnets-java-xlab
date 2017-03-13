package aliceinnets.xlab;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class PlayWithJsoup {
	
	public static void main(String[] args) {
		play();
	}

	private static void play() {
		String username = "foo";
		String password = "bar";
		String login = username + ":" + password;
		String base64login = new String(Base64.encodeBase64(login.getBytes()));

		try {
			Document document = Jsoup
			    .connect("https://github.com/aliceinnets")
			    .header("Authorization", "Basic " + base64login)
			    .get();
			
//			System.out.println(document);
			
			document = Jsoup
					.connect("https://github.com/aliceinnets")
					.get();
			
			System.out.println(document);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
