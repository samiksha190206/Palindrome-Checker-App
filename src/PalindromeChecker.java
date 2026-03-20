import java.util.*;

// Step 1: Strategy Interface
interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}

// Step 2: Stack आधारित strategy
class StackStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String input) {
        input = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        // Push all characters
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        // Compare while popping
        for (char ch : input.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// Step 3: Deque आधारित strategy
class DequeStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String input) {
        input = input.replaceAll("\\s+", "").toLowerCase();

        Deque<Character> deque = new LinkedList<>();

        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}

// Step 4: Context class
class PalindromeContext {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean execute(String input) {
        return strategy.checkPalindrome(input);
    }
}

// Step 5: Main class
public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeContext context = new PalindromeContext();

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("Choose Strategy:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");

        int choice = scanner.nextInt();

        // Inject strategy at runtime
        if (choice == 1) {
            context.setStrategy(new StackStrategy());
        } else if (choice == 2) {
            context.setStrategy(new DequeStrategy());
        } else {
            System.out.println("Invalid choice!");
            scanner.close();
            return;
        }

        boolean result = context.execute(input);

        if (result) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}