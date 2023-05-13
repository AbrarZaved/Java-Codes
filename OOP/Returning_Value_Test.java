
import java.util.Scanner;
public class Returning_Value_Test {
    public static void main(String[] args) {
     Returning_Value b = new Returning_Value();
     try (Scanner in = new Scanner(System.in)) {
        System.out.println("Enter any number: ");
         int d = in.nextInt();
         int c=b.square(d);
         System.out.printf("The square of %d is %d",d,c);
    }   
    }
}
