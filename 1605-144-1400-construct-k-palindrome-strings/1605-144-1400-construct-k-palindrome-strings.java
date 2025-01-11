class Solution {
    public boolean canConstruct(String s, int k) {
        Map<Character, Integer> mp=new HashMap<>();
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        if(mp.size()==1)return true;
        int cnt=0;
        int cnt_uniq=0;
        for (Integer v : mp.values())
        {
            if(v%2!=0)cnt++;
            // if(v==1)cnt_uniq++;
        }
        if(cnt>k||n<k)return false;
        return true;
    }
}