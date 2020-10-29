public class BinaryTree<T extends Comparable<T>> implements Comparable<BinaryTree<T>> {

    private T m_value;
    private BinaryTree<T> m_left;
    private BinaryTree<T> m_right;

    public BinaryTree(T value) {
        m_value = value;
        m_left = null;
        m_right = null;
    }

    public BinaryTree(T value, BinaryTree<T> left, BinaryTree<T> right) {
        m_value = value;
        m_left = left;
        m_right = right;
    }

    public BinaryTree<T> getLeft() {
        return m_left;
    }

    public BinaryTree<T> getRight() {
        return m_right;
    }

    public T getValue() {
        return m_value;
    }

    public void setLeft(BinaryTree<T> left) {
        m_left = left;
    }

    public void setRight(BinaryTree<T> right) {
        m_right = right;
    }

    public void setValue(T value) {
        m_value = value;
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        inorder(buf);
        return buf.toString();
    }

    public void inorder(StringBuffer buf) {
        if (m_left != null) {
            m_left.inorder(buf);
        }

        buf.append("\n " + m_value);

        if (m_right != null) {
            m_right.inorder(buf);
        }
    }

    public void preorder(StringBuffer buf) {
        buf.append("\n " + m_value);

        if (m_left != null) {
            m_left.preorder(buf);
        }

        if (m_right != null) {
            m_right.preorder(buf);
        }
    }

    public void postorder(StringBuffer buf) {
        if (m_left != null) {
            m_left.postorder(buf);
        }

        if (m_right != null) {
            m_right.postorder(buf);
        }

        buf.append("\n" + m_value);
    }

    @Override
    public int compareTo(BinaryTree<T> other) {
        return m_value.compareTo(other.m_value);
    }
}
