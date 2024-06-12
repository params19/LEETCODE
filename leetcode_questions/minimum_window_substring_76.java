package leetcode_questions;

import java.util.*;
class minimum_window_substring_76 {
    public String minWindow(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        int l = 0, r = 0, stidx = -1, minlen = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        //pehle t ke saare characters daal do map me
        for (int i = 0; i < n2; i++) 
        {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int required = map.size();
        int formed = 0;
        //sliding window use karo ki minimum length ki string mil jaye
        while (r < n1) 
        {
            char currentChar = s.charAt(r);
            //pehle frequency ghatao uss character ki
            map.put(currentChar, map.getOrDefault(currentChar, 0) - 1);
            if (map.get(currentChar) == 0) //ieterate karke length ko badhayega
            {
                formed++;
            }
            //shrink karne k liye ye wala part use hua h
            while (formed == required) 
            {
                if (r - l + 1 < minlen) 
                {
                    minlen = r - l + 1;
                    stidx = l;
                }
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) + 1);
                if (map.get(leftChar) > 0) 
                {
                    formed--;
                }
                l++;
            }
            r++;
        }
        return stidx == -1 ? "" : s.substring(stidx, stidx + minlen);
    }
}