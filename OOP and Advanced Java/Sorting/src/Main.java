import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Main
{
	private Object m_p1;
	private Object m_p2;

	public static void main(String[] args)
	{
		Main m = new Main();
		m.go();
	}

	private void go()
	{
		Person p1 = new Person("Peter", 48);
    Person p2 = new Person("Paul", 79);
    Person p3 = new Person("Susan", 79);
    Person p4 = new Person("Ramashish", 47);
    Person p5 = new Person("Sugdeo", 68);
    Person p6 = new Person("Michele", 47);
    Person p7 = new Person("Maya", 16);
    Person p8 = new Person("Walker", 19);
    Person p9 = new Person("Sonya", 19);
    Person p10 = new Person("Dylan", 14);

    List<Person> people = new ArrayList<Person>();
    people.add(p1);
    people.add(p2);
    people.add(p3);
    people.add(p4);
    people.add(p5);
    people.add(p6);
    people.add(p7);
    people.add(p8);
    people.add(p9);
    people.add(p10);


		System.out.println(people);
    Collections.sort(people);

    System.out.println(people);
    Collections.sort(people,
      new Comparator<Person>(){
        @Override //OVerrides
        public int compare (Person first, Person second){
          if (first.getAge() > second.getAge())
            return 1;
          else if (first.getAge() < second.getAge())
            return -1;
          else
              return 0;
        }
      }
    );
    System.out.println(people);
	}
}
