package topic20_is_brackets_valid;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> lefts = new Stack<>();
        int cursor = 0;
        while (cursor < s.length()) {
            if (lefts.size() > s.length() - cursor) {
                return false;
            }

            char c = s.charAt(cursor);
            if (lefts.empty()) {
                if (isLeft(c)) {
                    lefts.push(c);
                } else if (isRight(c)) {
                    return false;
                } else {
                    // invalid input
                    return false;
                }
            } else {
                if (isLeft(c)) {
                    lefts.push(c);
                } else if (isRight(c)) {
                    char l = lefts.peek();
                    if (isPair(l, c)) {
                        lefts.pop();
                    } else {
                        // invalid input
                        return false;
                    }
                }
            }

            cursor++;
        }

        return lefts.size() == 0;
    }

    private boolean isLeft(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private boolean isRight(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    private boolean isPair(char l, char r) {
        if (l == '(') {
            return r == ')';
        } else if (l == '[') {
            return r == ']';
        } else if (l == '{') {
            return r == '}';
        } else {
            // invalid input;
            return false;
        }
    }
}
