import java.util.*;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker App (All Use Cases) ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Executing all implemented Use Cases
        checkUC1_StringReversal(input);
        checkUC4_CharArrayTwoPointer(input);
        checkUC5_StackLIFO(input);
        checkUC6_StackAndQueue(input);
        checkUC7_DequeOptimized(input);

        scanner.close();
    }

    // --- UC1: Basic String Reversal ---
    public static void checkUC1_StringReversal(String input) {
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        printResult("UC1 (String Reversal)", input.equals(reversed));
    }

    // --- UC4: Character Array (Two-Pointer) ---
    public static void checkUC4_CharArrayTwoPointer(String input) {
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
        printResult("UC4 (Char Array 2-Pointer)", isPalindrome);
    }

    // --- UC5: Stack-Based (LIFO) ---
    public static void checkUC5_StackLIFO(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) stack.push(c);

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) reversed.append(stack.pop());

        printResult("UC5 (Stack LIFO)", input.equals(reversed.toString()));
    }

    // --- UC6: Stack + Queue (LIFO vs FIFO) ---
    public static void checkUC6_StackAndQueue(String input) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
            queue.add(c);
        }

        boolean isPalindrome = true;
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.remove())) {
                isPalindrome = false;
                break;
            }
        }
        printResult("UC6 (Stack + Queue)", isPalindrome);
    }

    // --- UC7: Deque-Based (Front & Rear) ---
    public static void checkUC7_DequeOptimized(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : input.toCharArray()) deque.addLast(c);

        boolean isPalindrome = true;
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalindrome = false;
                break;
            }
        }
        printResult("UC7 (Deque Optimized)", isPalindrome);
    }

    // Helper method to print results consistently
    private static void printResult(String useCase, boolean isPalindrome) {
        String status = isPalindrome ? "Palindrome" : "NOT a Palindrome";
        System.out.printf("%-30s : %s%n", "[" + useCase + "]", status);
    }
}