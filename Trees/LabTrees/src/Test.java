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
        SimpleTree treeD = new SimpleTree("D");
        SimpleTree treeE = new SimpleTree("E");
        SimpleTree treeF = new SimpleTree("F");
        SimpleTree treeB = new SimpleTree("B", treeD, treeE);
        SimpleTree treeC = new SimpleTree("C", null, treeF);
        SimpleTree root = new SimpleTree("A", treeB, treeC);
        
        // D B E A C F
        String s = root.toString();
        System.out.println(s);
        
        List<SimpleTree> trees = new ArrayList<SimpleTree>();
        trees.add(treeD);
        trees.add(treeF);
        trees.add(treeC);
        trees.add(treeE);
        trees.add(root);
        trees.add(treeB);
        
        Collections.sort(trees);
        
        for (SimpleTree t : trees)
        {
            System.out.println();
            System.out.print(t.getValue() + " ");
            System.out.println();
        } 
    }
}
