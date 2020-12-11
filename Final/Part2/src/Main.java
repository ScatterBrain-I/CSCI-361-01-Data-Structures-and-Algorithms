import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
   	public static void main(String[] args) throws Exception {
	    Huffman huff = new Huffman();
	    huff.bulidTreeFromFile("tree.txt");
        System.out.println("Huffman Encode/Decode test:");
        
        // GetCode works
        System.out.println("Get Code for 'A': " + huff.getCode('A'));
        System.out.println("Get Code for 'E': " + huff.getCode('E'));

        //Print Code HashMap
        System.out.print("HashMap of Codes: ");
        huff.printCodeTable();

        // inputs a test string to be encoded and the output to be decoded checking for parity
        String rawText = "ADDZZ";
        String encoded = huff.encode(rawText);
        String decoded = huff.decode(encoded);
        System.out.printf("%s encoded as: %s%n", rawText, encoded);
        System.out.printf("%s decoded as: %s%n", encoded, decoded);
        if (rawText.equals(decoded)) {
            System.out.println("Encoding and decoding have worked properly:");
        }
        else {
            System.out.println("Something went wrong with the encoding and decoding:");
        }
	}
}
