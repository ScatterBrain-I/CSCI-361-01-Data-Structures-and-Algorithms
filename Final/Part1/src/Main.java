import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // List of inputs
        List<Integer> list = new ArrayList<>(Arrays.asList(6,5,9,2));

        // make new object - call sorting method - print result 2,5,6,9 expected
        HeapSort<Integer> examTest = new HeapSort<Integer>();
        List<Integer> result = examTest.sortHeap(list);
        System.out.println(result);
    }
}
