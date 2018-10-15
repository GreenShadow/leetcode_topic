package mid.day7.topic3_next_permutation;

import java.util.Arrays;

public class Main13 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = new int[]{1, 3, 6, 5, 3};

        long start = System.currentTimeMillis();

        s.nextPermutation(test);

        long end = System.currentTimeMillis();

        System.out.println(Arrays.toString(test));
        System.out.println("time = " + (end - start));
    }
}
