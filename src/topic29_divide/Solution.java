package topic29_divide;

class Solution {
    public int divide(int x, int y) {
        if (x == 0) return 0;
        if (y == 0) throw new ArithmeticException("divide by 0");
        if (x == y) return 1;
        if (y == Integer.MIN_VALUE) return 0;

        boolean xPositive = x >= 0;
        boolean yPositive = y >= 0;
        if (xPositive) x = -x;
        if (yPositive) y = -y;
        if (x > y) return 0;

        boolean positive = xPositive == yPositive;
        if (y == -1) return getResult(-x, positive);

        int result = 0;
        do {
            x = x - y;
            result++;
        } while (x <= y);

        return getResult(result, positive);
    }

    private int getResult(int result, boolean positive) {
        if (result == Integer.MIN_VALUE) return positive ? Integer.MAX_VALUE : result;
        if (!positive) return -result;
        return result;
    }

    /* best */
    public int divide_best(int x, int y) {
        if (x == 0) return 0;
        if (y == 0) throw new ArithmeticException("divide by 0");
        if (x == Integer.MIN_VALUE && y == -1) return Integer.MAX_VALUE;

        long xCal = Math.abs((long) x);
        long yCal = Math.abs((long) y);
        int result = 0;
        while (xCal >= yCal) {
            long temp = yCal;
            long shift = 1;
            while (xCal >= (temp << 1)) {
                temp <<= 1;
                shift <<= 1;
            }
            xCal -= temp;
            result += shift;
        }

        return (x ^ y) >= 0 ? (-result) : result;
    }
}
