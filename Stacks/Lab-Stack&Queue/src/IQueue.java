public interface IQueue<T>{
	public void enqueue(T item);

	public T dequeue();

	public boolean isEmpty();

	public int getSize();

  	public void reverse();

  	public void sort();
}
