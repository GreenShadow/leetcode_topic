package topic29_divide;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int dividend = -2147483648;
        int divisor = 2;

        long start = System.currentTimeMillis();
        System.out.println("MY = " + s.divide_best(dividend, divisor));
        long end = System.currentTimeMillis();
        System.out.println("AN = " + ((long) dividend / (long) divisor));
        System.out.println("time = " + (end - start));

        System.out.println(Integer.MIN_VALUE);
    }
}
