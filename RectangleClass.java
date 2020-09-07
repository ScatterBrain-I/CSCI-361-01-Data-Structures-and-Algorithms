/*
Professor Desanty, I interpreted the UML so my class does not resemble it
exactly. The UML had a function Rectangle() as well as Rectangle(int w, int h).
I only need one constructor as so left out the first. I also anticpated The
function getParameter() to be getPerimmiter() and so coded appropriately.
I hope my assumptions were not presumptuous.
*/

public class Rectangle{
  private int m_width;
  private int m_height;

  public Rectangle(int w, int h){
    m_width = w;
    m_height = h;
  }
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
