class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
       String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int ip = 0;
        while(ip < s1.length() && ip < s2.length()){
            if(s1.charAt(ip) == s2.charAt(ip)){
                ip++;
            } else {
                break;
            }
        }
        return s1.substring(0, ip);
    }
} 
