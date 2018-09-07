package day2.topic3_z_convert;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1 || s == null || s.length() <= numRows) {
            return s;
        }

        return new ZCollection(numRows, s).fill();
    }

    private class ZCollection {
        private String mInput;
        private int mCellNum;
        private int mHeight;

        private ZCollection(int height, String s) {
            mInput = s;
            if (s.length() % (height * 2 - 2) != 0) {
                mCellNum = s.length() / (height * 2 - 2) + 1;
            } else {
                mCellNum = s.length() / (height * 2 - 2);
            }
            mHeight = height;
        }

        private String fill() {
            char[] result = new char[mInput.length()];
            int cursor = 0;
            all:
            for (int h = 0; h < mHeight; h++) {
                for (int cellIndex = 0; cellIndex < mCellNum; cellIndex++) {
                    if (h == 0 || h == mHeight - 1) { // first line or last line, one point only.
                        int p = (2 * mHeight - 2) * cellIndex + h;
                        if (p < mInput.length()) {
                            result[cursor] = mInput.charAt(p);
                            cursor++;
                        }
                    } else { // normal line, two points.

                        // first point, on the vertical path
                        int p1 = (2 * mHeight - 2) * cellIndex + h;
                        if (p1 < mInput.length()) {
                            result[cursor] = mInput.charAt(p1);
                            cursor++;
                        }

                        // second point, on the slash path
                        int p2 = (2 * mHeight - 2) * cellIndex + 2 * mHeight - 2 - h;
                        if (p2 < mInput.length()) {
                            result[cursor] = mInput.charAt(p2);
                            cursor++;
                        }
                    }
                    if (cursor >= mInput.length()) {
                        break all;
                    }
                }
            }
            return new String(result);
        }
    }
}
