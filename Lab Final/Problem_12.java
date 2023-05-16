import java.util.Scanner;

public class Problem_12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a;
        a=in.nextLine();
        boolean b=true;
        int length = a.length();
        for (int i = 0; i < length / 2; i++) {
            if (a.charAt(i) != a.charAt(length - i - 1)){
                b=false;
                break;
            }
        }
        if(b)
        System.out.println("Palindrome");
        else
        System.out.println("Not Palindrome");

    }
}
