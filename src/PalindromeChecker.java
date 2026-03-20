import java.util.Scanner;

public class PalindromeChecker {

    // Function to check palindrome after preprocessing
    public static boolean isPalindrome(String input) {

        // Step 1: Normalize string
        // Remove spaces and convert to lowercase
        input = input.replaceAll("\\s+", "").toLowerCase();

        int start = 0;
        int end = input.length() - 1;

        // Step 2: Compare characters
        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}