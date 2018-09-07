package day2.topic3_z_convert;

public class Main4 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String test = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int testTime = 1;

        long start = System.currentTimeMillis();
        Object result = null;
        for (int i = 0; i < testTime; i++) {
            result = s.convert(test, 4);
        }
        long end = System.currentTimeMillis();
        System.out.println("AN = AGMSYBFHLNRTXZCEIKOQUWDJPV");
        System.out.println("MY = " + result);
        System.out.println("Time = " + (end - start));
    }
}
