class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        Map<Character, Integer> mp=new HashMap<>();
        Set<Character> ss=new HashSet<>();
        ss.add('a');
        ss.add('b');
        ss.add('c');
        int l=0,r=0;
        int cnt=0;
        while(r<n)
        {
            char ch=s.charAt(r);
            if(ss.contains(ch)){
                mp.put(ch,mp.getOrDefault(ch,0)+1);
            }
            while(mp.size()>3)
            {
                char chr=s.charAt(l);
                if(ss.contains(chr))
                {
                    mp.put(chr,mp.get(chr)-1);
                    if(mp.get(chr)==0)mp.remove(chr);
                }
                cnt=n-r;
                l++;
            }
            while(l<n&&mp.size()==3)
            {
                char chh=s.charAt(l);
                if (ss.contains(chh)) {
                    mp.put(chh, mp.get(chh)-1);
                    if (mp.get(chh)==0)mp.remove(chh);
                }
                cnt+=n-r;
                l++;
            }
            r++;
        }
        return cnt;
    }
}