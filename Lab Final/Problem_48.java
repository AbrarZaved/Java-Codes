import java.util.Scanner;

public class Problem_48 {
    public static void main(String[] args) {
        int a;
        System.out.print("Enter any Integer: ");
        Scanner in = new Scanner(System.in);
        a=in.nextInt();
        System.out.print("The Factors are: ");
        
        for(int i=1;i<=a;i++){
            if(a%i==0)
            System.out.print(i+" "); 
        
    }
}
}
