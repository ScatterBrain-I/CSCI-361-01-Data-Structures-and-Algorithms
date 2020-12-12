import java.util.List;
import java.util.ArrayList;

public class Tree implements Comparable<Tree> {
  private Tree m_left;
  private Tree m_right;
  private Tree m_parent;
  private char m_char;
  private int m_total;

  public Tree(Tree l, Tree r, char ch, int total) {
    m_left = l;
    m_right = r;
    m_char = ch;
    m_total = total;
  }

  public Tree getLeft() {
    return m_left;
  }

  public Tree getRight() {
    return m_right;
  }

  public Tree getParent() {
    return m_parent;
  }

  public void setParent(Tree n) {
    m_parent = n;
  }

  public int getTotal() {
    return m_total;
  }

  public char getChar() {
    return m_char;
  }

  public void printTree() {
    _printTree(this);
  }

  public void _printTree(Tree n) {
    System.out.println(toString());
  }

  @Override
  public String toString() {
    List<String> buf = new ArrayList<String>();
    preorder(buf);
    return buf.toString();
  }

  @Override
  public int compareTo(Tree t2) {
    return getTotal() - t2.getTotal();
  }

  public void preorder(List<String> buf) {
    buf.add(m_total + ":" + m_char);
    if (m_left != null) {
      m_left.preorder(buf);
    }

    if (m_right != null) {
      m_right.preorder(buf);
    }
  }

  public boolean isLeaf() {
    return (getLeft() == null);
  }
}
