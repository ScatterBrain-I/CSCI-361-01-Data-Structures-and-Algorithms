import java.util.Collections;
import java.util.Comparator;

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
        if (n.m_char != '\0') {
			System.out.println(n.toString());
		}
        if (n.m_left != null) {
            _printTree(n.m_left);
        }
        if (n.m_right != null) {
            _printTree(n.m_right);
        }
	}

	@Override
	public String toString() {
		return String.format("%s (%2d)", m_char, m_total);
	}

	@Override
	public int compareTo(Tree t2) {
		int sort =  Integer.valueOf(m_total).compareTo(Integer.valueOf(t2.m_total));
        if (sort == 0) {
			sort = String.valueOf(m_char).compareTo(String.valueOf(t2.m_char));
        }
        return sort;

	}
}
