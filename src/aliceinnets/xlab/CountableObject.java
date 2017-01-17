package aliceinnets.xlab;

public class CountableObject implements Comparable<CountableObject>{
	public Object object;
	public int numObjects;
	
	public CountableObject(Object object, int numObjects) {
		// TODO Auto-generated constructor stub
		this.object = object;
		this.numObjects = numObjects;
	}
	
	public Object getObject() { return object; }
	public String getObjectToString() { return object.toString(); }
	public int getNumObjects() { return numObjects; }
	
	public void add(int numAddObjects) {
		numObjects = numObjects+numAddObjects;
	}
	
	public void subtract(int numSubtractObjects) {
		numObjects = numObjects-numSubtractObjects;
	}
	
	public int compareToByNumber(CountableObject countableObject) {
		if(numObjects > countableObject.getNumObjects()) return -1;
		if(numObjects < countableObject.getNumObjects()) return +1;
		return 0;
	}

	@Override
	public int compareTo(CountableObject countableObject) {
		// TODO Auto-generated method stub
		return object.toString().compareTo(countableObject.getObjectToString());
	}
	

}
