import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    // List of inputs for test
    List<Integer> list = new ArrayList<>(Arrays.asList(6,5,9,2));

    HeapSort<Integer> examTest = new HeapSort<Integer>(list);
    System.out.println(examTest);
  }
}
