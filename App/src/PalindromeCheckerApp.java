import java.util.*;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC13: Performance Comparison ===");
        System.out.print("Enter a long string to test performance: ");
        String input = scanner.nextLine();

        // 1. Measure String Reversal (UC1)
        long startUC1 = System.nanoTime();
        checkUC1(input);
        long endUC1 = System.nanoTime();
        long durationUC1 = endUC1 - startUC1;

        // 2. Measure Two-Pointer (UC4)
        long startUC4 = System.nanoTime();
        checkUC4(input);
        long endUC4 = System.nanoTime();
        long durationUC4 = endUC4 - startUC4;

        // 3. Measure Stack Based (UC5)
        long startUC5 = System.nanoTime();
        checkUC5(input);
        long endUC5 = System.nanoTime();
        long durationUC5 = endUC5 - startUC5;

        // Display Results in a Table format
        System.out.println("\n--- Performance Results ---");
        System.out.printf("%-25s | %-15s%n", "Algorithm", "Time (Nanoseconds)");
        System.out.println("----------------------------------------------");
        System.out.printf("%-25s | %-15d ns%n", "String Reversal (UC1)", durationUC1);
        System.out.printf("%-25s | %-15d ns%n", "Two-Pointer (UC4)", durationUC4);
        System.out.printf("%-25s | %-15d ns%n", "Stack-Based (UC5)", durationUC5);

        System.out.println("\nNote: Lower nanoseconds indicate better performance.");

        scanner.close();
    }

    // Logic from UC1
    public static boolean checkUC1(String input) {
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        return input.equals(reversed);
    }

    // Logic from UC4
    public static boolean checkUC4(String input) {
        int start = 0, end = input.length() - 1;
        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    // Logic from UC5
    public static boolean checkUC5(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) stack.push(c);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        return input.equals(sb.toString());
    }
}