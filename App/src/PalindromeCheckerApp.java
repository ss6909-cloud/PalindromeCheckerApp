import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Step 1: Convert string to char[]
        char[] charArray = input.toCharArray();

        // Step 2: Initialize two pointers
        int start = 0;
        int end = charArray.length - 1;
        boolean isPalindrome = true;

        // Step 3: Two-pointer comparison logic
        while (start < end) {
            if (charArray[start] != charArray[end]) {
                isPalindrome = false;
                break; // Optimization: stop as soon as a mismatch is found
            }
            start++;
            end--;
        }

        // Step 4: Output result
        if (isPalindrome) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}