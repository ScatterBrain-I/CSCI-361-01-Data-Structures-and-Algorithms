import java.util.Scanner;

public class Main{

	public static void main(String[] args){
		Main m = new Main();
		m.go();
	}

	private void go(){
		Scanner in = new Scanner(System.in);
		// Tests x^y
		System.out.println("Enter an integer:");
		int n = in.nextInt();
		System.out.println("Enter a 'to the power of' integer:");
		int p = in.nextInt();
		System.out.printf("%d to the power of %d = %d%n", n, p, RecursMaths.power(n, p));
		// Tests position on the Fibonacci sequence
		System.out.println("Enter an postion on the Fibonacci sequence:");
		int f = in.nextInt();
		System.out.printf("The value of the integer at position %d is %d%n", f, RecursMaths.f(f));
	}
}
