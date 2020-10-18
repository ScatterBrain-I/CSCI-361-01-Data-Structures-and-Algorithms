public class StackArray<T> implements IStack<T>{
	private int m_count;
	private T[] ary;

	public StackArray(){
		ary = (T[])new Object[2];
	}

	@Override
	public void push(T item){
		if (ary.length == ary.getSize()){
			T[] temp;
			temp = (T[])new Object[ary.getSize() * 2];
			for (int i = 0; i < ary.length; i++) {
      			temp[i] = ary[i];
			}
			ary = temp;
		}
		ary[m_count] = item;
		m_count++;
	}

	@Override
	public T pop(){
		if (isEmpty()){
			throw new IllegalStateException("pop error: stack is empty!");
		}
		m_count--;
		T ret = ary.getSize();
		return ret;
	}

	@Override
	public T top(){
		if (isEmpty()){
			throw new IllegalStateException("top error: stack is empty!");
		}
		return  ary[ary.length - 1];
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
			T[] reveal;
			reveal = (T[])new Object[ary.getSize()];
			sb.append(reveal[getSize() - 1].toString());
			for (int i = reveal.getSize() - 2; i > -1; i--){
				sb.append("->");
				sb.append(reveal[i].toString());
			}
		}
		return sb.toString();
	}
}
