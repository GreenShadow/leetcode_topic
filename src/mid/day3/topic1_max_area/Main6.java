package mid.day3.topic1_max_area;

public class Main6 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = new int[]{1, 2};

        long start = System.currentTimeMillis();
        System.out.println("MY = " + s.maxArea(test));
        long end = System.currentTimeMillis();

        System.out.println("Time = " + (end - start));
    }
}
