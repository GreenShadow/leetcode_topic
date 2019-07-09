package topic4_find_median_sorted_arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test1 = new int[]{
                1, 2, 4, 5, 6, 7, 8, 9
        };
        int[] test2 = new int[]{
                2, 4, 6, 9
        };

        long start = System.currentTimeMillis();

        double result = s.findMedianSortedArrays(test1, test2);

        long end = System.currentTimeMillis();

        System.out.println(result);
        System.out.println("time = " + (end - start));
    }
}
