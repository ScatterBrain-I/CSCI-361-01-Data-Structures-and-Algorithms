import java.util.List;
import java.util.ArrayList;

public class Main{
  public static void main(String args[]){
    // -----------------------------------
    // do not edit main...
    // -----------------------------------
    List<Person> people = new ArrayList<Person>();

    /*people.add(new Person("Frank", "Denton", 73));// open this back up before turnig in
    people.add(new Person("Mark", "Cohen", 44));
    people.add(new Person("Tim", "Smith", 22));
    people.add(new Person("Steve", "Denton", 16));
    people.add(new Person("Andy", "Ashton", 44));
    people.add(new Person("Albert", "Denton", 58));*/

    people.add(new Person("A", "A", 1)); // remove this before turning in
    people.add(new Person("E", "E", 5));
    people.add(new Person("F", "F", 6));
    people.add(new Person("C", "C", 3));
    people.add(new Person("B", "B", 2));
    people.add(new Person("D", "D", 4));

    List<Person> ans = mergeSort(people);
    System.out.println(ans);
  }

  public static List<Person> mergeSort(List<Person> items){
    List<Person> sorted = new ArrayList<Person>();

    if (items.size() == 1){
      //sorted.add(items.get(0));
      sorted = items;
      System.out.println("Base:" + sorted); //Debug line

    }
    else {
      //create two sublists
      List<Person> listA = new ArrayList<Person>();
      List<Person> listB = new ArrayList<Person>();
      List<Person> sortedA = new ArrayList<Person>();
      List<Person> sortedB = new ArrayList<Person>();

      for (int i = 0; i < items.size(); i++){
        if (i % 2 == 0){
          listA.add(items.get(i));
        }
        else {
          listB.add(items.get(i));
        }
      }
      System.out.println("A: " + listA); //Debug line
      System.out.println("B: " + listB); //Debug line
      System.out.println();
      //sort both sublists
      sortedA = mergeSort(listA);
      sortedB = mergeSort(listB);
      //merge two lists
      sorted = merge(sortedA, sortedB);
    }
    return sorted;
  }

  private static List<Person> merge(List<Person> partA, List<Person> partB){
    List<Person> merged = new ArrayList<Person>();
    int indexA = 0;
    int indexB = 0;
    System.out.println("* PartASize:" + partA.size() + "  PartBSize:"+ partB.size()); //Debug line
    while (indexA < partA.size() && indexB < partB.size()){
      if (partA.get(indexA).compareTo(partB.get(indexB)) < 0){
        merged.add(partA.get(indexA));
        System.out.println("* While if: " + merged); //Debug line
        indexA++;
      }
      /*else if (partA.get(indexA).compareTo(partB.get(indexB)) == 0){
        if(partA.get(indexA).getFirst().compareTo(partB.get(indexB).getFirst()) == -1){
          merged.add(partA.get(indexA));
          indexA++;
        }
        else{
          merged.add(partB.get(indexB));
          indexB++;
        }
      }*/
      else{
        merged.add(partB.get(indexB));
        System.out.println("* While Else: " + merged); //Debug line
        indexB++;
      }
    }

    /*if (partA.size() > 0){
      System.out.println("ifA: " + " iA:" + indexA + "  iB:" +  indexB + " " + merged); //Debug line
      merged.add(partA.get(indexA));
    }

    if (partB.size() > 0){
      System.out.println("ifB: " + " iA:" + indexA + "  iB:" +  indexB + " " + merged); //Debug line
      merged.add(partB.get(indexB));
    }*/

  return merged;
  }
}
