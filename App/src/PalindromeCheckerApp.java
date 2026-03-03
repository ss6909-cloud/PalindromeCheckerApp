import java.util.Scanner;

// Step 1: Encapsulate logic in a dedicated Service class
class PalindromeService {

    /**
     * Core logic method exposed to other classes.
     * This method is "Encapsulated" - the caller doesn't need
     * to know how the check is performed, only the result.
     */
    public boolean isPalindrome(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }

        // Normalize string (Logic from UC10)
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Two-pointer check (Logic from UC4)
        int start = 0;
        int end = clean.length() - 1;

        while (start < end) {
            if (clean.charAt(start) != clean.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

// Step 2: The Main Application Class
public class hePalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instantiate the Service Object
        PalindromeService service = new PalindromeService();

        System.out.println("=== UC11: OOP Palindrome Service ===");
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();

        // Step 3: Use the object to perform the check
        boolean result = service.isPalindrome(userInput);

        if (result) {
            System.out.println("Result: The input is a Palindrome.");
        } else {
            System.out.println("Result: The input is NOT a Palindrome.");
        }

        scanner.close();
    }
}