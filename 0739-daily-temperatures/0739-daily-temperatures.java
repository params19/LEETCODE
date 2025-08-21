class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n=temp.length;
        int res[]=new int[n];
        Stack<Integer> ss=new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
            while(!ss.isEmpty()&&temp[ss.peek()]<=temp[i])
            {
                ss.pop();
            }
            if(ss.isEmpty())
            {
                res[i]=0;
            }
            else{
                res[i]=ss.peek();
            }
            ss.push(i);
        }
        for(int i=0;i<n;i++)
        {
            if(res[i]==0)res[i]=0;
            else res[i]=res[i]-i;
        }
        return res;
    }
}