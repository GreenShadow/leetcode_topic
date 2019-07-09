package topic10_regular_match;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "bbcacbabbcbaaccabc";
        String a = "b*a*.c*bb*.*";
        String p = "b*a*a*.c*bb*b*.*.*";

        String asd = "a.*z";
        int zxc = asd.indexOf(".*");
        System.out.println(asd.substring(0, zxc));

        long start = System.currentTimeMillis();

        boolean result = solution.isMatch(s, p);

        long end = System.currentTimeMillis();

        System.out.println(result);
        System.out.println("time = " + (end - start));
    }
}
