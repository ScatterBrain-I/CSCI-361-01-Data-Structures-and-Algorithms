public class RecursMaths{

	public static int power(int num, int power){
		if (power == 0){
			return 1;
		}
		else {
			return num * power(num, power - 1);
		}
	}

	public static int f(int n){
		if (n == 0){
			return 0;
		}
		else if (n == 1){
			return 1;
		}
		else {
			return f(n - 1) + f(n - 2);
		}
	}
}
