package mid.day3.topic2_int_to_roman;

public class Main7 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int test = 600;

        long start = System.currentTimeMillis();
        System.out.println("MY = " + s.intToRoman(test));
        long end = System.currentTimeMillis();

        System.out.println("AN = " + "DC");
        System.out.println("Time = " + (end - start));
    }
}
