package topic1_two_sum;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = new int[]{4, 5, 6, 7, 0, 1, 2};
        int testTarget = 0;

        long start = System.currentTimeMillis();

        int[] result = s.twoSum(test, testTarget);

        long end = System.currentTimeMillis();

        System.out.println(Arrays.toString(result));
        System.out.println("time = " + (end - start));
    }
}
