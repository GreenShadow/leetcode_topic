package topic10_regular_match;

import java.util.ArrayList;

class Solution {
    public boolean isMatch(String s, String p) {
        if (isEmpty(s) || isEmpty(p)) {
            return false;
        }

        if (p.startsWith("*")) {
            return false;
        }

        // cut fixed match
        int start = 0;
        while (start + 1 < s.length() && start + 1 < p.length() && p.charAt(start + 1) != '*') {
            if (s.charAt(start) == p.charAt(start) || p.charAt(start) == '.') {
                start++;
            } else {
                break;
            }
        }

        int endS = s.length() - 1;
        int endP = p.length() - 1;
        while (endS > 0 && endP > 0 && p.charAt(endP) != '*') {
            if (s.charAt(endS) == p.charAt(endP) || p.charAt(endP) == '.') {
                endS--;
                endP--;
            } else {
                break;
            }
        }

        s = s.substring(start, endS + 1);
        p = p.substring(start, endP + 1);

        if (isEmpty(s) && isEmpty(p)) {
            // fixed matched
            return true;
        }

        if (isEmpty(s) || isEmpty(p)) {
            // not match
            return false;
        }

        ArrayList<String> pList = fillP(p);
        int cursorP = 0;
        while (!matchDigit(s, pList, 0, cursorP)) {
            if (cursorP + 1 == pList.size()) {
                return false;
            }

            if (pList.get(cursorP).length() == 2) {
                cursorP++;
            } else {
                return false;
            }
        }

        return false;
    }

    private boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }

    private ArrayList<String> fillP(String p) {
        String[] ps = p.split("\\*");
        ArrayList<String> pList = new ArrayList<>();

        if (ps.length == 1) {
            pList.add(p);
            return pList;
        }

        for (String cp : ps) {
            if (cp.length() == 1) {
                String digit = cp + "*";
                if (pList.isEmpty() || !digit.equals(pList.get(pList.size() - 1))) {
                    pList.add(cp + "*");
                }
            } else {
                pList.add(cp.substring(0, cp.length() - 1));
                pList.add(cp.charAt(cp.length() - 1) + "*");
            }
        }

        if (!p.endsWith("*")) {
            String s = pList.remove(pList.size() - 1);
            pList.add(s.substring(0, s.length() - 1));
        }

//        while (cursor < p.length()) {
//            String digit;
//            if (cursor + 1 < p.length()) {
//                if (p.charAt(cursor + 1) == '*') {
//                    digit = p.substring(cursor, cursor + 2);
//                    cursor++;
//                } else {
//                    digit = p.substring(cursor, cursor + 1);
//                }
//            } else {
//                digit = p.substring(cursor, cursor + 1);
//            }
//
//            if (pList.size() == 0) {
//                pList.add(digit);
//            } else if (!pList.get(pList.size() - 1).equals(digit)) {
//                pList.add(digit);
//            }
//            // do nothing for same digit
//            cursor++;
//        }
        return pList;
    }

    private boolean matchDigit(String s, ArrayList pList, int cursorS, int cursorP) {
        if (cursorS + 1 == s.length() && cursorP + 1 == pList.size()) {
            // matched
            return true;
        }

        if (cursorS + 1 == s.length() || cursorP + 1 == pList.size()) {
            // not match
            return false;
        }
        return false;
    }

    private boolean isMatch(String s, String p, int cursorS, int cursorP) {
        if (cursorS + 1 == s.length() && cursorP + 1 == p.length()) {
            // matched
            return true;
        }

        if (cursorS + 1 == s.length() || cursorP + 1 == p.length()) {
            // not match
            return false;
        }

        if (p.charAt(cursorP) == s.charAt(cursorS)) {
            return isMatch(s, p, cursorS + 1, cursorP + 1);
        }

        if (p.charAt(cursorP) == '.') {
            if (cursorP + 1 == p.length()) {
                return isMatch(s, p, cursorS, cursorP + 1);
            }

            if (p.charAt(cursorP) != '*') {
                // for .
                return isMatch(s, p, cursorS + 1, cursorP + 1);
            }

            // .*
            while (isMatch(s, p, cursorS, cursorP + 1)) {
                cursorS++;
            }
        }
        return false;
    }
}
