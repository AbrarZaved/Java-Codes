import java.util.Scanner;

public class SimpleCalculator {
   public static void main(String[] args) {
      try (Scanner input = new Scanner(System.in)) {
        int num1, num2;
          int sum, difference, product;
          float quotient;

          System.out.print("Enter first integer: ");
          num1 = input.nextInt();
          System.out.print("Enter second integer: ");
          num2 = input.nextInt();

          sum = num1 + num2;
          difference = num1 - num2;
          product = num1 * num2;
          quotient = (float) num1 / num2;

          System.out.println("Sum: " + sum);
          System.out.println("Difference: " + difference);
          System.out.println("Product: " + product);
          System.out.println("Quotient: " + quotient);
    }
   }
}
