package mid.day6.topic1_generate_parenthesis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis_meiguang(int n) {
        if (n < 1) {
            return Collections.emptyList();
        }
        LinkedList<String> que = new LinkedList<>();
        que.offer("(");
        while (que.peek().length() != 2 * n) {
            String current = que.poll();
            String test;
            test = current + '(';
            if (valid(test, n)) {
                que.offer(test);
            }

            test = current + ')';
            if (valid(test, n)) {
                que.offer(test);
            }
        }

        return que;
    }

    private boolean valid(String s, int n) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left > n || right > left) {
                return false;
            }
        }

        return true;
    }

    /* ======== best ======== */
    public List<String> generateParenthesis_best(int n) {
        List<String> result = new ArrayList<>();
        char[] temp = new char[n + n];
        helper(result, temp, 0, n, n);
        return result;
    }

    private void helper(List<String> result, char[] temp, int index, int l, int r) {
        if (l == 0 && r == 0) {
            result.add(new String(temp));
            return;
        }

        if (l > 0) {
            temp[index] = '(';
            helper(result, temp, index + 1, l - 1, r);
        }

        if (r > 0 && r > l) {
            temp[index] = ')';
            helper(result, temp, index + 1, l, r - 1);
        }
    }
}
