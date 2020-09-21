import java.util.List;
import java.util.ArrayList;

public class Schedule
{
  private List<Course> m_courses=new ArrayList<Course>();
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
