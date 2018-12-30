package topic8_atoi;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String test = "2147483648";
        int testTime = 1;


        long start = System.currentTimeMillis();
        System.out.println("MY = " + s.myAtoi(test));
        long end = System.currentTimeMillis();


        System.out.println("AN = " + "2147483647");
        System.out.println("MAX= " + Integer.MAX_VALUE);
        System.out.println("MIN= " + Integer.MIN_VALUE);
        System.out.println("Time = " + (end - start));
    }
}
