class Solution {
    public int minimumCardPickup(int[] cards) {
        int n=cards.length;
        Map<Integer, Integer> mp=new HashMap<>();
        int ans=Integer.MAX_VALUE;
        int l=0,r=0;
        while(r<n)
        {
            if(!mp.containsKey(cards[r]))
            {
                mp.put(cards[r],r);
            }
            else{
                int len=r-mp.get(cards[r])+1;
                ans=Math.min(ans, len);
                l++;
            }
            mp.put(cards[r],r);
            r++;
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}