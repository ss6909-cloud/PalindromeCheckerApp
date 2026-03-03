import java.util.Scanner;

// Define the Node structure
class Node {
    char data;
    Node next;
    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            System.out.println("The given string is a Palindrome.");
            return;
        }

        // Step 1: Convert String to Singly Linked List
        Node head = new Node(input.charAt(0));
        Node temp = head;
        for (int i = 1; i < input.length(); i++) {
            temp.next = new Node(input.charAt(i));
            temp = temp.next;
        }

        // Step 2: Find middle using Fast and Slow pointers
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 3: Reverse the second half of the list
        Node secondHalf = reverseList(slow);
        Node firstHalf = head;

        // Step 4: Compare the two halves
        boolean isPalindrome = true;
        Node secondHalfCopy = secondHalf; // To keep track for comparison
        while (secondHalfCopy != null) {
            if (firstHalf.data != secondHalfCopy.data) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalfCopy = secondHalfCopy.next;
        }

        // Step 5: Output result
        if (isPalindrome) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }

    // Helper method to reverse a linked list in-place
    public static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}