import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.go();
    }

    public void go() {
        int ary[] = {82, 79, 46, 16, 12, 39, 41, 6, 4, 11};
        //int ary[] = {82, 79, 46, 3, 12, 39, 41, 6, 4, 11};
        //int ary[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        //int ary[] = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        //int ary[] = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};


        int root = getRoot(ary);
        System.out.printf("Root: %s%n", root);

        List<Integer> leaves = getAllLeaves(ary);
        System.out.printf("Leaves: %s%n", leaves);

        List<Integer> parents = getAllParents(ary);
        System.out.printf("Parents: %s%n", parents);

        boolean isMaxHeap1 = isMaxHeap(0, ary);
        System.out.printf("Is MaxHeap: %s%n", isMaxHeap1);
    }

    // ---------------------------------------------------------------
    // return the value of the root of the tree represented by ary
    // ---------------------------------------------------------------
    public int getRoot(int ary[]) {
        return ary[0];
    }

    // ---------------------------------------------------------------
    // return a list containing the values for all of the nodes in the
    // tree that are leaves
    // ---------------------------------------------------------------
    public List<Integer> getAllLeaves(int ary[]) {
        List<Integer> l = new ArrayList<Integer>();
        for (int i = 0; i < ary.length; i++) {
            if (i * 2 + 1 > ary.length || i * 2 + 2 > ary.length) {
                System.out.println(i + ":" + ary[i]);
                l.add(ary[i]);
            }
        }
        return l;
    }

    // ---------------------------------------------------------------
    // return a list containing the values for all of the nodes in the
    // tree that are parents
    // ---------------------------------------------------------------
    public List<Integer> getAllParents(int ary[]) {
        List<Integer> l = new ArrayList<Integer>();
        for (int i = 0; i < ary.length; i++) {
            if (i * 2 + 1 < ary.length || i * 2 + 2 < ary.length) {
                l.add(ary[i]);
            }
        }
        return l;
    }

    // ---------------------------------------------------------------
    // return true if the tree represented by ary is a valid max heap
    // ---------------------------------------------------------------
    public boolean isMaxHeap(int rootIndex, int ary[]) {
        for (int i = 0; i < ary.length; i++) {
            if (i * 2 + 1 < ary.length || i * 2 + 2 < ary.length) {
                if (ary[i] < ary[i * 2 + 1] && ary[i] < ary[i * 2 + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
