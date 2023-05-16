import java.util.Scanner;

public class Problem_46 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");
        int deci = scanner.nextInt();

        String bin = Integer.toBinaryString(deci);
    
        String oct = Integer.toOctalString(deci);

        String hex = Integer.toHexString(deci);

        System.out.println("Decimal: " + deci);
        System.out.println("Binary: " + bin);
        System.out.println("Octal: " + oct);
        System.out.println("Hexadecimal: " + hex);

        scanner.close();
    }
}
