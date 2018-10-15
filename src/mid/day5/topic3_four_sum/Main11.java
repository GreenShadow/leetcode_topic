package mid.day5.topic3_four_sum;

public class Main11 {
    public static void main(String[] args) {
        Solution s = new Solution();

//        int[] test = new int[]{1, 0, -1, 0, -2, 2};
//        int target = 0;

        int[] test = new int[]{-3, -1, 0, 2, 4, 5};
        int target = 0;

        long start = System.currentTimeMillis();
        System.out.println(s.fourSum(test, target));
        long end = System.currentTimeMillis();
        System.out.println("time = " + (end - start));

//        long start = System.currentTimeMillis();
//        System.out.println("Answer = " + s.threeSumClosest(test, target));
//        long end = System.currentTimeMillis();
//        System.out.println("Time = " + (end - start));
    }
}
