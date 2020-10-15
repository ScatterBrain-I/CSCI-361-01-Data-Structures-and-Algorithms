import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class QueueLL<T extends Comparable<T>> implements IQueue<T>{
  public static void main(String args[]){
    //Test
    IQueue<Integer> queue = new QueueLL<Integer>();
    // Enqueue (five items in random order)
    queue.enqueue(42);
    queue.enqueue(343);
    queue.enqueue(8);
    queue.enqueue(23);
    queue.enqueue(169);
    System.out.println("\nEnqueue 5 Random Items: ");
    System.out.println(queue);
    // Dequeue
    System.out.println("\nDequeue 1 item: ");
    queue.dequeue();
    System.out.println(queue);
    //Reverse queue
    System.out.println("\nReverse the queue: ");
    queue.reverse();
    System.out.println(queue);
    //Sort queue
    System.out.println("\nSort the queue: ");
    queue.sort();
    System.out.println(queue);
  }

  private Node m_head;
  private int m_count;
  public QueueLL(){
    m_head = new Node(null);
    m_count = 0;
  }

  public void reverse(){
    IStack<T> stack = new StackLL<T>();
    m_count = getSize();
    while (m_count > 0){
      stack.push(dequeue());
    }
    m_count = stack.getSize();
    for (int i = m_count; i > 0; i--){
      enqueue(stack.pop());
    }
  }

	public void sort(){
    ArrayList<T> temp  = new ArrayList<T>();
    for (int i = 0; i < getSize(); i++){
      temp.add(dequeue());
    }
    Collections.sort(temp);
    for (T x : temp){
      enqueue(x);
    }
  }

	@Override
	public void enqueue(T item){
		// FIFO: this queue places new items at the head of the queue...
		Node n = new Node(item);
		n.m_next = m_head.m_next;
		m_head.m_next = n;
		m_count++;
  }

	@Override
	public T dequeue(){
    // FIFO: this queue removes items from the tail of the queue...
    if (isEmpty()){
      throw new IllegalStateException("dequeue error: queue is empty!");
    }

    T ret = null;
    Node cur = m_head;

    // while not at the tail...
    while (cur.m_next != null){
      // if I am at the second from the tail of the queue...
      if (cur.m_next.m_next == null){
        // grab the data from the last item in the queue...
        ret = cur.m_next.m_data;
        // detatch the last item in the queue...
        cur.m_next = null;
        break;
      } else {
        // otherwise, continue moving towards the tail of the queue...
        cur = cur.m_next;
      }
    }
    m_count--;
    return ret;
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
    StringBuffer sb = new StringBuffer("rear->");
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
