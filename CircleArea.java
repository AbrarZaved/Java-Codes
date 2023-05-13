import java.util.Scanner;

public class CircleArea {
   public static void main(String[] args) {
      try (Scanner input = new Scanner(System.in)) {
        System.out.print("Enter the radius of the circle: ");
          float radius = (float) input.nextDouble();

          float area = (float) (3.1416 * radius * radius);

          System.out.printf("The area of the circle is: %.2f\n", area);
    }
   }
}
