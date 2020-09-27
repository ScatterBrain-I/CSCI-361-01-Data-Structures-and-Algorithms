import java.util.Scanner;

public class Main{

  public static void main(String args[]){
    Main m = new Main();
    m.go();
  }

  public void go(){
    Scanner kb = new Scanner(System.in);
    System.out.println("\nEnter number of total objects: ");
    int n = kb.nextInt();
    System.out.println("Enter number to be 'grabbed': ");
    int k = kb.nextInt();
    System.out.printf
      ("%n%d items grabbed from %d total objects yields %d different combinations.%n%n",
      k, n, Combination.combination(n, k));
    kb.close();
  }
}
