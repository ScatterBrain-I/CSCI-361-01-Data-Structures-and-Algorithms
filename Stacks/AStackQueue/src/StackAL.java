public class StackAL<T> implements IStack<T>{
	private Node m_head;
	private int m_count;

	public StackAL(){
		m_head = new Node(null);
	}

	@Override
	public void push(T item){
		Node n = new Node(item);
		n.m_next = m_head.m_next;
		m_head.m_next = n;
		m_count++;
	}

	@Override
	public T pop(){
		if (isEmpty()){
			throw new IllegalStateException("pop error: stack is empty!");
		}
		m_count--;
		T ret = m_head.m_next.m_data;
		m_head.m_next = m_head.m_next.m_next;
		return ret;
	}

	@Override
	public T top(){
		if (isEmpty()){
			throw new IllegalStateException("top error: stack is empty!");
		}
		return  m_head.m_next.m_data;
	}

	@Override
	public boolean isEmpty(){
		return getSize() == 0;
	}

	@Override
	public int getSize(){
		return m_count;
	}

	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer("top->");
		if (!isEmpty()){
			Node node = m_head.m_next;
			sb.append(node.m_data.toString());
			while (node.m_next != null){
				node = node.m_next;
				sb.append("->");
				sb.append(node.m_data.toString());
			}
		}
		return sb.toString();
	}

	private class Node{
	 	private T m_data;
	 	private Node m_next;

		public Node(T data){
			m_data = data;
			m_next = null;
		}
	}
}
