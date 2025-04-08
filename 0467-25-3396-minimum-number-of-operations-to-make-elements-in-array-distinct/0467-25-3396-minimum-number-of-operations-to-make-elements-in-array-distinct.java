class Solution {
    public int minimumOperations(int[] nums) {
        List<Integer> ll=new ArrayList<>();
        for (int i:nums)ll.add(i);
        int ans=0;
        while(!ll.isEmpty())
        {
            if(check(ll))return ans;
            else{
                if(ll.size()<3)return ans+1;
                else{
                for (int i=0; i<3&&!ll.isEmpty();i++){
                ll.remove(0);
                }
            }
            ans++;
        }
        }
        return ans;
    }
    public boolean check(List<Integer> ll)
    {
        Set<Integer> ss=new HashSet<>(ll);
        if(ss.size()==ll.size())return true;
        return false;
    }
}