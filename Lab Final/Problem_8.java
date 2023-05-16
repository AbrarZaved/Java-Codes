import java.util.Scanner;

public class Problem_8 {
    public static void main(String[] args) {
        Scanner ab=new Scanner(System.in);
        int []a=new int[5];
        int pos=0,count=0;
        for(int i=0;i<5;i++){
            a[i]=ab.nextInt();
            if(a[i]>0){
                pos+=a[i];
                count++;
            }
        }
        double average = (double) pos / count;
        System.out.println("Number of Positive Integers: "+count);
        System.out.printf("Average of all Positive Values: %.2f",average);
    }
}
