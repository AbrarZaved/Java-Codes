import java.util.Scanner;

public class Problem_50{
static int factorial(int n) {
    int fact = 1;
    int i = 1;
    while(i <= n) {
       fact *= i;
       i++;
    }
    return fact;
 }
 public static void main(String args[]) {
    int n , r , comb, per;
    Scanner in = new Scanner(System.in);
    System.out.print("Enter the value of n: ");
    n=in.nextInt();
    System.out.print("Enter the value of r: ");
    r=in.nextInt();
    per = factorial(n) / factorial(n-r);
    System.out.println("Permutation: " + per);
    comb = factorial(n) / (factorial(r) * factorial(n-r));
    System.out.println("Combination: " + comb);
 }
}
