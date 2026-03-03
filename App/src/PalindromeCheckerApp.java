import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker App ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // UC1/2: Basic String Reverse Check
        checkUsingStringReversal(input);

        // UC4: Character Array (Two-Pointer) Check
        checkUsingCharArray(input);

        // UC5: Stack-Based Check
        checkUsingStack(input);

        scanner.close();
    }

    // --- UC1/2: String Reversal Method ---
    public static void checkUsingStringReversal(String input) {
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }

        System.out.println("\n[UC1/2: String Reversal]");
        if (input.equals(reversed)) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }
    }

    // --- UC4: Character Array (Two-Pointer) Method ---
    public static void checkUsingCharArray(String input) {
        char[] charArray = input.toCharArray();
        int start = 0;
        int end = charArray.length - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (charArray[start] != charArray[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        System.out.println("\n[UC4: Character Array Two-Pointer]");
        if (isPalindrome) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }
    }

    // --- UC5: Stack-Based Method ---
    public static void checkUsingStack(String input) {
        Stack<Character> stack = new Stack<>();

        // Push all characters onto the stack
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        // Pop characters to build reversed string
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        System.out.println("\n[UC5: Stack-Based LIFO]");
        if (input.equals(reversed.toString())) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }
    }
}