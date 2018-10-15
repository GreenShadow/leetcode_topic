package mid.day5.topic1_three_sum_closest;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return target;
        }

        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }

        int result = nums[0] + nums[1] + nums[2];
        int minDiff = Math.abs(result - target);
        boolean leftIncrease = true;

        for (int a = 0; a < nums.length - 2; a++) {
            for (int b = a + 1; b < nums.length - 1; b++)
                for (int c = b + 1; c < nums.length; c++) {
                    int sum = nums[a] + nums[b] + nums[c];
                    if (sum == result) continue;

                    int currentDiff = Math.abs(sum - target);
                    if (currentDiff <= minDiff) {
                        if (currentDiff == 0) return sum;
                        result = sum;
                        minDiff = currentDiff;
                    }
                    leftIncrease = !leftIncrease;
                }
        }

        return result;
    }

    public int threeSumClosest_error(int[] nums, int target) {
        // there is no answer in this case.
        if (nums == null || nums.length < 3) {
            return 0;
        }

        // if the length is 3, no calculation is required, the answer is just the sum of these three numbers.
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }

        // we need to sort this array first
        // after sorting, the answers to this question are always contiguous in the array.
        Arrays.sort(nums);

        // if the length is 4, we have only 2 choices: the first three numbers or the last three numbers
        if (nums.length == 4) {
            return Math.abs(nums[0] - target) > Math.abs(nums[3] - target)
                    ? nums[1] + nums[2] + nums[3]
                    : nums[0] + nums[1] + nums[2];
        }

        // here, the length of nums always larger than 4

        // first, we need to get the index i so that nums [i] is closest to target in this array and it is greater than
        // or equal to target.
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                break;
            }
        }

        // no one larger or equal to target
        if (i == nums.length) {
            // the answer must be the sum of the last three items.
            return nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1];
        }

        // here, we have this conclusion : num[i - 1] < target <= num[i], so the answers should be in this range:
        // from num[i - 3] to num[i + 2] (assume that all of these indexes are exist).
        //
        //      num[i - 3]  num[i - 2]  num[i - 1]   (target)     num[i]    num[i + 1]  num[i + 2]
        // ----------|-----------|-----------|-----------|-----------|-----------|----------|-----------> nums
        //           |<-------result1------->|
        //                       |<---------------resut2------------>|
        //                                   |<-------------result3------------->|
        //                                                           |<-------result4------>|

        // and also, the theoretical minimum of this question is the triple of target, so once some one result equal to
        // triple of target, that is the correct answer, no need to calculate further.
        int triple = target * 3;
        Integer result4;
        if (i < nums.length - 2) {
            result4 = nums[i] + nums[i + 1] + nums[i + 2];

            if (result4 == triple) {
                return triple;
            }
        } else {
            result4 = null;
        }

        Integer result3;
        if (i <= nums.length - 2 && i >= 1) {
            result3 = nums[i - 1] + nums[i] + nums[i + 1];

            if (result3 == triple) {
                return triple;
            }
        } else {
            result3 = null;
        }

        Integer result2;
        if (i >= 2) {
            result2 = nums[i - 2] + nums[i - 1] + nums[i];

            if (result2 == triple) {
                return triple;
            }
        } else {
            result2 = null;
        }

        Integer result1;
        if (i >= 3) {
            result1 = nums[i - 3] + nums[i - 2] + nums[i - 1];

            // nums[i - 3] <= nums[i - 2] <= nums[i - 1] < target, so result1 will never equal to triple of target.
            // so we don't need to check it again.
        } else {
            result1 = null;
        }

        // here, we believe that no result equal to triple of target. but the triple of target is the theoretical
        // minimum of this question, so the correct must be the one which closest to triple of target
        //
        // so, we sort these results and triple of target together
        ArrayList<Integer> results = new ArrayList<>();
        if (result1 != null) results.add(result1);
        if (result2 != null) results.add(result2);
        if (result3 != null) results.add(result3);
        if (result4 != null) results.add(result4);
        results.add(triple);
        results.sort(Integer::compareTo);

        // and find the index of triple of target
        i = results.lastIndexOf(triple);

        if (i == 0) {
            // i is first one, answer is the second.
            return results.get(i + 1);
        } else if (i < results.size() - 1) {
            // 0 < i < 4, we should calculate it.
            return closest(results.get(i - 1), results.get(i + 1), triple);
        } else if (i == results.size() - 1) {
            // i is the last one, answer is the second to last.
            return results.get(i - 1);
        } else {
            // will never reach
            throw new RuntimeException();
        }
    }

    private int closest(int a, int b, int tripleOfTarget) {
        return Math.abs(a - tripleOfTarget) > Math.abs(b - tripleOfTarget) ? b : a;
    }
}
