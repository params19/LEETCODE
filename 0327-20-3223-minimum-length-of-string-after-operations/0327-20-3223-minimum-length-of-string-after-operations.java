class Solution {
    public int minimumLength(String s) {
        int n=s.length();
        Map<Character, Integer> mp=new HashMap<>();
        for(char ch : s.toCharArray())
        {
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        int ans=0;
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            Integer val = entry.getValue();
            if(val<=2)ans+=val;
            else if(val%2!=0)ans+=1;
            else ans+=2;
        }
        if(ans==0)return n;
        return ans;
    }
}