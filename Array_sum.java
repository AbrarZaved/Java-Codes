
import java.util.Scanner;
public class Array_sum {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int sum=0;
            int a[] = new int [5];
            for(int i=0;i<5;i++)
            {
                a[i]=input.nextInt();
                sum+=a[i];

            }
            System.out.println("Sum: "+sum);
        }

    }
}
