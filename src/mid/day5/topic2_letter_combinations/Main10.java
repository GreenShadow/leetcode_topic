package mid.day5.topic2_letter_combinations;

public class Main10 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String test = "23456789234567";

        long start = System.currentTimeMillis();
//        System.out.println(s.letterCombinations_best(test));
        s.letterCombinations_best(test);
        long end = System.currentTimeMillis();
        System.out.println("best time = " + (end - start));

        start = System.currentTimeMillis();
//        System.out.println(s.letterCombinations(test));
        s.letterCombinations(test);
        end = System.currentTimeMillis();
        System.out.println("  my time = " + (end - start));

//        long start = System.currentTimeMillis();
//        System.out.println("Answer = " + s.threeSumClosest(test, target));
//        long end = System.currentTimeMillis();
//        System.out.println("Time = " + (end - start));
    }
}
