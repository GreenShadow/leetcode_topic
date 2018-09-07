package day2.topic2_longest_palindrome;

class Solution {
    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() <= 1) {
            return s;
        }

        char[] chars = s.toCharArray();
        int length = chars.length - 1;

        while (length > 0) {
            for (int i = 0; i < chars.length - length; i++) {
                Range range = new Range(i, i + length);
                if (range.length == 1) {
                    return String.valueOf(s.charAt(0));
                }
                if (checkSymmetry(chars, range)) {
                    return s.substring(range.start, range.start + range.length);
                }
            }
            length--;
        }
        return String.valueOf(s.charAt(0));
    }

    private boolean checkSymmetry(char[] sub, Range range) {
        int cp; // cursor positive
        int cn; // cursor negative
        if (range.length % 2 == 0) {
            cp = range.start + range.length / 2;
            cn = cp - 1;
        } else {
            cp = range.start + range.length / 2 + 1;
            cn = cp - 2;
        }

        for (; cn >= range.start; cn--, cp++) {
            if (sub[cn] != sub[cp]) {
                return false;
            }
        }
        return true;
    }

    private class Range {
        private int start;
        private int end;
        private int length;

        private Range(int start, int end) {
            this.start = start;
            this.end = end;
            length = end - start + 1;
        }

        @Override
        public String toString() {
            return "Range{" +
                    "start=" + start +
                    ", end=" + end +
                    ", length=" + length +
                    '}';
        }
    }
}
