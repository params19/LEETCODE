import java.math.BigInteger;

class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            if (num.charAt(0) == '0' && i > 1) {
                break;
            }
            for (int j = i + 1; n - j >= Math.max(i, j - i); j++) {
                if (num.charAt(i) == '0' && j - i > 1) {
                    break;
                }

                String num1Str = num.substring(0, i);
                String num2Str = num.substring(i, j);

                if (isValidSequence(num1Str, num2Str, j, num)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValidSequence(String num1Str, String num2Str, int start, String num) {
        BigInteger num1 = new BigInteger(num1Str);
        BigInteger num2 = new BigInteger(num2Str);

        while (start < num.length()) {
            BigInteger sum = num1.add(num2);
            String sumStr = sum.toString();

            if (!num.startsWith(sumStr, start)) {
                return false;
            }

            start += sumStr.length();
            num1 = num2;
            num2 = sum;
        }
        return true;
    }
}
