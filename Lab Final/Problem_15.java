import java.util.Scanner;

public class Problem_15 {
    public static void main(String[] args) {
        int a;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter value of N: ");
        a=in.nextInt();
        int fibo=1,rem=1;
        System.out.print("0,1,1");
        for(int i=4;i<=a;i++){
            int sum=fibo+rem;
            rem=fibo;
            fibo=sum;
            System.out.print(","+sum);

        }
    }
}
