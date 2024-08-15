import java.util.*;
class Solution {
    public List<String> validStrings(int n) {
        List<String> res=new ArrayList<>();
        recur(n,res,"");
        return res;
    }
    public void recur(int n,List<String> res,String s){
        if(n==0)
        {
            res.add(s);
            return;
        }
        if(s.length()==0||s.charAt(s.length()-1)=='1')
        {
            recur(n-1,res,s+"0");
        }
        recur(n-1,res,s+"1");
    }
}