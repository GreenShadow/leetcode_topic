package topic9_is_palindrome;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int test = -1200;

        long start = System.currentTimeMillis();

        boolean result = s.isPalindrome(test);

        long end = System.currentTimeMillis();

        System.out.println(result);
        System.out.println("time = " + (end - start));
    }
}
