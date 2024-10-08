class Solution {
    public String smallestSubsequence(String s) {
     int n=s.length();
        String ans="";
        int[] last_ndex_cnt=new int[26];
        boolean[] visited=new boolean[26];
        for(int i=0;i<n;i++){
            last_ndex_cnt[s.charAt(i)-'a']=i;
        }

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            int idx=ch-'a';
            if(visited[idx]){
                continue;
            }
            while(ans.length()>0 && ans.charAt(ans.length()-1)>ch && last_ndex_cnt[ans.charAt(ans.length()-1)-'a']>i){
                visited[ans.charAt(ans.length()-1)-'a']=false;
                ans=ans.substring(0,ans.length()-1);
            }
            ans+=ch;
            visited[idx]=true;
        }
        return ans;
    }
}