import java.util.Scanner;

public class Problem_37 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char a;
        System.out.print("Enter any character: ");
        a=in.next().charAt(0);
        if(a>=48 && a<=57)
        System.out.println("It is a Digit");
        else
        System.out.println("It is not digit");

    }
}
