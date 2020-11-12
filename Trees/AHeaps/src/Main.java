public class Main {
    public static void main(String[] args) {
       int[] l = {1, 2, 3, 8, 9, 7};
       Heap h = new Heap();
       // add an array of items and print
       h.insertAll(l);
       System.out.println(h);
       //add individual items and print
       h.insert(6);
       h.insert(5);
       h.insert(10);
       h.insert(4);
       System.out.println(h);
       //remove an item (print statement to show working return) - rebuild heap - print
       System.out.println(h.removeTop());
       System.out.println(h);
       //clear the heap and print
       h.clear();
       System.out.println(h);
    }
}
