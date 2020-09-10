

public class Diff extends Sum {

  public Diff(int op1, int op2)
  {
  super(op1, op2);
  }

  @Override
  public int operate()
  {
    return getOperand1()-getOperand2();
  }
}
