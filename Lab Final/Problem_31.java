import java.util.Scanner;

public class Problem_31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int number1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int number2 = scanner.nextInt();

        System.out.print("Enter the third number: ");
        int number3 = scanner.nextInt();

        int gcd = findGcd(number1, number2, number3);
        int lcm = findLcm(number1, number2, number3);

        System.out.println("GCD: " + gcd);
        System.out.println("LCM: " + lcm);

        scanner.close();
    }

    public static int findGcd(int a, int b, int c) {
        return gcd(gcd(a, b), c);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static int findLcm(int a, int b, int c) {
        return lcm(lcm(a, b), c);
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}

