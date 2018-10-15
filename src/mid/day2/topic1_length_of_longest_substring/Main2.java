package mid.day2.topic1_length_of_longest_substring;

public class Main2 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String test = "aaaaaaaa";
        int testTime = 100000000;

        System.out.println(test.length());
        long start = System.currentTimeMillis();
        int result = -123;
        try {
            for (int i = 0; i < testTime; i++) {
                result = s.lengthOfLongestSubstring(test);
            }
        } finally {
            long end = System.currentTimeMillis();
            System.out.println(result + "      time = " + (end - start));
        }
    }
}
