import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Main
{
   	public static void main(String[] args) throws Exception
	{
	    Huffman huff = new Huffman();
        Frequency frequent = new Frequency();
        frequent.frequency();

	    List<String> nodes = new ArrayList<String>();
	    huff.populateNodesFromFile("frequencyFile.txt", nodes);
	    System.out.println(nodes);

	    Tree root = huff.buildTreeFromNodes(nodes);

            huff.printTree(root);

            System.out.println("A: " + huff.getCode(root, 'A'));
            System.out.println("D: " + huff.getCode(root, 'D'));
            System.out.println("Z: " + huff.getCode(root, 'Z'));
            System.out.println("E: " + huff.getCode(root, 'E'));
            System.out.println("C: " + huff.getCode(root, 'C'));


            String code = "000101110"; //"DAZE"
            System.out.printf(code + " decoded as: ");
            System.out.println(huff.decode(root, code));
	}
}
