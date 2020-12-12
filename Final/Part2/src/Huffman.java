import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Huffman {
  private Tree nodes;
  private HashMap<Character, String> codeTable = new HashMap<Character, String>();;

  public void bulidTreeFromFile(String fileName) throws FileNotFoundException {
    List<Tree> items = new ArrayList<Tree>();
      populateNodesFromFile(fileName, items);
      nodes = buildTreeFromNodes(items);
      makeCodeMap(nodes);
  }

  private void populateNodesFromFile(String fileName, List<Tree> nodes) throws FileNotFoundException {
    File file = new File(fileName);
    Scanner scanner = new Scanner(file);
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      String[] data = line.split(",");
      char character = data[0].charAt(0);
      if (Character.isLetter(character)) {
        codeTable.put(character, "");
      }
      int frequency = Integer.parseInt(data[1]);
      Tree node = new Tree(null, null, character, frequency);
      nodes.add(node);
    }
    scanner.close();
  }

  private Tree buildTreeFromNodes(List<Tree> nodes) {
    if(nodes.size() == 1) {
      return nodes.get(0);
    }
    else {
      Collections.sort(nodes);
      Tree left = nodes.get(0);
      Tree right = nodes.get(1);
      int total = left.getTotal() + right.getTotal();
      Tree newNode = new Tree(left, right, Character.MIN_VALUE, total);
      if(nodes.size() == 2) {
        return newNode;
      }
      nodes.remove(left);
      nodes.remove(right);
      nodes.add(newNode);
      return buildTreeFromNodes(nodes);
    }
  }

  private HashMap<Character, String> makeCodeMap(Tree root) {
    codeTable.forEach((k, v) -> {
      codeTable.put(k, buildCode(root, k, ""));
    });
    return codeTable;
  }

  public void printTree() {
    System.out.println(nodes.toString());
  }

  public void printCodeTable() {
    System.out.println(codeTable.toString());
  }

  public String getCode(char ch) {
    return codeTable.get(ch);
  }

  private String buildCode(Tree root, char ch, String code) {
    if (root.isLeaf() && Character.isLetter(root.getChar())) {
      return root.getChar() == ch ? code : "";
    }
    String leftCode = buildCode(root.getLeft(), ch, code + "0");
    String rightCode = buildCode(root.getRight(), ch, code + "1");
    code = leftCode.length() > 0 ? leftCode : rightCode;
    return code;
  }

  public String encode(String rawText) {
    String encoded = "";
    Tree n = nodes;
    for (char c : rawText.toCharArray()) {
      encoded = encoded + getCode(c);
    }
    return encoded;
  }

  public String decode(String code) {
    String decoded = "";
    Tree n = nodes;
    for (char c : code.toCharArray()) {
      if (c == '0') {
        n = n.getLeft();
      }
      else {
        n = n.getRight();
      }
      if (n.getLeft() == null) {
        decoded = decoded + n.getChar();
        n = nodes;
      }
    }
    return decoded;
  }
}
