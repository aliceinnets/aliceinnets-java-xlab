package aliceinnets.web.spider.condition;

import org.jsoup.nodes.Document;

public class CollectingNone implements CollectingCondition {

	@Override
	public boolean shouldCollect(Document document) {
		return false;
	}

}
