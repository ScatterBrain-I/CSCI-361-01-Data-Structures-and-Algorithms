import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class MinStack<T extends Comparable<T>> implements IStack<T>{
    private IStack<T> auxillary;
    private IStack<T> mainStack;

    public static void main(String args[]) {
        //Test add 5, find min, add 5 more, find min, pop 2, find min
        MinStack<Integer> test = new MinStack<Integer>();
        test.push(42);
        test.push(343);
        test.push(8);
        test.push(23);
        test.push(169);
        System.out.println("\nPush 5 Random Items: ");
        System.out.println(test);
        System.out.println("Minimum is " + test.min());
        test.push(500);
        test.push(411);
        test.push(911);
        test.push(3);
        test.push(81);
        System.out.println("\nPush 5 more Random Items: ");
        System.out.println(test);
        System.out.println("Minimum is " + test.min());
        test.pop();
        test.pop();
        System.out.println("\nPop twice to get rid of the low and retest: ");
        System.out.println("Minimum is " + test.min());
    }

    private Node m_head;
    private int m_count;
    public MinStack() {
        m_head = new Node(null);
        m_count = 0;
        auxillary = new StackLL<T>();
        mainStack = new StackLL<T>();
    }

    public T min() {
        return auxillary.top();
    }

    @Override
	public void push(T item) {
		// runs in constant time...
        mainStack.push(item);
        if (auxillary.isEmpty()) {
            auxillary.push(item);
        }
        if (mainStack.top().compareTo(auxillary.top()) < 0) {
            auxillary.push(item);
        }
		Node n = new Node(item);
		n.m_next = m_head.m_next;
		m_head.m_next = n;
		m_count++;
	}

    @Override
    public T pop() {
        // runs in constant time...

        if (isEmpty())
            throw new IllegalStateException("pop error: stack is empty!");
        if (mainStack.top() == auxillary.top()) {
            mainStack.pop();
            auxillary.pop();
        }
        mainStack.pop();
        m_count--;
        T ret = m_head.m_next.m_data;
        m_head.m_next = m_head.m_next.m_next;
        return ret;
    }

    @Override
    public T top() {
        // runs in constant time...

        if (isEmpty()) {
            throw new IllegalStateException("top error: stack is empty!");
        }
        return  m_head.m_next.m_data;
    }

    @Override
    public boolean isEmpty() {
        // runs in constant time...

        return getSize() == 0;
    }

    @Override
    public int getSize() {
        // runs in constant time...
        return m_count;
    }

    @Override
    public String toString() {
        // runs in linear time...

        StringBuffer sb = new StringBuffer("top->");
        if (!isEmpty()) {
            Node node = m_head.m_next;
            sb.append(node.m_data.toString());
            while (node.m_next != null) {
                node = node.m_next;
                sb.append("->");
                sb.append(node.m_data.toString());
            }
        }
        return sb.toString();
    }

    /**
     * <p>Internal class used to represent a link in a linked list
     * structure.  Each node in the list contains the element
     * that was added to the stack, as well as a reference to the
     * next item in the stack.</p>
     */
    private class Node{
        private T m_data;
        private Node m_next;

        public Node(T data) {
            m_data = data;
            m_next = null;
        }
    }
}
