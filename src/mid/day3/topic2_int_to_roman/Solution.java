package mid.day3.topic2_int_to_roman;

class Solution {
    private static final char[] CLAZZ = new char[]{
            'I', // index 0
            'V', // index 1
            'X', // index 2
            'L', // index 3
            'C', // index 4
            'D', // index 5
            'M', // index 6
    };

    public String intToRoman(int num) {
        if (num <= 0 || num >= 4000) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        // M
        int classM = num / 1000;
        num %= 1000;
        if (classM > 0) {
            for (int i = 0; i < classM; i++) {
                sb.append('M');
            }
        }

        int pow = 10;
        for (int i = 2; i >= 0; i--) {
            int unit = (int) Math.pow(pow, i);
            int digitNum = num / unit;
            num = num % unit;
            int maxClassIndex = (i + 1) * 2;
            getDigit(digitNum, maxClassIndex, sb);
        }

        return sb.toString();
    }

    private void getDigit(int digitNum, int maxClassIndex, StringBuilder sb) {
        if (digitNum <= 0) {
            return;
        }

        if (digitNum == 9) {
            sb.append(getDownClass(maxClassIndex)).append(CLAZZ[maxClassIndex]);
        } else if (digitNum >= 5) {
            sb.append(CLAZZ[maxClassIndex - 1]);
            digitNum -= 5;
            for (int i = 0; i < digitNum; i++) {
                sb.append(getDownClass(maxClassIndex));
            }
        } else if (digitNum == 4) {
            sb.append(getDownClass(maxClassIndex - 1)).append(CLAZZ[maxClassIndex - 1]);
        } else {
            for (int i = 0; i < digitNum; i++) {
                sb.append(CLAZZ[maxClassIndex - 2]);
            }
        }
    }

    private char getDownClass(int index) {
        if (index % 2 == 0) {
            return CLAZZ[index - 2];
        } else {
            return CLAZZ[index - 1];
        }
    }
}
