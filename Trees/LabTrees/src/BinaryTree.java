public class BinaryTree implements Comparable<BinaryTree>
{
    private String m_value;
    private BinaryTree m_left;
    private BinaryTree m_right;

    public SimpleTree(String value)
    {
        m_value = value;
        m_left = null;
        m_right = null;
    }

    public SimpleTree(String value,
                      BinaryTree left,
                      BinaryTree right)
    {
        m_value = value;
        m_left = left;
        m_right = right;
    }

    public BinaryTree getLeft()
    {
        return m_left;
    }

    public BinaryTree getRight()
    {
        return m_right;
    }

    public String getValue()
    {
        return m_value;
    }

    public void setLeft(BinaryTree left)
    {
        m_left = left;
    }

    public void setRight(BinaryTree right)
    {
        m_right = right;
    }

    public void setVale(String value)
    {
        m_value = value;
    }

    @Override
    public String toString()
    {
        StringBuffer buf = new StringBuffer();
        inorder(buf);
        return buf.toString();
    }

    public void inorder(StringBuffer buf)
    {
        if (m_left != null)
            m_left.inorder(buf);

        buf.append("\n"+ m_value);

        if (m_right != null)
            m_right.inorder(buf);
    }

    public void preorder(StringBuffer buf)
    {
        buf.append("\n"+ m_value);

        if (m_left != null)
            m_left.preorder(buf);

        if (m_right != null)
            m_right.preorder(buf);
    }

    public void postorder(StringBuffer buf)
    {
        if (m_left != null)
            m_left.postorder(buf);

        if (m_right != null)
            m_right.postorder(buf);

        buf.append("\n"+ m_value);
    }

    @Override
    public int compareTo(BinaryTree other)
    {
        return m_value.compareTo(other.m_value);
    }

}
