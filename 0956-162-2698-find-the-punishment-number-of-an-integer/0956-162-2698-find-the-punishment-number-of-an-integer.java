// T.C : O(n * 2^(log10(n^2)))
// S.C : O(n * log10(n^2))
//acha sawal 

class Solution {
    public boolean check(int i, int currsum, String s, int num, int[][] t) {
        if (i == s.length()) {
            return currsum == num;
        }
        if (currsum > num) 
            return false;

        if (t[i][currsum] != -1) // we have repeating subproblems. Draw tree diagram of "1296"
            return t[i][currsum] == 1;

        boolean possible = false;
        for (int j = i; j < s.length(); j++) {
            String currentString = s.substring(i, j + 1);
            int addend = Integer.parseInt(currentString);

            possible = possible || check(j + 1, currsum + addend, s, num, t);
            if (possible) {
                t[i][currsum] = 1; // Update the memoization table
                return true;
            }
        }

        t[i][currsum] = 0; // Update the memoization table
        return false;
    }

    public int punishmentNumber(int n) {
        int punishmentNum = 0;
        for (int num = 1; num <= n; num++) {
            int squareNum = num * num;
            String s = Integer.toString(squareNum);

            int[][] t = new int[s.length()][num + 1];
            for (int[] row : t) {
                java.util.Arrays.fill(row, -1);
            }

            if (check(0, 0, s, num, t)) {
                punishmentNum += squareNum;
            }
        }
        return punishmentNum;
    }
}