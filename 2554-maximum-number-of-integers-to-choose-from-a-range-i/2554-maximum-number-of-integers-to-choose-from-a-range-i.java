class Solution {
    public int maxCount(int[] arr, int n, int max) {
        Set<Long> ss=new HashSet<>();
        for(long i : arr)ss.add(i);
        long s=0;
        int cnt=0;
        for(long i=1;i<=n;i++)
        {
            if(ss.contains(i))continue;
            if((s+i)<=max)
            {
                cnt++;
                s+=i;
                // ss.remove(i);
            }
            else break;
        }
        return cnt;
    }
}