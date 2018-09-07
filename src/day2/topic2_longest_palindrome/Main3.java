package day2.topic2_longest_palindrome;

public class Main3 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String test = "asdasddsadsa";
//      String test = "aaaaaaa";
        int testTime = 1;

        System.out.println(test.length());
        long start = System.currentTimeMillis();
        Object result = null;
        for (int i = 0; i < testTime; i++) {
            result = s.longestPalindrome(test);
        }
        long end = System.currentTimeMillis();
        System.out.println(result + "      time = " + (end - start));
    }
}
