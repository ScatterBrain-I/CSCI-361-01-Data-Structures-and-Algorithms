public class Foo{

  public int foo(int x, int y){
    if (x < y){
      return -3;
    }
    else {
      return foo(x - y, y + 3) + y;
    }
  }
}
