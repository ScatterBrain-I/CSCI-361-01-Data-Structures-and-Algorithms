/*
Created this file only after doing work on paper. Wanted to double check my
work as well as run other tests to learn more. looking for patterns, nugative
inputs, 0s, etc.
*/
public class Recursion1{
  public static void main(String[] args){
    System.out.println("Number 1.1");
    System.out.println(Foo(2,7));
    System.out.println();

    System.out.println("Number 1.2");
    System.out.println(Foo(5,3));
    System.out.println();

    System.out.println("Number 1.3");
    System.out.println(Foo(15,3));
    System.out.println();

    System.out.println("Number 1.extension");
    System.out.println(Foo(100,0));
    System.out.println();

    System.out.println("Number 2.1");
    System.out.println(Foo2(10,4));
    System.out.println();

    System.out.println("Number 2.2");
    System.out.println(Foo2(4,3));
    System.out.println();

    System.out.println("Number 2.3");
    System.out.println(Foo2(4,7));
    System.out.println();

    System.out.println("Number 2.extension");
    System.out.println(Foo2(-5,0));
    System.out.println();
  }

  public static int Foo(int x, int y){
    if (x < y){
      System.out.println("(if): (" + x + ", " + y + ") = -3");
      System.out.println("Finished");
      return -3;
    }
    else {
      System.out.println("(else): (" + x + ", " + y + ") + " + y);
      return Foo(x - y, y + 3) + y;
    }
  }

  public static int Foo2(int x, int y){
    if (x > y){
      System.out.println("(if): (" + x + ", " + y + ") = -1");
      System.out.println("Finished");
      return -1;
    }
    else if (x == y){
      System.out.println("(else if): (" + x + ", " + y + ") = 1");
      System.out.println("Finished");
      return 1;
    }
    else {
      System.out.println("(else): (" + x + ", " + y + "): " + x + " * " +
      "foo (" + (x+1) + ", " + y + ")");
      return x * Foo2(x + 1, y);
    }
  }
}
