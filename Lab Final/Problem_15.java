import java.util.Scanner;

public class Problem_15 {
    public static void main(String[] args) {
        int a;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter value of N: ");
        a=in.nextInt();
        int fibo=0,rem=1;
        System.out.println("Fibonacci Series");
        System.out.print("0");
        for(int i=1;i<a;i++){
            int sum=fibo+rem;
            rem=fibo;
            fibo=sum;
            System.out.print(","+sum);

        }
    }
}
