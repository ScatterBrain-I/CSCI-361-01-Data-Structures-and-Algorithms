import java.util.Arrays;

public class Main
{
   public static void main(String[] args)
   {
      int[] l = {1, 2, 3, 8, 9, 7};
      Heap h = new Heap();
      h.insertAll(l);
      System.out.println(h);
      h.insert(6);
      h.insert(5);
      h.insert(10);
      h.insert(4);
      System.out.println(h);
      h.removeTop();
      System.out.println(h);

   }
}
