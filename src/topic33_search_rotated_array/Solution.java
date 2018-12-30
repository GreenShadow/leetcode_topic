package topic33_search_rotated_array;

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length <= 2) {
            return checkLength(nums, target, 0, nums.length - 1);
        }

        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int start, int end) {
        if (end - start <= 1) {
            return checkLength(nums, target, start, end);
        }

        int mid = start + (end - start) / 2;
        if (nums[start] <= nums[mid]) {
            // left ordered
            if (nums[start] <= target && nums[mid] >= target) {
                // inside left sequence
                return binarySearch(nums, target, start, mid);
            } else {
                // inside right sequence
                return search(nums, target, mid, end);
            }
        } else {
            // right ordered
            if (nums[mid] <= target && nums[end] >= target) {
                // inside right sequence
                return binarySearch(nums, target, mid, end);
            } else {
                // inside left sequence
                return search(nums, target, start, mid);
            }
        }
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        if (end - start <= 1) {
            return checkLength(nums, target, start, end);
        }

        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearch(nums, target, mid, end);
        } else {
            return binarySearch(nums, target, start, mid);
        }
    }

    private int checkLength(int[] nums, int target, int start, int end) {
        if (start == end) {
            return nums[start] == target ? start : -1;
        }

        if ((end - start) == 1) {
            if (nums[start] == target) {
                return start;
            }

            if (nums[end] == target) {
                return end;
            }
            return -1;
        }

        return -2;
    }
}
