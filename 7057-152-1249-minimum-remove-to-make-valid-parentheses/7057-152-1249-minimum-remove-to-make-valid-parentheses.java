class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        Stack<Integer> ss = new Stack<>(); 
        Set<Integer> inval = new HashSet<>();
        for (int i=0;i<n;i++) 
        {
            char ch=s.charAt(i);
            if (ch == '(')ss.push(i);
            else if(ch == ')') {
                if (!ss.isEmpty()) {
                    ss.pop();
                } else {
                    inval.add(i); 
                }
            }
        }
        while (!ss.isEmpty()) {
            inval.add(ss.pop());
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<n;i++){
            if (!inval.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
