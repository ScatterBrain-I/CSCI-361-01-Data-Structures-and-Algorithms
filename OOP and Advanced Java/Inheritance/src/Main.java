/**
 *
 * @author PeterNiemeyer
 * Assignment: Lab.Inheritance
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
    //test it...
    IBinaryOperator s = new Sum(8, 12);
    System.out.println(s.operate());
    s.setOperand1(18);
    System.out.println(s.operate());

    IBinaryOperator d = new Diff(8, 12);
    System.out.println(d.operate());
    d.setOperand1(18);
    System.out.println(d.operate());
  }
}
