package topic14_longest_common_prefix;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] test = new String[]{
                "c", "c"
        };

        long start = System.currentTimeMillis();
        System.out.println("MY = " + s.longestCommonPrefix(test));
        long end = System.currentTimeMillis();
        System.out.println("Time = " + (end - start));
    }
}
