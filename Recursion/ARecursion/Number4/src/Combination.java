public class Combination{

  public static int combination(int n, int k){
    if (k == 0 || n == 0 || k == n){
      return 1;
    }
    else{
      return combination(n-1, k) + combination(n-1, k-1);
    }
  }
}
