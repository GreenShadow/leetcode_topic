package topic4_find_median_sorted_arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return findMedian(nums2);
        }

        if (nums2 == null || nums2.length == 0) {
            return findMedian(nums1);
        }

        int[] merged = new int[nums1.length + nums2.length];

        int a = 0, b = 0, i = 0;
        for (; a < nums1.length && b < nums2.length; i++) {
            if (nums1[a] <= nums2[b]) {
                merged[i] = nums1[a];
                a++;
            } else {
                merged[i] = nums2[b];
                b++;
            }
        }

        for (; a < nums1.length; a++, i++) {
            merged[i] = nums1[a];
        }
        for (; b < nums2.length; b++, i++) {
            merged[i] = nums2[b];
        }

        return findMedian(merged);
    }

    private double findMedian(int[] nums) {
        if (nums.length % 2 == 0) {
            int mid2 = nums.length / 2;
            int mid1 = mid2 - 1;
            return (nums[mid1] + nums[mid2]) / 2d;
        } else {
            return nums[nums.length / 2];
        }
    }
}
