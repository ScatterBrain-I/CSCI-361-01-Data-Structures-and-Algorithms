/**
 *
 * @author PeterNiemeyer
 * Assignment: Lab.Class_Relationships
 * Submitted: 8 Sept 20
 *
 **/

import java.util.List;
import java.util.ArrayList;

public class Main{
  public static void main(String args[])
  {
    Main m = new Main();
    m.go();
  }

  public void go()
  {
    Schedule sc1 = new Schedule();
    Schedule sc2 = new Schedule();

    Course c0 = new Course("Hybrid HS", "7:40am", "2:30pm");
    Course c1 = new Course("Networking", "8am", "8:50am");
    Course c2 = new Course("Database","9am","9:50am");
    Course c3 = new Course("Web Development","10am","10:50am");
    Course c4 = new Course("Java I","12pm","12:50pm");
    Course c5 = new Course("Yoga","1pm","1:50pm");
    Course c6 = new Course("OOP and Advanced Java", "Online", "");

    sc1.addCourse(c1);
    sc1.addCourse(c2);
    sc1.addCourse(c3);
    sc1.addCourse(c4);
    sc1.addCourse(c5);

    sc2.addCourse(c0);
    sc2.addCourse(c6);

    //Test it...
    System.out.printf("%nHere is Course 'c1' toString():%n");
    System.out.print(c1.toString());
    System.out.printf("%nHere is Schedule 'sc1' toString():%n");
    sc1.toString();
    System.out.printf("%n");
    System.out.printf("%nHere is Schedule 'sc2' toString():%n");
    sc2.toString();
    System.out.printf("%n");
  }
}
