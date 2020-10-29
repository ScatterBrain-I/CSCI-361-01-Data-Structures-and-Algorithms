import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Test{
    public static void main(String args[]){
        /*
                A
            B       C
         D     E       F
        */
        BinaryTree<String> treeD = new BinaryTree<String>("D");
        BinaryTree<String> treeE = new BinaryTree<String>("E");
        BinaryTree<String> treeF = new BinaryTree<String>("F");
        BinaryTree<String> treeB = new BinaryTree<String>("B", treeD, treeE);
        BinaryTree<String> treeC = new BinaryTree<String>("C", null, treeF);
        BinaryTree<String> root = new BinaryTree<String>("A", treeB, treeC);

        // D B E A C F
        String s = root.toString();
        System.out.println(s);

        List<BinaryTree<String>> trees = new ArrayList<BinaryTree<String>>();
        trees.add(treeD);
        trees.add(treeF);
        trees.add(treeC);
        trees.add(treeE);
        trees.add(root);
        trees.add(treeB);

        Collections.sort(trees);

        for (BinaryTree t : trees){
            System.out.println();
            System.out.print(t.getValue() + " ");
            System.out.println();
        }

        /*          9
                5       13
            2       7       17
        1
        */
        BinaryTree<Double> tree1 = new BinaryTree<Double>(1.0);
        BinaryTree<Double> tree2 = new BinaryTree<Double>(2.2, tree1, null);
        BinaryTree<Double> tree7 = new BinaryTree<Double>(7.3);
        BinaryTree<Double> tree17 = new BinaryTree<Double>(17.9);
        BinaryTree<Double> tree5 = new BinaryTree<Double>(5.2, tree2, tree7);
        BinaryTree<Double> tree13 = new BinaryTree<Double>(13.1, null, tree17);
        BinaryTree<Double> root9 = new BinaryTree<Double>(9.9, tree5, tree13);

        // 1 2 5 7 9 13 17
        String s2 = root9.toString();
        System.out.println(s2);

        List<BinaryTree<Double>> treeDoub = new ArrayList<BinaryTree<Double>>();
        treeDoub.add(tree1);
        treeDoub.add(tree7);
        treeDoub.add(tree17);
        treeDoub.add(tree13);
        treeDoub.add(root9);
        treeDoub.add(tree2);
        treeDoub.add(tree5);

        Collections.sort(treeDoub);

        for (BinaryTree t : treeDoub){
            System.out.println();
            System.out.print(t.getValue() + " ");
            System.out.println();
        }
    }
}
