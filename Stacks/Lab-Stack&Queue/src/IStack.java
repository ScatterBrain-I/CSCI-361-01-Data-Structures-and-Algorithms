public interface IStack<T>
{
	public void push(T item);

	public T pop();

	public T top();

	public boolean isEmpty();

	public int getSize();
}
