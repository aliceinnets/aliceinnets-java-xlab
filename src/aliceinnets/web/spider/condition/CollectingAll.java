package aliceinnets.web.spider.condition;

import org.jsoup.nodes.Document;

public class CollectingAll implements CollectingCondition {

	@Override
	public boolean shouldCollect(Document document) {
		return true;
	}
	
}
