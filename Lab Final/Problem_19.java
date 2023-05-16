import java.util.Scanner;

public class Problem_19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the Array size: ");
        int n;
        n=in.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++)
        a[i]=in.nextInt();
        int small=a[0],count=0;
        for(int i=0;i<n;i++){
            if(a[i]<small)
            small=a[i];
        }
        for(int i=0;i<n;i++){
            if(a[i]==small){
            count=i+1;
            break;
            }
            
        }
        System.out.println("Smallest Number: "+small);
        System.out.println("Position: "+count);

        
    }
    
}
