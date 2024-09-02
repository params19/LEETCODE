import java.util.ArrayList;
import java.util.List;

class Solution {
 
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        solve(0, 0, new StringBuilder(), n * 2, res);
        return res;
    }

    private void solve(int i, int open, StringBuilder sb, int n, List<String> res) {
        if (i == n) {
            if (open == 0) {
                res.add(sb.toString());
            }
            return;
        }

        sb.append('(');
        solve(i + 1, open + 1, sb, n, res);
        sb.deleteCharAt(sb.length() - 1);

        if (open > 0) {
            sb.append(')');
            solve(i + 1, open - 1, sb, n, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
