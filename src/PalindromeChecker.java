import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
 public class PalindromeChecker {
    public static void main(String[] args) {
        String input = "civic";
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            queue.add(c);
            stack.push(c);
                }

        boolean isPalindrome = true;
        while (!queue.isEmpty()) {
            if (queue.remove() != stack.pop()) {
                isPalindrome = false;
                break;
                    }
                }
                System.out.println("Input text : " + input);
                System.out.println("Is it a palindrome? " + isPalindrome);
            }
        }

