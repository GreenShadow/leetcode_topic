package mid.day2.topic1_length_of_longest_substring;

public class Best {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(i)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(i)] = j + 1;
        }
        return ans;
    }
}
