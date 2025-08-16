class Solution {
    public String simplifyPath(String path) {
        String[] token=path.split("/");
        Stack<String> st=new Stack<>();
        for(String s : token)
        {
            if(s.equals("")||s.equals("."))continue;
            if(s.equals("..")){
                if(!st.isEmpty())st.pop();
            }
            else{
                st.push(s);
            }
        }
        StringBuilder res=new StringBuilder();
        for(String s : st)
        {
            res.append("/").append(s);
        }
        return res.length()==0?"/":res.toString();
    }
}