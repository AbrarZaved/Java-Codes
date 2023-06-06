import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the paragraph: ");
        String paragraph = scanner.nextLine();

        int wordCount = countWords(paragraph);

        System.out.println("Total number of words: " + wordCount);

        scanner.close();
    }

    public static int countWords(String paragraph) {
        if (paragraph == null || paragraph.isEmpty()) {
            return 0;
        }

        String[] words = paragraph.trim().split("\\W+");

        int count = 0;
        for (String word : words) {
            if (!word.isEmpty()) {
                count++;
            }
        }

        return count;
    }
}
