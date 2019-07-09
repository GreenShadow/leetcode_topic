package topic14_longest_common_prefix;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0] == null ? "" : strs[0];
        }

        for (String s : strs) {
            if (isEmpty(s)) {
                return "";
            }
        }

        StringBuilder sb = new StringBuilder();
        int cursor = 0;
        while (isValidIndex(strs, cursor)) {
            sb.append(strs[0].charAt(cursor));
            cursor++;
        }
        return sb.toString();
    }

    private boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }

    private boolean isValidIndex(String[] strs, int index) {
        for (String s : strs) {
            if (index >= s.length()) {
                return false;
            }
            char c = strs[0].charAt(index);
            if (s.charAt(index) != c) {
                return false;
            }
        }
        return true;
    }
}
