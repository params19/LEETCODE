class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totgas=0,totcost=0;
        int ans=0, bal=0;
        int n=gas.length;
        for(int i=0;i<n;i++)
        {
            totgas+=gas[i];
            totcost+=cost[i];
            bal+=gas[i]-cost[i];
            if(bal<0){
                ans=i+1;
                bal=0;
            }
        }
        return totgas<totcost?-1:ans;
    }
}