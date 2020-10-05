import java.util.List;
import java.util.ArrayList;

public class Main{
  public static void main(String args[]){
    // -----------------------------------
    // do not edit main...
    // -----------------------------------
    List<Person> people = new ArrayList<Person>();

    people.add(new Person("Frank", "Denton", 73));
    people.add(new Person("Mark", "Cohen", 44));
    people.add(new Person("Tim", "Smith", 22));
    people.add(new Person("Steve", "Denton", 16));
    people.add(new Person("Andy", "Ashton", 44));
    people.add(new Person("Albert", "Denton", 58));

    List<Person> ans = mergeSort(people);
    System.out.println(ans);
  }

  public static List<Person> mergeSort(List<Person> items){
    List<Person> sorted = new ArrayList<Person>();
    // base case
    if (items.size() == 1){
      sorted = items;
    }
    else {
      //two sublists unsorted and two sublists after sorting
      List<Person> listA = new ArrayList<Person>();
      List<Person> listB = new ArrayList<Person>();
      List<Person> sortedA = new ArrayList<Person>();
      List<Person> sortedB = new ArrayList<Person>();
      //create two sublists
      for (int i = 0; i < items.size(); i++){
        if (i % 2 == 0){
          listA.add(items.get(i));
        }
        else {
          listB.add(items.get(i));
        }
      }
      //sort both sublists
      sortedA = mergeSort(listA);
      sortedB = mergeSort(listB);
      //merge two lists into one
      sorted = merge(sortedA, sortedB);
    }
    return sorted;
  }

  private static List<Person> merge(List<Person> partA, List<Person> partB){
    List<Person> merged = new ArrayList<Person>();
    /*
    check both lists while they each have items in them
    add element to merged list
    remove 'lower' element from original list
    */
    while (partA.size()>=1 && partB.size()>=1){
      if (partA.get(0).compareTo(partB.get(0)) < 0){
        merged.add(partA.get(0));
        partA.remove(0);
      }
      // checks by first name if last name is same
      else if (partA.get(0).compareTo(partB.get(0)) == 0){
        if(partA.get(0).getFirst().compareTo(partB.get(0).getFirst()) < 0){
          merged.add(partA.get(0));
          partA.remove(0);
        }
        else{
          merged.add(partB.get(0));
          partB.remove(0);
        }
      }
      else{
        merged.add(partB.get(0));
        partB.remove(0);
      }
    }
    //adds and removes if any items are left not needing to be compared
    while (partA.size() > 0){
      merged.add(partA.get(0));
      partA.remove(0);
    }
    while (partB.size() > 0){
      merged.add(partB.get(0));
      partB.remove(0);
    }
  return merged;
  }
}
