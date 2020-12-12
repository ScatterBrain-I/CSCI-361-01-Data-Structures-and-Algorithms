import java.util.List;
import java.util.ArrayList;

public class Heap<T extends Comparable<T>> implements IHeap<T> {
  private List<T> nodes;

  public Heap() {
    clear();
  }

  @Override
  public void insert(T item) {
    nodes.add(item);
    reheapUp(lastIndex());
  }

  @Override
  public void insertAll(List<T> items) {
    for (T item : items) {
      insert(item);
    }
  }

  @Override
  public int size() {
    return nodes.size();
  }

  @Override
  public T removeTop() {
    T oldTop = nodes.get(0);

    if (size() > 0) {
      nodes.set(0, nodes.get(lastIndex()));
      nodes.remove(size() -1);
    }

    reheapDown(0);
    return oldTop;
  }

  @Override
  public void clear() {
    nodes = new ArrayList<T>();
  }

  public void reheapUp(int index) {
    if (index == 0) {
      return;
    }

    int parentIndex = getParentIndex(index);
    T current = nodes.get(index);
    T parent = nodes.get(parentIndex);

    if (current.compareTo(parent) > 0) {
      swap(index, parentIndex);
      reheapUp(parentIndex);
    }
  }

  private void reheapDown(int index) {
    if (size() == 0) {
      return;
    }

    T me = nodes.get(index);

    int leftIndex = getLeftIndex(index);
    int rightIndex = getRightIndex(index);
    T left = null;
    T right = null;

    if (leftIndex < size()) {
      left = nodes.get(getLeftIndex(index));
    }

    if (rightIndex < size()) {
      right = nodes.get(getRightIndex(index));
    }

    // no children, can't move down...
    if (left == null && right == null) {
      return;
    }

    // I am bigger than both children, can't move down...
    if (left != null && compare(me, left) > 0 && right != null && compare(me, right) > 0) {
      return;
    }

    // I am smaller than both children, so move towards the larger child...
    if (left != null && compare(me, right) < 0 && right != null && compare(me, left) < 0) {
      if (compare(left, right) > 0) {
        reheapDownLeft(index);
      }
      else {
        reheapDownRight(index);
      }
    }
    // I am smaller than the left, so move down to the left...
    else if (left != null && compare(me, left) < 0) {
      reheapDownLeft(index);
    }
    // I am smaller than the right, so move down to the right...
    else if (right != null && compare(me, right) < 0) {
      reheapDownRight(index);
    }
  }

  private void reheapDownLeft(int index) {
    swap(index, getLeftIndex(index));
    reheapDown(getLeftIndex(index));
  }

  private void reheapDownRight(int index) {
    swap(index, getRightIndex(index));
    reheapDown(getRightIndex(index));
  }

  private void swap(int a, int b) {
    T temp = nodes.get(a);
    nodes.set(a, nodes.get(b));
    nodes.set(b, temp);
  }

  private int getParentIndex(int index) {
    return (index - 1) / 2;
  }

  private int getLeftIndex(int index) {
    return (2 * index) + 1;
  }

  private int getRightIndex(int index) {
    return (2 * index) + 2;
  }

  private int lastIndex() {
    return size() - 1;
  }

  private int compare(T item1, T item2) {
    if (item1 == null || item2 == null) {
      return 0;
    }

    return item1.compareTo(item2);
  }

  @Override
  public String toString() {
    return nodes.toString();
  }
}
