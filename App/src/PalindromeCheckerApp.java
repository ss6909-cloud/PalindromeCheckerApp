import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        System.out.println("Welcome to Palindrome Checker Management App");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String word = scanner.nextLine();

        String reversed = "";
        boolean isPalindrome = true;

        word = word.toLowerCase();

        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(word + " is a Palindrome.");
        } else {
            System.out.println(word + " is NOT a Palindrome.");
        }

        scanner.close();
    }
}