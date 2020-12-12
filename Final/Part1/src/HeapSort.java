import java.util.List;
import java.util.ArrayList;

public class HeapSort<T> {
    private static List<Integer> result;

    public HeapSort(List<Integer> items) {
        sortHeap(items);
    }

    public static List<Integer> sortHeap(List<Integer> items) {
        List<Integer> nodes = new ArrayList<Integer>();
        Heap<Integer> maxHeap = new Heap<Integer>();
        maxHeap.insertAll(items);
        while (maxHeap.size() > 0) {
            nodes.add(0, maxHeap.removeTop());
        }
        result = nodes;
        return result;
    }

    @Override
    public String toString() {
        return result.toString();
    }
}
