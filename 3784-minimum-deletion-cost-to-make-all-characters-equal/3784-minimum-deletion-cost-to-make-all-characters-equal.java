class Solution {
    public long minCost(String s, int[] cost) {
        long ans=Long.MAX_VALUE;
        int n=s.length();
        Map<Character, Long> mp=new HashMap<>();
        long sum=0;
        for(int i=0;i<n;i++)
        {
            if(mp.containsKey(s.charAt(i)))
            {
                long v=mp.get(s.charAt(i));
                long h=v+cost[i];
                mp.put(s.charAt(i),h);
            }
            else{
                mp.put(s.charAt(i),(long)cost[i]);
            }
            sum=sum+cost[i];
        }
        for(Map.Entry<Character, Long> m: mp.entrySet())
        {
           long v=m.getValue();
           long d=sum-v;
           ans=Math.min(ans,d); 
        }
        return ans;
    }
}