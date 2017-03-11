package aliceinnets.web.spider.condition;

import org.jsoup.nodes.Document;

public class CollectingAnd implements CollectingCondition {
	
	private CollectingCondition condition1;
	private CollectingCondition condition2;
	
	
	public CollectingAnd(CollectingCondition condition1, CollectingCondition condition2) {
		this.condition1 = condition1;
		this.condition2 = condition2;
	}
	

	@Override
	public boolean shouldCollect(Document document) {
		if(condition1.shouldCollect(document) && condition2.shouldCollect(document)) {
			return true;
		} else {
			return false;
		}
	}


	public CollectingCondition getCondition1() {
		return condition1;
	}


	public void setCondition1(CollectingCondition condition1) {
		this.condition1 = condition1;
	}


	public CollectingCondition getCondition2() {
		return condition2;
	}


	public void setCondition2(CollectingCondition condition2) {
		this.condition2 = condition2;
	}

}
