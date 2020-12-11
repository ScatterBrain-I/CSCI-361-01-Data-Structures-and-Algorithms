import java.util.List;

public interface IHeap<T extends Comparable<T>> {
  public void insert(T item);
  public void insertAll(List<T> items);
  public int size();
  public T removeTop();
  public void clear();
}
