import java.util.*;
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> temp=new ArrayList<>();
        int n=s.length();
        return rec(0,n,s,res,temp);
    }
    private List<List<String>> rec(int i,int n,String s,List<List<String>> res,List<String> temp){
        if(i==n){
            res.add(new ArrayList<>(temp));
            return res;
        }
        for(int j=i;j<n;j++){
            if(isPalin(s,i,j)){
                temp.add(s.substring(i,j+1));
                rec(j+1,n,s,res,temp);
                temp.remove(temp.size()-1);
            }
        }
        return res;
    }
    private boolean isPalin(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}