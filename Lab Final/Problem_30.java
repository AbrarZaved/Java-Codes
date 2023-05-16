import java.util.Scanner;

public class Problem_30 {
    public static void main(String[] args) {
        int n;
        Scanner in=new Scanner(System.in);
        System.out.print("Enter the limit: ");
        n=in.nextInt();
        int first=0,sum=0;
        for(int i=1;i<=n;i++){ 
            first=first*10+1;
            sum+=first;
            System.out.print(first);
            if(i!=n)
            System.out.print("+");

        }
        System.out.print("="+sum);

    }
}
