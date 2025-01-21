class Solution {
    public int[] numberOfPairs(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i : nums)
        {
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        int p=0,nt=0;
        for (Map.Entry<Integer, Integer> entry:mp.entrySet())
        {
            int val=entry.getValue();
            if(val%2==0)p+=val/2;
            else{
                p+=val/2;
                nt++;
            } 
        }
        return new int[]{p,nt};
    }
}