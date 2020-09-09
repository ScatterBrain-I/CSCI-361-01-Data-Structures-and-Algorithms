/**
 *
 * @author PeterNiemeyer
 * Assignment: Lab.Interfaces
 * Submitted: 10 Sept 20
 *
 **/

public class Main{
  public static void main(String args[])
  {
    Main m = new Main();
    m.go();
  }

  public void go()
  {
  //Test it...
    Pig Dave = new Pig("Dave");
    Duck Hebert = new Duck("Hebert");
    Pig Snarkle = new Pig("Snarkle");
    Duck Lenora = new Duck("Lenora");
    System.out.println();
    System.out.println(Dave.makeSound());
    System.out.println(Hebert.makeSound());
    System.out.println(Snarkle.makeSound());
    System.out.println(Lenora.makeSound());
    System.out.println();

  }
}
