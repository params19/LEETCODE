import java.util.*;

class Solution {
    public boolean isSafe(int row, int col, List<String> board, int n)
     {
        int duprow = row;
        int dupcol = col;

        // Check upper diagonal
        while (row >= 0 && col >= 0) 
        {
            if (board.get(row).charAt(col) == 'Q') return false;
            row--;
            col--;
        }

        col = dupcol;
        row = duprow;

        // Check left side
        while (col >= 0)
         {
            if (board.get(row).charAt(col) == 'Q') return false;
            col--;
        }

        col = dupcol;
        row = duprow;

        // Check lower diagonal
        while (row < n && col >= 0) 
        {
            if (board.get(row).charAt(col) == 'Q') return false;
            row++;
            col--;
        }

        return true;
    }

    public void solve(int col, List<String> board, List<List<String>> ans, int n) {
        if (col == n) {
            ans.add(new ArrayList<>(board));
            return;
        }

        for (int row = 0; row < n; row++) 
        {
            if (isSafe(row, col, board, n))
            {
                char[] charArray = board.get(row).toCharArray();
                charArray[col] = 'Q';
                board.set(row, new String(charArray));
                solve(col + 1, board, ans, n);
                charArray[col] = '.';
                board.set(row, new String(charArray));
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();
        String emptyRow = ".".repeat(n);
        for (int i = 0; i < n; i++) 
        {
            board.add(emptyRow);
        }
        solve(0, board, ans, n);
        return ans;
    }
}
