

public class Sum implements IBinaryOperator
{
  private int m_op1;
  private int m_op2;

  public Sum(int op1, int op2)
  {
    m_op1 = op1;
    m_op2 = op2;
  }

  @Override
  public void setOperand1(int o1)
  {
    m_op1 = o1;
  }

  @Override
  public void setOperand2(int o2)
  {
    m_op2 = o2;
  }

  @Override
  public int getOperand1()
  {
    return m_op1;
  }

  @Override
  public int getOperand2()
  {
    return m_op2;
  }

  @Override
  public int operate()
  {
    return m_op1 + m_op2;
  }
}
