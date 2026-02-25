public class PalindromeChecker {
    public static void main(String[] args) {
                String input = "madam";
                String reverse= "";
                for (int i = input.length() - 1; i >= 0; i--) {
                    reverse += input.charAt(i);
                }
                boolean isPalindrome = input.equals(reverse);
                System.out.println("Input text : " + input);
                System.out.println("Is it a palindrome? " + isPalindrome);
            }
        }
