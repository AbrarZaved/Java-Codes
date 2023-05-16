import java.util.Scanner;

public class Problem_33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        int alphabetCount = 0;
        int digitCount = 0;
        int specialCharCount = 0;
        int space=0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (Character.isLetter(c)) {
                alphabetCount++;
            } else if (Character.isDigit(c)) {
                digitCount++;
            }
             else if(c==' '){
                space++;

             }
             else {
                specialCharCount++;
            }
        }

        System.out.println("Alphabets: " + alphabetCount);
        System.out.println("Digits: " + digitCount);
        System.out.println("Special Characters: " + specialCharCount);

        scanner.close();
    }
}
