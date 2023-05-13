

import java.util.Scanner;

public class A_1791 {
    public static void main(String[] args) {
        int A;
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        char C;
        for(int i=0; i<A; i++){
           Scanner s = new Scanner(System.in); 
            C = s.next().charAt(0);
            if(C == 'c' || C == 'f' || C == 'd' || C == 'e' || C == 'o' || C == 'r' || C == 's')
            System.out.println("YES");
            else
            System.out.println("NO");
        }
    }
}
