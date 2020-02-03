import java.util.Collection;



public interface iStack<T> {
	
	public void push(T element);
	public T pop();
	public T get(int index);
	public int getIndex(T object);
	public void addAll(Collection<T> values);
	public int size();

}
