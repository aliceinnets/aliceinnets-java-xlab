package aliceinnets.web.spider.condition;

public class CrawlingOr implements CrawlingCondition {
	
	private CrawlingCondition condition1;
	private CrawlingCondition condition2;
	
	
	public CrawlingOr(CrawlingCondition condition1, CrawlingCondition condition2) {
		this.condition1 = condition1;
		this.condition2 = condition2;
	}
	

	@Override
	public boolean shouldCrawl(String url) {
		if(condition1.shouldCrawl(url) && condition2.shouldCrawl(url)) {
			return true;
		} else {
			return false;
		}
	}


	public CrawlingCondition getCondition1() {
		return condition1;
	}


	public void setCondition1(CrawlingCondition condition1) {
		this.condition1 = condition1;
	}


	public CrawlingCondition getCondition2() {
		return condition2;
	}


	public void setCondition2(CrawlingCondition condition2) {
		this.condition2 = condition2;
	}

}
