import java.util.Scanner;

public class Problem_16 {
    public static void main(String[] args) {
        int a;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter value of N: ");
        a=in.nextInt();
        int sum=1;
        for(int i=a;i>0;i--){
            sum*=i;
        }
        System.out.println("The Factorial is: "+sum);
    }
}