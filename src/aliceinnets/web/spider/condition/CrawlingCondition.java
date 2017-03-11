package aliceinnets.web.spider.condition;

public interface CrawlingCondition {
	
	public boolean shouldCrawl(String url);

}
