package aliceinnets.web.spider.condition;

import org.jsoup.nodes.Document;

public interface CollectingCondition {
	
	public boolean shouldCollect(Document document);

}
