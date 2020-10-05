public class Person implements Comparable <Person>{
  private String m_first;
  private String m_last;
  private int m_age;

  public Person(String first, String last, int age){
    m_first = first;
    m_last = last;
    m_age = age;
  }

  public String getFirst(){
    return m_first;
  }

  public String getLast(){
    return m_last;
  }

  public int getAge(){
    return m_age;
  }

  // Natural Ordering by Last Name
  @Override
  public int compareTo(Person other){
    return m_last.compareTo(other.m_last);
  }

  @Override
  public String toString(){
    return m_last + ", " + m_first + " " + m_age;
  }
}
