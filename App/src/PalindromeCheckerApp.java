import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC10: Normalized Palindrome Checker ===");
        System.out.print("Enter a string (phrases allowed): ");
        String input = scanner.nextLine();

        // Step 1: Normalize the string
        // [^a-zA-Z0-9] matches anything that is NOT a letter or a number
        // "" replaces those characters with nothing (removes them)
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Step 2: Apply Two-Pointer logic on the cleaned string
        boolean isPalindrome = checkPalindrome(cleanInput);

        // Step 3: Output result
        System.out.println("\nOriginal: " + input);
        System.out.println("Normalized: " + cleanInput);

        if (isPalindrome && !cleanInput.isEmpty()) {
            System.out.println("Result: The string is a Palindrome (ignoring case/spaces).");
        } else {
            System.out.println("Result: The string is NOT a Palindrome.");
        }

        scanner.close();
    }

    // Reuse the efficient Two-Pointer logic from UC4
    public static boolean checkPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}