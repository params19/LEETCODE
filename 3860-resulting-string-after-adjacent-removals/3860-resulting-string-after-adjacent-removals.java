class Solution {
    public String resultingString(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(!st.isEmpty() && fun(st.peek(), ch)) st.pop();
            else st.push(ch);
        }
        StringBuilder ans = new StringBuilder();
        for(char ch : st) ans.append(ch);
        return ans.toString();
    }
    static boolean fun(char ch1, char ch2) {
        int dif = Math.abs(ch1 - ch2);
        return (dif == 1) || (dif == 25);
    }
}