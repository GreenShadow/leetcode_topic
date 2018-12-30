package topic1_two_sum;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 <br/>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。 <br/>
 * 示例: <br/>
 * 给定 nums = [2, 7, 11, 15], target = 9 <br/>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9 <br/>
 * 所以返回 [0, 1]
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        if (nums.length == 2) {
            return nums[0] + nums[1] == target ? new int[]{0, 1} : null;
        }

        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }
}
