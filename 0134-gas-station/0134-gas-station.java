class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int ans=0;
        int totg=0, totc=0, balance=0;
        for(int i=0;i<n;i++)
        {
            totg+=gas[i];
            totc+=cost[i];
            balance+=gas[i]-cost[i];
            if(balance<0){
                ans=(i+1);
                balance=0;
            }
        }
        if(totc>totg)return -1;
        return ans;
    }
}