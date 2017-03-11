package aliceinnets.web.spider.condition;

public class CrawlingAll implements CrawlingCondition {

	@Override
	public boolean shouldCrawl(String url) {
		return true;
	}

}
