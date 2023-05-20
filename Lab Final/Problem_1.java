import java.util.Scanner;

public class Problem_1{
    public static void main(String[] args) {
        double a,b,area,perimeter;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Length: ");
        a=sc.nextDouble();
        System.out.print("Enter the Width: ");
        b=sc.nextDouble();
        area=a*b;
        perimeter=2*(a+b);
        System.out.println("Area: "+area);
        System.out.println("Perimeter: "+perimeter);
        
    }
}