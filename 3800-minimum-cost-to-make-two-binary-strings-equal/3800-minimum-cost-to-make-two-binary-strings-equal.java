class Solution {
    public long minimumCost(String s, String t, int flipCost, int swapCost, int crossCost) {
        int n=s.length();
        int cnt01=0, cnt10=0;
        for(int i=0; i<n; i++)
        {
            if(s.charAt(i)=='0'&&t.charAt(i)=='1')cnt01++;
            else if(s.charAt(i)=='1'&&t.charAt(i)=='0')cnt10++;
        }
        long cost=0;
        long pairFix=Math.min(2*flipCost,swapCost);
        long pairs=Math.min(cnt01,cnt10);
        cost+=pairs*pairFix;
        long rem=Math.abs(cnt01-cnt10);
        cost+=(rem/2)*Math.min(2*flipCost,swapCost+crossCost)+(rem%2)*flipCost;
        return cost;
    }
}