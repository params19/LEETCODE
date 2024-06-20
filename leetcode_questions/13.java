import java.util.*;
class Solution {
    //Time complexity: O(n)
    //Space complexity: O(1)
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = map.get(s.charAt(s.length() - 1));
        for(int j = s.length() - 2; j >= 0; j--) {
            if(map.get(s.charAt(j)) < map.get(s.charAt(j+1))) {
                res -= map.get(s.charAt(j));
            } else {
                res += map.get(s.charAt(j));
            }
        }
        return res;
    }
}