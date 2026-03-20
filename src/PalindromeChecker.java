import java.util.*;

public class PalindromeChecker {

    // 🔹 Method 1: Simple Two-Pointer
    public static boolean simpleCheck(String input) {
        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // 🔹 Method 2: Stack
    public static boolean stackCheck(String input) {
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : input.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // 🔹 Method 3: Deque
    public static boolean dequeCheck(String input) {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Normalize input
        input = input.replaceAll("\\s+", "").toLowerCase();

        // 🔹 Measure Simple Method
        long start1 = System.nanoTime();
        boolean result1 = simpleCheck(input);
        long end1 = System.nanoTime();

        // 🔹 Measure Stack Method
        long start2 = System.nanoTime();
        boolean result2 = stackCheck(input);
        long end2 = System.nanoTime();

        // 🔹 Measure Deque Method
        long start3 = System.nanoTime();
        boolean result3 = dequeCheck(input);
        long end3 = System.nanoTime();

        // 🔹 Display Results
        System.out.println("\n--- Results ---");
        System.out.println("Simple Method: " + (result1 ? "Palindrome" : "Not Palindrome")
                + " | Time: " + (end1 - start1) + " ns");

        System.out.println("Stack Method: " + (result2 ? "Palindrome" : "Not Palindrome")
                + " | Time: " + (end2 - start2) + " ns");

        System.out.println("Deque Method: " + (result3 ? "Palindrome" : "Not Palindrome")
                + " | Time: " + (end3 - start3) + " ns");

        scanner.close();
    }
}