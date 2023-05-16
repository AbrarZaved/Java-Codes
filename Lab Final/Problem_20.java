import java.util.Scanner;

public class Problem_20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the distance in centimeters: ");
        double centimeters = scanner.nextDouble();

        double inches = centimeters / 2.54;

        System.out.println("The corresponding value in inches: " + inches);
    }
}
