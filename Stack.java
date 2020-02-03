/**
 * 
 */

/**
 * @author MAQUITO
 *
 */
import java.util.Collection;
import java.util.Vector;


public class Stack<T> implements iStack<T> {
	private Vector<T> vector = new Vector<T>();
	
	@Override
	public void push(T element) {
		// TODO Auto-generated method stub
		vector.add(element);
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		T lastValue = vector.lastElement();
		vector.remove(vector.size()-1);
		
		return lastValue;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return vector.get(index);
	}

	@Override
	public int getIndex(T object) {
		// TODO Auto-generated method stub
		return vector.indexOf(object);
		
	}

	@Override
	public void addAll(Collection<T> values) {
		// TODO Auto-generated method stub
		for(T value:values) {
			vector.add(value);
			
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return vector.size();
		
	}
	

}
