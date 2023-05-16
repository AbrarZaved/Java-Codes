import java.util.Scanner;

public class Problem_25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter temperature in Fahrenheit: ");
        double fah = scanner.nextDouble();

        double celsius = (fah - 32) * 5 / 9;
        System.out.println("Equivalent temperature in Celsius: " + celsius);

        System.out.print("Enter temperature in Celsius: ");
        double cel = scanner.nextDouble();

        double fahrenheit = (cel * 9 / 5) + 32;
        System.out.println("Equivalent temperature in Fahrenheit: " + fahrenheit);

        scanner.close();
    }
}

