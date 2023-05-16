import java.util.Scanner;

public class Problem_9 {
    public static void main(String[] args) {
        float a;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the side length of the cube: ");
         a = scanner.nextFloat();

        double surfaceArea = 6 * (a * a);
        double volume = a * a * a;

        System.out.println("Surface Area of the Cube: " + surfaceArea);
        System.out.println("Volume of the Cube: " + volume);
    }
    
}
