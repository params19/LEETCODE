class Solution {
    public long countOfSubstrings(String word, int k) {
        int n=word.length();
        String vow="aeiou";
        Map<Character, Integer> mp=new HashMap<>();
        int nxt[]=new int[n];
        int lst=n;
        for(int i=n-1;i>=0;i--)
        {
            nxt[i]=lst;
            if(vow.indexOf(word.charAt(i))==-1){
                lst=i;
            }
        }
        int l=0,r=0,cons=0;
        long ans=0;
        while(r<n)
        {
            char ch=word.charAt(r);
            if(vow.indexOf(ch)>=0){
                mp.put(ch,mp.getOrDefault(ch,0)+1);
            }else{
                cons++;
            }
            while(cons>k)
            {
                char chr=word.charAt(l);
                if(vow.indexOf(chr)>=0){
                    mp.put(chr,mp.get(chr)-1);
                    if(mp.get(chr)==0)mp.remove(chr);
                }
                else{
                    cons--;
                }
                l++;
            }
            while(l<n&& mp.size()==5&&cons==k)
            {
                int idx=nxt[r];
                ans+=idx-r;
                char chh=word.charAt(l);
                if (vow.indexOf(chh)>=0) {
                    mp.put(chh, mp.get(chh)-1);
                    if (mp.get(chh)==0)mp.remove(chh);
                } else {
                    cons--;
                }
                l++;
            }
            r++;
        }
        return ans;
    }
}