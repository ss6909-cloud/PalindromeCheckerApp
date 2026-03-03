import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Step 1: Call the recursive function
        boolean isPalindrome = checkRecursive(input, 0, input.length() - 1);

        // Step 2: Output result
        if (isPalindrome) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }

    /**
     * Recursive method to check for palindrome
     * @param str The original string
     * @param start The current starting index
     * @param end The current ending index
     * @return true if palindrome, false otherwise
     */
    public static boolean checkRecursive(String str, int start, int end) {
        // Base Condition 1: If pointers meet or cross, it's a palindrome
        if (start >= end) {
            return true;
        }

        // Base Condition 2: If characters at start and end don't match
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive Step: Check the substring excluding the first and last characters
        return checkRecursive(str, start + 1, end - 1);
    }
}