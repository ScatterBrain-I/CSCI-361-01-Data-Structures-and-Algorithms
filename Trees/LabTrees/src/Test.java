import java.util.*;

public class Test
{
    public static void main(String args[])
    {
        /*
                A
            B       C
         D     E       F
        */
        BinaryTree treeD = new SimpleTree("D");
        BinaryTree treeE = new SimpleTree("E");
        BinaryTree treeF = new SimpleTree("F");
        BinaryTree treeB = new SimpleTree("B", treeD, treeE);
        BinaryTree treeC = new SimpleTree("C", null, treeF);
        BinaryTree root = new SimpleTree("A", treeB, treeC);

        // D B E A C F
        String s = root.toString();
        System.out.println(s);

        List<BinaryTree> trees = new ArrayList<BinaryTree>();
        trees.add(treeD);
        trees.add(treeF);
        trees.add(treeC);
        trees.add(treeE);
        trees.add(root);
        trees.add(treeB);

        Collections.sort(trees);

        for (BinaryTree t : trees)
        {
            System.out.println();
            System.out.print(t.getValue() + " ");
            System.out.println();
        }
    }
}
