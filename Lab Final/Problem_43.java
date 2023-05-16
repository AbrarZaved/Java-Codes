import java.util.Scanner;

public class Problem_43 {
    public static void main(String[] args) {
        double x; 
        int n;     
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the Base: ");
        x=in.nextDouble();
        System.out.print("Enter the Exponent: ");
        n=in.nextInt();
        
        double result = Math.pow(x, n);
        
        System.out.println(x + " raised to the power " + n + " is: " + result);
    }
}
