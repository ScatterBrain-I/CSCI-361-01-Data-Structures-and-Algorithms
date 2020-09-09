/**
 *
 * @author PeterNiemeyer
 * Assignment:Lab.Classes
 * Submitted: 8 Sept 20
 *
 **/

public class Rectangle{
  private int m_width;
  private int m_height;

  public Rectangle(){
    m_width = 2;
    m_height = 3;
  }
  public Rectangle(int w, int h){
    m_width = w;
    m_height = h;
  }
  public int getWidth(){
    return m_width;
  }

  public int getHeight(){
    return m_height;
  }

  public int getArea(){
    return m_width * m_height;
  }

  public int getPerimeter(){
    return (m_width + m_height) * 2;
  }
}
