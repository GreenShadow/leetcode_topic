package mid.day2.topic4_atoi;

class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        boolean positive = true;
        long result = 0;
        int cursor = 0;

        // first, remove white space
        while (cursor < str.length() && str.charAt(cursor) == ' ') {
            cursor++;
        }

        // second, get the sign
        if (cursor >= str.length()) {
            return 0;
        }
        if (str.charAt(cursor) == '+') {
            cursor++;
        } else if (str.charAt(cursor) == '-') {
            positive = false;
            cursor++;
        }

        // third, remove the start zeros
        while (cursor < str.length() && str.charAt(cursor) == '0') {
            cursor++;
        }

        // finally, convert
        while (cursor < str.length()) {
            if (str.charAt(cursor) >= '0' && str.charAt(cursor) <= '9') {
                result = result * 10 + str.charAt(cursor) - 48;
                if (positive) {
                    if (result > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                } else {
                    if (result > (long) Integer.MAX_VALUE + 1) {
                        return Integer.MIN_VALUE;
                    }
                }
            } else {
                break;
            }
            cursor++;
        }

        if (positive) {
            return (int) result;
        } else {
            return (int) (result * -1);
        }
    }
}
