import java.util.Scanner;

public class Main{

  public static void main(String args[]){
    Main m = new Main();
    m.go();
  }

  public void go(){
    Scanner kb = new Scanner(System.in);
    System.out.println("\nEnter character: ");
    char character = kb.nextLine().charAt(0);
    System.out.println("Enter sentence: ");
    String sentence = kb.nextLine();
    System.out.println("Your sentence with '" + character + "' removed: \n" +
      RemoveChar.removeChar(sentence, character) + "\n");
    kb.close();
  }
}
