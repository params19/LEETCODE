class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer,Integer> mp=new HashMap<>();
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                    int v1=nums[i];
                    int v2=nums[j];
                    int pro=v1*v2;
                    if(mp.containsKey(pro))
                    {
                        ans+=mp.get(pro)*8;
                        // ans++;
                    }
                    mp.put(pro,mp.getOrDefault(pro,0)+1);
                }
        }
        return ans;
    }
}