package topic11_max_area;

class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        if (height.length == 2) {
            return min(height[0], height[1]);
        }

        int result = 0;
        int start = 0;
        int end = height.length - 1;

        while (start < end) {
            result = max(result, min(height[start], height[end]) * (end - start));

            if (height[start] > height[end]) {
                end--;
            } else {
                start++;
            }
        }

        return result;
    }

    private int max(int a, int b) {
        if (a >= b) {
            return a;
        }
        return b;
    }

    private int min(int a, int b) {
        if (a >= b) {
            return b;
        }
        return a;
    }
}
