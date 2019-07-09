package topic20_is_brackets_valid;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        String test = "(((())";

        long start = System.currentTimeMillis();
        System.out.println(s.isValid(test));
        long end = System.currentTimeMillis();
        System.out.println("time = " + (end - start));
    }
}
