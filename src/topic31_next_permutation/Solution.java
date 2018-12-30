package topic31_next_permutation;

import java.util.Arrays;

class Solution {
    void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 1) return;

        if (nums.length == 2) {
            int tmp = nums[0];
            nums[0] = nums[1];
            nums[1] = tmp;
            return;
        }

        // find down position
        int downPosition = -1;
        for (int a = nums.length - 2; a >= 0; a--) {
            if (nums[a] < nums[a + 1]) {
                downPosition = a;
                break;
            }
        }

        // no next
        if (downPosition == -1) {
            Arrays.sort(nums);
            return;
        }

        // find closest
        int closestPosition = -1;
        for (int a = downPosition; a < nums.length - 1; a++) {
            if (nums[a] > nums[downPosition] && nums[a + 1] <= nums[downPosition]) {
                closestPosition = a;
                break;
            }
        }
        if (closestPosition == -1) {
            closestPosition = nums.length - 1;
        }

        swap(nums, downPosition, closestPosition);
        reverse(nums, downPosition + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
