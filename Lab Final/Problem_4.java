import java.util.Scanner;

public class Problem_4 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        n=sc.nextInt();
        int []a= new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            if(a[i]%2!=0)
            sum+=a[i];
        }
        System.out.println("Sum of all odd numbers: "+sum);

    }
    
}
