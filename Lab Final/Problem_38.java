import java.util.Scanner;

public class Problem_38 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n=in.nextInt();
        int []a=new int[n];
        System.out.print("Enter the values: ");
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        System.out.print("Reverse Order: ");
        for(int i=n-1;i>=0;i--){
            System.out.print(a[i]+" ");
        }
    }
}
