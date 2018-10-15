package mid.day5.topic3_four_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    /**
     * Similar with {@link mid.day4.topic1_three_sum.Solution#threeSum(int[])}
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int a = 0; a < nums.length - 3; a++) {
            int b = a + 1;
            for (; b < nums.length - 2; b++) {
                int c = b + 1, d = nums.length - 1;
                while (c < d) {
                    int current = nums[a] + nums[b] + nums[c] + nums[d];

                    if (current < target) {
                        do {
                            c++;
                        } while (c < d && nums[c] == nums[c - 1]);
                    } else if (current > target) {
                        do {
                            d--;
                        } while (c < d && nums[d] == nums[d + 1]);
                    } else {
                        ArrayList<Integer> item = new ArrayList<>();
                        item.add(nums[a]);
                        item.add(nums[b]);
                        item.add(nums[c]);
                        item.add(nums[d]);
                        result.add(item);

                        do {
                            c++;
                        } while (c < d && nums[c] == nums[c - 1]);

                        do {
                            d--;
                        } while (c < d && nums[d] == nums[d + 1]);
                    }
                }

                while (b < nums.length - 3 && nums[b] == nums[b + 1]) {
                    b++;
                }
            }

            while (a < nums.length - 3 && nums[a] == nums[a + 1]) {
                a++;
            }
        }

        return result;
    }
}
