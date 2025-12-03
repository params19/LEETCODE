class Solution {
    public int maxSumDivThree(int[] nums) {
        int n=nums.length;
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        int ans=0;
        for(int i: nums)
        {
            ans+=i;
        }
        if(ans%3==0)return ans;
        for(int i: nums)
        {
            if(i%3==1){
                l1.add(i);
            }
            else if(i%3==2)
            {
                l2.add(i);
            }
        }
        Collections.sort(l1);
        Collections.sort(l2);
        int rem=ans%3;
        int a=0;
        if(rem==1)
        {
            int v1=(l1.size()>=1)?ans-l1.get(0):0;
            int v2=(l2.size()>=2)?ans-l2.get(0)-l2.get(1):0;
            a=Math.max(v1,v2);
        }
        else if(rem==2)
        {
            int v1=(l1.size()>=2)?ans-l1.get(0)-l1.get(1):0;
            int v2=(l2.size()>=1)?ans-l2.get(0):0;
            a=Math.max(v1,v2);
        }
        return a;
    }
}