import java.util.*;

// Step 1: Define the Strategy Interface
interface PalindromeStrategy {
    boolean check(String text);
}

// Step 2: Implement Concrete Strategy - Stack Based
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String text) {
        Stack<Character> stack = new Stack<>();
        for (char c : text.toCharArray()) stack.push(c);
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) reversed.append(stack.pop());
        return text.equalsIgnoreCase(reversed.toString());
    }
}

// Step 3: Implement Concrete Strategy - Two-Pointer Based
class TwoPointerStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (Character.toLowerCase(text.charAt(left)) != Character.toLowerCase(text.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

// Step 4: The Context Class that uses the Strategy
class PalindromeContext {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String text) {
        return strategy.check(text);
    }
}

// Step 5: Main Application
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeContext context = new PalindromeContext();

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("\nSelect Strategy:");
        System.out.println("1. Stack Strategy (LIFO)");
        System.out.println("2. Two-Pointer Strategy (Optimized)");
        int choice = scanner.nextInt();

        // Polymorphism in action: Injecting the strategy at runtime
        if (choice == 1) {
            context.setStrategy(new StackStrategy());
            System.out.println("Using: Stack Strategy");
        } else {
            context.setStrategy(new TwoPointerStrategy());
            System.out.println("Using: Two-Pointer Strategy");
        }

        boolean result = context.executeStrategy(input);
        System.out.println("Result: " + (result ? "Palindrome" : "NOT a Palindrome"));

        scanner.close();
    }
}