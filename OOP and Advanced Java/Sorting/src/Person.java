public class Person implements Comparable <Person>
{
  private static int m_count;
  private String m_name;
  private int m_age;

  public Person(String name, int age)
  {
      m_name = name;
      m_age = age;
      m_count++;
  }

  public String getName()
  {
    return m_name;
  }

  public int getAge()
  {
    return m_age;
  }

  public void growOld()
  {
    m_age++;
  }

  public static int getCount()
  {
    return m_count;
  }

  @Override
  public String toString()
  {
    String s = String.format("Hello, my name is %s and I am %s years old.", m_name, m_age);
    return s;
  }
}
