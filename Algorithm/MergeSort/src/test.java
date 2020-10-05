import java.util.List;
import java.util.ArrayList;

public class test{
  public static void main(String args[]){
    List<Integer> aaa = new ArrayList<>();
    List<Integer> bbb = new ArrayList<>();
    List<Integer> ccc = new ArrayList<>();
    aaa.add(1);
    aaa.add(3);
    aaa.add(5);
    aaa.add(7);
    aaa.add(17);
    bbb.add(2);
    bbb.add(4);
    bbb.add(6);
    bbb.add(8);
    bbb.add(10);
    bbb.add(12);
    bbb.add(14);
    bbb.add(18);
    bbb.add(20);
    bbb.add(22);
    System.out.println(aaa);
    System.out.println(bbb);
    int indexA = 0;
    int indexB = 0;
    while (aaa.size()>= 1 && bbb.size()>= 1){
      if (aaa.get(0).compareTo(bbb.get(0)) < 0){
        System.out.println(indexA + ":" + aaa.size());
        ccc.add(aaa.get(indexA));
        aaa.remove(0);
        //System.out.println("A."+indexA + "=" + aaa.get(indexA));

      }
      else{
        System.out.println(indexB + ":" + bbb.size());
        ccc.add(bbb.get(indexB));
        //System.out.println("B."+ indexB + "=" + bbb.get(indexB) );
        bbb.remove(0);
      }
    }
    while (aaa.size() > 0){
      ccc.add(aaa.get(0));
      aaa.remove(0);
      //indexA++;
    }

    while (bbb.size() > 0){
      ccc.add(bbb.get(0));
      bbb.remove(0);
      //indexB++;
    }
    System.out.println(aaa);
    System.out.println(bbb);
  System.out.println(ccc);
}
}
