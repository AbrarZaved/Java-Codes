import java.util.Scanner;
public class Exception_Problem {
    public static void main(String[] args) {
        while(true)
        {
            try {
                Scanner input = new Scanner(System.in); 
                System.out.print("Please enter Num1: ");
                int a=input.nextInt();
                System.out.print("Please enter Num2: ");
                int b=input.nextInt();
                int result = a/b;
                System.out.println("Result: "+a+"/"+b+" = "+result);
            }catch(Exception e){
                System.out.println("Exception: "+e);
                System.out.println("You must enter integer. Please Try Agaain");
                
            }
        }
        
        
    }
}
