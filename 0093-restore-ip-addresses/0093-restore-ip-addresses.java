import java.util.*;
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        solve(0, 0, s, "", res);
        return res;
    }

    private void solve(int index, int sections, String s, String current, List<String> res) {
        if (index == s.length() && sections == 4) {
            res.add(current.substring(0, current.length() - 1)); 
            return;
        }
        if (sections >= 4) {
            return;
        }

        for (int len = 1; len <= 3; len++) {
            if (index + len <= s.length() && isOkay(s.substring(index, index + len))) {
                solve(index + len, sections + 1, s, current + s.substring(index, index + len) + ".", res);
            }
        }
    }

    private boolean isOkay(String s) {
        int number = Integer.parseInt(s);
        return (s.length() == Integer.toString(number).length() && number >= 0 && number <= 255);
    }
}
