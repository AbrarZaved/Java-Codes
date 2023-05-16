import java.util.Scanner;

public class Problem_32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int number1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int number2 = scanner.nextInt();
        int hcf = HCF(number1, number2);
        System.out.println("HCF: " + hcf);
    }
    public static int HCF(int a, int b) {
        if (b == 0) {
            return a;
        }
        return HCF(b, a % b);
    }
}