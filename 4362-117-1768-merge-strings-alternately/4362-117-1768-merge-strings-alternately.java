class Solution {
    public String mergeAlternately(String w1, String w2) {
        int n=w1.length();
        int m=w2.length();
        StringBuilder res=new StringBuilder();
        int i=0,j=0;
        while(i<n||j<m)
        {
            if(i<n){
                res.append(w1.charAt(i));
                i++;
            }
            if(j<m){
                res.append(w2.charAt(j));
                j++;
            }
        }
        return res.toString();
    }
}