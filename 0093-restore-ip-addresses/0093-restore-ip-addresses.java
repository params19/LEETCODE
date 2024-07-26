class Solution {
    public List<String> restoreIpAddresses(String s) {
        Set<String> ls = new HashSet<>();
        getIpAddresses(s, ls, "", 0, false,-1,0);
        return new ArrayList(ls);
    }

    public void getIpAddresses(String s, Set<String> ls, String temp, int cur, boolean isDot, int num, int dot){
        if(cur == s.length() && dot == 3){
            ls.add(temp);
            return;
        }
        if(dot < 0 || cur >= s.length()) return;

        char alpha = s.charAt(cur);
        int digit = alpha - '0';

        if(num == 0 && digit >= 0) return; // Edge case 

        num = (num < 0) ? digit : num*10 + digit;
        
        // Adding dot
        if(isDot) {
            temp += '.';
            dot += 1;
        }

        if(num <= 255){
            temp += alpha;
            cur += 1;
            getIpAddresses(s, ls, temp, cur, false,num,dot);
            temp.substring(0, temp.length()-1);
        }
        // calling method to add a dot 
        getIpAddresses(s, ls, temp, cur, true, -1, dot);
    }
}