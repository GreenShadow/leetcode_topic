package mid.day7.topic3_next_permutation;

import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 1) return;

        if (nums.length == 2) {
            int tmp = nums[0];
            nums[0] = nums[1];
            nums[1] = tmp;
            return;
        }

        for (int a = nums.length - 1; a >= 0; a--) {
            for (int b = a - 1; b >= 0; b--) {
                if (nums[a] > nums[b]) {
                    shift(nums, b, a);
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }

    private void shift(int[] source, int start, int end) {
        if (start >= end) return;
        if (end - start > 0) {
            int tmp = source[end];
            System.arraycopy(source, start, source, start + 1, end - start);
            source[start] = tmp;
        }
    }
}
