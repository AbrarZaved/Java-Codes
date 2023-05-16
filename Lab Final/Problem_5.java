import java.util.Scanner;

public class Problem_5 {
    public static void main(String[] args) {
        float a,b,c;
        Scanner sc= new Scanner(System.in);
        System.out.println("Input three float values: ");
        a=sc.nextFloat();
        b=sc.nextFloat();
        c=sc.nextFloat();
        if((a+b)>c &&(b+c)>a && (a+c)>b)
        System.out.println("Possible");
        else
        System.out.println("It is not possible");
    }
    
}
