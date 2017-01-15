package util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Resizable-array that contains no duplicate elements. This class extends
 * the <tt>ArrayList</tt> class {@link ArrayList} and has a hashset, 
 * which is the <tt>HashSet<tt> class {@link HashSet}, in order to
 * prevent adding duplicate elements.
 * 
 * @author alice<aliceinnets@gmail.com>
 * 
 */
public class SetArrayList<E> extends ArrayList<E> {
	private static final long serialVersionUID = -4774576773745703842L;
	
	HashSet<E> hashset;
	
	public SetArrayList() {
		super();
		hashset = new HashSet<E>();
	}
	
	public SetArrayList(int initialCapacity) {
		super(initialCapacity);
		hashset = new HashSet<E>(initialCapacity);
	}
	
	public SetArrayList(Collection<? extends E> c) {
		super(new HashSet<E>(c));
		hashset = new HashSet<E>(c);
	}
	
	@Override
	public boolean add(E e) {
		if(hashset.add(e)) {
			return super.add(e);
		} else {
			return false;
		}
	}
	
	@Override
	public void add(int index, E element) {
		_add(index, element);
	}
	
	private boolean _add(int index, E element) {
		if(hashset.add(element)) {
			super.add(index, element);
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean addAll(Collection<? extends E> c) {
		int numNew = 0;
		for(E e : c) {
			if(add(e)) {
				++numNew;
			}
		}
		return numNew != 0;
	}
	
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		int numNew = 0;
		for(E e : c) {
			if(_add(index+numNew, e)) {
				++numNew;
			}
		}
		return numNew != 0;
	}
	

}
