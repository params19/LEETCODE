class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int res[]=new int[n];
        Stack<Integer> ss=new Stack<>();
        for(int i=2*n-1;i>=0;i--)
        {
            while(!ss.isEmpty()&&nums[ss.peek()]<=nums[(i%n)])
            {
                ss.pop();
            }
            if(ss.isEmpty())
            {
                res[i%n]=-1;
            }
            else{
                res[(i%n)]=nums[ss.peek()];
            }
            ss.push(i%n);
        }
        return res;
    }
}