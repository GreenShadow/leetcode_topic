package topic17_letter_combinations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return Collections.emptyList();
        }

        List<String> result = null;
        List<String> tmp;

        for (int i = 0; i < digits.length(); i++) {
            LetterOfNum lom = new LetterOfNum(digits.charAt(i));
            tmp = new ArrayList<>();
            for (char letter : lom.letters()) {
                if (result == null) {
                    tmp.add(Character.toString(letter));
                } else {
                    for (String t : result) {
                        tmp.add(t + letter);
                    }
                }
            }
            result = tmp;
        }

        return result;
    }

    private class LetterOfNum {
        private char[] mLetters;

        private LetterOfNum(char num) {
            if ('2' <= num && num <= '6') {
                char base = (char) ('a' + (num - '2') * 3);
                mLetters = new char[]{base, (char) (base + 1), (char) (base + 2)};
            } else if ('7' == num) {
                mLetters = new char[]{'p', 'q', 'r', 's'};
            } else if ('8' == num) {
                mLetters = new char[]{'t', 'u', 'v'};
            } else if ('9' == num) {
                mLetters = new char[]{'w', 'x', 'y', 'z'};
            } else {
                throw new RuntimeException("invalid input mNum = " + num);
            }
        }

        private char[] letters() {
            return mLetters;
        }
    }

    /* =========================== best below =========================== */

    private String[] codes = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations_best(String digits) {
        if (digits == null || digits.equals("")) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        backtrace(digits, result, "", 1, digits.length());
        return result;
    }

    private void backtrace(String digits, List<String> list, String str, int deep, int n) {
        if (deep == n) {
            for (char c : codes[digits.charAt(deep - 1) - '0' - 2].toCharArray()) {
                list.add(str + c);
            }
        } else {
            for (char c : codes[digits.charAt(deep - 1) - '0' - 2].toCharArray()) {
                backtrace(digits, list, str + c, deep + 1, n);
            }
        }
    }
}
