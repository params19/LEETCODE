class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder res=new StringBuilder(s);
        while(res.indexOf(part)>=0)
        {
            int idx=res.indexOf(part);
            res.delete(idx,idx+part.length());
        }
        return res.toString();
    }
}