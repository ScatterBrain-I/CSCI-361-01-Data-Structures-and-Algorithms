import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;

public class Huffman {
    String returnCode = "";
    public void populateNodesFromFile(String file, List<String> nodes) throws FileNotFoundException {
        try {
            File myFile = new File(file);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                nodes.add(data);
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("That file does not exist.");
            e.printStackTrace();
        }
    }

    public Tree buildTreeFromNodes(List<String> nodes) {
        List<Tree> trees = new ArrayList<Tree>();
        for (String data : nodes) {
            char letter = data.charAt(0);
            int value = Integer.parseInt(data.substring(2));
            Tree t = new Tree(null, null, letter, value);
            trees.add(t);
        }

        while (trees.size() >= 2) {
            Collections.sort(trees);
            Tree left = trees.remove(0);
            Tree right = trees.remove(0);
            Tree parentTree = new Tree(left, right, '\0', left.getTotal() + right.getTotal());
            left.setParent(parentTree);
            right.setParent(parentTree);
            trees.add(parentTree);
        }
        Tree root = trees.remove(0);
        return root;
    }

	public void printTree(Tree root) {
        root.printTree();
	}

	public String getCode(Tree root, char ch) {

        IStack<String> codeStack = new StackLL<String>();
        boolean go = true;
        if (root.getChar() == ch) {
            returnCode = "";
            while (root.getParent() != null) {
                if (root == root.getParent().getLeft()) {
                    codeStack.push("0");
                }
                else {
                    codeStack.push("1");
                }
                root = root.getParent();
            }
            int codeStackSize = codeStack.getSize();

            for (int i = 0; i < codeStackSize; i++) {
                returnCode = returnCode + codeStack.pop();
            }
            go = false;
        }
        if (go == true && root.getLeft() != null) {
            getCode(root.getLeft(), ch);
        }
        if (go == true && root.getRight() !=null) {
            getCode(root.getRight(), ch);
        }
        return returnCode;
    }

	public String decode(Tree root, String code) {
        String decoded = "";
        Tree n = root;
        for (char c : code.toCharArray()) {
            if (c == '0') {
                n = n.getLeft();
            }
            else {
                n = n.getRight();
            }
            if (n.getLeft() == null) {
                decoded = decoded + n.getChar();
                n = root;
            }
        }
        return decoded;


	}
}
