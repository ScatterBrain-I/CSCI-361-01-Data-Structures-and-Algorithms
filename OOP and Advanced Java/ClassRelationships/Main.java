/**
 *
 * @author PeterNiemeyer
 * Assignment: Lab.Class_Relationships
 * Submitted: 8 Sept 20
 *
 **/

import java.util.*;

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

  public class Schedule
  {
    private ArrayList<Course> m_courses=new ArrayList<Course>();
    private Course m_course;

    public Schedule()
    {}

    public void addCourse(Course c)
    {
      m_course = c;
      m_courses.add(c);
    }

    @Override //This is ugly. How can I make this cleaner?
    public String toString()
    {
      String s = "";
      System.out.println("Your Schedule");
      for (Course c : m_courses)
      {
        System.out.printf(c.toString());
      }
      return s;
    }
  }

  public class Course
  {
    private String m_title;
    private String m_start;
    private String m_end;

    public Course(String title, String start, String end)
    {
      m_title = title;
      m_start = start;
      m_end = end;
    }

    public String getTitle()
    {
      return m_title;
    }

    public String getStart()
    {
      return m_start;
    }

    public String getEnd()
    {
      return m_end;
    }

    @Override
    public String toString()
    {
      String s = String.format("%s: %s - %s%n", m_title, m_start, m_end);
      return s;
    }
  }

}
