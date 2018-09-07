package day2.topic1_length_of_longest_substring;

class Solution {
    private static final int ASCII_MAX = 127;

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int length = s.length();
        if (length <= 0) {
            return 0;
        }

        length = length > ASCII_MAX ? ASCII_MAX : length;
        char[] chars = s.toCharArray();

        while (length > 0) {
            if (hasRepeat(chars, length)) {
                length--;
                continue;
            }
            return length;
        }
        return s.length();
    }

    private static boolean hasRepeat(char[] chars, int l) {
        int start = 0;
        int end = start + l;
        while (end < chars.length) {
            if (!checkSelf(chars, start, end)) {
                return false;
            } else {
                start++;
                end++;
            }
        }
        return true;
    }

    private static boolean checkSelf(char[] sub, int start, int end) {
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                if (sub[i] == sub[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
