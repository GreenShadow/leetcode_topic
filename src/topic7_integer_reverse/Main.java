package topic7_integer_reverse;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int test = 12354168;

        long start = System.currentTimeMillis();

        int result = s.reverse(test);

        long end = System.currentTimeMillis();

        System.out.println(result);
        System.out.println("time = " + (end - start));
    }
}
