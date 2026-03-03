import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker App ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Existing Use Cases
        checkUsingStringReversal(input);
        checkUsingCharArray(input);
        checkUsingStack(input);

        // UC6: Queue + Stack Based Check
        checkUsingQueueAndStack(input);

        scanner.close();
    }

    // --- UC1/2: String Reversal Method ---
    public static void checkUsingStringReversal(String input) {
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }
        System.out.println("\n[UC1/2: String Reversal] Result: " + (input.equals(reversed) ? "Palindrome" : "NOT a Palindrome"));
    }

    // --- UC4: Character Array (Two-Pointer) Method ---
    public static void checkUsingCharArray(String input) {
        char[] charArray = input.toCharArray();
        int start = 0, end = charArray.length - 1;
        boolean isPalindrome = true;
        while (start < end) {
            if (charArray[start] != charArray[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        System.out.println("[UC4: Character Array] Result: " + (isPalindrome ? "Palindrome" : "NOT a Palindrome"));
    }

    // --- UC5: Stack-Based Method ---
    public static void checkUsingStack(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) stack.push(c);
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) reversed.append(stack.pop());
        System.out.println("[UC5: Stack-Based] Result: " + (input.equals(reversed.toString()) ? "Palindrome" : "NOT a Palindrome"));
    }

    // --- UC6: Queue + Stack Based Method ---
    public static void checkUsingQueueAndStack(String input) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Step 1: Push to Stack (LIFO) and Enqueue to Queue (FIFO)
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            stack.push(c);
            queue.add(c);
        }

        boolean isPalindrome = true;

        // Step 2: Compare Dequeue (Front) with Pop (Back)
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.remove())) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("[UC6: Queue + Stack] Result: " + (isPalindrome ? "Palindrome" : "NOT a Palindrome"));
    }
}g