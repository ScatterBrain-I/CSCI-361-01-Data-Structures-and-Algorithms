public class Main{
  public static void main(String args[])
  {
    Main m = new Main();
    m.go();
  }

  public void go()
  {
    Rectangle Default = new Rectangle();
    System.out.printf("%nDefault Rectangle:%n");
    System.out.println("Width: " + Default.getWidth());
    System.out.println("Height: " + Default.getHeight());
    System.out.println("Area: " + Default.getArea());
    System.out.println("Perimeter: " + Default.getPerimeter());

    Rectangle ThreeFour = new Rectangle(3,4);
    System.out.printf("%nRectangle 3 x 4:%n");
    System.out.println("Width: " + ThreeFour.getWidth());
    System.out.println("Height: " + ThreeFour.getHeight());
    System.out.println("Area: " + ThreeFour.getArea());
    System.out.println("Perimeter: " + ThreeFour.getPerimeter());
  }
}
