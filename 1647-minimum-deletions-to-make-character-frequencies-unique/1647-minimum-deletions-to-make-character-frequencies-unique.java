class Solution {
    public int minDeletions(String s) {
        int n=s.length();
        Map<Character, Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        List<Integer> ll=new ArrayList<>();
        for(Map.Entry<Character, Integer> entry: mp.entrySet())
        {
            int v=entry.getValue();
            ll.add(v);
        }
        Collections.sort(ll);
        Set<Integer> ss=new HashSet<>();
        int ans=0;
        for(int i=0;i<ll.size();i++)
        {
            if(!ss.contains(ll.get(i)))
            {
                ss.add(ll.get(i));
            }
            else{
                int vv=ll.get(i);
                while(ss.contains(vv))
                {
                    ans++;
                    vv--;
                }
                if(vv!=0)ss.add(vv);
            }
        }
        return ans;
    }
}