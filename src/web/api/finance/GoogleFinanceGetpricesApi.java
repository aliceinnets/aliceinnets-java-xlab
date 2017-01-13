package web.api.finance;

import java.io.IOException;
import java.util.Arrays;

import org.jsoup.Jsoup;

public class GoogleFinanceGetpricesApi {
	
	public final static String BASE_URL = "http://www.google.com/finance/getprices"; 
	
	
	public static String getUrl(String symbol) {
		return getUrl(symbol, 86400, null, null, null);
	}
	
	
	public static String getUrl(String symbol, double interval) {
		return getUrl(symbol, interval, null, null, null);
	}
	
	
	public static String getUrl(String symbol, double interval, String period) {
		return getUrl(symbol, interval, period, null, null);
	}
	
	
	public static String getUrl(String symbol, double interval, String period, String market, String columns) {
		String url = BASE_URL+"?q="+symbol;
		if(interval > 0.0) url += "&i="+interval;
		if(period != null) url += "&p="+period;
		if(market != null) url += "&x="+market;
		if(columns != null) url += "&f="+columns;		
				
		return url;
	}
	
	
	public static String getHtmlBodyText(String url) {
		try {
			return Jsoup.connect(url).get().text();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static double[][] getData(String symbol) {
		return getData(symbol, 86400, null, null, null);
	}
	
	
	public static double[][] getData(String symbol, double interval) {
		return getData(symbol, interval, null, null, null);
	}
	
	
	public static double[][] getData(String symbol, double interval, String period) {
		return getData(symbol, interval, period, null, null);
	}
	
	
	public static double[][] getData(String symbol, double interval, String period, String market, String columns) {
		try {
			String url = getUrl(symbol, interval, period, market, columns);
			
			String bodyText = Jsoup.connect(url).get().text();
			String[] bodyTextLines = bodyText.split(" ");
			
			String exchange = bodyTextLines[0].replace("EXCHANGE", "");
			double marketOpenMinute = Double.parseDouble(bodyTextLines[1].replace("MARKET_OPEN_MINUTE=", ""));
			double marketCloseMinute = Double.parseDouble(bodyTextLines[2].replace("MARKET_CLOSE_MINUTE=", ""));
			double timeInterval = Double.parseDouble(bodyTextLines[3].replace("INTERVAL=", ""));
			String[] dataColumns = bodyTextLines[4].replace("COLUMNS=", "").split(",");
			String dataLog = bodyTextLines[5].replace("DATA", "");
			double timezoneOffset = Double.parseDouble(bodyTextLines[6].replace("TIMEZONE_OFFSET=", ""));
			
			double[][] data = new double[dataColumns.length][bodyTextLines.length-7];
			
			String[] dataStringHeader = bodyTextLines[7].split(",");
			double firstTimeStamp = Double.parseDouble(dataStringHeader[0].replace("a", ""));
			
			data[0][0] = firstTimeStamp;
			for(int i=1;i<dataStringHeader.length;++i) {
				data[i][0] = Double.parseDouble(dataStringHeader[i]);
			}
			
			for(int j=1;j<data[0].length;++j) {
				String[] dataString = bodyTextLines[j+7].split(",");
				data[0][j] = firstTimeStamp + timeInterval * Double.parseDouble(dataString[0]);
				for(int i=1;i<data.length;++i) {
					data[i][j] = Double.parseDouble(dataString[i]);
				}
			}
			
			return data;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static void main(String[] args) {
		double[][] data = getData("GOOG");
		
		for(int i=0;i<data.length;++i) {
			System.out.println(Arrays.toString(data[i]));
		}
	}
	
}

