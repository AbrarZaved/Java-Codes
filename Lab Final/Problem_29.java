import java.util.Scanner;

public class Problem_29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of terms: ");
        int n = scanner.nextInt();

        double sum = 0.0;

        System.out.print("Harmonic Series: ");
        for (int i = 1; i <= n; i++) {
            double term = 1.0 / i;
            sum += term;

            System.out.print(term);

            if (i != n) {
                System.out.print(" + ");
            }
        }

        System.out.println();
        System.out.println("Sum of the Harmonic Series: " + sum);

        scanner.close();
    }
}
