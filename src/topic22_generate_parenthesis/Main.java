package topic22_generate_parenthesis;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int test = 8;

        long start = System.currentTimeMillis();
//        s.generateParenthesis(test);
        System.out.println(s.generateParenthesis_meiguang(test));
        long end = System.currentTimeMillis();
        System.out.println("time = " + (end - start));
    }
}
