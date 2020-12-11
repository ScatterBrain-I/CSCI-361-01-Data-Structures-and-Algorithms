import java.util.List;
import java.util.ArrayList;

public class HeapSort<T> {
    public static List<Integer> sortHeap(List<Integer> items) {
        List<Integer> nodes = new ArrayList<Integer>();
        Heap<Integer> maxHeap = new Heap<Integer>();
        maxHeap.insertAll(items);
        while (maxHeap.size() > 0) {
            nodes.add(0, maxHeap.removeTop());
        }
        return nodes;
    }
}
